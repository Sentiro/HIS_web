package com.neu.controller;

import com.neu.entity.po.Bill;
import com.neu.entity.po.Patient;
import com.neu.entity.vo.PayReturn_vo;
import com.neu.entity.vo.Pay_vo;
import com.neu.service.BillService;
import com.neu.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class PayController {

    @Autowired
    BillService billService;

    @Autowired
    PatientInfoService patientInfoService;

    @GetMapping(value = "/pay/getBills")
    public List<Pay_vo> getBills(
            @RequestParam(value = "bingliID",required = true) int bingliID
    ){
        //po 转换成 vo
        List<Pay_vo> bills =billService.getBills(bingliID,"已开立");
        return bills;
    }

    /**
    * @Description: 根据病历号获取患者信息
    * @Param: bingliID
    * @return: Patient
    * @Author: Sentiro
    * @Date: 2020/7/18
    */
    @GetMapping(value = "/pay/getPatientInfo")
    public Patient getPatient(
            @RequestParam(value = "bingliID",required = true) int bingliID
    ){
        return patientInfoService.getPatientByBingliID(bingliID);
    }

    /**
    * @Description: 缴费一个处方下的所有项目药品
    * @Param:  处方号，挂号员ID
    * @return:  String
    * @Author: Sentiro
    * @Date: 2020/7/17
    */
    @PostMapping(value = "/pay")
    public String payBills(
            @RequestBody PayReturn_vo payReturn_vo
            ){
//        return payReturn_vo.toString();
        int count=0;
        for(Integer i:payReturn_vo.getPreID()){

            if(billService.payOnePre(i,payReturn_vo.getRegistrarID()).equals("success")){
                count++;
            }
        }
        if(count==payReturn_vo.getPreID().length){
            return "成功";
        }else{
            return "失败";
        }

   }
}
