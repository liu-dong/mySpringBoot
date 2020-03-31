package com.dong.web.controller;

import com.dong.utils.ResponseResult;
import com.dong.web.model.SystemMenuBean;
import com.dong.web.service.SystemMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单管理模块
 *
 * @author LD
 */
@Api(tags = "菜单管理模块")
@RestController
@RequestMapping("/system/systemMenu")
public class SystemMenuController {

    @Autowired
    private SystemMenuService systemMenuService;

    /**
     * 查询菜单信息列表
     * @return
     */
    @PostMapping("/findSystemMenuList")
    public ResponseResult findSystemMenuList(){
        SystemMenuBean bean = new SystemMenuBean();
        bean.setHasChild(1);
        int limit = 2;
        int page = 1;
        return systemMenuService.findSystemMenuList(bean,limit,page);
    }

    /**
     * 获取菜单树
     * @return
     */
    @ApiOperation("获取菜单树")
    @GetMapping("/getSystemMenuTree")
    public ResponseResult getSystemMenuTree(int type){
        return systemMenuService.getSystemMenuTree(type);
    }

    /**
     * 保存菜单信息
     *
     * @param bean
     * @return
     */
    @RequestMapping("/saveSystemMenuInfo")
    public ResponseResult saveSystemMenuInfo(SystemMenuBean bean){
        return systemMenuService.saveSystemMenuInfo(bean);
    }

    /**
     * 查询菜单详细页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/getSystemMenuView")
    public ResponseResult getSystemMenuView(String id){
        return systemMenuService.getSystemMenuView(id);
    }

    /**
     * 删除菜单信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteSystemMenuInfo")
    public ResponseResult deleteSystemMenuInfo(String id){
        return systemMenuService.deleteSystemMenuInfo(id);
    }
}
