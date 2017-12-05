package br.uva.rsuva.controller.rest.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.uva.rsuva.controller.rest.OportunidadeEndPoint;
import br.uva.rsuva.model.dao.OportunidadeDAO;
import br.uva.rsuva.model.dao.impl.OportunidadeDAOImpl;
import br.uva.rsuva.model.entity.Oportunidade;

@Path("/oportunidade")
public class OportunidadeEndPointImpl implements OportunidadeEndPoint {

	private OportunidadeDAO oportunidadeDAO;

	@Override
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Oportunidade> getOportunidades() {
		oportunidadeDAO = new OportunidadeDAOImpl();
		return oportunidadeDAO.listar();

	}

	@Override
	@POST
	@Path("/new")
	@Produces("application/json")
	@Consumes({ MediaType.APPLICATION_JSON })
	public int incluirOportunidade(Oportunidade oportunidade) {
		oportunidadeDAO = new OportunidadeDAOImpl();
		return oportunidadeDAO.incluir(oportunidade);

	}

	@Override
	@DELETE
	@Path("delete/{id}")
	@Produces("application/json")
	@Consumes({ MediaType.APPLICATION_JSON })
	public boolean removerOportunidade(@PathParam("id") int id) {
		Oportunidade oportunidade = new Oportunidade();
		oportunidade.setId(id);
		oportunidadeDAO = new OportunidadeDAOImpl();
		return oportunidadeDAO.excluir(oportunidade);
	}
	
	@Override
	@PUT
	@Path("edit")
	@Produces("application/json")
	@Consumes({ MediaType.APPLICATION_JSON })
	public boolean alterarOportunidade(Oportunidade oportunidade) {
		oportunidadeDAO = new OportunidadeDAOImpl();
		return oportunidadeDAO.alterar(oportunidade);
	}

}
