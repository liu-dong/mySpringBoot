package com.dong.web.model;

import java.util.Date;

/**
*  人员信息
*
*  @author LD
*/
public class PersonInfoBean {
    private String id;//
    private String name;//
    private String identityCard;//身份证
    private Integer age;//
    private Date birthdate;//出生日期
    private Object sex;//0：男、1：女
    private String phone;//
    private String email;//
    private String presentAddress;//现住址
    private String nativePlace;//籍贯
    private String individualResume;//个人简介
    private Date createTime;//
    private Date updateTime;//


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getIdentityCard() {
        return this.identityCard;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public Object getSex() {
        return this.sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPresentAddress() {
        return this.presentAddress;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() {
        return this.nativePlace;
    }

    public void setIndividualResume(String individualResume) {
        this.individualResume = individualResume;
    }

    public String getIndividualResume() {
        return this.individualResume;
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