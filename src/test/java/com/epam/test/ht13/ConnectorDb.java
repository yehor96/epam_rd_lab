package com.epam.test.ht13;

import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectorDb {
    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER = "root";
    public static final String PASS = "1";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
