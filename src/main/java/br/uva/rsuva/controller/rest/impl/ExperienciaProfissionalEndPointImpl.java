/*
 * Renato Nascimento - 03/11
 * Implementação burra, revisar
*/


package br.uva.rsuva.controller.rest.impl;

//import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.uva.rsuva.controller.rest.ExperienciaProfissionalEndPoint;
import br.uva.rsuva.model.dao.*;
import br.uva.rsuva.model.dao.impl.*;
import br.uva.rsuva.model.entity.*;

public class ExperienciaProfissionalEndPointImpl implements ExperienciaProfissionalEndPoint{

	private ExperienciaProfissionalDAO experienciaProfissionalDAO;
	
	@Override
	@GET
	@Path("obter/{id}")
	@Produces("application/json")
	public ExperienciaProfissional getExperienciaProfissional(@PathParam("id")int id) {
		
		experienciaProfissionalDAO = new ExperienciaProfissionalDAOImpl();
		
		ExperienciaProfissional experienciaProfissional = experienciaProfissionalDAO.getExperienciaProfissional(id);

		return experienciaProfissional;
	}

	@Override
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public List<ExperienciaProfissional> getExperiencias() {
		
		experienciaProfissionalDAO = new ExperienciaProfissionalDAOImpl();
		return experienciaProfissionalDAO.listar();
	}

	@Override
	@GET
	@Path("/adicionar")
	@Produces("application/json")
	@Consumes({MediaType.APPLICATION_JSON})
	public int incluirExperienciaProfissional(ExperienciaProfissional experienciaProfissional, Candidato candidato) {
		experienciaProfissionalDAO = new ExperienciaProfissionalDAOImpl();
		return experienciaProfissionalDAO.incluir(experienciaProfissional, candidato);
	}

	@Override
	@GET
	@Path("/alterar")
	@Produces("application/json")
	@Consumes({MediaType.APPLICATION_JSON})
	public boolean alterarExperienciaProfissional(ExperienciaProfissional experienciaprofissional) {
		experienciaProfissionalDAO = new ExperienciaProfissionalDAOImpl();
		return experienciaProfissionalDAO.alterar(experienciaprofissional);
	}

	@Override
	@GET
	@Path("/remover")
	@Produces("application/json")
	@Consumes({MediaType.APPLICATION_JSON})
	public boolean removerExperienciaProfissional(ExperienciaProfissional experienciaprofissional) {
		experienciaProfissionalDAO = new ExperienciaProfissionalDAOImpl();
		return experienciaProfissionalDAO.excluir(experienciaprofissional);
	}
	

}
