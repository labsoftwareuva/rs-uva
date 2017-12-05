package br.uva.rsuva.model.entity;

import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Oportunidade {

	@XmlElement
	private int id;

	@XmlElement(name = "processo")
	private int idProcesso;

	@XmlElement
	private int qtdVagas;

	@XmlElement
	private double salarioInicial;

	@XmlElement
	private String areaAtuacao;

	@XmlElement
	private String cargo;

	@XmlElement
	private String requisitos;

	@XmlElement
	private String beneficios;// TODO virar classe

	@XmlElement
	private String descricao;

	@XmlElement
	private GregorianCalendar dataInicial;

	@XmlElement
	private GregorianCalendar dataFinal;

	public Oportunidade() {
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

	public GregorianCalendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(GregorianCalendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public GregorianCalendar getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(GregorianCalendar dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
