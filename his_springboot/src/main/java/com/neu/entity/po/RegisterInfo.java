package com.neu.entity.po;

import java.util.Date;

public class RegisterInfo {
    private int registerID;
    private String regStatus;
    private String regDate;
    private int regLevel;
    private String regType;
    private int patientID;
    private int medRecordID;
    private int registrarID;
    private int billID;
    private String wubie;
    private String hasNote;
    private int doctorID;
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "RegisterInfo{" +
                "registerID=" + registerID +
                ", regStatus='" + regStatus + '\'' +
                ", regDate=" + regDate +
                ", regLevel=" + regLevel +
                ", regType='" + regType + '\'' +
                ", patientID=" + patientID +
                ", medRecordID=" + medRecordID +
                ", registrarID=" + registrarID +
                ", billID=" + billID +
                ", wubie='" + wubie + '\'' +
                ", hasNote='" + hasNote + '\'' +
                ", doctorID=" + doctorID +
                '}';
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getRegisterID() {
        return registerID;
    }

    public void setRegisterID(int registerID) {
        this.registerID = registerID;
    }

    public RegisterInfo() {
    }

    public RegisterInfo(String regStatus, String date, int level, String type, int patientID, int medRecordID, int registrarID, int billID, String wubie, String hasNote) {
        this.regStatus = regStatus;
        this.regDate = date;
        this.regLevel = level;
        this.regType = type;
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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getRegLevel() {
        return regLevel;
    }

    public void setRegLevel(int regLevel) {
        this.regLevel = regLevel;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
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
