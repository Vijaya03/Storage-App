package com.example.hp.storageaap.dbutil;

/**
 * Created by HP on 14-02-2018.
 */

public class Company_constant {
    public static final String DBNAME="company";
    public static final int DBVERSION=1;
    public static final String TABLE_NAME="employee";
    public static final String COL_ID="empid";
    public static final String COL_NAME="empname";
    public static final String COL_SALARY="salary";
    public static final String EMP_SQL="create table employee(empid integer primary key,empname text,salary integer)";
}
