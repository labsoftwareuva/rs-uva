package br.uva.rsuva.model.entity;

import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormacaoComplementar {
	
	@XmlElement
	private int id;
	@XmlElement
	private String instituicao;
	@XmlElement
	private String curso;
	@XmlElement
	private String tipoCurso;
	@XmlElement
	private String pais;
	@XmlElement
	private String estado;
	@XmlElement
	private String duracao;
	@XmlElement
	private String situacao;
	@XmlElement
	private GregorianCalendar dataConclusao;
	@XmlElement
	private String mesConclusao;
	@XmlElement
	private String anoConclusao;
	
	public FormacaoComplementar(){}
	
	
	public FormacaoComplementar(int id, String instituicao, String curso, String tipoCurso, String pais, String estado,
			String duracao, String situacao, GregorianCalendar dataConclusao) {
		super();
		this.id = id;
		this.instituicao = instituicao;
		this.curso = curso;
		this.tipoCurso = tipoCurso;
		this.pais = pais;
		this.estado = estado;
		this.duracao = duracao;
		this.situacao = situacao;
		this.dataConclusao = dataConclusao;
	}
	


	public FormacaoComplementar(int id, String instituicao, String curso, String tipoCurso, String pais, String estado,
			String duracao, String situacao, GregorianCalendar dataConclusao, String mesConclusao,
			String anoConclusao) {
		super();
		this.id = id;
		this.instituicao = instituicao;
		this.curso = curso;
		this.tipoCurso = tipoCurso;
		this.pais = pais;
		this.estado = estado;
		this.duracao = duracao;
		this.situacao = situacao;
		this.dataConclusao = dataConclusao;
		this.mesConclusao = mesConclusao;
		this.anoConclusao = anoConclusao;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public String getTipoCurso() {
		return tipoCurso;
	}


	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
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
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
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
