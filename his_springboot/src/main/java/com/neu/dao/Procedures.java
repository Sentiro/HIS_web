package com.neu.dao;

import com.neu.entity.po.DiagnoseInfo;
import com.neu.entity.po.Prescription;
import com.neu.entity.vo.RegisterInfo_vo;

public interface Procedures {
    public String pay(int preID,int staffID);

    public String register(RegisterInfo_vo info);

    public String refund();

    public String diagnose(DiagnoseInfo info);

    public String prescript(Prescription prescription,String medicines);

    public String distributeMed(int bingliID);

    public String refundReg(int regID);
}
