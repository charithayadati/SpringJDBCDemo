package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo {
    public void getBatch(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123");
                Statement statement = connection.createStatement();){
                statement.addBatch("insert into employee values(43,'siri',25,'female')");
                statement.addBatch("insert into employee values(42,'sandhya',26,'female')");
                statement.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
