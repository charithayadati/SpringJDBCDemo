package com.stackroute.jdbc;

import java.sql.SQLException;

public class App
{
    public static void main( String[] args )
    {
        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
        ResultSetMetadataDemo resultSetMetadataDemo=new ResultSetMetadataDemo();
        DatabaseMetadataDemo databaseMetadataDemo=new DatabaseMetadataDemo();
        RowSetDemo rowSetDemo=new RowSetDemo();
        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        JdbcBatchDemo jdbcBatchDemo=new JdbcBatchDemo();


        simpleJdbcDemo.getEmployeeDetails();
        simpleJdbcDemo.getEmployeeDetailsInReverse();
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("cherry","female");
        resultSetMetadataDemo.getColumnCount();
        resultSetMetadataDemo.getColumnDetails();
        databaseMetadataDemo.getDataBaseMetaData();
        jdbcTransactionDemo.transactionCommit();
       jdbcTransactionDemo.transactionRollBack();
       jdbcBatchDemo.getBatch();
       rowSetDemo.getJdbcRowset();
    }
}
