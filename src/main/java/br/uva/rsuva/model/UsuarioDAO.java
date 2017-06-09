package br.uva.rsuva.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.uva.rsuva.model.entity.Usuario;

public class UsuarioDAO {
	
	private Connection conexao;
	
	public UsuarioDAO(){
		this.conexao = ConnectionFactory.getConnection();
	}	
	
	public Usuario getUsuario(int id){
		
		String qry = "";
		PreparedStatement stmt = null;
		Usuario usuario = null;
		
		qry  = "SELECT ID,NOME,EMAIL,SENHA FROM USUARIO ";
		qry += "WHERE ID = ?";
		
		try{
			
			stmt = conexao.prepareStatement(qry);
			stmt.setInt(1, id);
		    ResultSet rs = stmt.executeQuery();
		    rs.next();
		    
			usuario = new Usuario();
			usuario.setId(rs.getInt("ID"));
			usuario.setNome(rs.getString("NOME"));
			usuario.setEmail(rs.getString("EMAIL"));
			usuario.setSenha(rs.getString("SENHA"));
		    
		    stmt.close();
		    conexao.close();
		    
		}catch(SQLException SQLEx){
			System.out.println(SQLEx);			
		}finally{ 
		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (conexao != null) {
		        try {
		            conexao.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
		
		return usuario;
	
	}
	
	public ArrayList<Usuario> listarUsuarios(){
		
		String qry = "";
		PreparedStatement stmt = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		qry  = "SELECT ID,NOME,EMAIL,SENHA FROM USUARIO ";		
		
		try{
			
			stmt = conexao.prepareStatement(qry);
		    ResultSet rs = stmt.executeQuery();
		    while(rs.next()){
		    
				Usuario u = new Usuario();		    	
				u.setId(rs.getInt("ID"));
				u.setNome(rs.getString("NOME"));
				u.setEmail(rs.getString("EMAIL"));
				u.setSenha(rs.getString("SENHA"));
				usuarios.add(u);
			
		    }
		    
		    stmt.close();
		    conexao.close();
		    
		}catch(SQLException SQLEx){
			System.out.println(SQLEx);			
		}finally{ 
		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (conexao != null) {
		        try {
		            conexao.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
		
		return usuarios;
	
	}
	
	public int incluir(Usuario usuario){
						
		String qry = "";
		PreparedStatement stmt = null;
		int novoId = 0;
		
		qry = "INSERT INTO USUARIO (NOME,EMAIL,SENHA) VALUES (?,?,?)";
		
		try{
			
			stmt = conexao.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);		
			stmt.setString(1, usuario.getNome());
		    stmt.setString(2, usuario.getEmail());
		    stmt.setString(3, usuario.getSenha());
		    stmt.executeUpdate();
		    
		    ResultSet rs = stmt.getGeneratedKeys();
		    if(rs.next()){
		    	novoId = rs.getInt(1);
		    }		    
		    
		    stmt.close();
		    conexao.close();
		    
		}catch(SQLException SQLEx){
			System.out.println(SQLEx);		
		}finally{ 
		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (conexao != null) {
		        try {
		            conexao.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
		
		return novoId;
	}
	
	public boolean alterar(Usuario usuario){
		
		boolean sucesso = true;		
		String qry = "";
		PreparedStatement stmt = null;
		
		qry =  "UPDATE USUARIO SET NOME = ?, EMAIL = ?, SENHA = ? ";
		qry += "WHERE ID = ?";
		
		try{
			
			stmt = conexao.prepareStatement(qry);
		    stmt.setString(1, usuario.getNome());
		    stmt.setString(2, usuario.getEmail());
		    stmt.setString(3, usuario.getSenha());
		    stmt.setInt(4, usuario.getId());
		    stmt.execute();
		    stmt.close();
		    conexao.close();
		    
		}catch(SQLException SQLEx){
			System.out.println(SQLEx);
			sucesso = false;
		}finally{ 
		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (conexao != null) {
		        try {
		            conexao.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
		
		return sucesso;
	}
	
	public boolean excluir(Usuario usuario){
		
		boolean sucesso = true;		
		String qry = "";
		PreparedStatement stmt = null;
		
		qry =  "DELETE FROM USUARIO WHERE ID = ?";
		
		try{
			
			stmt = conexao.prepareStatement(qry);
		    stmt.setInt(1, usuario.getId());
		    stmt.execute();
		    stmt.close();
		    conexao.close();
		    
		}catch(SQLException SQLEx){
			System.out.println(SQLEx);
			sucesso = false;
		}finally{ 
		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (conexao != null) {
		        try {
		            conexao.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
		
		return sucesso;
	}

}
