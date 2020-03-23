package com.dong.web.login.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sys_menu", schema = "my_data")
public class SysMenu {
    private String id;
    private String parentId;
    private String menuName;
    private int menuLevel;
    private String menuIcon;
    private Integer menuOrder;
    private String menuUrl;
    private String menuPath;
    private Integer menuStatus;
    private int hasChild;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Basic
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parent_id", nullable = true, length = 36)
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "menu_name", nullable = false, length = 50)
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "menu_level", nullable = false)
    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }

    @Basic
    @Column(name = "menu_icon", nullable = true, length = 100)
    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    @Basic
    @Column(name = "menu_order", nullable = true)
    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    @Basic
    @Column(name = "menu_url", nullable = true, length = 100)
    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Basic
    @Column(name = "menu_path", nullable = true, length = 255)
    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    @Basic
    @Column(name = "menu_status", nullable = true)
    public Integer getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Integer menuStatus) {
        this.menuStatus = menuStatus;
    }

    @Basic
    @Column(name = "has_child", nullable = false)
    public int getHasChild() {
        return hasChild;
    }

    public void setHasChild(int hasChild) {
        this.hasChild = hasChild;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysMenu sysMenu = (SysMenu) o;
        return menuLevel == sysMenu.menuLevel &&
                hasChild == sysMenu.hasChild &&
                Objects.equals(id, sysMenu.id) &&
                Objects.equals(parentId, sysMenu.parentId) &&
                Objects.equals(menuName, sysMenu.menuName) &&
                Objects.equals(menuIcon, sysMenu.menuIcon) &&
                Objects.equals(menuOrder, sysMenu.menuOrder) &&
                Objects.equals(menuUrl, sysMenu.menuUrl) &&
                Objects.equals(menuPath, sysMenu.menuPath) &&
                Objects.equals(menuStatus, sysMenu.menuStatus) &&
                Objects.equals(createTime, sysMenu.createTime) &&
                Objects.equals(updateTime, sysMenu.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, menuName, menuLevel, menuIcon, menuOrder, menuUrl, menuPath, menuStatus, hasChild, createTime, updateTime);
    }
}
