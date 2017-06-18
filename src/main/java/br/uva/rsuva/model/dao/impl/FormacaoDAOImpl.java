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
import br.uva.rsuva.model.dao.FormacaoDAO;
import br.uva.rsuva.model.entity.Candidato;
import br.uva.rsuva.model.entity.Formacao;

public class FormacaoDAOImpl implements FormacaoDAO{
	
	private Connection conexao;
	
	public FormacaoDAOImpl() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	@Override
	public int incluir(Formacao formacao, Candidato candidato) {
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		int novoId = 0;
		
		sbQuery.append("INSERT INTO FORMACAO (IDCANDIDATO,INSTITUICAO,CURSO,NIVEL,ESTADOATUAL,OUTROS,DATACONCL,ESTADO,PAIS)");
		sbQuery.append(" VALUES(?,?,?,?,?,?,?,?,?)");
		
		try {
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, candidato.getId());
			stmt.setString(2, formacao.getInstituicao());
			stmt.setString(3, formacao.getCurso());
			stmt.setString(4, formacao.getNivel());
			stmt.setString(5, formacao.getEstadoAtual());
			stmt.setString(6, formacao.getOutros());
			stmt.setDate(7, new java.sql.Date(formacao.getDataConclusao().getTimeInMillis()));
			stmt.setString(8, formacao.getEstado());
			stmt.setString(9, formacao.getPais());
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
	public boolean alterar(Formacao formacao) {
		boolean sucesso = true;		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("UPDATE FORMACAO SET INSTITUICAO = ?, CURSO = ?, NIVEL = ?, ESTADOATUAL = ?,");
		sbQuery.append("OUTROS = ?, DATACONCL = ?, ESTADO = ?, PAIS = ? WHERE ID = ?");
		
		try {
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, formacao.getInstituicao());
			stmt.setString(2, formacao.getCurso());
			stmt.setString(3, formacao.getNivel());
			stmt.setString(4, formacao.getEstadoAtual());
			stmt.setString(5, formacao.getOutros());
			stmt.setDate(6, new java.sql.Date(formacao.getDataConclusao().getTimeInMillis()));
			stmt.setString(7, formacao.getEstado());
			stmt.setString(8, formacao.getPais());
			stmt.setInt(9, formacao.getId());
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
	public boolean excluir(Formacao formacao) {
		boolean sucesso = true;		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("DELETE FROM FORMACAO WHERE ID=?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
		    stmt.setInt(1, formacao.getId());
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
	public List<Formacao> listar(int id) {
		List<Formacao> formacoes = new ArrayList<>();
		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("SELECT ID, INSTITUICAO, CURSO, NIVEL, ESTADOATUAL, OUTROS, DATACONCL, ");
		sbQuery.append("ESTADO, PAIS FROM FORMACAO WHERE IDCANDIDATO=?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
		    while(rs.next()){
			    Formacao formacao = new Formacao();
			    formacao.setId(rs.getInt("ID"));
			    formacao.setInstituicao(rs.getString("INSTITUICAO"));
			    formacao.setCurso(rs.getString("CURSO"));
			    formacao.setNivel(rs.getString("NIVEL"));
			    formacao.setEstadoAtual(rs.getString("ESTADOATUAL"));
			    formacao.setOutros(rs.getString("OUTROS"));
				
				GregorianCalendar dataconclusao = new GregorianCalendar();
				dataconclusao.setTime(rs.getDate("DATACONCL"));
				formacao.setDataConclusao(dataconclusao);
				
				formacao.setEstado(rs.getString("ESTADO"));
				formacao.setPais(rs.getString("PAIS"));
				
				formacoes.add(formacao);
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
		
		return formacoes;
	}

	@Override
	public Formacao getFormacao(int id) {
		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("SELECT ID, INSTITUICAO, CURSO, NIVEL, ESTADOATUAL, OUTROS, DATACONCL, ");
		sbQuery.append("ESTADO, PAIS FROM FORMACAO WHERE ID=?");
		Formacao formacao = new Formacao();
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
		    
		    
		    formacao.setId(rs.getInt("ID"));
		    formacao.setInstituicao(rs.getString("INSTITUICAO"));
		    formacao.setCurso(rs.getString("CURSO"));
		    formacao.setNivel(rs.getString("NIVEL"));
		    formacao.setEstadoAtual(rs.getString("ESTADOATUAL"));
		    formacao.setOutros(rs.getString("OUTROS"));
			
			GregorianCalendar dataconclusao = new GregorianCalendar();
			dataconclusao.setTime(rs.getDate("DATACONCL"));
			formacao.setDataConclusao(dataconclusao);
			
			formacao.setEstado(rs.getString("ESTADO"));
			formacao.setPais(rs.getString("PAIS"));
				
			
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
		
		return formacao;
	}

}
