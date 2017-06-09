package br.uva.rsuva.model.entity;
import br.uva.rsuva.model.entity.CursoEnum;
import br.uva.rsuva.model.entity.MesEnum;

public class Formacao {
	
	private int id;
	private CursoEnum curso;
	private String estadoAtual;
	private String outros;	
	private MesEnum mesConclusao;	
	private int anoConclusao;
	private String estado;
	private String pais;
	
	public Formacao(){}

	public Formacao(int id, CursoEnum curso, String estadoAtual, String outros, MesEnum mesConclusao, int anoConclusao,
			String estado, String pais) {
		this.id = id;
		this.curso = curso;
		this.estadoAtual = estadoAtual;
		this.outros = outros;
		this.mesConclusao = mesConclusao;
		this.anoConclusao = anoConclusao;
		this.estado = estado;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CursoEnum getCurso() {
		return curso;
	}

	public void setCurso(CursoEnum curso) {
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

	public MesEnum getMesConclusao() {
		return mesConclusao;
	}

	public void setMesConclusao(MesEnum mesConclusao) {
		this.mesConclusao = mesConclusao;
	}

	public int getAnoConclusao() {
		return anoConclusao;
	}

	public void setAnoConclusao(int anoConclusao) {
		this.anoConclusao = anoConclusao;
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

	
	
}
