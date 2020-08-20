package com.dong.web.model;

import java.util.Date;

/**
 * @author LD
 */
public class PermissionInfoBean {
    private String id;// 
    private String permissionName;// 权限名称
    private Integer permissionType;// 权限类型  0：菜单权限、1：操作权限
    private String resourceId;// 资源id(菜单表id)
    private Date createTime;//
    private Date updateTime;// 


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionName() {
        return this.permissionName;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public Integer getPermissionType() {
        return this.permissionType;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }
}