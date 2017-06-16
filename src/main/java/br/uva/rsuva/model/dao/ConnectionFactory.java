package br.uva.rsuva.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	public static Connection getConnection(Properties p) {
		
		Connection con = null;
		String host = "35.186.177.136";
		String port = "3306";
		String login = "rsuva";
		String password = "rsuva";		
		String database = "RSUVA";
		
        try {        	
        	
 /*       	host = p.getProperty("prop.server.host");
        	port = p.getProperty("prop.server.port");
        	login = p.getProperty("prop.server.login");
        	password = p.getProperty("prop.server.password");
        	database = p.getProperty("prop.server.database");*/
        	
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, login, password);
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return con;
        
    }
	
	public static Connection getConnection() {
		
		Connection con = null;
		String host = "35.186.177.136";
		String port = "3306";
		String login = "rsuva";
		String password = "rsuva";		
		String database = "RSUVA";
		
        try {        	
        	
        	/*Properties p = Propriedades.getProp();
        	host = p.getProperty("prop.server.host");
        	port = p.getProperty("prop.server.port");
        	login = p.getProperty("prop.server.login");
        	password = p.getProperty("prop.server.password");
        	database = p.getProperty("prop.server.database");*/
        	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, login, password);
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return con;
        
    }
}
