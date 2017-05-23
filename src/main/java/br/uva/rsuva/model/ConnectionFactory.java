package br.uva.rsuva.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://35.186.177.136:3306", "rsuva", "rsuva");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
