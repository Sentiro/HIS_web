package com.neu.entity.po;

public class User {

    private int uID;
    private String realName;
    private String uName;
    private String uPassword;
    private int departmentID;
    private int uType; //医生 挂号员 管理员
    private int uLevel; //专家 普通
    private int zhicheng;

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getuType() {
        return uType;
    }

    public void setuType(int uType) {
        this.uType = uType;
    }

    public int getuLevel() {
        return uLevel;
    }

    public void setuLevel(int uLevel) {
        this.uLevel = uLevel;
    }

    public int getZhicheng() {
        return zhicheng;
    }

    public void setZhicheng(int zhicheng) {
        this.zhicheng = zhicheng;
    }

    @Override
    public String toString() {
        return "User{" +
                "realName='" + realName + '\'' +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", departmentID=" + departmentID +
                ", uType=" + uType +
                ", uLevel=" + uLevel +
                ", zhicheng=" + zhicheng +
                '}';
    }

    public User(String realName, String uName, String uPassword, int departmentID, int uType, int uLevel, int zhicheng) {
        this.realName = realName;
        this.uName = uName;
        this.uPassword = uPassword;
        this.departmentID = departmentID;
        this.uType = uType;
        this.uLevel = uLevel;
        this.zhicheng = zhicheng;
    }

    public User(String uName, String uPassword) {
        this.uName = uName;
        this.uPassword = uPassword;
    }

    public User() {
    }
}
