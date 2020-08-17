package com.neu.entity.vo;

import com.neu.entity.po.Disease;

import java.util.List;

public class Diagnose_vo {
    private String history;
    private String zhusu;
    private String type;
    private String jiwang;
    private String guoming;
    private String exam;
    private int doctorID;
    private int regID;
    private String diseaseList;
    private List<Disease> diseases;

    public String getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(String diseaseList) {
        this.diseaseList = diseaseList;
    }

    @Override
    public String toString() {
        return "Diagnose_vo{" +
                "history='" + history + '\'' +
                ", zhusu='" + zhusu + '\'' +
                ", type='" + type + '\'' +
                ", jiwang='" + jiwang + '\'' +
                ", guoming='" + guoming + '\'' +
                ", exam='" + exam + '\'' +
                ", doctorID=" + doctorID +
                ", regID=" + regID +
                ", diseases=" + diseases +
                '}';
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getZhusu() {
        return zhusu;
    }

    public void setZhusu(String zhusu) {
        this.zhusu = zhusu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJiwang() {
        return jiwang;
    }

    public void setJiwang(String jiwang) {
        this.jiwang = jiwang;
    }

    public String getGuoming() {
        return guoming;
    }

    public void setGuoming(String guoming) {
        this.guoming = guoming;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }
}
