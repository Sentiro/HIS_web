package com.neu.dao;

import com.neu.entity.po.Medicine;

import java.util.List;

public interface MedicineDao {

    public List<Medicine> queryLikeMedicine(String str);

    public Medicine queryOneByID(int id);
}
