package br.uva.rsuva.controller.rest;

import java.util.List;

import br.uva.rsuva.model.entity.Usuario;

public interface UsuarioEndPoint {
	
	public Usuario getUsuario(int id);
	
	public List<Usuario> getUsuarios();
	
	public int incluirUsuario(String nome, String email, String senha);
	
	public boolean alterarUsuario(int id, String nome, String email, String senha);
	
	public boolean removerUsuario(int id);
	
}
