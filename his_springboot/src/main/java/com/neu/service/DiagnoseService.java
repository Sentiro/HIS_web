package com.neu.service;

import com.neu.dao.*;
import com.neu.entity.po.DiagnoseInfo;
import com.neu.entity.po.Disease;
import com.neu.entity.po.DiseaseDiagnose;
import com.neu.entity.vo.Diagnose_vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DiagnoseService {

    @Autowired
    DiseaseDao diseaseDao;

    @Autowired
    Procedures procedures;

    @Autowired
    DiseaseDiagnoseDao diseaseDiagnoseDao;

    @Autowired
    DiagnoseInfoDao diagnoseInfoDao;

    @Autowired
    RegisterInfoDao registerInfoDao;

    public String diagnose(Diagnose_vo info){
        int bingliID =registerInfoDao.queryRegisterInfoByRegID(info.getRegID()).getMedRecordID();
        //更新diagnose
        DiagnoseInfo diagnoseInfo =new DiagnoseInfo();
        diagnoseInfo.setdHistory(info.getHistory());
        diagnoseInfo.setZhusu(info.getZhusu());
        diagnoseInfo.setDoctorID(info.getDoctorID());
        diagnoseInfo.setType(info.getType());
        diagnoseInfo.setNoteID(bingliID);
        diagnoseInfo.setRegisterID(info.getRegID());
        diagnoseInfo.setStatus(1);
        diagnoseInfo.setTime(String.valueOf(LocalDateTime.now()));
        DiagnoseInfo diag=diagnoseInfoDao.queryForOne(info.getRegID());
//        System.out.println("diag根据regID查到的"+diag.toString());
        int diagID=0;
        if(diag!=null){
            diagnoseInfoDao.update(diagnoseInfo);
            diagID=diag.getDiagnoseID();
        }else {
            diagID=diagnoseInfoDao.insert(diagnoseInfo);
        }
        //更新诊断疾病表
        List<Disease> diseases=info.getDiseases();
        for(Disease disease:diseases){
            DiseaseDiagnose diseaseDiagnose=new DiseaseDiagnose();
            diseaseDiagnose.setDatetime(String.valueOf(LocalDateTime.now()));
            diseaseDiagnose.setDiagnoseID(diagID);
            diseaseDiagnose.setRegID(info.getRegID());
            diseaseDiagnose.setDiseaseID(disease.getId());
            diseaseDiagnoseDao.insertOneDiseaseDiagnose(diseaseDiagnose);
        }
        //更新挂号的状态
        int i =registerInfoDao.updateStatus(info.getRegID(),"2");
        return "success";
    }

    public List<Disease> queryDiseaseLike(String str){
        return diseaseDao.queryLikeDisease(str);
    }


}
