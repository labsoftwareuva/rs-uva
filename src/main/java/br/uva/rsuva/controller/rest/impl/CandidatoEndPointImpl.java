package br.uva.rsuva.controller.rest.impl;

import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.uva.rsuva.controller.rest.CandidatoEndPoint;
import br.uva.rsuva.model.dao.CandidatoDAO;
import br.uva.rsuva.model.dao.ExperienciaProfissionalDAO;
import br.uva.rsuva.model.dao.FormacaoComplementarDAO;
import br.uva.rsuva.model.dao.FormacaoDAO;
import br.uva.rsuva.model.dao.impl.CandidatoDAOImpl;
import br.uva.rsuva.model.dao.impl.ExperienciaProfissionalDAOImpl;
import br.uva.rsuva.model.dao.impl.FormacaoComplementarDAOImpl;
import br.uva.rsuva.model.dao.impl.FormacaoDAOImpl;
import br.uva.rsuva.model.entity.Candidato;
import br.uva.rsuva.model.entity.Formacao;
import br.uva.rsuva.model.entity.FormacaoComplementar;

@Path("/candidato")
public class CandidatoEndPointImpl implements CandidatoEndPoint{
	
	private CandidatoDAO candidatoDAO;
	private FormacaoComplementarDAO formacaoComplementarDAO;
	private ExperienciaProfissionalDAO experienciaProfissionalDAO;
	private FormacaoDAO formacaoDAO;
	
	@Override
	@GET
	@Path("obter/{id}")
	@Produces("application/json")
	public Candidato getCandidato(@PathParam("id") int id) {
		candidatoDAO = new CandidatoDAOImpl();
		formacaoComplementarDAO = new FormacaoComplementarDAOImpl();
		experienciaProfissionalDAO = new ExperienciaProfissionalDAOImpl();
		formacaoDAO = new FormacaoDAOImpl();
		
		Candidato candidato = candidatoDAO.getCandidato(id);
		
		candidato.setFormacoes(formacaoDAO.listar(id));
		candidato.setExperienciasProfissionais(experienciaProfissionalDAO.listar(id));
		candidato.setFormacoesComplementares(formacaoComplementarDAO.listar(id));
		
		return candidato;
	}

	@Override
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public List<Candidato> getCandidatos() {
		candidatoDAO = new CandidatoDAOImpl();
		return candidatoDAO.listar();
	}

	@Override
	@POST
	@Path("/cadastrar")
	@Produces("application/json")
	@Consumes({MediaType.APPLICATION_JSON})
	public int incluirCandidato(Candidato candidato) {
		//List<Formacao> formacoes = new ArrayList<>();
		for(Formacao formacao: candidato.getFormacoes()){
			int ano = Integer.parseInt(formacao.getAnoConclusao());
			int mes = Integer.parseInt(formacao.getMesConclusao());
			formacao.setDataConclusao(new GregorianCalendar(ano, mes, 1));
		}
		for(FormacaoComplementar formacaoComplementar: candidato.getFormacoesComplementares()){
			int ano = Integer.parseInt(formacaoComplementar.getAnoConclusao());
			int mes = Integer.parseInt(formacaoComplementar.getMesConclusao());
			formacaoComplementar.setDataConclusao(new GregorianCalendar(ano, mes, 1));
		}
		candidatoDAO = new CandidatoDAOImpl();
		return candidatoDAO.incluirCompleto(candidato);
		
	}

	@Override
	public boolean alterarUsuario(Candidato candidato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerUsuario(Candidato candidato) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
