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
     * 查询菜单树
     * @param type （查询菜单树类型 1：根据递归获取菜单树(多次访问数据库)、2：根据所有菜单数据生成菜单树（访问一次菜单））
     * @return
     */
    ResponseResult getSystemMenuTree(int type);

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
