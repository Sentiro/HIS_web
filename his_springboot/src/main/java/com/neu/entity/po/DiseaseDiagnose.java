package com.neu.entity.po;

public class DiseaseDiagnose {
    private int id;
    private int diseaseID;
    private int diagnoseID;
    private String datetime;
    private int regID;

    @Override
    public String toString() {
        return "DiseaseDiagnoseDao{" +
                "id=" + id +
                ", diseaseID=" + diseaseID +
                ", diagnoseID=" + diagnoseID +
                ", datetime='" + datetime + '\'' +
                ", regID=" + regID +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(int diseaseID) {
        this.diseaseID = diseaseID;
    }

    public int getDiagnoseID() {
        return diagnoseID;
    }

    public void setDiagnoseID(int diagnoseID) {
        this.diagnoseID = diagnoseID;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }
}
