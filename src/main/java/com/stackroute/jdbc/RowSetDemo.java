package com.stackroute.jdbc;


import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowSetDemo {
    public void getJdbcRowset() {

        {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                // Setting database details using JdbcRowSet
                JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
                jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/stackroute");
                jdbcRowSet.setUsername("root");
                jdbcRowSet.setPassword("Root@123");
                jdbcRowSet.setCommand("select * from employee");
                jdbcRowSet.execute();

                while (jdbcRowSet.next()) {
                    System.out.println("Id: " + jdbcRowSet.getInt(1) + " Name: " + jdbcRowSet.getString(2) + "   Age: " + jdbcRowSet.getInt(3) + "   Gender: " + jdbcRowSet.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

