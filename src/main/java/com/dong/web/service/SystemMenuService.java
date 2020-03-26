package com.dong.web.service;

import com.dong.utils.ResponseResult;
import com.dong.web.model.SystemMenuBean;

public interface SystemMenuService {


    /**
     * 查询菜单列表
     *
     * @param bean
     * @param limit
     * @param page
     * @return
     */
    ResponseResult findSystemMenuList(SystemMenuBean bean, int limit, int page);

    /**
     * 保存菜单信息
     *
     * @param bean
     * @return
     */
    ResponseResult saveSystemMenuInfo(SystemMenuBean bean);

    /**
     * 查询菜单详细页面
     *
     * @param id
     * @return
     */
    ResponseResult getSystemMenuView(String id);

    /**
     * 删除菜单信息
     *
     * @param id
     * @return
     */
    ResponseResult deleteSystemMenuInfo(String id);
}
