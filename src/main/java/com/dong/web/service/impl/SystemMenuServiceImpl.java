package com.dong.web.service.impl;

import com.dong.common.CommonUtils;
import com.dong.common.ResponseResult;
import com.dong.web.dao.CommonDao;
import com.dong.web.dao.SysMenuJpaDao;
import com.dong.web.entity.SysMenu;
import com.dong.web.model.SystemMenuBean;
import com.dong.web.service.SystemMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class SystemMenuServiceImpl implements SystemMenuService {

    @Autowired
    private SysMenuJpaDao sysMenuJpaDao;

    @Autowired
    private CommonDao commonDao;


    /**
     * 查询菜单列表
     *
     * @param bean
     * @param limit
     * @param page
     * @return
     */
    @Override
    public ResponseResult findSystemMenuList(SystemMenuBean bean, int limit, int page) {
        ResponseResult result = new ResponseResult();
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>();
        sql.append(" SELECT id, parent_id parentId, menu_name menuName, menu_level menuLevel, ");
        sql.append(" menu_icon menuIcon, menu_order menuOrder, menu_url menuUrl, ");
        sql.append(" menu_path menuPath, menu_status menuStatus, has_child hasChild ");
        sql.append(" FROM sys_menu ");
        sql.append(" WHERE 1 = 1 ");
        if (!StringUtils.isEmpty(bean.getMenuStatus())) {
            sql.append(" AND menu_status = ? ");
            param.add(bean.getMenuStatus());
        }
        if (!StringUtils.isEmpty(bean.getHasChild())) {
            sql.append(" AND has_child = ? ");
            param.add(bean.getHasChild());
        }
        List<Map<String, Object>> dataList = commonDao.findListBySql(sql, param, page, limit);
        result.setData(dataList);
        result.setTotal(dataList.size());
        result.setMessage("查询成功！");
        return result;
    }

    /**
     * 查询菜单树
     * @param type （查询菜单树类型 1：根据递归获取菜单树(多次访问数据库)、2：根据所有菜单数据生成菜单树（访问一次菜单））
     * @return
     */
    @Override
    public ResponseResult getSystemMenuTree(int type) {
        if (1 == type) {
            return ResponseResult.success(getMenuTreeByRecursion(""), "查询成功!");
        }else if (2==type) {
            List<SysMenu> sysMenuList = sysMenuJpaDao.findAll();
            return ResponseResult.success(getMenuTreeByALL(sysMenuList), "查询成功!");
        }
        return ResponseResult.error("查询失败!");
    }

    @Override
    public ResponseResult saveSystemMenuInfo(SystemMenuBean bean) {
        SysMenu entity = new SysMenu();
        BeanUtils.copyProperties(bean, entity);
        entity.setId(CommonUtils.getUUID());
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        entity = sysMenuJpaDao.save(entity);
        return ResponseResult.success(entity, "保存成功!");
    }

    @Override
    public ResponseResult getSystemMenuView(String id) {
        if (StringUtils.isEmpty(id)) {
            return ResponseResult.error("查询失败，id不能为空!");
        } else {
            SysMenu entity = sysMenuJpaDao.getOne(id);
            return ResponseResult.success(entity, "查询成功!");
        }
    }

    @Override
    public ResponseResult deleteSystemMenuInfo(String id) {
        if (StringUtils.isEmpty(id)) {
            return ResponseResult.error("删除失败，id不能为空!");
        } else {
            SysMenu entity = sysMenuJpaDao.getOne(id);
            sysMenuJpaDao.delete(entity);
            return ResponseResult.success(null, "删除成功!");
        }
    }

    /**
     * 根据递归获取菜单树 (多次访问数据库)
     *
     * @param parentId //子菜单的父菜单主键
     * @return
     */
    private List<Map<String, Object>> getMenuTreeByRecursion(String parentId) {
        List<Map<String, Object>> menuList = new ArrayList<>();
        List<SysMenu> sysMenuList;
        if (StringUtils.isEmpty(parentId)) {//如果父菜单主键为空说明找的是一级菜单
            sysMenuList = sysMenuJpaDao.getAllByMenuLevel(1);
        } else {
            sysMenuList = sysMenuJpaDao.getAllByParentId(parentId);
        }
        if (!CollectionUtils.isEmpty(sysMenuList)) {
            for (SysMenu sysMenu : sysMenuList) {
                parentId = sysMenu.getId();
                List<Map<String, Object>> childrenList = new ArrayList<>();
                if (sysMenu.getHasChild() == 1) {
                    childrenList = getMenuTreeByRecursion(parentId);
                }
                Map<String, Object> map = setMenu(sysMenu,childrenList);//生成菜单对象
                menuList.add(map);
            }
        }
        return menuList;
    }

    /**
     * 根据所有菜单数据生成菜单树（访问一次菜单）
     *
     * @param sysMenuList
     * @return
     */
    public List<Map<String, Object>> getMenuTreeByALL(List<SysMenu> sysMenuList) {
        List<Map<String, Object>> result = new ArrayList<>();
        for (SysMenu sysMenu : sysMenuList) {
            if (sysMenu.getMenuLevel() == 1) {
                Map<String, Object> map = setMenu(sysMenu,null);
                if (sysMenu.getHasChild() == 1) {
                    map.put("children", getChildrenMenuByRecursion(sysMenuList, map));//获取子菜单
                }
                result.add(map);
            }
        }
        return result;
    }

    /**
     * 递归获取子菜单
     * @param sysMenuList
     * @param parentMenu
     * @return
     */
    private List<Map<String, Object>> getChildrenMenuByRecursion(List<SysMenu> sysMenuList, Map<String, Object> parentMenu) {
        List<Map<String, Object>> childrenList = new ArrayList<>();//子菜单列表
        for (SysMenu menu : sysMenuList) {
            if (!StringUtils.isEmpty(menu.getParentId()) && parentMenu.get("id").equals(menu.getParentId())) {
                Map<String, Object> childrenMenu = setMenu(menu,null);
                childrenMenu.put("children", getChildrenMenuByRecursion(sysMenuList, childrenMenu));
                childrenList.add(childrenMenu);
            }
        }
        return childrenList;
    }

    /**
     * 生成一个菜单对象
     * @param sysMenu
     * @param childrenList
     * @return
     */
    private Map<String, Object> setMenu(SysMenu sysMenu,List<Map<String,Object>> childrenList) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", sysMenu.getId());
        map.put("title", sysMenu.getMenuName());
        map.put("url", sysMenu.getMenuUrl());
        map.put("icon", sysMenu.getMenuIcon());
        map.put("children", childrenList);
        return map;
    }
}
