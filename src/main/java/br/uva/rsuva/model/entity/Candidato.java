package br.uva.rsuva.model.entity;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Candidato {
	
	@XmlElement
	private int id;
	@XmlElement
	private List<ExperienciaProfissional> experienciasProfissionais;
	@XmlElement
	private List<Formacao> formacoes;
	@XmlElement
	private List<FormacaoComplementar> formacoesComplementares;
	private ArrayList<ProcessoSeletivo> processosSeletivos;
	private PerfilPrimario perfil;
	@XmlElement
	private Usuario usuario;
	@XmlElement
	private String cpf;
	@XmlElement
	private String endereco;
	@XmlElement
	private String numero;
	@XmlElement
	private String complemento;
	@XmlElement
	private String cep;
	@XmlElement
	private String estado;
	@XmlElement
	private String cidade;
	@XmlElement
	private GregorianCalendar dataNascimento;
	@XmlElement
	private String rg;
	@XmlElement
	private String emissor;
	@XmlElement
	private GregorianCalendar expedicao;
	@XmlElement
	private char sexo;
	@XmlElement
	private String telefone;
	@XmlElement
	private String celular;
	@XmlElement
	private String uf;
	
	public Candidato(){}

	
	


	public Candidato(int id, List<ExperienciaProfissional> experienciasProfissionais, List<Formacao> formacoes,
			List<FormacaoComplementar> formacoesComplementares, ArrayList<ProcessoSeletivo> processosSeletivos,
			PerfilPrimario perfil, Usuario usuario, String cpf, String endereco, String numero, String complemento,
			String cep, String estado, String cidade, GregorianCalendar dataNascimento, String rg, String emissor,
			GregorianCalendar expedicao, char sexo, String telefone, String celular, String uf) {
		super();
		this.id = id;
		this.experienciasProfissionais = experienciasProfissionais;
		this.formacoes = formacoes;
		this.formacoesComplementares = formacoesComplementares;
		this.processosSeletivos = processosSeletivos;
		this.perfil = perfil;
		this.usuario = usuario;
		this.cpf = cpf;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.emissor = emissor;
		this.expedicao = expedicao;
		this.sexo = sexo;
		this.telefone = telefone;
		this.celular = celular;
		this.uf = uf;
	}





	public Candidato(int id, String cpf, String endereco, String numero, String complemento, String cep, String estado,
			String cidade, GregorianCalendar dataNascimento, String rg, String emissor, GregorianCalendar expedicao,
			char sexo, String telefone, String celular, String uf) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.emissor = emissor;
		this.expedicao = expedicao;
		this.sexo = sexo;
		this.telefone = telefone;
		this.celular = celular;
		this.uf = uf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<ProcessoSeletivo> getProcessosSeletivos() {
		return processosSeletivos;
	}

	public void setProcessosSeletivos(ArrayList<ProcessoSeletivo> processosSeletivos) {
		this.processosSeletivos = processosSeletivos;
	}

	public PerfilPrimario getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilPrimario perfil) {
		this.perfil = perfil;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public GregorianCalendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(GregorianCalendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

	public GregorianCalendar getExpedicao() {
		return expedicao;
	}

	public void setExpedicao(GregorianCalendar expedicao) {
		this.expedicao = expedicao;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<ExperienciaProfissional> getExperienciasProfissionais() {
		return experienciasProfissionais;
	}

	public void setExperienciasProfissionais(List<ExperienciaProfissional> experienciasProfissionais) {
		this.experienciasProfissionais = experienciasProfissionais;
	}

	public List<Formacao> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(List<Formacao> formacoes) {
		this.formacoes = formacoes;
	}

	public List<FormacaoComplementar> getFormacoesComplementares() {
		return formacoesComplementares;
	}

	public void setFormacoesComplementares(List<FormacaoComplementar> formacoesComplementares) {
		this.formacoesComplementares = formacoesComplementares;
	}
	
}
