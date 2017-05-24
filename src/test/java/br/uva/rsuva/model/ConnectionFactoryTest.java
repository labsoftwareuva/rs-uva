package br.uva.rsuva.model;

import java.sql.Connection;
import java.util.Properties;

public class ConnectionFactoryTest {

	public static void main(String[] args) {
		
		try{
			
			Properties p = Propriedades.getProp();
			Connection con = ConnectionFactory.getConnection(p);
			
			if(con != null && !con.isClosed()){
				System.out.println("Conectado com sucesso!");
				con.close();
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}

	}

}
