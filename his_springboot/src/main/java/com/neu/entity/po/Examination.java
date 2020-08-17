package com.neu.entity.po;

public class Examination {
    private String examName;
    private int examID;
    private String status;
    private float price;
    private int regID;
    private int docID;
    private String result;
    private int projectID;
    private int num;

    @Override
    public String toString() {
        return "Examination{" +
                "examName='" + examName + '\'' +
                ", examID=" + examID +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", regID=" + regID +
                ", docID=" + docID +
                ", result='" + result + '\'' +
                ", projectID=" + projectID +
                ", num=" + num +
                '}';
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
