package com.suchness.intellisense.user.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.suchness.intellisense.common.api.CommonResult;
import com.suchness.intellisense.common.api.ResultCode;
import com.suchness.intellisense.common.constant.AuthConstant;
import com.suchness.intellisense.common.domain.UserDto;
import com.suchness.intellisense.common.exception.Asserts;
import com.suchness.intellisense.mapper.AdminMapper;
import com.suchness.intellisense.mapper.AdminPermissionRelationMapper;
import com.suchness.intellisense.mapper.AdminRoleRelationMapper;
import com.suchness.intellisense.model.*;
import com.suchness.intellisense.user.dao.AdminPermissionRelationDao;
import com.suchness.intellisense.user.dao.AdminRoleRelationDao;
import com.suchness.intellisense.user.dto.AdminParam;
import com.suchness.intellisense.user.dto.UpdateAdminPasswordParam;
import com.suchness.intellisense.user.service.AdminCacheService;
import com.suchness.intellisense.user.service.AdminService;
import com.suchness.intellisense.user.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/***
 *  author: rushi
 *  create_time : 2020/11/2416:23
 *******/
@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AuthService authService;
    @Autowired
    private AdminRoleRelationMapper adminRoleRelationMapper;

    @Autowired
    private AdminRoleRelationDao adminRoleRelationDao;

    @Autowired
    private AdminPermissionRelationMapper adminPermissionRelationMapper;

    @Autowired
    private AdminPermissionRelationDao adminPermissionRelationDao;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AdminCacheService adminCacheService;

    @Override
    public Admin getAdminByUsername(String username) {
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Admin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public Admin register(AdminParam adminParam) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminParam, admin);
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        //???????????????????????????????????????
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(admin.getUsername());
        List<Admin> umsAdminList = adminMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //???????????????????????????
        String encodePassword = BCrypt.hashpw(admin.getPassword());
        admin.setPassword(encodePassword);
        adminMapper.insert(admin);
        return admin;
    }

    @Override
    public CommonResult login(String username, String password) {
        if(StrUtil.isEmpty(username)||StrUtil.isEmpty(password)){
            Asserts.fail("?????????????????????????????????");
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.ADMIN_CLIENT_ID);
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("username",username);
        params.put("password",password);
        CommonResult restResult = authService.getAccessToken(params);
        if(ResultCode.SUCCESS.getCode()==restResult.getCode()&&restResult.getData()!=null){
            //todo
            //insertLoginLog(username);
        }
        return restResult;
    }

    @Override
    public Admin getItem(Long id) {
            return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Admin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andUsernameLike("%" + keyword + "%");
            example.or(example.createCriteria().andNickNameLike("%" + keyword + "%"));
        }
        List<Admin> admins = adminMapper.selectByExample(example);
        return admins;
    }

    @Override
    public int update(Long id, Admin admin) {
        admin.setId(id);
        Admin rawAdmin = adminMapper.selectByPrimaryKey(id);
        if(rawAdmin.getPassword().equals(admin.getPassword())){
            //??????????????????????????????????????????
            admin.setPassword(null);
        }else{
            //?????????????????????????????????????????????
            if(StrUtil.isEmpty(admin.getPassword())){
                admin.setPassword(null);
            }else{
                admin.setPassword(BCrypt.hashpw(admin.getPassword()));
            }
        }
        int count = adminMapper.updateByPrimaryKeySelective(admin);
        adminCacheService.delAdmin(id);
        return count;
    }

    @Override
    public int delete(Long id) {
        int count = adminMapper.deleteByPrimaryKey(id);
        adminCacheService.delAdmin(id);
        return count;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //????????????????????????
        AdminRoleRelationExample adminRoleRelationExample = new AdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
        //???????????????
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<AdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                AdminRoleRelation roleRelation = new AdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleRelationDao.insertList(list);
        }
        return count;
    }

    @Override
    public List<Role> getRoleList(Long adminId) {
        return adminRoleRelationDao.getRoleList(adminId);
    }

    @Override
    public List<Resource> getResourceList(Long adminId) {
        return adminRoleRelationDao.getResourceList(adminId);
    }

    @Override
    public int updatePermission(Long adminId, List<Long> permissionIds) {
        //???????????????????????????
        AdminPermissionRelationExample relationExample = new AdminPermissionRelationExample();
        relationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminPermissionRelationMapper.deleteByExample(relationExample);
        //??????????????????????????????
        List<Permission> permissionList = adminRoleRelationDao.getRolePermissionList(adminId);
        List<Long> rolePermissionList = permissionList.stream().map(Permission::getId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(permissionIds)) {
            List<AdminPermissionRelation> relationList = new ArrayList<>();
            //?????????+??????
            List<Long> addPermissionIdList = permissionIds.stream().filter(permissionId -> !rolePermissionList.contains(permissionId)).collect(Collectors.toList());
            //?????????-??????
            List<Long> subPermissionIdList = rolePermissionList.stream().filter(permissionId -> !permissionIds.contains(permissionId)).collect(Collectors.toList());
            //??????+-????????????
            relationList.addAll(convert(adminId,1,addPermissionIdList));
            relationList.addAll(convert(adminId,-1,subPermissionIdList));
            return adminPermissionRelationDao.insertList(relationList);
        }
        return 0;
    }

    /**
     * ???+-???????????????????????????
     */
    private List<AdminPermissionRelation> convert(Long adminId,Integer type,List<Long> permissionIdList) {
        List<AdminPermissionRelation> relationList = permissionIdList.stream().map(permissionId -> {
            AdminPermissionRelation relation = new AdminPermissionRelation();
            relation.setAdminId(adminId);
            relation.setType(type);
            relation.setPermissionId(permissionId);
            return relation;
        }).collect(Collectors.toList());
        return relationList;
    }

    @Override
    public List<Permission> getPermissionList(Long adminId) {
        return adminRoleRelationDao.getPermissionList(adminId);
    }

    @Override
    public int updatePassword(UpdateAdminPasswordParam param) {
        if(StrUtil.isEmpty(param.getUsername())
                ||StrUtil.isEmpty(param.getOldPassword())
                ||StrUtil.isEmpty(param.getNewPassword())){
            return -1;
        }
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(param.getUsername());
        List<Admin> adminList = adminMapper.selectByExample(example);
        if(CollUtil.isEmpty(adminList)){
            return -2;
        }
        Admin admin = adminList.get(0);
        if(!BCrypt.checkpw(param.getOldPassword(),admin.getPassword())){
            return -3;
        }
        admin.setPassword(BCrypt.hashpw(param.getNewPassword()));
        adminMapper.updateByPrimaryKey(admin);
        adminCacheService.delAdmin(admin.getId());
        return 1;
    }

    @Override
    public UserDto loadUserByUsername(String username) {
        //??????????????????
        Admin admin = getAdminByUsername(username);
        if (admin != null) {
            List<Role> roleList = getRoleList(admin.getId());
            UserDto userDTO = new UserDto();
            BeanUtils.copyProperties(admin,userDTO);
            if(CollUtil.isNotEmpty(roleList)){
                List<String> roleStrList = roleList.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
                userDTO.setRoles(roleStrList);
            }
            return userDTO;
        }
        return null;
    }

    @Override
    public Admin getCurrentAdmin() {
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if(StrUtil.isEmpty(userStr)){
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
        Admin admin = adminCacheService.getAdmin(userDto.getId());
        if(admin!=null){
            return admin;
        }else{
            admin = adminMapper.selectByPrimaryKey(userDto.getId());
            adminCacheService.setAdmin(admin);
            return admin;
        }
    }
}
