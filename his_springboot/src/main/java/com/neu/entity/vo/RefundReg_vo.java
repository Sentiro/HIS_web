package com.neu.entity.vo;

import com.neu.entity.po.Patient;
import com.neu.entity.po.RegisterInfo;

import java.util.List;

public class RefundReg_vo {
    private Patient patient;
    private List<RegisterInfo> registerInfos;

    @Override
    public String toString() {
        return "RefundReg_vo{" +
                "patient=" + patient +
                ", registerInfos=" + registerInfos +
                '}';
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<RegisterInfo> getRegisterInfos() {
        return registerInfos;
    }

    public void setRegisterInfos(List<RegisterInfo> registerInfos) {
        this.registerInfos = registerInfos;
    }
}
