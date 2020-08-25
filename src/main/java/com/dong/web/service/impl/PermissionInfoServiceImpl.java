package com.dong.web.service.impl;

import com.dong.common.CommonUtils;
import com.dong.common.ResponseResult;
import com.dong.web.dao.CommonDao;
import com.dong.web.dao.PermissionJpaDao;
import com.dong.web.entity.Permission;
import com.dong.web.model.PermissionInfoBean;
import com.dong.web.service.PermissionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PermissionInfoServiceImpl implements PermissionInfoService {

   @Autowired
   private PermissionJpaDao permissionJpaDao;
   @Autowired
   private CommonDao commonDao;

   /**
   * 查询权限信息列表
   *
   * @param bean
   * @param limit
   * @param page
   * @return
   */
   @Override
   public ResponseResult findPermissionInfoList(PermissionInfoBean bean, int limit, int page) {
      ResponseResult result = new ResponseResult();
      StringBuilder sql = new StringBuilder();
      List<Object> param = new ArrayList<>();
      sql.append(" SELECT id, permission_name permissionName, permission_type permissionType, ");
      sql.append(" resource_id resourceId, create_time createTime, update_time updateTime ");
      sql.append(" FROM permission ");
      sql.append(" WHERE 1 = 1 ");
      sql.append(" ORDER BY create_time DESC ");
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

   /**
   * 保存权限信息
   *
   * @param bean
   * @return
   */
   @Override
   public ResponseResult savePermissionInfo(PermissionInfoBean bean) {
      Permission entity = new Permission();
      if (StringUtils.isEmpty(bean.getId())) {//新增
         entity.setId(CommonUtils.getUUID());
         entity.setCreateTime(new Date());
      } else {
         entity = permissionJpaDao.getOne(bean.getId());
      }
      entity.setUpdateTime(new Date());
      entity.setPermissionName(bean.getPermissionName());
      entity.setPermissionType(bean.getPermissionType());
      entity.setResourceId(bean.getResourceId());
      entity = permissionJpaDao.save(entity);
      return ResponseResult.success(entity, "保存成功!");
   }

   /**
   * 查询权限信息详细页面
   *
   * @param id
   * @return
   */
   @Override
   public ResponseResult getPermissionInfoView(String id) {
      if (StringUtils.isEmpty(id)) {
         return ResponseResult.error("查询失败，id不能为空!");
      } else {
         Permission entity = permissionJpaDao.getOne(id);
         return ResponseResult.success(entity, "查询成功!");
      }
   }

   /**
   * 删除权限信息
   *
   * @param id
   * @return
   */
   @Override
   public ResponseResult deletePermissionInfo(String id) {
      if (StringUtils.isEmpty(id)) {
         return ResponseResult.error("删除失败，id不能为空!");
      } else {
         Permission entity = permissionJpaDao.getOne(id);
         permissionJpaDao.delete(entity);
         return ResponseResult.success(null, "删除成功!");
      }
   }

}