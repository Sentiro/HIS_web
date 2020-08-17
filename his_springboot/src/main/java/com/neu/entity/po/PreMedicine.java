package com.neu.entity.po;

public class PreMedicine {
    private int ID;
    private int medicineID;
    private int prescriptionID;
    private int num;
    private String usage;
    private String  times;
    private String status;

    @Override
    public String toString() {
        return "PreMedicine{" +
                "ID=" + ID +
                ", medicineID=" + medicineID +
                ", prescriptionID=" + prescriptionID +
                ", num=" + num +
                ", usage='" + usage + '\'' +
                ", times='" + times + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(int medicineID) {
        this.medicineID = medicineID;
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
