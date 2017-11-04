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
import br.uva.rsuva.model.dao.ExperienciaProfissionalDAO;
import br.uva.rsuva.model.entity.Candidato;
import br.uva.rsuva.model.entity.ExperienciaProfissional;

public class ExperienciaProfissionalDAOImpl implements ExperienciaProfissionalDAO{
	
	private Connection conexao;
	
	public ExperienciaProfissionalDAOImpl() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	@Override
	public int incluir(ExperienciaProfissional experienciaProfissional, Candidato candidato) {
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		int novoId = 0;
		
		sbQuery.append("INSERT INTO EXPERIENCIAPROF (IDCANDIDATO, EMPRESA, PAIS, ESTADO, TITULOCARGO, SETOR, ATUALIDADE, ATIVIDADES,");
		sbQuery.append(" INICIOPERIODO, TERMINOPERIODO) VALUES (?,?,?,?,?,?,?,?,?,?)");
		
		try {
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, candidato.getId());
			stmt.setString(2, experienciaProfissional.getEmpresa());
			stmt.setString(3, experienciaProfissional.getPais());
			stmt.setString(4, experienciaProfissional.getEstado());
			stmt.setString(5, experienciaProfissional.getTituloCargo());
			stmt.setString(6, experienciaProfissional.getSetor());
			stmt.setString(7, experienciaProfissional.getAtualidade());
			stmt.setString(8, experienciaProfissional.getAtividades());
			stmt.setDate(9, new java.sql.Date(experienciaProfissional.getInicioPeriodo().getTimeInMillis()));
			stmt.setDate(10, new java.sql.Date(experienciaProfissional.getFimPeriodo().getTimeInMillis()));
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
	public boolean alterar(ExperienciaProfissional experienciaProfissional) {
		boolean sucesso = true;		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("UPDATE EXPERIENCIAPROF SET EMPRESA = ?, PAIS = ?, ESTADO = ?, TITULOCARGO = ?, SETOR = ?,");
		sbQuery.append("ATUALIDADE = ?, ATIVIDADES = ?, INICIOPERIODO = ?, TERMINOPERIODO = ? WHERE ID = ?");
		
		try {
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, experienciaProfissional.getEmpresa());
			stmt.setString(2, experienciaProfissional.getPais());
			stmt.setString(3, experienciaProfissional.getEstado());
			stmt.setString(4, experienciaProfissional.getTituloCargo());
			stmt.setString(5, experienciaProfissional.getSetor());
			stmt.setString(6, experienciaProfissional.getAtualidade());
			stmt.setString(7, experienciaProfissional.getAtividades());
			stmt.setDate(8, new java.sql.Date(experienciaProfissional.getInicioPeriodo().getTimeInMillis()));
			stmt.setDate(9, new java.sql.Date(experienciaProfissional.getFimPeriodo().getTimeInMillis()));
			stmt.setInt(10, experienciaProfissional.getId());
			
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
	public boolean excluir(ExperienciaProfissional experienciaProfissional) {
		boolean sucesso = true;		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("DELETE FROM EXPERIENCIAPROF WHERE ID=?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
		    stmt.setInt(1, experienciaProfissional.getId());
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
	public List<ExperienciaProfissional> listar() {
		List<ExperienciaProfissional> experiencias = new ArrayList<>();
		
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("SELECT ID, EMPRESA, PAIS, ESTADO, TITULOCARGO, SETOR, ATUALIDADE,");
		sbQuery.append(" ATIVIDADES, INICIOPERIODO, TERMINOPERIODO FROM EXPERIENCIAPROF WHERE IDCANDIDATO = ?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
			//stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
		    while(rs.next()){
			    ExperienciaProfissional experienciaProfissional = new ExperienciaProfissional();
				experienciaProfissional.setId(rs.getInt("ID"));
				experienciaProfissional.setEmpresa(rs.getString("EMPRESA"));
				experienciaProfissional.setPais(rs.getString("PAIS"));
				experienciaProfissional.setEstado(rs.getString("ESTADO"));
				experienciaProfissional.setTituloCargo(rs.getString("TITULOCARGO"));
				experienciaProfissional.setSetor(rs.getString("SETOR"));
				experienciaProfissional.setAtualidade(rs.getString("ATUALIDADE"));
				experienciaProfissional.setAtividades(rs.getString("ATIVIDADES"));
				GregorianCalendar inicioPeriodo = new GregorianCalendar();
				inicioPeriodo.setTime(rs.getDate("INICIOPERIODO"));
				experienciaProfissional.setInicioPeriodo(inicioPeriodo);
				GregorianCalendar fimPeriodo = new GregorianCalendar();
				fimPeriodo.setTime(rs.getDate("TERMINOPERIODO"));
				experienciaProfissional.setFimPeriodo(fimPeriodo);
				experiencias.add(experienciaProfissional);
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
		
		return experiencias;
	}

	@Override
	public ExperienciaProfissional getExperienciaProfissional(int id) {
		ExperienciaProfissional experienciaProfissional = new ExperienciaProfissional();
		StringBuilder sbQuery = new StringBuilder();
		PreparedStatement stmt = null;
		
		sbQuery.append("SELECT ID, EMPRESA, PAIS, ESTADO, TITULOCARGO, SETOR, ATUALIDADE,");
		sbQuery.append(" ATIVIDADES, INICIOPERIODO, TERMINOPERIODO FROM EXPERIENCIAPROF WHERE ID = ?");
		
		try{
			
			stmt = conexao.prepareStatement(sbQuery.toString());
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
	    
			experienciaProfissional.setId(rs.getInt("ID"));
			experienciaProfissional.setEmpresa(rs.getString("EMPRESA"));
			experienciaProfissional.setPais(rs.getString("PAIS"));
			experienciaProfissional.setEstado(rs.getString("ESTADO"));
			experienciaProfissional.setTituloCargo(rs.getString("TITULOCARGO"));
			experienciaProfissional.setSetor(rs.getString("SETOR"));
			experienciaProfissional.setAtualidade(rs.getString("ATUALIDADE"));
			experienciaProfissional.setAtividades(rs.getString("ATIVIDADES"));
			GregorianCalendar inicioPeriodo = new GregorianCalendar();
			inicioPeriodo.setTime(rs.getDate("INICIOPERIODO"));
			experienciaProfissional.setInicioPeriodo(inicioPeriodo);
			GregorianCalendar fimPeriodo = new GregorianCalendar();
			fimPeriodo.setTime(rs.getDate("TERMINOPERIODO"));
			experienciaProfissional.setFimPeriodo(fimPeriodo);
			
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
		
		return experienciaProfissional;
	}

}
