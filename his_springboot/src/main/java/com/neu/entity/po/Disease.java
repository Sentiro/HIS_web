package com.neu.entity.po;

public class Disease {
    private String  ICD;
    private int id;
    private  String disName;
    private String pinyin;

    @Override
    public String toString() {
        return "Disease{" +
                "ICD='" + ICD + '\'' +
                ", id=" + id +
                ", disName='" + disName + '\'' +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }

    public String getICD() {
        return ICD;
    }

    public void setICD(String ICD) {
        this.ICD = ICD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}
