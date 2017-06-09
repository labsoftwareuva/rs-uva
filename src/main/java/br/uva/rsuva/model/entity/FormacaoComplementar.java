package br.uva.rsuva.model.entity;

import java.util.GregorianCalendar;

public class FormacaoComplementar {
	
	private int id;
	private String instituicao;
	private String curso;
	private TipoCursoEnum tipoCurso;
	private String pais;
	private String estado;
	private DuracaoEnum duracao;
	private SituacaoEnum situacao;
	private GregorianCalendar dataConclusao;
	
	public FormacaoComplementar(){}
	
	public FormacaoComplementar(int id, String instituicao, String curso, TipoCursoEnum tipoCurso, String pais,
			String estado, DuracaoEnum duracao, SituacaoEnum situacao, GregorianCalendar dataConclusao) {
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
	public TipoCursoEnum getTipoCurso() {
		return tipoCurso;
	}
	public void setTipoCurso(TipoCursoEnum tipoCurso) {
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
	public DuracaoEnum getDuracao() {
		return duracao;
	}
	public void setDuracao(DuracaoEnum duracao) {
		this.duracao = duracao;
	}
	public SituacaoEnum getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}
	public GregorianCalendar getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(GregorianCalendar dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

}
