package br.uva.rsuva.model.entity;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Formacao {
	@XmlElement
	private int id;
	@XmlElement
	private String instituicao;
	@XmlElement
	private String curso;
	@XmlElement
	private String estadoAtual;
	@XmlElement
	private String outros;	
	@XmlElement
	private String estado;
	@XmlElement
	private String pais;
	@XmlElement
	private GregorianCalendar dataConclusao;
	@XmlElement
	private String nivel;
	@XmlElement
	private String mesConclusao;
	@XmlElement
	private String anoConclusao;
	
	public Formacao(){}

	

	public Formacao(int id, String instituicao, String curso, String estadoAtual, String outros, String estado,
			String pais, GregorianCalendar dataConclusao, String nivel) {
		super();
		this.id = id;
		this.instituicao = instituicao;
		this.curso = curso;
		this.estadoAtual = estadoAtual;
		this.outros = outros;
		this.estado = estado;
		this.pais = pais;
		this.dataConclusao = dataConclusao;
		this.nivel = nivel;
	}
	



	public Formacao(int id, String instituicao, String curso, String estadoAtual, String outros, String estado,
			String pais, GregorianCalendar dataConclusao, String nivel, String mesConclusao, String anoConclusao) {
		super();
		this.id = id;
		this.instituicao = instituicao;
		this.curso = curso;
		this.estadoAtual = estadoAtual;
		this.outros = outros;
		this.estado = estado;
		this.pais = pais;
		this.dataConclusao = dataConclusao;
		this.nivel = nivel;
		this.mesConclusao = mesConclusao;
		this.anoConclusao = anoConclusao;
	}



	public String getNivel() {
		return nivel;
	}



	public void setNivel(String nivel) {
		this.nivel = nivel;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(String estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

	public String getOutros() {
		return outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}



	public String getInstituicao() {
		return instituicao;
	}



	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}



	public GregorianCalendar getDataConclusao() {
		return dataConclusao;
	}



	public void setDataConclusao(GregorianCalendar dataConclusao) {
		this.dataConclusao = dataConclusao;
	}



	public String getMesConclusao() {
		return mesConclusao;
	}



	public void setMesConclusao(String mesConclusao) {
		this.mesConclusao = mesConclusao;
	}



	public String getAnoConclusao() {
		return anoConclusao;
	}



	public void setAnoConclusao(String anoConclusao) {
		this.anoConclusao = anoConclusao;
	}	

	
	
}
