package br.uva.rsuva.model.entity;

public class PerfilPrimario {
	
	private int id;
	private String area;
	private Especializacao especializacao;
	
	public PerfilPrimario(){}

	public PerfilPrimario(int id, String area, Especializacao especializacao) {
		this.id = id;
		this.area = area;
		this.especializacao = especializacao;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Especializacao getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(Especializacao especializacao) {
		this.especializacao = especializacao;
	}
	
	
}
