package br.uva.rsuva.model.entity;

import java.util.GregorianCalendar;

public class Oportunidade {
	
	private int id;
	private int idProcesso;
	private int qtdVagas;
	private double salarioInicial;
	private String areaAtuacao;
	private String cargo;
	private String requisitos;
	private String beneficios;
	private GregorianCalendar inicioPeriodo;
	private GregorianCalendar fimPeriodo;
	
	
	public Oportunidade() {
	}
	
	public Oportunidade(int id, int idProcesso, int qtdVagas, double salarioInicial, String areaAtuacao, String cargo,
			String requisitos, String beneficios, GregorianCalendar inicioPeriodo, GregorianCalendar fimPeriodo) {
		super();
		this.id = id;
		this.idProcesso = idProcesso;
		this.qtdVagas = qtdVagas;
		this.salarioInicial = salarioInicial;
		this.areaAtuacao = areaAtuacao;
		this.cargo = cargo;
		this.requisitos = requisitos;
		this.beneficios = beneficios;
		this.inicioPeriodo = inicioPeriodo;
		this.fimPeriodo = fimPeriodo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdProcesso() {
		return idProcesso;
	}


	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}


	public int getQtdVagas() {
		return qtdVagas;
	}


	public void setQtdVagas(int qtdVagas) {
		this.qtdVagas = qtdVagas;
	}


	public double getSalarioInicial() {
		return salarioInicial;
	}


	public void setSalarioInicial(double salarioInicial) {
		this.salarioInicial = salarioInicial;
	}


	public String getAreaAtuacao() {
		return areaAtuacao;
	}


	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getRequisitos() {
		return requisitos;
	}


	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}


	public String getBeneficios() {
		return beneficios;
	}


	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}


	public GregorianCalendar getInicioPeriodo() {
		return inicioPeriodo;
	}


	public void setInicioPeriodo(GregorianCalendar inicioPeriodo) {
		this.inicioPeriodo = inicioPeriodo;
	}


	public GregorianCalendar getFimPeriodo() {
		return fimPeriodo;
	}


	public void setFimPeriodo(GregorianCalendar fimPeriodo) {
		this.fimPeriodo = fimPeriodo;
	}
}
