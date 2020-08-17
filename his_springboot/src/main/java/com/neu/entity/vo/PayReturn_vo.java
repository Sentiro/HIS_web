package com.neu.entity.vo;

import java.util.Arrays;

public class PayReturn_vo {
    private int []preID;
    private int registrarID;

    @Override
    public String toString() {
        return "PayReturn_vo{" +
                "preID=" + Arrays.toString(preID) +
                ", registrarID=" + registrarID +
                '}';
    }

    public int[] getPreID() {
        return preID;
    }

    public void setPreID(int[] preID) {
        this.preID = preID;
    }

    public int getRegistrarID() {
        return registrarID;
    }

    public void setRegistrarID(int registrarID) {
        this.registrarID = registrarID;
    }
}
