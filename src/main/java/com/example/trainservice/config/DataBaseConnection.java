package com.example.trainservice.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String HOST = "localhost";
    private static final String DB = "postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    public static Connection getPostgresConnection() throws SQLException {
        final String DSN = "jdbc:postgresql://" + HOST + ":5432/" + DB;
        return DriverManager.getConnection(DSN, USER, PASSWORD);
    }
}
