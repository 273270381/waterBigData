package com.suchness.intellisense.user.component;

import com.suchness.intellisense.user.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/***
 *  author: rushi
 *  create_time : 2020/11/279:14
 *******/
@Component
public class ResourceRoleRulesHolder {

    @Autowired
    private ResourceService resourceService;

    @PostConstruct
    public void initResourceRolesMap(){
        resourceService.initResourceRolesMap();
    }
}
