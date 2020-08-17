package com.neu.controller;

import com.neu.dao.Procedures;
import com.neu.entity.po.Patient;
import com.neu.entity.po.RegisterInfo;
import com.neu.entity.vo.RefundReg_vo;
import com.neu.entity.vo.RegisterInfo_vo;
import com.neu.service.PatientInfoService;
import com.neu.service.RegisterInfoService;
import com.neu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class RefundRegController {
    @Autowired
    RegisterInfoService registerInfoService;

    @Autowired
    PatientInfoService patientInfoService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/refundReg/getRegInfoList")
    public RefundReg_vo getRegInfoList(
            @RequestParam(value = "bingliID") int bingliID
    ){
        RefundReg_vo info=new RefundReg_vo();
        Patient patient=patientInfoService.getPatientByBingliID(bingliID);
        List<RegisterInfo> registerInfo=registerInfoService.getRegisterInfoByBingliID(bingliID);
        info.setPatient(patient);
        info.setRegisterInfos(registerInfo);
        return info;
    }

    @PostMapping(value="/refundReg")
    public String refundReg(
            @RequestParam(value="regID") int regID
    ){
        return registerInfoService.refund(regID);
    }

}
