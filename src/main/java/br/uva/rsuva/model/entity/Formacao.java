package br.uva.rsuva.model.entity;
import br.uva.rsuva.model.entity.CursoEnum;
import br.uva.rsuva.model.entity.MesEnum;

public class Formacao {
	
	private Long Id;
	private CursoEnum Curso;
	private String EstadoAtual;
	private String Outros;	
	private MesEnum MesConclusao;	
	private int AnoConclusao;
	private String Estado;
	private String Pais;
	
	public Formacao(){}	
	public Formacao(Long id, CursoEnum curso, String estadoAtual, String outros, MesEnum mesConclusao, int anoConclusao,
			String estado, String pais) {		
		Id = id;
		Curso = curso;
		EstadoAtual = estadoAtual;
		Outros = outros;
		MesConclusao = mesConclusao;
		AnoConclusao = anoConclusao;
		Estado = estado;
		Pais = pais;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public CursoEnum getCurso() {
		return Curso;
	}
	public void setCurso(CursoEnum curso) {
		Curso = curso;
	}
	public String getEstadoAtual() {
		return EstadoAtual;
	}
	public void setEstadoAtual(String estadoAtual) {
		EstadoAtual = estadoAtual;
	}
	public String getOutros() {
		return Outros;
	}
	public void setOutros(String outros) {
		Outros = outros;
	}
	public MesEnum getMesConclusao() {
		return MesConclusao;
	}
	public void setMesConclusao(MesEnum mesConclusao) {
		MesConclusao = mesConclusao;
	}
	public int getAnoConclusao() {
		return AnoConclusao;
	}
	public void setAnoConclusao(int anoConclusao) {
		AnoConclusao = anoConclusao;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		Pais = pais;
	}
	
}
