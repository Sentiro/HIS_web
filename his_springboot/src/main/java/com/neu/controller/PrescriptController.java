package com.neu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neu.entity.po.Medicine;
import com.neu.entity.po.Prescription;
import com.neu.entity.vo.Pre_vo;
import com.neu.entity.vo.Prescription_vo;
import com.neu.service.PrescriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class PrescriptController {

    @Autowired
    PrescriptService prescriptService;

    @PostMapping(value = "/prescript")
    public String prescript(
            //JSONObject string
           // Pre_vo pre_vo
            @RequestBody Pre_vo pre_vo
            ){
        System.out.println(pre_vo);
        for(Prescription_vo pre:pre_vo.getPrescriptions()){
            Prescription prescription=new Prescription();
            prescription.setDoctorID(pre_vo.getDocID());
            prescription.setPreName(pre.getName());
            prescription.setRegisterID(pre_vo.getRegID());
            prescription.setStatus("已开立");
            prescription.setpTime(String.valueOf(LocalDateTime.now()));
            String medicines=JSON.toJSONString(pre.getMedicines());
            System.out.println(medicines);
            prescriptService.prescript(prescription,medicines);
        }
        return "success";

     //Pre_vo pre_vo= JSON.toJavaObject(string,Pre_vo.class);
     //return String.valueOf(pre_vo.getDoctorID());
       // return pre_vo.toString();
    }

    @GetMapping(value = "/searchMedicine")
    public List<Medicine> getMedicines(
            @RequestParam(value = "str") String str
    ) {
        return prescriptService.likeQuery(str);
    }
}
