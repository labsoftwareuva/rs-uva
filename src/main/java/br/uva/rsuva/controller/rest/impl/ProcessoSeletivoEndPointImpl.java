/*
 * Renato Nascimento - 03/11
 * Implementação burra, revisar
*/


package br.uva.rsuva.controller.rest.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.uva.rsuva.controller.rest.ProcessoSeletivoEndPoint;
import br.uva.rsuva.model.dao.*;
import br.uva.rsuva.model.dao.impl.*;
import br.uva.rsuva.model.entity.*;

public class ProcessoSeletivoEndPointImpl implements ProcessoSeletivoEndPoint{

	private ProcessoSeletivoDAO processoSeletivoDAO;
	
	@Override
	@GET
	@Path("obter/{id}")
	@Produces("application/json")
	public ProcessoSeletivo getProcessoSeletivo(@PathParam("id")int id) {
		
		processoSeletivoDAO = new ProcessoSeletivoDAOImpl();
		
		ProcessoSeletivo processoSeletivo = processoSeletivoDAO.getProcessoSeletivo(id);

		return processoSeletivo;
	}

	@Override
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public List<ProcessoSeletivo> getProcessos() {
		
		processoSeletivoDAO = new ProcessoSeletivoDAOImpl();
		return processoSeletivoDAO.listar();
	}

	@Override
	@GET
	@Path("/adicionar")
	@Produces("application/json")
	@Consumes({MediaType.APPLICATION_JSON})
	public int incluirProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
		processoSeletivoDAO = new ProcessoSeletivoDAOImpl();
		return processoSeletivoDAO.incluir(processoSeletivo);
	}

	@Override
	@GET
	@Path("/alterar")
	@Produces("application/json")
	@Consumes({MediaType.APPLICATION_JSON})
	public boolean alterarProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
		processoSeletivoDAO = new ProcessoSeletivoDAOImpl();
		return processoSeletivoDAO.alterar(processoSeletivo);
	}

	@Override
	@GET
	@Path("/remover")
	@Produces("application/json")
	@Consumes({MediaType.APPLICATION_JSON})
	public boolean removerProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
		processoSeletivoDAO = new ProcessoSeletivoDAOImpl();
		return processoSeletivoDAO.excluir(processoSeletivo);
	}
	

}
