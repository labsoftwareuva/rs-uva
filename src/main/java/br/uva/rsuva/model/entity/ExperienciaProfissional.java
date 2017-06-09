package br.uva.rsuva.model.entity;

import java.util.GregorianCalendar;

public class ExperienciaProfissional {
	
	private int id;
	private String empresa;
	private String pais;
	private String estado;
	private String tituloCargo;
	private String setor;
	private String atualidade;
	private String atividades;
	private GregorianCalendar periodo;
	
	public ExperienciaProfissional(){}

	public ExperienciaProfissional(int id, String empresa, String pais, String estado, String tituloCargo, String setor,
			String atualidade, String atividades, GregorianCalendar periodo) {
		this.id = id;
		this.empresa = empresa;
		this.pais = pais;
		this.estado = estado;
		this.tituloCargo = tituloCargo;
		this.setor = setor;
		this.atualidade = atualidade;
		this.atividades = atividades;
		this.periodo = periodo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTituloCargo() {
		return tituloCargo;
	}

	public void setTituloCargo(String tituloCargo) {
		this.tituloCargo = tituloCargo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getAtualidade() {
		return atualidade;
	}

	public void setAtualidade(String atualidade) {
		this.atualidade = atualidade;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

	public GregorianCalendar getPeriodo() {
		return periodo;
	}

	public void setPeriodo(GregorianCalendar periodo) {
		this.periodo = periodo;
	}

}
