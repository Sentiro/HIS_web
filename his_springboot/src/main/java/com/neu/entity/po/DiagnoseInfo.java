package com.neu.entity.po;

public class DiagnoseInfo {
    private int diagnoseID;
    private String dHistory;
    private String zhusu;
    private String type;
    private int registerID;
    private int doctorID;
    private String time;
    private int status;
    private int noteID;

    @Override
    public String toString() {
        return "DiagnoseInfo{" +
                "diagnoseID=" + diagnoseID +
                ", dHistory='" + dHistory + '\'' +
                ", zhusu='" + zhusu + '\'' +
                ", type='" + type + '\'' +
                ", registerID=" + registerID +
                ", doctorID=" + doctorID +
                ", time='" + time + '\'' +
                ", status=" + status +
                ", noteID=" + noteID +
                '}';
    }



    public int getDiagnoseID() {
        return diagnoseID;
    }

    public void setDiagnoseID(int diagnoseID) {
        this.diagnoseID = diagnoseID;
    }

    public String getdHistory() {
        return dHistory;
    }

    public void setdHistory(String dHistory) {
        this.dHistory = dHistory;
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

    public int getRegisterID() {
        return registerID;
    }

    public void setRegisterID(int registerID) {
        this.registerID = registerID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }
}
