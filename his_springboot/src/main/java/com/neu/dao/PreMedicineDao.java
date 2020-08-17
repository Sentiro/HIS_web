package com.neu.dao;

import com.neu.entity.po.PreMedicine;

import java.util.List;

public interface PreMedicineDao {

    public List<PreMedicine> queryPreMedicineByPreID(int preID);
}
