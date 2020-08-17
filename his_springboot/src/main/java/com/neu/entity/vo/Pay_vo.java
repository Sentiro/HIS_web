package com.neu.entity.vo;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

import java.util.Date;

public class Pay_vo {
    private String docName;
    private int docID;
    private int regID;
    private String bingliID;
    private String name;
    private String proName;
    private int num;
    private float price;
    private String status;
    private String date;
    private int preID;

    @Override
    public String toString() {
        return "Pay_vo{" +
                "docName='" + docName + '\'' +
                ", docID=" + docID +
                ", regID=" + regID +
                ", bingliID='" + bingliID + '\'' +
                ", name='" + name + '\'' +
                ", proName='" + proName + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", preID=" + preID +
                '}';
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public int getPreID() {
        return preID;
    }

    public void setPreID(int preID) {
        this.preID = preID;
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public String getBingliID() {
        return bingliID;
    }

    public void setBingliID(String bingliID) {
        this.bingliID = bingliID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
