package com.dong.web.service.impl;

import com.dong.utils.CommonUtils;
import com.dong.utils.ResponseResult;
import com.dong.web.dao.SysMenuJpaDao;
import com.dong.web.entity.SysMenu;
import com.dong.web.model.SystemMenuBean;
import com.dong.web.service.SystemMenuService;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SystemMenuServiceImpl implements SystemMenuService {

    @Autowired
    private SysMenuJpaDao sysMenuJpaDao;
    @Autowired
    private EntityManager entityManager;

    @Override
    public ResponseResult findSystemMenuList(SystemMenuBean bean, int limit, int page) {
        ResponseResult result = new ResponseResult();
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>();
        sql.append("select * from sys_menu where 1=1 ");
        if (!StringUtils.isEmpty(bean.getHasChild())) {
            sql.append(" and has_child = ? ");
            param.add(bean.getHasChild());
        }
        Query query = entityManager.createNativeQuery(String.valueOf(sql));
        for (int i = 0; i < param.size(); i++) {
            query.setParameter(i + 1, param.get(i));
        }
        query.setFirstResult(limit - 1);//起始数
        query.setMaxResults(page);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String, Object>> dataList = query.getResultList();
        result.setData(dataList);
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
}
