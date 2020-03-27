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
     * @param parentId
     * @return
     */
    private List<Map<String ,Object>> getMenuTreeByRecursion(String parentId){
        List<Map<String,Object>> menuList = new ArrayList<>();
        List<SysMenu> sysMenuList;
        if (StringUtils.isEmpty(parentId)){
            sysMenuList = sysMenuJpaDao.findAll();
        }else {
            sysMenuList = sysMenuJpaDao.getAllByParentId(parentId);
        }
        if (!CollectionUtils.isEmpty(sysMenuList)){
            for (SysMenu sysMenu : sysMenuList) {
                Map<String,Object> map = new HashMap<>();
                parentId = sysMenu.getParentId();
                map.put("id",sysMenu.getId());
                map.put("title",sysMenu.getMenuName());
                map.put("url",sysMenu.getMenuUrl());
                map.put("icon",sysMenu.getMenuIcon());
                List<Map<String,Object>> childrenList = new ArrayList<>();
                if (sysMenu.getHasChild() == 1){
                    childrenList = getMenuTreeByRecursion(parentId);
                }
                map.put("children",childrenList);
                menuList.add(map);
            }
        }
        return menuList;
    }
}
