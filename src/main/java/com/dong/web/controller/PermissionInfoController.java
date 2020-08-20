package com.dong.web.controller;

import com.dong.common.ResponseResult;
import com.dong.web.model.PermissionInfoBean;
import com.dong.web.service.PermissionInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*  权限信息管理
*
*  @author LD
*/
@Api(tags = "权限管理模块")
@RestController
@RequestMapping("/permissionInfo")
public class PermissionInfoController {

    @Autowired
    private PermissionInfoService permissionInfoService;

    /**
    * 查询权限信息列表
    *
    * @param bean
    * @param limit
    * @param page
    * @return
    */
    @PostMapping("/findPermissionInfoList")
    public ResponseResult findPermissionInfoList(PermissionInfoBean bean, int limit, int page) {
        return permissionInfoService.findPermissionInfoList(bean, limit, page);
    }

    /**
    * 保存权限信息
    *
    * @param bean
    * @return
    */
    @PostMapping("/savePermissionInfo")
    public ResponseResult savePermissionInfo(PermissionInfoBean bean) {
        return permissionInfoService.savePermissionInfo(bean);
    }

    /**
    * 查询权限信息详细页面
    *
    * @param id
    * @return
    */
    @GetMapping("/getPermissionInfoView")
    public ResponseResult getPermissionInfoView(String id) {
        return permissionInfoService.getPermissionInfoView(id);
    }

    /**
    * 删除权限信息
    *
    * @param id
    * @return
    */
    @PostMapping("/deletePermissionInfo")
    public ResponseResult deletePermissionInfo(String id) {
        return permissionInfoService.deletePermissionInfo(id);
    }
}