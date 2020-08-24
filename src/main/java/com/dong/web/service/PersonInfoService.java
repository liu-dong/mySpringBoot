package com.dong.web.service;

import com.dong.common.ResponseResult;
import com.dong.web.model.PersonInfoBean;

public interface PersonInfoService {

    /**
    * 查询人员信息列表
    *
    * @param bean
    * @param limit
    * @param page
    * @return
    */
    ResponseResult findPersonInfoList(PersonInfoBean bean, int limit, int page);

    /**
    * 保存人员信息
    *
    * @param bean
    * @return
    */
    ResponseResult savePersonInfo(PersonInfoBean bean);

    /**
    * 查询人员信息详细页面
    *
    * @param id
    * @return
    */
    ResponseResult getPersonInfoView(String id);

    /**
    * 删除人员信息
    *
    * @param id
    * @return
    */
    ResponseResult deletePersonInfo(String id);
}