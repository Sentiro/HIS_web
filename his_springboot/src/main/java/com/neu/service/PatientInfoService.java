package com.neu.service;

import com.neu.dao.PatientDao;
import com.neu.dao.RegisterInfoDao;
import com.neu.entity.po.Patient;
import com.neu.entity.po.RegisterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientInfoService {

    @Autowired
    PatientDao patientDao;

    @Autowired
    RegisterInfoDao registerInfoDao;

    public Patient getPatientByBingliID(int id){
        List<Patient> patients=patientDao.queryPatientByBingliID(id);
        if(patients.size()>0){
            return patients.get(0);
        }else
       return null;
    }

    public int getBingliID(){
        return patientDao.queryAvailableBingliID();
    }



}
