package com.dong.web.model;

import lombok.Data;

/**
 * @author LD
 * @date 2020/3/22 22:02
 */
@Data
public class SystemMenuBean {

    private String id;
    private String parentId;
    private String menuName;
    private Integer menuLevel;//菜单级别（一级菜单、二级菜单）
    private String menuIcon;//菜单图标
    private Integer menuOrder;//菜单排序
    private String menuUrl;//菜单地址
    private String menuPath;//菜单路径
    private Integer menuStatus;//菜单状态，是否显示
    private Integer hasChild;//是否有子菜单
}

