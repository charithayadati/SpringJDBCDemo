package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    public void getColumnCount() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from employee");) {

           ResultSetMetaData resultSetMetadataDemo=resultSet.getMetaData();
            int colCount = resultSetMetadataDemo.getColumnCount();
            System.out.println("Number Of Columns : "+colCount+"\n");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void getColumnDetails(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from employee");) {

            ResultSetMetaData resultSetMetadataDemo=resultSet.getMetaData();
            int colCount = resultSetMetadataDemo.getColumnCount();
            System.out.println("Column Details :");

            for (int i = 1; i<= colCount; i++)
            {

                String colName = resultSetMetadataDemo.getColumnName(i);

                String colType = resultSetMetadataDemo.getColumnTypeName(i);

                System.out.println(colName+" is of type "+colType);
            }
            System.out.println("\n");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
