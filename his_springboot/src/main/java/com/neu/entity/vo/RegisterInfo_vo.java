package com.neu.entity.vo;

import java.util.Date;

public class RegisterInfo_vo {

    private int regID;
    private String name;
    private int age;
    private String gender;
    private String birthdate;
    private String ageType;
    private String shenfenID;
    private String regStatus;
    private String address;

    @Override
    public String toString() {
        return "RegisterInfo_vo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", ageType='" + ageType + '\'' +
                ", shenfenID='" + shenfenID + '\'' +
                ", regStatus='" + regStatus + '\'' +
                ", address='" + address + '\'' +
                ", regDate='" + regDate + '\'' +
                ", department=" + department +
                ", doctorID=" + doctorID +
                ", level=" + level +
                ", type='" + type + '\'' +
                ", patientID=" + patientID +
                ", medRecordID=" + medRecordID +
                ", registrarID=" + registrarID +
                ", billID=" + billID +
                ", wubie='" + wubie + '\'' +
                ", hasNote='" + hasNote + '\'' +
                '}';
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String  getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    private String regDate;
    private int department;
    private int doctorID;
    private int level;
    private String type;
    private int patientID;
    private int medRecordID;
    private int registrarID;
    private int billID;
    private String wubie;
    private String hasNote;

    public RegisterInfo_vo() {
    }

    public RegisterInfo_vo(String regStatus, Date date, int level, String type, int patientID, int medRecordID, int registrarID, int billID, String wubie, String hasNote) {
        this.regStatus = regStatus;
        this.level = level;
        this.type = type;
        this.patientID = patientID;
        this.medRecordID = medRecordID;
        this.registrarID = registrarID;
        this.billID = billID;
        this.wubie = wubie;
        this.hasNote = hasNote;
    }

    public String getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(String regStatus) {
        this.regStatus = regStatus;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getMedRecordID() {
        return medRecordID;
    }

    public void setMedRecordID(int medRecordID) {
        this.medRecordID = medRecordID;
    }

    public int getRegistrarID() {
        return registrarID;
    }

    public void setRegistrarID(int registrarID) {
        this.registrarID = registrarID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public String getWubie() {
        return wubie;
    }

    public void setWubie(String wubie) {
        this.wubie = wubie;
    }

    public String getHasNote() {
        return hasNote;
    }

    public void setHasNote(String hasNote) {
        this.hasNote = hasNote;
    }
}

