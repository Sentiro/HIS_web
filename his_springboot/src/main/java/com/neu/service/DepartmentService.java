package com.neu.service;

import com.neu.dao.DepartmentDao;
import com.neu.entity.po.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    public List<Department> getDepart(){
        return departmentDao.getDeparts();
    }
}
