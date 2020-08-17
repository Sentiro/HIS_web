package com.neu.entity.po;

public class Invoice {
    private int id;
    private int invoiceID;
    private int amount;
    private String status;
    private String datetime;
    private int regID;
    private int registrarID;
    private String type;
    private int chonghongID;

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceID=" + invoiceID +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", datetime='" + datetime + '\'' +
                ", regID=" + regID +
                ", registrarID=" + registrarID +
                ", type='" + type + '\'' +
                ", chonghongID=" + chonghongID +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getRegistrarID() {
        return registrarID;
    }

    public void setRegistrarID(int registrarID) {
        this.registrarID = registrarID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getChonghongID() {
        return chonghongID;
    }

    public void setChonghongID(int chonghongID) {
        this.chonghongID = chonghongID;
    }
}
