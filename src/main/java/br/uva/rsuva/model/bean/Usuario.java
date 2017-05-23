package br.uva.rsuva.model.bean;

public class Usuario {

	private Long Id;
	private String Nome;
	private String Senha;	
	private String Email;
	
	public Usuario(){}	
	
	public Usuario(Long id, String nome, String senha, String email) {
		
		Id = id;
		Nome = nome;
		Senha = senha;
		Email = email;
	}

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public Long getID() {
		return Id;
	}
	public void setID(Long id) {
		Id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
