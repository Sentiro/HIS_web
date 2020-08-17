package com.neu.entity.po;

public class Department {
    private String dName;
    private int departmentID;
    private String DeptCode;

    @Override
    public String toString() {
        return "Department{" +
                "dName='" + dName + '\'' +
                ", departmentID=" + departmentID +
                ", DeptCode='" + DeptCode + '\'' +
                '}';
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        this.DeptCode = deptCode;
    }
}
