package br.uva.rsuva.model.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {
	@XmlElement
	private int id;
	@XmlElement
	private String nome;
	@XmlElement
	private String senha;
	@XmlElement
	private String email;
	
	public Usuario(){}
	
	public Usuario(int id, String nome, String senha, String email) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}
	public Usuario(String nome, String senha, String email) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}
	public Usuario(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString(){
		return this.nome + " " + this.email + " " + this.senha;
	}
	
}
