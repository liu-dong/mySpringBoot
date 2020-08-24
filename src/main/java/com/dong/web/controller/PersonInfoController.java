package com.dong.web.controller;

import com.dong.common.ResponseResult;
import com.dong.web.model.PersonInfoBean;
import com.dong.web.service.PersonInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*  人员信息管理
*
*  @author LD
*/
@Api(tags = "人员管理模块")
@RestController
@RequestMapping("/personInfo")
public class PersonInfoController {

    @Autowired
    private PersonInfoService personInfoService;

    /**
    * 查询人员信息列表
    *
    * @param bean
    * @param limit
    * @param page
    * @return
    */
    @PostMapping("/findPersonInfoList")
    public ResponseResult findPersonInfoList(PersonInfoBean bean, int limit, int page) {
        return personInfoService.findPersonInfoList(bean, limit, page);
    }

    /**
    * 保存人员信息
    *
    * @param bean
    * @return
    */
    @PostMapping("/savePersonInfo")
    public ResponseResult savePersonInfo(PersonInfoBean bean) {
        return personInfoService.savePersonInfo(bean);
    }

    /**
    * 查询人员信息详细页面
    *
    * @param id
    * @return
    */
    @GetMapping("/getPersonInfoView")
    public ResponseResult getPersonInfoView(String id) {
        return personInfoService.getPersonInfoView(id);
    }

    /**
    * 删除人员信息
    *
    * @param id
    * @return
    */
    @PostMapping("/deletePersonInfo")
    public ResponseResult deletePersonInfo(String id) {
        return personInfoService.deletePersonInfo(id);
    }
}