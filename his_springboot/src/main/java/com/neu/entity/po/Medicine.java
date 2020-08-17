package com.neu.entity.po;

public class Medicine {
    private int ID;
    private String medicineID;
    private String mName;
    private float price;
    private String standard;
    private String pinyin;

    public String getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "ID=" + ID +
                ", mName='" + mName + '\'' +
                ", price=" + price +
                ", standard='" + standard + '\'' +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}
