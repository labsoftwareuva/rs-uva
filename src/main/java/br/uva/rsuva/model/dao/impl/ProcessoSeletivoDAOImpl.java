package br.uva.rsuva.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import br.uva.rsuva.model.dao.ConnectionFactory;
import br.uva.rsuva.model.dao.ProcessoSeletivoDAO;
import br.uva.rsuva.model.entity.ProcessoSeletivo;

public class ProcessoSeletivoDAOImpl implements ProcessoSeletivoDAO{
	
	private Connection conexao;
	
	public ProcessoSeletivoDAOImpl() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	@Override
	public int incluir(ProcessoSeletivo processoSeletivo) {
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		int novoId = 0;
		
		sbQuery.append("INSERT INTO PROCESSOSELETIVO (ID, DESCRICAO, DURACAO");
		sbQuery.append("?,?,?");
		
		try {
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, processoSeletivo.getId());
			stmt.setString(2, processoSeletivo.getDescricao());
			stmt.setDate(3, new java.sql.Date(processoSeletivo.getDuracao().getTimeInMillis())); //Toguepi acha que isso não está correto
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
	public boolean alterar(ProcessoSeletivo processoSeletivo) {
		boolean sucesso = true;		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("UPDATE PROCESSOSELETIVO SET DESCRICAO = ?, DURACAO = ?");
		sbQuery.append("WHERE ID = ?");
		
		try {
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, processoSeletivo.getDescricao());
			stmt.setDate(2, new java.sql.Date(processoSeletivo.getDuracao().getTimeInMillis()));
			stmt.setInt(3, processoSeletivo.getId());
			
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
	public boolean excluir(ProcessoSeletivo processoSeletivo) {
		boolean sucesso = true;		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("DELETE FROM PROCESSOSELETIVO WHERE ID=?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
		    stmt.setInt(1, processoSeletivo.getId());
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
	public List<ProcessoSeletivo> listar() {
		List<ProcessoSeletivo> processos = new ArrayList<>();
		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("SELECT ID, DURACAO, DESCRICAO");
		sbQuery.append("FROM PROCESSOSELETIVO WHERE ID = ?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
			//stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
		    while(rs.next()){
			    ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();
				processoSeletivo.setId(rs.getInt("ID"));
				processoSeletivo.setDescricao(rs.getString("DESCRICAO"));
				GregorianCalendar duracao = new GregorianCalendar();
				duracao.setTime(rs.getDate("DURACAO"));
				processoSeletivo.setDuracao(duracao);
				processos.add(processoSeletivo);
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
		
		return processos;
	}

	@Override
	public ProcessoSeletivo getProcessoSeletivo(int id) {
		ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("SELECT ID, DESCRICAO, DURACAO");
		sbQuery.append("FROM PROCESSOSELETIVO WHERE ID = ?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
	    
			processoSeletivo.setId(rs.getInt("ID"));
			processoSeletivo.setDescricao(rs.getString("DESCRICAO"));
			GregorianCalendar duracao = new GregorianCalendar();
			duracao.setTime(rs.getDate("DURACAO"));
			processoSeletivo.setDuracao(duracao);
	
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
		
		return processoSeletivo;
	}

}
