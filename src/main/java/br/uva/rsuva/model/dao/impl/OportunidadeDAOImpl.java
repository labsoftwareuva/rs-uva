package br.uva.rsuva.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import br.uva.rsuva.model.dao.OportunidadeDAO;
import br.uva.rsuva.model.dao.ConnectionFactory;
import br.uva.rsuva.model.entity.Oportunidade;

public class OportunidadeDAOImpl implements OportunidadeDAO{
	
	private Connection conexao;
	
	public OportunidadeDAOImpl() {
		this.conexao = ConnectionFactory.getConnection();
	}
	@Override
	public int incluir(Oportunidade oportunidade) {
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		int novoId = 0;
		sbQuery.append("INSERT INTO OPORTUNIDADE (ID, ID_PROCESSO, AREA_ATUACAO, CARGO, QTD_VAGAS, DATA_INICIO, DATA_TERMINO, ");
		sbQuery.append("REQUISITOS, SALARIO_INICIAL, BENEFICIOS VALUES (");
		sbQuery.append("?,?,?,?,?,?,?,?,?,?)");
		
		try {
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, oportunidade.getId());
			stmt.setInt(2, oportunidade.getIdProcesso());
			stmt.setString(3, String.valueOf(oportunidade.getAreaAtuacao()));
			stmt.setString(4, oportunidade.getCargo());
			stmt.setInt(5, oportunidade.getQtdVagas());
			stmt.setDate(6, new java.sql.Date(oportunidade.getInicioPeriodo().getTimeInMillis()));
			stmt.setDate(7, new java.sql.Date(oportunidade.getFimPeriodo().getTimeInMillis()));
			stmt.setString(8, oportunidade.getRequisitos());
			stmt.setDouble(9, oportunidade.getSalarioInicial());
			stmt.setString(10, String.valueOf(oportunidade.getBeneficios()));
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
	public boolean alterar(Oportunidade oportunidade) {
		boolean sucesso = true;		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("UPDATE OPORTUNIDADE SET CARGO=?, QTD_VAGAS=?, DATA_INICIO=?, DATA_TERMINO=?,");
		sbQuery.append(" REQUISITOS=?, SALARIO_INICIAL=?, BENEFICIOS=? WHERE ID = ?");
		
		try {
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, oportunidade.getCargo());
			stmt.setInt(2, oportunidade.getQtdVagas());
			stmt.setDate(3, new java.sql.Date(oportunidade.getInicioPeriodo().getTimeInMillis()));
			stmt.setDate(4, new java.sql.Date(oportunidade.getFimPeriodo().getTimeInMillis()));
			stmt.setString(5, oportunidade.getRequisitos());
			stmt.setDouble(6, oportunidade.getSalarioInicial());
			stmt.setString(7, String.valueOf(oportunidade.getBeneficios()));
			
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
	public boolean excluir(Oportunidade oportunidade) {
		boolean sucesso = true;		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("DELETE FROM OPORTUNIDADE WHERE ID=?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
		    stmt.setInt(1, oportunidade.getId());
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
	public List<Oportunidade> listar() {
		List<Oportunidade> oportunidades = new ArrayList<>();
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("SELECT ID, ID_PROCESSO, AREA_ATUACAO, CARGO, QTD_VAGAS, DATA_INICIO, DATA_TERMINO, ");
		sbQuery.append("REQUISITOS, SALARIO_INICIAL, BENEFICIOS FROM OPORTUNIDADE");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
			ResultSet rs = stmt.executeQuery();
		    while(rs.next()){
		    	Oportunidade oportunidade = new Oportunidade();
		    	oportunidade.setId(rs.getInt("ID"));
		    	oportunidade.setIdProcesso(rs.getInt("ID_PROCESSO"));
		    	oportunidade.setAreaAtuacao(rs.getString("AREA_ATUACAO"));
		    	oportunidade.setCargo(rs.getString("CARGO"));
		    	oportunidade.setQtdVagas(rs.getInt("QTD_VAGAS"));
		    	GregorianCalendar dataInicio = new GregorianCalendar();
		    	dataInicio.setTime(rs.getDate("DATA_INICIO"));
		    	oportunidade.setInicioPeriodo(dataInicio);
		    	GregorianCalendar dataFim = new GregorianCalendar();
		    	dataFim.setTime(rs.getDate("DATA_TERMINO"));
		    	oportunidade.setFimPeriodo(dataFim);
		    	oportunidade.setRequisitos(rs.getString("REQUISITOS"));
		    	oportunidade.setSalarioInicial(rs.getInt("SALARIO_INICIAL"));
		    	oportunidade.setBeneficios(rs.getString("BENEFICIOS"));
		    	oportunidades.add(oportunidade);
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
		
		return oportunidades;
	}

	@Override
	public Oportunidade getOportunidade(int id) {
		Oportunidade oportunidade = new Oportunidade();
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("SELECT ID, ID_PROCESSO, AREA_ATUACAO, CARGO, QTD_VAGAS, DATA_INICIO, DATA_TERMINO, ");
		sbQuery.append("REQUISITOS, SALARIO_INICIAL, BENEFICIOS FROM OPORTUNIDADE WHERE ID=?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
	    
	    	oportunidade.setId(rs.getInt("ID"));
	    	oportunidade.setIdProcesso(rs.getInt("ID_PROCESSO"));
	    	oportunidade.setAreaAtuacao(rs.getString("AREA_ATUACAO"));
	    	oportunidade.setCargo(rs.getString("CARGO"));
	    	oportunidade.setQtdVagas(rs.getInt("QTD_VAGAS"));
	    	GregorianCalendar dataInicio = new GregorianCalendar();
	    	dataInicio.setTime(rs.getDate("DATA_INICIO"));
	    	oportunidade.setInicioPeriodo(dataInicio);
	    	GregorianCalendar dataFim = new GregorianCalendar();
	    	dataFim.setTime(rs.getDate("DATA_TERMINO"));
	    	oportunidade.setFimPeriodo(dataFim);
	    	oportunidade.setRequisitos(rs.getString("REQUISITOS"));
	    	oportunidade.setSalarioInicial(rs.getInt("SALARIO_INICIAL"));
	    	oportunidade.setBeneficios(rs.getString("BENEFICIOS"));

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
		
		return oportunidade;
	}
}
