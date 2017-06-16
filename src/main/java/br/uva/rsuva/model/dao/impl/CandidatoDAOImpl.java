package br.uva.rsuva.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import br.uva.rsuva.model.dao.CandidatoDAO;
import br.uva.rsuva.model.dao.ConnectionFactory;
import br.uva.rsuva.model.entity.Candidato;

public class CandidatoDAOImpl implements CandidatoDAO{
	
	private Connection conexao;
	
	public CandidatoDAOImpl() {
		this.conexao = ConnectionFactory.getConnection();
	}
	@Override
	public int incluir(Candidato candidato) {
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		int novoId = 0;
		sbQuery.append("INSERT INTO CANDIDATO (CPF, ENDERECO, NUMERO, COMPLEMENTO, CEP, ESTADO, CIDADE, DATANASC,");
		sbQuery.append(" RG, EMISSOR, EXPEDICAO, SEXO, TELEFONE, CELULAR) VALUES (");
		sbQuery.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		try {
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, candidato.getCpf());
			stmt.setString(2, candidato.getEndereco());
			stmt.setInt(3, candidato.getNumero());
			stmt.setString(4, candidato.getComplemento());
			stmt.setString(5, candidato.getCep());
			stmt.setString(6, candidato.getEstado());
			stmt.setString(7, candidato.getCidade());
			stmt.setDate(8, new java.sql.Date(candidato.getDataNascimento().getTimeInMillis()));
			stmt.setString(9, candidato.getRg());
			stmt.setString(10, candidato.getEmissor());
			stmt.setDate(11, new java.sql.Date(candidato.getExpedicao().getTimeInMillis()));
			stmt.setString(12, String.valueOf(candidato.getSexo()));
			stmt.setString(13, candidato.getTelefone());
			stmt.setString(14, candidato.getCelular());
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
		    if(rs.next()){
		    	novoId = rs.getInt(1);
		    }
		    
		    stmt.close();
		    conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
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

	@Override
	public boolean alterar(Candidato candidato) {
		boolean sucesso = true;		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("UPDATE CANDIDATO SET CPF=?, ENDERECO=?, NUMERO=?, COMPLEMENTO=?, CEP=?, ESTADO=?, CIDADE=?, DATANASC=?,");
		sbQuery.append(" RG=?, EMISSOR=?, EXPEDICAO=?, SEXO=?, TELEFONE=?, CELULAR=? WHERE ID = ?");
		
		try {
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, candidato.getCpf());
			stmt.setString(2, candidato.getEndereco());
			stmt.setInt(3, candidato.getNumero());
			stmt.setString(4, candidato.getComplemento());
			stmt.setString(5, candidato.getCep());
			stmt.setString(6, candidato.getEstado());
			stmt.setString(7, candidato.getCidade());
			stmt.setDate(8, new java.sql.Date(candidato.getDataNascimento().getTimeInMillis()));
			stmt.setString(9, candidato.getRg());
			stmt.setString(10, candidato.getEmissor());
			stmt.setDate(11, new java.sql.Date(candidato.getExpedicao().getTimeInMillis()));
			stmt.setString(12, String.valueOf(candidato.getSexo()));
			stmt.setString(13, candidato.getTelefone());
			stmt.setString(14, candidato.getCelular());
			stmt.setInt(15, candidato.getId());
			
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

	@Override
	public boolean excluir(Candidato candidato) {
		boolean sucesso = true;		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("DELETE FROM CANDIDATO WHERE ID=?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
		    stmt.setInt(1, candidato.getId());
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

	@Override
	public List<Candidato> listar() {
		List<Candidato> candidatos = new ArrayList<>();
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("SELECT ID, CPF, ENDERECO, NUMERO, COMPLEMENTO, CEP, ESTADO, CIDADE, DATANASC, RG, EMISSOR, ");
		sbQuery.append("EXPEDICAO, SEXO, TELEFONE, CELULAR FROM CANDIDATO ");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
			ResultSet rs = stmt.executeQuery();
		    while(rs.next()){
		    	Candidato candidato = new Candidato();
		    	candidato.setId(rs.getInt("ID"));
		    	candidato.setCpf(rs.getString("CPF"));
		    	candidato.setEndereco(rs.getString("ENDERECO"));
		    	candidato.setNumero(Integer.valueOf(rs.getString("CPF")));
		    	candidato.setComplemento(rs.getString("COMPLEMENTO"));
		    	candidato.setCep(rs.getString("CEP"));
		    	candidato.setEstado(rs.getString("ESTADO"));
		    	candidato.setCidade(rs.getString("CIDADE"));
		    	GregorianCalendar dataNasc = new GregorianCalendar();
		    	dataNasc.setTime(rs.getDate("DATANASC"));
		    	candidato.setDataNascimento(dataNasc);
		    	candidato.setRg(rs.getString("RG"));
		    	candidato.setEmissor(rs.getString("EMISSOR"));
		    	GregorianCalendar expedicao = new GregorianCalendar();
		    	dataNasc.setTime(rs.getDate("EXPEDICAO"));
		    	candidato.setExpedicao(expedicao);
		    	candidato.setSexo(rs.getString("SEXO").charAt(0));
		    	candidato.setTelefone(rs.getString("TELEFONE"));
		    	candidato.setCelular(rs.getString("CELULAR"));
		    	candidatos.add(candidato);
		    }
		    stmt.execute();
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
		
		return candidatos;
	}

	@Override
	public Candidato getCandidato(int id) {
		Candidato candidato = new Candidato();
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("SELECT ID, CPF, ENDERECO, NUMERO, COMPLEMENTO, CEP, ESTADO, CIDADE, DATANASC, RG, EMISSOR, ");
		sbQuery.append("EXPEDICAO, SEXO, TELEFONE, CELULAR FROM CANDIDATO WHERE ID=?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
	    
			candidato.setId(rs.getInt("ID"));
	    	candidato.setCpf(rs.getString("CPF"));
	    	candidato.setEndereco(rs.getString("ENDERECO"));
	    	candidato.setNumero(Integer.valueOf(rs.getString("CPF")));
	    	candidato.setComplemento(rs.getString("COMPLEMENTO"));
	    	candidato.setCep(rs.getString("CEP"));
	    	candidato.setEstado(rs.getString("ESTADO"));
	    	candidato.setCidade(rs.getString("CIDADE"));
	    	GregorianCalendar dataNasc = new GregorianCalendar();
	    	dataNasc.setTime(rs.getDate("DATANASC"));
	    	candidato.setDataNascimento(dataNasc);
	    	candidato.setRg(rs.getString("RG"));
	    	candidato.setEmissor(rs.getString("EMISSOR"));
	    	GregorianCalendar expedicao = new GregorianCalendar();
	    	dataNasc.setTime(rs.getDate("EXPEDICAO"));
	    	candidato.setExpedicao(expedicao);
	    	candidato.setSexo(rs.getString("SEXO").charAt(0));
	    	candidato.setTelefone(rs.getString("TELEFONE"));
	    	candidato.setCelular(rs.getString("CELULAR"));

	    	stmt.execute();
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
		
		return candidato;
	}

}
