package br.uva.rsuva.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	public static Connection getConnection(Properties p) {
		
		Connection con = null;
		String host = "";
		String port = "";
		String login = "";
		String password = "";		
		
        try {        	
        	
        	host = p.getProperty("prop.server.host");
        	port = p.getProperty("prop.server.port");
        	login = p.getProperty("prop.server.login");
        	password = p.getProperty("prop.server.password");
        	
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port, login, password);
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return con;
        
    }
}
