package com.dong.web.controller;

import com.dong.utils.ResponseResult;
import com.dong.web.model.SystemMenuBean;
import com.dong.web.service.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单管理模块
 *
 * @author LD
 */
@RestController
@RequestMapping("/systemMenu")
public class SystemMenuController {

    @Autowired
    private SystemMenuService systemMenuService;

    @RequestMapping("/findSystemMenuList")
    public ResponseResult findSystemMenuList(){
        SystemMenuBean bean = new SystemMenuBean();
        bean.setHasChild(1);
        int limit = 1;
        int page = 1;
        return systemMenuService.findSystemMenuList(bean,limit,page);
    }
}
