package br.uva.rsuva.model;

import java.util.ArrayList;

import br.uva.rsuva.model.entity.Usuario;

public class UsuarioDAOTest {

	public static void main(String[] args) {
		
		int id = 0;
		
		// Testa inclusão
		Usuario u = new Usuario();
		u.setNome("Bruno");
		u.setEmail("bruno.sobral.silva@gmail.com");
		u.setSenha("123456");
		
		UsuarioDAO dao = new UsuarioDAO();
		id = dao.incluir(u);
		
		dao = new UsuarioDAO();
		u = dao.getUsuario(id);
		
		System.out.println("Usuario incluido: " + u);
						
		// Testa alteracao
		u.setNome("Bruno Sobral");
		dao = new UsuarioDAO();
		dao.alterar(u);
		
		dao = new UsuarioDAO();
		u = dao.getUsuario(id);
		System.out.println("Usuario alterado: " + u);		
		
		// Testa listagem de usuários
		
		System.out.println("Listagem de usuarios na base:");
		
		dao = new UsuarioDAO();
		ArrayList<Usuario> usuarios = dao.listarUsuarios();
		for(Usuario us : usuarios){
			System.out.println(us);
		}
		
		// Testa exclusao
		dao = new UsuarioDAO();
		dao.excluir(u);
		
		System.out.println("Usuario " + u.getNome() + " excluido.");

	}

}
