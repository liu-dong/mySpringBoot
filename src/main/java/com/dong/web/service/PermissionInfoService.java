package com.dong.web.service;

import com.dong.common.ResponseResult;
import com.dong.web.model.PermissionInfoBean;

public interface PermissionInfoService {

    /**
    * 查询权限信息列表
    *
    * @param bean
    * @param limit
    * @param page
    * @return
    */
    ResponseResult findPermissionInfoList(PermissionInfoBean bean, int limit, int page);

    /**
    * 保存权限信息
    *
    * @param bean
    * @return
    */
    ResponseResult savePermissionInfo(PermissionInfoBean bean);

    /**
    * 查询权限信息详细页面
    *
    * @param id
    * @return
    */
    ResponseResult getPermissionInfoView(String id);

    /**
    * 删除权限信息
    *
    * @param id
    * @return
    */
    ResponseResult deletePermissionInfo(String id);
}