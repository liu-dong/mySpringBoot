package com.dong.web.service.impl;

import com.dong.utils.CommonUtils;
import com.dong.utils.ResponseResult;
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


    @Override
    public ResponseResult findSystemMenuList(SystemMenuBean bean, int limit, int page) {
        ResponseResult result = new ResponseResult();
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>();
        sql.append(" SELECT * FROM sys_menu WHERE 1 = 1 ");
        if (!StringUtils.isEmpty(bean.getHasChild())) {
            sql.append(" AND has_child = ? ");
            param.add(bean.getHasChild());
        }
        List<Map<String, Object>> dataList = commonDao.findListBySql(sql, param, page, limit);
        result.setData(dataList);
        return result;
    }

    @Override
    public ResponseResult findSystemMenuList(SystemMenuBean bean) {
        ResponseResult result = new ResponseResult();
        result.setData(getMenuTreeByRecursion(""));
        return result;
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
     * 递归获取菜单树
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
                Map<String, Object> map = new HashMap<>();
                parentId = sysMenu.getId();
                map.put("id", sysMenu.getId());
                map.put("title", sysMenu.getMenuName());
                map.put("url", sysMenu.getMenuUrl());
                map.put("icon", sysMenu.getMenuIcon());
                List<Map<String, Object>> childrenList = new ArrayList<>();
                if (sysMenu.getHasChild() == 1) {
                    childrenList = getMenuTreeByRecursion(parentId);
                }
                map.put("children", childrenList);
                menuList.add(map);
            }
        }
        return menuList;
    }


    public List<Map<String, Object>> getMenuList(List<SysMenu> sysMenuList) {
        List<Map<String, Object>> result = new ArrayList<>();
        for (SysMenu sysMenu : sysMenuList) {
            Map<String, Object> map = new HashMap<>();
            if (sysMenu.getMenuLevel() == 1) {
                map.put("id", sysMenu.getId());
                map.put("title", sysMenu.getMenuName());
                map.put("url", sysMenu.getMenuUrl());
                map.put("icon", sysMenu.getMenuIcon());
                List<Map<String, Object>> childrenList = new ArrayList<>();
                if (sysMenu.getHasChild() == 1) {
                    String parentId = sysMenu.getId();
                    childrenList = getChildrenMenuByRecursion(sysMenuList,parentId);
                }
                map.put("children", childrenList);
            }
            result.add(map);
        }
        return result;
    }

    private List<Map<String, Object>> getChildrenMenuByRecursion(List<SysMenu> sysMenuList, String parentId) {
        List<Map<String, Object>> childrenList = new ArrayList<>();
        for (SysMenu menu : sysMenuList) {
            if (parentId.equals(menu.getParentId())) {
                Map<String, Object> chilrenMenu = new HashMap<>();
                chilrenMenu.put("id", menu.getId());
                chilrenMenu.put("title", menu.getMenuName());
                chilrenMenu.put("url", menu.getMenuUrl());
                chilrenMenu.put("icon", menu.getMenuIcon());
                chilrenMenu.put("children", getChildrenMenuByRecursion(sysMenuList,parentId));
                childrenList.add(chilrenMenu);
            }
        }
        return childrenList;
    }
}
