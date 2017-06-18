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
import br.uva.rsuva.model.entity.ExperienciaProfissional;
import br.uva.rsuva.model.entity.Formacao;
import br.uva.rsuva.model.entity.FormacaoComplementar;

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
			stmt.setString(3, candidato.getNumero());
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
			stmt.setString(3, candidato.getNumero());
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
		    	candidato.setNumero(rs.getString("CPF"));
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
		    	expedicao.setTime(rs.getDate("EXPEDICAO"));
		    	candidato.setExpedicao(expedicao);
		    	candidato.setSexo(rs.getString("SEXO").charAt(0));
		    	candidato.setTelefone(rs.getString("TELEFONE"));
		    	candidato.setCelular(rs.getString("CELULAR"));
		    	candidatos.add(candidato);
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
	    	candidato.setNumero(rs.getString("CPF"));
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
	    	expedicao.setTime(rs.getDate("EXPEDICAO"));
	    	candidato.setExpedicao(expedicao);
	    	candidato.setSexo(rs.getString("SEXO").charAt(0));
	    	candidato.setTelefone(rs.getString("TELEFONE"));
	    	candidato.setCelular(rs.getString("CELULAR"));

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
	@SuppressWarnings("resource")
	@Override
	public int incluirCompleto(Candidato candidato) {
		
		
		PreparedStatement stmt = null;
		int novoId = 0;
		int idUsuario = 0;
		try {
			conexao.setAutoCommit(false);
			StringBuilder sbQuery = new StringBuilder();
			sbQuery.append("INSERT INTO USUARIO (NOME,EMAIL,SENHA) VALUES (?,?,?)");
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, candidato.getUsuario().getNome());
		    stmt.setString(2, candidato.getUsuario().getEmail());
		    stmt.setString(3, candidato.getUsuario().getSenha());
		    stmt.executeUpdate();
		    
		    ResultSet rs = stmt.getGeneratedKeys();
		    if(rs.next()){
		    	idUsuario = rs.getInt(1);
		    }	
		    
		    sbQuery = new StringBuilder();
			sbQuery.append("INSERT INTO CANDIDATO (CPF, ENDERECO, NUMERO, COMPLEMENTO, CEP, ESTADO, CIDADE, DATANASC,");
			sbQuery.append(" RG, EMISSOR, EXPEDICAO, SEXO, TELEFONE, CELULAR, IDUSUARIO) VALUES (");
			sbQuery.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
			stmt = conexao.prepareStatement(sbQuery.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, candidato.getCpf());
			stmt.setString(2, candidato.getEndereco());
			stmt.setString(3, candidato.getNumero());
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
			stmt.setInt(15, idUsuario);
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
		    if(rs.next()){
		    	novoId = rs.getInt(1);
		    }
			/////////////////////////////////////////////
			List<ExperienciaProfissional> experiencias = candidato.getExperienciasProfissionais();
			for(ExperienciaProfissional ep:experiencias){
				sbQuery = new StringBuilder();
				sbQuery.append("INSERT INTO EXPERIENCIAPROF (IDCANDIDATO, EMPRESA, PAIS, ESTADO, TITULOCARGO, SETOR, ATUALIDADE, ATIVIDADES,");
				sbQuery.append(" INICIOPERIODO, TERMINOPERIODO) VALUES (?,?,?,?,?,?,?,?,?,?)");
				stmt = conexao.prepareStatement(sbQuery.toString());
				stmt.setInt(1, novoId);
				stmt.setString(2, ep.getEmpresa());
				stmt.setString(3, ep.getPais());
				stmt.setString(4, ep.getEstado());
				stmt.setString(5, ep.getTituloCargo());
				stmt.setString(6, ep.getSetor());
				stmt.setString(7, ep.getAtualidade());
				stmt.setString(8, ep.getAtividades());
				stmt.setDate(9, new java.sql.Date(ep.getInicioPeriodo().getTimeInMillis()));
				stmt.setDate(10, new java.sql.Date(ep.getFimPeriodo().getTimeInMillis()));
				stmt.executeUpdate();
			}
		    List<Formacao> formacoes = candidato.getFormacoes();
		    for(Formacao frm:formacoes){
		    	sbQuery = new StringBuilder();
				sbQuery.append("INSERT INTO FORMACAO (IDCANDIDATO,INSTITUICAO,CURSO,NIVEL,ESTADOATUAL,OUTROS,DATACONCL,ESTADO,PAIS) VALUES (?,?,?,?,?,?,?,?,?)");
				stmt = conexao.prepareStatement(sbQuery.toString());
				stmt.setInt(1, novoId);
				stmt.setString(2, frm.getInstituicao());
				stmt.setString(3, frm.getCurso());
				stmt.setString(4, frm.getNivel());
				stmt.setString(5, frm.getEstadoAtual());
				stmt.setString(6, frm.getOutros());
				stmt.setDate(7, new java.sql.Date(frm.getDataConclusao().getTimeInMillis()));
				stmt.setString(8, frm.getEstado());
				stmt.setString(9, frm.getPais());
				stmt.executeUpdate();
		    }
		    List<FormacaoComplementar> formacoesComp = candidato.getFormacoesComplementares();
		    for(FormacaoComplementar fcp: formacoesComp){
		    	sbQuery = new StringBuilder();
		    	sbQuery.append("INSERT INTO FORMACAOCOMP (IDCANDIDATO,INSTITUICAO,CURSO,TIPOCURSO,PAIS,ESTADO,DURACAO,SITUACAO,DATACONCL)");
		    	sbQuery.append(" VALUES (?,?,?,?,?,?,?,?,?)");
		    	stmt = conexao.prepareStatement(sbQuery.toString());
		    	stmt.setInt(1, novoId);
		    	stmt.setString(2, fcp.getInstituicao());
				stmt.setString(3, fcp.getCurso());
				stmt.setString(4, fcp.getTipoCurso());
				stmt.setString(5, fcp.getPais());
				stmt.setString(6, fcp.getEstado());
				stmt.setString(7, fcp.getDuracao());
				stmt.setString(8, fcp.getSituacao());
				stmt.setDate(9, new java.sql.Date(fcp.getDataConclusao().getTimeInMillis()));
				stmt.executeUpdate();
		    }
		    
		    conexao.commit();
		    stmt.close();
		    
		    conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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

}
