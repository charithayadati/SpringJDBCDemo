package com.stackroute.jdbc;

import java.sql.*;

public class JdbcTransactionDemo {
    private Connection connection;
public void transactionCommit(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    try (
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123");
            Statement statement = connection.createStatement();  )  {

        connection.setAutoCommit(false);
        statement.executeUpdate("insert into employee values(19,'Uday',25,'male')");
        statement.executeUpdate("insert into employee values(20,'Hari',22,'male')");
        connection.commit();
        ResultSet resultSet=statement.executeQuery("select * from employee");
        while (resultSet.next()) {
            System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2) + "   Age: " + resultSet.getInt(3) + "   Gender: " + resultSet.getString(4));
        }

        System.out.println("\n");

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

public void transactionRollBack(){


    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123");
            Statement statement = connection.createStatement();  )  {

        connection.setAutoCommit(false);
        statement.executeUpdate("insert into employee values(41,'siri',25,'female')");
        statement.executeUpdate("insert into employee values(29,'Ramya',22,'female')");
        ResultSet resultSet=statement.executeQuery("select * from employee");
        while (resultSet.next()) {
            System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2) + "   Age: " + resultSet.getInt(3) + "   Gender: " + resultSet.getString(4));
        }
        System.out.println("\n");

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } catch (Exception ex) {
        ex.printStackTrace();
    }

}

}
