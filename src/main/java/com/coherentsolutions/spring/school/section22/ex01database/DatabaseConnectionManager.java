package com.coherentsolutions.spring.school.section22.ex01database;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {

    private Connection connection;

    @PostConstruct
    public void init() {
        try {
            // Initialize the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate_db", "bestuser", "bestuser");
            System.out.println("Database connection initialized.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void close() {
        try {
            // Close the database connection
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
