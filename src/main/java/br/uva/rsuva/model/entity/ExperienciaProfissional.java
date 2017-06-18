package br.uva.rsuva.model.entity;

import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExperienciaProfissional {
	@XmlElement
	private int id;
	@XmlElement
	private String empresa;
	@XmlElement
	private String pais;
	@XmlElement
	private String estado;
	@XmlElement
	private String tituloCargo;
	@XmlElement
	private String setor;
	@XmlElement
	private String atualidade;
	@XmlElement
	private String atividades;
	@XmlElement
	private GregorianCalendar inicioPeriodo;
	@XmlElement
	private GregorianCalendar fimPeriodo;
	
	
	public ExperienciaProfissional(){}

	

	
	public ExperienciaProfissional(int id, String empresa, String pais, String estado, String tituloCargo, String setor,
			String atualidade, String atividades, GregorianCalendar inicioPeriodo, GregorianCalendar fimPeriodo) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.pais = pais;
		this.estado = estado;
		this.tituloCargo = tituloCargo;
		this.setor = setor;
		this.atualidade = atualidade;
		this.atividades = atividades;
		this.inicioPeriodo = inicioPeriodo;
		this.fimPeriodo = fimPeriodo;
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
