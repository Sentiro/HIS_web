package com.neu.entity.po;

import java.util.Date;

public class Patient {
    private String pName;
    private int age;
    private String sex;
    private String birthdate;
    private String ageType;
    private String shenfenID;
    private String regStatus;
    private String address;
    private int medRecordID;


    @Override
    public String toString() {
        return "Patient{" +
                "pName='" + pName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthdate=" + birthdate +
                ", ageType='" + ageType + '\'' +
                ", shenfenID='" + shenfenID + '\'' +
                ", regStatus='" + regStatus + '\'' +
                ", address='" + address + '\'' +
                ", medRecordID=" + medRecordID +
                '}';
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAgeType() {
        return ageType;
    }

    public void setAgeType(String ageType) {
        this.ageType = ageType;
    }

    public String getShenfenID() {
        return shenfenID;
    }

    public void setShenfenID(String shenfenID) {
        this.shenfenID = shenfenID;
    }

    public String getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(String regStatus) {
        this.regStatus = regStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMedRecordID() {
        return medRecordID;
    }

    public void setMedRecordID(int medRecordID) {
        this.medRecordID = medRecordID;
    }
}
