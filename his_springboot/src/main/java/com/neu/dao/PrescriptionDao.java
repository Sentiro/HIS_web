package com.neu.dao;

import com.neu.entity.po.Prescription;

import java.util.List;

public interface PrescriptionDao {

    public List<Prescription> queryByRegID(int regID);
}
