package com.neu.controller;

import com.neu.Utils;
import com.neu.entity.po.Department;
import com.neu.entity.po.Patient;
import com.neu.entity.po.User;
import com.neu.entity.vo.RegisterInfo_vo;
import com.neu.service.DepartmentService;
import com.neu.service.PatientInfoService;
import com.neu.service.RegisterInfoService;
import com.neu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class RegisterController {

    @Autowired
    RegisterInfoService registerInfoService;

    @Autowired
    PatientInfoService patientService;

    @Autowired
    UserService userService;

    @Autowired
    DepartmentService departmentService;
    /**
    * @Description: 插入挂号信息
    * @Param:  RegisterInfo_vo
    * @return:  String 成功或失败
    * @Author: Sentiro
    * @Date: 2020/7/16
    */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register( RegisterInfo_vo registerInfo_vo) {
        //  productRepo.put(product.getID(), product);
        System.out.println("[controller]:插入挂号信息"+registerInfo_vo);
        registerInfo_vo.setBirthdate(Utils.format(registerInfo_vo.getBirthdate()));
        registerInfo_vo.setRegDate(Utils.format(registerInfo_vo.getRegDate()));
        //System.out.println("here");
        return registerInfoService.insert(registerInfo_vo);
    }

    //查询科室
    /**
    * @Description:  返回科室信息
    * @Param:
    * @return:  list<Department>
    * @Author: Sentiro
    * @Date: 2020/7/16
    */
    @GetMapping(value = "/register/getDepart")
    public List<Department> getDepart(){
        System.out.println("[get]:获取科室");
        return departmentService.getDepart();
    }

    /**
    * @Description:  根据科室id返回医生信息
    * @Param:  int id
    * @return:  List<User>
    * @Author: Sentiro
    * @Date: 2020/7/16
    */
    @RequestMapping(value = "/register/getDocs")
    public List<User> searchDoctors(
            @RequestParam(value = "departID") int id
    ){
        return userService.getDoctorByDepartment(id);
    }

    @GetMapping(value = "/register/PatientInfo")
    public Patient getPatientInfoByBingliID(
            @RequestParam(value = "bingliID") int id
    ){
       return patientService.getPatientByBingliID(id);
    }

    @GetMapping(value = "/register/getLevelPrice")
    public Float getPrice(
            @RequestParam(value = "levelID") int levelID
    ){
        return registerInfoService.getLevelPrice(levelID);
    }

    @GetMapping(value = "/getBingliID")
    public int getBingliID(){
        return patientService.getBingliID()+1;
    }

}