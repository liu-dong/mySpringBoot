package com.dong.web.service.impl;

import com.dong.common.ResponseResult;
import com.dong.web.model.PermissionInfoBean;
import com.dong.web.service.PermissionInfoService;
import org.springframework.stereotype.Service;

@Service
public class PermissionInfoServiceImpl implements PermissionInfoService {

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
      return null;
   }

   /**
   * 保存权限信息
   *
   * @param bean
   * @return
   */
   @Override
   public ResponseResult savePermissionInfo(PermissionInfoBean bean) {
      return null;
   }

   /**
   * 查询权限信息详细页面
   *
   * @param id
   * @return
   */
   @Override
   public ResponseResult getPermissionInfoView(String id) {
      return null;
   }

   /**
   * 删除权限信息
   *
   * @param id
   * @return
   */
   @Override
   public ResponseResult deletePermissionInfo(String id) {
      return null;
   }

}