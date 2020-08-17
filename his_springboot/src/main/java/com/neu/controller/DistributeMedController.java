package com.neu.controller;

import com.neu.entity.vo.Pay_vo;
import com.neu.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class DistributeMedController {

    @Autowired
    BillService billService;

    @GetMapping(value = "/distribute/query")
    public List<Pay_vo> getDistributeList(
            @RequestParam(value = "bingliID") int bingliID
    ){
        return billService.getBills(bingliID,"已缴费");
    }

    @PostMapping(value="/distribute")
    public String distributeMed(
            @RequestParam(value = "bingliID") int bingliID
    ){
        return billService.distributeMed(bingliID);
    }


}
