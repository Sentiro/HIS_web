package com.neu.service;

import com.neu.dao.MedicineDao;
import com.neu.dao.Procedures;
import com.neu.entity.po.Medicine;
import com.neu.entity.po.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptService {

    @Autowired
    Procedures procedures;

    @Autowired
    MedicineDao medicineDao;

    public String prescript(Prescription prescription,String medicine){
        return procedures.prescript(prescription,medicine);
    }

    public List<Medicine> likeQuery(String med){
        return medicineDao.queryLikeMedicine(med);
    }
}
