package br.uva.rsuva.model.entity;

import java.util.GregorianCalendar;

public class ProcessoSeletivo {
	
	private int id;
	private String descricao;
	private GregorianCalendar duracao;
	
	public ProcessoSeletivo(){}
	
	public ProcessoSeletivo(int id, String descricao, GregorianCalendar duracao) {
		this.id = id;
		this.descricao = descricao;
		this.duracao = duracao;
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
	public GregorianCalendar getDuracao() {
		return duracao;
	}
	public void setDuracao(GregorianCalendar duracao) {
		this.duracao = duracao;
	}

}
