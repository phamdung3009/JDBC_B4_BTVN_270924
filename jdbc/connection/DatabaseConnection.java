package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection getConnection(String DB_URL, String USER, String PASS) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection failed!");
        }
        return con;
    }
}
