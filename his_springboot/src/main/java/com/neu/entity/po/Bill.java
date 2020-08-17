package com.neu.entity.po;

import java.time.format.DateTimeFormatter;

public class Bill {
    private int regID;
    private int projectID;
    private String invoiceID;
    private String name;
    private float price;
    private String projectType;
    private String num;
    private int departID;
    private String time;
    private int registrarID;
    private String correspondID;

    @Override
    public String toString() {
        return "Bill{" +
                "regID=" + regID +
                ", projectID=" + projectID +
                ", invoiceID='" + invoiceID + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", projectType='" + projectType + '\'' +
                ", num='" + num + '\'' +
                ", departID=" + departID +
                ", time='" + time + '\'' +
                ", registrarID=" + registrarID +
                ", correspondID='" + correspondID + '\'' +
                '}';
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getDepartID() {
        return departID;
    }

    public void setDepartID(int departID) {
        this.departID = departID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRegistrarID() {
        return registrarID;
    }

    public void setRegistrarID(int registrarID) {
        this.registrarID = registrarID;
    }

    public String getCorrespondID() {
        return correspondID;
    }

    public void setCorrespondID(String correspondID) {
        this.correspondID = correspondID;
    }
}
