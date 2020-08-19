package com.dong.web.service;

import com.dong.common.ResponseResult;
import com.dong.web.model.RoleInfoBean;

public interface RoleInfoService {


    /**
     * 查询角色列表
     *
     * @param bean
     * @param limit
     * @param page
     * @return
     */
    ResponseResult findRoleInfoList(RoleInfoBean bean, int limit, int page);


    /**
     * 保存角色信息
     *
     * @param bean
     * @return
     */
    ResponseResult saveRoleInfo(RoleInfoBean bean);

    /**
     * 查询角色详细页面
     *
     * @param id
     * @return
     */
    ResponseResult getRoleInfoView(String id);

    /**
     * 删除角色信息
     *
     * @param id
     * @return
     */
    ResponseResult deleteRoleInfo(String id);
}
