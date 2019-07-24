package com.stackroute.jdbc;

import java.sql.*;

public class DatabaseMetadataDemo {

    public void getDataBaseMetaData(){

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from employee");) {
            DatabaseMetaData metaData=connection.getMetaData();
            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Logged User: " + metaData.getUserName());
            System.out.println("JDBC Driver: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());
            System.out.println("\n");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
