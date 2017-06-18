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
import br.uva.rsuva.model.dao.FormacaoComplementarDAO;
import br.uva.rsuva.model.entity.Candidato;
import br.uva.rsuva.model.entity.FormacaoComplementar;

public class FormacaoComplementarDAOImpl implements FormacaoComplementarDAO{
	
	private Connection conexao;
	
	public FormacaoComplementarDAOImpl() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	@Override
	public int incluir(FormacaoComplementar formacaoComplementar, Candidato candidato) {
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		int novoId = 0;
		
		sbQuery.append("INSERT INTO FORMACAOCOMP(IDCANDIDATO,INSTITUICAO,CURSO,TIPOCURSO,PAIS,ESTADO,DURACAO,SITUACAO,DATACONCL)");
		sbQuery.append(" VALUES(?,?,?,?,?,?,?,?,?)");
		
		try {
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, candidato.getId());
			stmt.setString(2, formacaoComplementar.getInstituicao());
			stmt.setString(3, formacaoComplementar.getCurso());
			stmt.setString(4, formacaoComplementar.getTipoCurso());
			stmt.setString(5, formacaoComplementar.getPais());
			stmt.setString(6, formacaoComplementar.getEstado());
			stmt.setString(7, formacaoComplementar.getDuracao());
			stmt.setString(8, formacaoComplementar.getSituacao());
			stmt.setDate(9, new java.sql.Date(formacaoComplementar.getDataConclusao().getTimeInMillis()));
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
	public boolean alterar(FormacaoComplementar formacaoComplementar) {
		boolean sucesso = true;		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("UPDATE FORMACAOCOMP SET INSTITUICAO = ?, CURSO = ?, TIPOCURSO = ?, PAIS = ?, ESTADO = ?,");
		sbQuery.append(" DURACAO = ?, SITUACAO = ?, DATACONCL = ? WHERE ID = ?");
		
		try {
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, formacaoComplementar.getInstituicao());
			stmt.setString(2, formacaoComplementar.getCurso());
			stmt.setString(3, formacaoComplementar.getTipoCurso());
			stmt.setString(4, formacaoComplementar.getPais());
			stmt.setString(5, formacaoComplementar.getEstado());
			stmt.setString(6, formacaoComplementar.getDuracao());
			stmt.setString(7, formacaoComplementar.getSituacao());
			stmt.setDate(8, new java.sql.Date(formacaoComplementar.getDataConclusao().getTimeInMillis()));
			stmt.setInt(9, formacaoComplementar.getId());
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
	public boolean excluir(FormacaoComplementar formacaoComplementar) {
		boolean sucesso = true;		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("DELETE FROM FORMACAOCOMP WHERE ID=?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
		    stmt.setInt(1, formacaoComplementar.getId());
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
	public List<FormacaoComplementar> listar(int id) {
		List<FormacaoComplementar> formacoes = new ArrayList<>();
		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("SELECT ID, INSTITUICAO, CURSO, TIPOCURSO, PAIS, ESTADO,");
		sbQuery.append(" DURACAO, SITUACAO, DATACONCL FROM FORMACAOCOMP WHERE IDCANDIDATO = ?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
		    while(rs.next()){
		    	FormacaoComplementar formacao = new FormacaoComplementar();
			    formacao.setId(rs.getInt("ID"));
			    formacao.setInstituicao(rs.getString("INSTITUICAO"));
			    formacao.setCurso(rs.getString("CURSO"));
			    formacao.setTipoCurso(rs.getString("TIPOCURSO"));
			    formacao.setPais(rs.getString("PAIS"));
			    formacao.setEstado(rs.getString("ESTADO"));
			    formacao.setDuracao(rs.getString("DURACAO"));
			    formacao.setSituacao(rs.getString("SITUACAO"));
				
				GregorianCalendar dataconclusao = new GregorianCalendar();
				dataconclusao.setTime(rs.getDate("DATACONCL"));
				formacao.setDataConclusao(dataconclusao);
				
				
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
	public FormacaoComplementar getFormacaoComplementar(int id) {
		FormacaoComplementar formacao = new FormacaoComplementar();
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("SELECT ID, INSTITUICAO, CURSO, TIPOCURSO, PAIS, ESTADO,");
		sbQuery.append(" DURACAO, SITUACAO, DATACONCL FROM FORMACAOCOMP WHERE ID = ?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
		    
		    	
		    formacao.setId(rs.getInt("ID"));
		    formacao.setInstituicao(rs.getString("INSTITUICAO"));
		    formacao.setCurso(rs.getString("CURSO"));
		    formacao.setTipoCurso(rs.getString("TIPOCURSO"));
		    formacao.setPais(rs.getString("PAIS"));
		    formacao.setEstado(rs.getString("ESTADO"));
		    formacao.setDuracao(rs.getString("DURACAO"));
		    formacao.setSituacao(rs.getString("SITUACAO"));
			
			GregorianCalendar dataconclusao = new GregorianCalendar();
			dataconclusao.setTime(rs.getDate("DATACONCL"));
			formacao.setDataConclusao(dataconclusao);
				
				
			
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
