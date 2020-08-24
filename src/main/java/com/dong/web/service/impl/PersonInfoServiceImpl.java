package com.dong.web.service.impl;

import com.dong.common.ResponseResult;
import com.dong.web.model.PersonInfoBean;
import com.dong.web.service.PersonInfoService;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

   /**
   * 查询人员信息列表
   *
   * @param bean
   * @param limit
   * @param page
   * @return
   */
   @Override
   public ResponseResult findPersonInfoList(PersonInfoBean bean, int limit, int page) {
      return null;
   }

   /**
   * 保存人员信息
   *
   * @param bean
   * @return
   */
   @Override
   public ResponseResult savePersonInfo(PersonInfoBean bean) {
      return null;
   }

   /**
   * 查询人员信息详细页面
   *
   * @param id
   * @return
   */
   @Override
   public ResponseResult getPersonInfoView(String id) {
      return null;
   }

   /**
   * 删除人员信息
   *
   * @param id
   * @return
   */
   @Override
   public ResponseResult deletePersonInfo(String id) {
      return null;
   }

}