package br.uva.rsuva.controller.rest.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.uva.rsuva.controller.rest.UsuarioEndPoint;
import br.uva.rsuva.model.dao.UsuarioDAO;
import br.uva.rsuva.model.entity.Usuario;

@Path("/usuario")
public class UsuarioEndPointImpl implements UsuarioEndPoint{
	
	private UsuarioDAO usuarioDao;
	
	@Override
	@GET
	@Path("obter/{id}")
	@Produces("application/json")
	public Usuario getUsuario(@PathParam("id") int id) {
		usuarioDao = new UsuarioDAO();
		return usuarioDao.getUsuario(id);
	}
	
	@Override
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public List<Usuario> getUsuarios() {
		usuarioDao = new UsuarioDAO();
		return usuarioDao.listarUsuarios();
	}

	@Override
	@POST
	@Path("/cadastrar")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public int incluirUsuario(	@FormParam("nome") String nome,
								@FormParam("email")String email,
								@FormParam("senha")String senha) {
		usuarioDao = new UsuarioDAO();
		return usuarioDao.incluir(new Usuario(nome,senha,email));
	}

	@Override
	@POST
	@Path("/alterar")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public boolean alterarUsuario(	@FormParam("id") int id, 
									@FormParam("nome") String nome,
									@FormParam("senha") String email,
									@FormParam("email") String senha) {
		usuarioDao = new UsuarioDAO();
		return usuarioDao.alterar(new Usuario(id, nome, senha, email));
	}

	@Override
	@DELETE
	@Path("/remover/{id}")
	public boolean removerUsuario(@PathParam("id") int id) {
		usuarioDao = new UsuarioDAO();
		
		return usuarioDao.excluir(new Usuario(id));
	}

}
