package com.neu.service;

import com.neu.dao.LevelDao;
import com.neu.dao.PatientDao;
import com.neu.dao.RegisterInfoDao;
import com.neu.dao.impl.ProceduresImpl;
import com.neu.entity.po.Patient;
import com.neu.entity.po.RegisterInfo;
import com.neu.entity.vo.RegisterInfo_vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterInfoService {
    @Autowired
    ProceduresImpl procedures;

    @Autowired
    RegisterInfoDao registerInfoDao;

    @Autowired
    PatientDao patientDao;

    @Autowired
    LevelDao levelDao;
    //update info
    public String insert(RegisterInfo_vo info){
         return procedures.register(info);
    }

    public String refund(int regID){
        return procedures.refundReg(regID);
    }

    public List<RegisterInfo_vo> getPatientOfDoc(int docID, String date){
        List<RegisterInfo_vo> list=new ArrayList<>();
        List<RegisterInfo> registerInfos=registerInfoDao.queryRegisterInfoByDoc(docID,date);
        for(RegisterInfo info:registerInfos){
            Patient patient=patientDao.queryPatientByBingliID(info.getMedRecordID()).get(0);
            RegisterInfo_vo registerInfo_vo=new RegisterInfo_vo();
            registerInfo_vo.setAge(patient.getAge());
            registerInfo_vo.setAgeType(patient.getAgeType());
            registerInfo_vo.setName(patient.getpName());
            registerInfo_vo.setMedRecordID(patient.getMedRecordID());
            registerInfo_vo.setRegID(info.getRegisterID());
            registerInfo_vo.setRegStatus(info.getRegStatus());
            registerInfo_vo.setGender(patient.getSex());
            list.add(registerInfo_vo);
        }
        return list;
    }

    public float getLevelPrice(int id){
        return levelDao.queryLevelPriceByID(id);
    }

    public List<RegisterInfo> getRegisterInfoByBingliID(int bingliID){
        return  registerInfoDao.queryRegisterInfoByBingliID(bingliID);
    }
}
