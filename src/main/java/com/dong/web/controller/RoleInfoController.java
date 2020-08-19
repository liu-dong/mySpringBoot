package com.dong.web.controller;

import com.dong.common.ResponseResult;
import com.dong.web.model.RoleInfoBean;
import com.dong.web.service.RoleInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色管理模块
 *
 * @author LD
 */
@Api(tags = "角色管理模块")
@RestController
@RequestMapping("/system/roleInfo")
public class RoleInfoController {

    @Autowired
    private RoleInfoService roleInfoService;

    /**
     * 查询角色信息列表
     *
     * @param bean
     * @param limit
     * @param page
     * @return
     */
    @PostMapping("/findRoleInfoList")
    public ResponseResult findRoleInfoList(RoleInfoBean bean, int limit, int page) {
        return roleInfoService.findRoleInfoList(bean, limit, page);
    }

    /**
     * 保存角色信息
     *
     * @param bean
     * @return
     */
    @PostMapping("/saveRoleInfo")
    public ResponseResult saveRoleInfo(RoleInfoBean bean) {
        return roleInfoService.saveRoleInfo(bean);
    }

    /**
     * 查询角色详细页面
     *
     * @param id
     * @return
     */
    @GetMapping("/getRoleInfoView")
    public ResponseResult getRoleInfoView(String id) {
        return roleInfoService.getRoleInfoView(id);
    }

    /**
     * 删除角色信息
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteRoleInfo")
    public ResponseResult deleteRoleInfo(String id) {
        return roleInfoService.deleteRoleInfo(id);
    }
}
