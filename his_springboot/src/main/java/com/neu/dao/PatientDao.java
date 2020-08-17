package com.neu.dao;

import com.neu.entity.po.Patient;

import java.util.List;


public interface PatientDao {

    public List<Patient> queryPatientByBingliID(int id);

    public int queryAvailableBingliID();
}
