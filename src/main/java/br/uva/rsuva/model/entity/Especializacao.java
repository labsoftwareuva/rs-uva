package br.uva.rsuva.model.entity;

public class Especializacao {
	
	private int id;
	private String descricao;
	
	public Especializacao(){}
	
	public Especializacao(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
