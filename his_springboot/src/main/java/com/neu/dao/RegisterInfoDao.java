package com.neu.dao;


import com.neu.entity.po.Patient;
import com.neu.entity.po.RegisterInfo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RegisterInfoDao {


    List<RegisterInfo> queryRegisterInfoByDoc(int docID, String date);

    public List<RegisterInfo> queryRegisterInfoByBingliID(int bingliID);

    public RegisterInfo queryRegisterInfoByRegID(int regID);

    /**
    * @Description: -- 1-已挂号未看诊 2-已看诊 3-已退号 4-已失效 --
    * @Param: regID,status 状态
    * @return: 改变的行数
    * @Author: Sentiro
    * @Date: 2020/7/17
    */
    public int updateStatus(int regID,String status);
}
