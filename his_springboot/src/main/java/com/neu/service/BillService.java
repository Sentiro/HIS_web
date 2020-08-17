package com.neu.service;

import com.neu.dao.*;
import com.neu.entity.po.*;
import com.neu.entity.vo.Pay_vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    UserDao userDao;

    @Autowired
    BillDao billDao;

    @Autowired
    RegisterInfoDao registerInfoDao;

    @Autowired
    Procedures procedures;

    @Autowired
    PreMedicineDao preMedicineDao;

    @Autowired
    PrescriptionDao prescriptionDao;

    @Autowired
    MedicineDao medicineDao;

    @Autowired
    PatientDao patientDao;
    /**
    * @Description: 根据病历号返回需要缴费的项目列表
    * @Param: int bingliID
    * @return: List Bill
    * @Author: Sentiro
    * @Date: 2020/7/17
    */
    public List<Pay_vo> getBills(int bingliID,String status){

        List<Pay_vo> payBills=new ArrayList<>();

        List<Patient> patientList=patientDao.queryPatientByBingliID(bingliID);

        //查找患者信息
        if (patientList.size()>0){
            Patient patient=patientList.get(0);
            //查找regID
            List<RegisterInfo> registerInfos= registerInfoDao.queryRegisterInfoByBingliID(bingliID);
            for(RegisterInfo info:registerInfos){
                //查找医生
                User doc=userDao.queryUserByID(info.getDoctorID());
                //查找prescription
                List<Prescription> prescriptions=prescriptionDao.queryByRegID(info.getRegisterID());
                for (Prescription prescription:prescriptions){
                    //查找preMedicine
                    List<PreMedicine> preMedicines=preMedicineDao.queryPreMedicineByPreID(prescription.getPrescriptionID());
                    for (PreMedicine p:preMedicines){
                        if(p.getStatus().equals(status)){

                            //查询药品名称
                            Medicine med=medicineDao.queryOneByID(p.getMedicineID());

                            Pay_vo pay=new Pay_vo();
                            pay.setStatus(p.getStatus());
                            pay.setBingliID(String.valueOf(bingliID));
                            pay.setDate(prescription.getpTime());
                            pay.setName(patient.getpName());
                            pay.setNum(p.getNum());
                            pay.setDocID(info.getDoctorID());
                            pay.setDocName(doc.getRealName());
                            pay.setPreID(prescription.getPrescriptionID());
                            //  pay.setProName(bill.getp);
                            pay.setRegID(info.getRegisterID());
                            pay.setProName(med.getmName());
                            pay.setPrice(med.getPrice());
                            //pay.setStatus(bill.);

                            //加入列表
                            payBills.add(pay);
                        }
                    }
                }
        }
            return payBills;
        }else {
            return null;
        }


    }

    public String payOnePre(int preID,int staffID){
        return procedures.pay(preID,staffID);
    }

    public String distributeMed(int bingliID){
        return procedures.distributeMed(bingliID);
    }
}

