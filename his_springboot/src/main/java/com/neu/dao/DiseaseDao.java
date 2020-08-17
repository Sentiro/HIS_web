package com.neu.dao;

import com.neu.entity.po.Disease;

import java.util.List;

public interface DiseaseDao {
    public List<Disease> queryLikeDisease(String str);

}
