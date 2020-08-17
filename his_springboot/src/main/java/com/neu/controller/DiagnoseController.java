package com.neu.controller;

import com.alibaba.fastjson.JSONObject;
import com.neu.entity.po.DiagnoseInfo;
import com.neu.entity.po.Disease;
import com.neu.entity.po.Patient;
import com.neu.entity.vo.Diagnose_vo;
import com.neu.entity.vo.RegisterInfo_vo;
import com.neu.service.DiagnoseService;
import com.neu.service.RegisterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class DiagnoseController {

    @Autowired
    DiagnoseService diagnoseService;

    @Autowired
    RegisterInfoService registerInfoService;

    @PostMapping(value = "/docMain/getPatients")
    public List<RegisterInfo_vo> getPatients(
            @RequestParam(value = "id",required = true) int id,
            @RequestParam(value = "date",required = true) String date
            ){
        return registerInfoService.getPatientOfDoc(id,date);
    }

  /*  @PostMapping(value = "/diagnose")
    public String diagnose(Diagnose_vo diagnose_vo){
        return diagnose_vo.toString();
       //return diagnoseService.diagnose(diagnose_vo);
    }*/
  @PostMapping(value = "/diagnose",produces="application/json;charset=UTF-8")
  public String diagnose(@RequestBody Diagnose_vo diagnose_vo){
      System.out.println(diagnose_vo.toString());

     // return diagnose_vo.toString();
      return diagnoseService.diagnose(diagnose_vo);
  }

    @GetMapping(value = "/searchDisease")
    public List<Disease> getDiseaseLike(
            @RequestParam(value = "str") String str
    ){
        return diagnoseService.queryDiseaseLike(str);
    }
}
