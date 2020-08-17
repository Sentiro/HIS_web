package com.neu.dao.impl;

import com.neu.dao.Procedures;
import com.neu.entity.po.DiagnoseInfo;
import com.neu.entity.po.Prescription;
import com.neu.entity.vo.RegisterInfo_vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;


@Repository
public class ProceduresImpl implements Procedures {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public String pay(int preID,int staffID) {
        String result = (String) jdbcTemplate.execute(
                con -> {
                    String storedProc = "{call pay_bills (?,?,?)}";// 调用的sql
                    CallableStatement cs = con.prepareCall(storedProc);
                    cs.setObject(1, preID);// 设置输入参数的值
                    cs.setObject(2, staffID);// 设置输入参数的值
                    cs.registerOutParameter(3, Types.VARCHAR);// 注册输出参数的类型
                    return cs;
                }, (CallableStatementCallback) cs -> {
                    cs.execute();
                    return cs.getString(3);// 获取输出参数的值
                });
        return result;
    }

    @Override
    public String register(RegisterInfo_vo info) {
        String result = (String) jdbcTemplate.execute(
                new CallableStatementCreator() {
                    public CallableStatement createCallableStatement(Connection con) throws SQLException {
                        String sql = "{call register(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
                        CallableStatement stmt = con.prepareCall(sql);

                        stmt.setObject(2, info.getShenfenID());
                        stmt.setObject(3, info.getName());
                        stmt.setObject(4, info.getGender());
                        stmt.setObject(5, info.getBirthdate());
                        stmt.setObject(6, info.getAge());
                        stmt.setObject(7, info.getAgeType());
                        stmt.setObject(8, info.getAddress());
                        stmt.setObject(9, info.getRegDate());
                        stmt.setObject(10, info.getWubie());
                        stmt.setObject(11, info.getDoctorID());
                        stmt.setObject(12, info.getLevel());
                        stmt.setObject(13, info.getType());
                        stmt.setObject(14, info.getBillID());
                        stmt.setObject(15, info.getRegistrarID());

                        stmt.registerOutParameter(1, Types.VARCHAR);
                        return stmt;
                    }
                }, new CallableStatementCallback() {
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        cs.execute();
                        return cs.getObject(1);// 获取输出参数的值
                    }
                });

        return result;
    }

    @Override
    public String refund() {
        return null;
    }

    @Override
    public String diagnose(DiagnoseInfo info) {

        return null;
    }

    @Override
    public String prescript(Prescription prescription, String medicines) {
        System.out.println(prescription.getPrescriptionID()+" "+prescription.getRegisterID()+" "+medicines);
        String result = (String) jdbcTemplate.execute(
                con -> {
                    String storedProc = "{call prescript (?,?,?,?)}";// 调用的sql
                    CallableStatement cs = con.prepareCall(storedProc);
                    cs.setObject(1, prescription.getRegisterID());// 设置输入参数的值
                    cs.setObject(2, prescription.getPreName());// 设置输入参数的值
                    cs.setObject(3, medicines);// 设置输入参数的值

                    cs.registerOutParameter(4, Types.VARCHAR);// 注册输出参数的类型
                    return cs;
                }, (CallableStatementCallback) cs -> {
                    cs.execute();
                    return cs.getString(4);// 获取输出参数的值
                });
        return result;
    }

    @Override
    public String distributeMed(int bingliID) {
        String result = (String) jdbcTemplate.execute(
                con -> {
                    String storedProc = "{call distribute_medicine (?,?)}";// 调用的sql
                    CallableStatement cs = con.prepareCall(storedProc);
                    cs.setObject(1,bingliID);// 设置输入参数的值

                    cs.registerOutParameter(2, Types.VARCHAR);// 注册输出参数的类型
                    return cs;
                }, (CallableStatementCallback) cs -> {
                    cs.execute();
                    return cs.getString(2);// 获取输出参数的值
                });
        return result;
    }

    @Override
    public String refundReg(int regID) {
        String result = (String) jdbcTemplate.execute(
                con -> {
                    String storedProc = "{call register_refund (?,?)}";// 调用的sql
                    CallableStatement cs = con.prepareCall(storedProc);
                    cs.setObject(1,regID);// 设置输入参数的值

                    cs.registerOutParameter(2, Types.VARCHAR);// 注册输出参数的类型
                    return cs;
                }, (CallableStatementCallback) cs -> {
                    cs.execute();
                    return cs.getString(2);// 获取输出参数的值
                });
        return result;
    }
}
