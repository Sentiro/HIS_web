package com.neu.entity.vo;

import java.util.List;

public class Pre_vo {
    private List<Prescription_vo> prescriptions;
    private int docID;
    private int regID;

    @Override
    public String toString() {
        return "Pre_vo{" +
                "prescriptions=" + prescriptions +
                ", docID=" + docID +
                ", regID=" + regID +
                '}';
    }

    public List<Prescription_vo> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription_vo> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }
}
