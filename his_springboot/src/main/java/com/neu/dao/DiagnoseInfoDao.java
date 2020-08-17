package com.neu.dao;

import com.neu.entity.po.DiagnoseInfo;

import java.util.List;

public interface DiagnoseInfoDao {

    public int update(DiagnoseInfo diagnoseInfo);

    public DiagnoseInfo queryForOne(int regID);

    public List<DiagnoseInfo> queryForList();

    public int insert(DiagnoseInfo diagnoseInfo);
}
