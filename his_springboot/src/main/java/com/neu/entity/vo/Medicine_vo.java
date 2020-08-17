package com.neu.entity.vo;

public class Medicine_vo {
    private int id;
    private int num;
    private String usage;
    private String times;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", num=" + num +
                ", usage='" + usage + '\'' +
                ", times='" + times + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
