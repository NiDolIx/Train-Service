package com.example.trainservice.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    public static Connection getPostgresConnection() throws SQLException, IOException {
        Properties properties = new Properties();

        try(InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
            properties.load(in);
        }

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}
