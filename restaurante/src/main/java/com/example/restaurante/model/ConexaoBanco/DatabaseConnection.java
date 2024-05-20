package com.example.restaurante.model.ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/restaurante";
        String user = "postgres";
        String password = "47557609";
        return DriverManager.getConnection(url, user, password);
    }
}
