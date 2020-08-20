package com.dong.web.service.impl;

import com.dong.common.CommonUtils;
import com.dong.common.ResponseResult;
import com.dong.web.dao.CommonDao;
import com.dong.web.dao.RoleJpaDao;
import com.dong.web.entity.Role;
import com.dong.web.model.RoleInfoBean;
import com.dong.web.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleJpaDao roleJpaDao;

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
    public ResponseResult findRoleInfoList(RoleInfoBean bean, int limit, int page) {
        ResponseResult result = new ResponseResult();
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>();
        sql.append(" SELECT id, role_name roleName, remark, create_time createTime, ");
        sql.append(" update_time updateTime ");
        sql.append(" FROM role ");
        sql.append(" WHERE 1 = 1 ");
        int total = commonDao.getTotalBySql(sql, param);
        if (total > 0) {
            List<Map<String, Object>> dataList = commonDao.findListBySql(sql, param, page, limit);
            result.setData(dataList);
            result.setTotal(dataList.size());
            result.setMessage("查询成功！");
        }
        result.setTotal(total);
        return result;
    }


    @Override
    public ResponseResult saveRoleInfo(RoleInfoBean bean) {
        Role entity = new Role();
        if (StringUtils.isEmpty(bean.getId())) {//新增
            entity.setId(CommonUtils.getUUID());
            entity.setCreateTime(new Date());
        } else {
            entity = roleJpaDao.getOne(bean.getId());
        }
        entity.setUpdateTime(new Date());
        entity.setRoleName(bean.getRoleName());
        entity.setRemark(bean.getRemark());
        entity = roleJpaDao.save(entity);
        return ResponseResult.success(entity, "保存成功!");
    }

    @Override
    public ResponseResult getRoleInfoView(String id) {
        if (StringUtils.isEmpty(id)) {
            return ResponseResult.error("查询失败，id不能为空!");
        } else {
            Role entity = roleJpaDao.getOne(id);
            return ResponseResult.success(entity, "查询成功!");
        }
    }

    @Override
    public ResponseResult deleteRoleInfo(String id) {
        if (StringUtils.isEmpty(id)) {
            return ResponseResult.error("删除失败，id不能为空!");
        } else {
            Role entity = roleJpaDao.getOne(id);
            roleJpaDao.delete(entity);
            return ResponseResult.success(null, "删除成功!");
        }
    }

}
