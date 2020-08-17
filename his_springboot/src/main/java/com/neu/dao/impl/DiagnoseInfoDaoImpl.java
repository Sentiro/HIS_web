package com.neu.dao.impl;

import com.neu.dao.DiagnoseInfoDao;
import com.neu.entity.po.DiagnoseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DiagnoseInfoDaoImpl implements DiagnoseInfoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<DiagnoseInfo> mapper=new BeanPropertyRowMapper<>(DiagnoseInfo.class);


    @Override
    public int update(DiagnoseInfo info) {
        String sql="update diagnoseInfo set dHistory=?,zhusu=?,dType=?,doctorID=?,sTime=?,dStatus=?,noteID=? where registerID=?";
        return jdbcTemplate.update(sql,new Object[]{info.getdHistory(),info.getZhusu(),info.getType(),info.getDoctorID(),LocalDateTime.now(),info.getStatus(),info.getNoteID(),info.getRegisterID()});
    }

    @Override
    public DiagnoseInfo queryForOne(int regID) {
        String query="select diagnoseID from diagnoseInfo where registerID=? ";
        List<DiagnoseInfo> diagnoseInfos=jdbcTemplate.query(query,mapper,regID);
        if(diagnoseInfos.size()>0){
            return diagnoseInfos.get(0);
        }else
            return null;

    }

    @Override
    public List<DiagnoseInfo> queryForList() {
        return null;
    }

    /**
    * @Description: 插入一条病例首页
    * @Param:  病例首页diagnoseInfo
    * @return:  插入改行的diagnoseID
    * @Author: Sentiro
    * @Date: 2020/7/17
    */
    @Override
    public int insert(DiagnoseInfo diagnoseInfo) {
        diagnoseInfo.setTime(String.valueOf(LocalDateTime.now()));
        String sql="insert into diagnoseInfo(dHistory,zhusu,dType,registerID,doctorID,sTime,dStatus,noteID)" +
                "values(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                diagnoseInfo.getdHistory(),
                diagnoseInfo.getZhusu(),
                diagnoseInfo.getType(),
                diagnoseInfo.getRegisterID(),
                diagnoseInfo.getDoctorID(),
                diagnoseInfo.getTime(),
                diagnoseInfo.getStatus(),
                diagnoseInfo.getNoteID()
        );
        String query="select diagnoseID from diagnoseInfo where registerID=? ";
        int diagID=jdbcTemplate.queryForObject(query,Integer.class,diagnoseInfo.getRegisterID());
        return diagID;
    }
}
