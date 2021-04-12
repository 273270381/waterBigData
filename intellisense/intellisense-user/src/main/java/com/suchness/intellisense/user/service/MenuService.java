package com.suchness.intellisense.user.service;

import com.suchness.intellisense.model.Menu;
import com.suchness.intellisense.user.dto.MenuNode;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/11/2516:08
 *******/
public interface MenuService {

    /**
     * 创建后台菜单
     */
    int create(Menu menu);

    /**
     * 修改后台菜单
     */
    int update(Long id, Menu menu);

    /**
     * 根据ID获取菜单详情
     */
    Menu getItem(Long id);

    /**
     * 根据ID删除菜单
     */
    int delete(Long id);

    /**
     * 分页查询后台菜单
     */
    List<Menu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 树形结构返回所有菜单列表
     */
    List<MenuNode> treeList();

    /**
     * 修改菜单显示状态
     */
    int updateHidden(Long id, Integer hidden);
}
