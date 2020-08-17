package com.neu.entity.vo;

import com.neu.entity.po.Medicine;
import com.neu.entity.po.PreMedicine;

import java.util.List;

public class Prescription_vo {
    private int docID;
    private int regID;
    private String name;
    private String status;
    private List<Medicine_vo> medicines;


    @Override
    public String
    toString() {
        return "Prescription_vo{" +
                "docID=" + docID +
                ", regID=" + regID +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", medicines='" + medicines + '\'' +
                '}';
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Medicine_vo> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine_vo> medicines) {
        this.medicines = medicines;
    }
}
