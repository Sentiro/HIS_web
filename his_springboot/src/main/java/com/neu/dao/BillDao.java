package com.neu.dao;

import com.neu.entity.po.Bill;

import java.util.List;

public interface BillDao {
    /**
    * @Description: 根据病历号查找bill记录
    * @Param:
    * @return:
    * @Author: Sentiro
    * @Date: 2020/7/17
    */
    public List<Bill> queryBillsByRegID(int regID);


}
