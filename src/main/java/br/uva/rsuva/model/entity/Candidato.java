package br.uva.rsuva.model.entity;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Candidato {
	
	private int id;
	private ArrayList<ExperienciaProfissional> experienciasProfissionais;
	private ArrayList<Formacao> formacoes;
	private ArrayList<FormacaoComplementar> formacoesComplementares;
	private ArrayList<ProcessoSeletivo> processosSeletivos;
	private PerfilPrimario perfil;
	private Usuario usuario;
	private String cpf;
	private String endereco;
	private int numero;
	private String complemento;
	private String cep;
	private String estado;
	private String cidade;
	private GregorianCalendar dataNascimento;
	private String rg;
	private String emissor;
	private GregorianCalendar expedicao;
	private SexoEnum sexo;
	private int telefone;
	private int celular;
	private String uf;
	
	public Candidato(){}

	public Candidato(int id, ArrayList<ExperienciaProfissional> experienciasProfissionais,
			ArrayList<Formacao> formacoes, ArrayList<FormacaoComplementar> formacoesComplementares,
			ArrayList<ProcessoSeletivo> processosSeletivos, PerfilPrimario perfil, Usuario usuario, String cpf,
			String endereco, int numero, String complemento, String cep, String estado, String cidade,
			GregorianCalendar dataNascimento, String rg, String emissor, GregorianCalendar expedicao, SexoEnum sexo,
			int telefone, int celular, String uf) {
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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<ExperienciaProfissional> getExperienciasProfissionais() {
		return experienciasProfissionais;
	}

	public void setExperienciasProfissionais(ArrayList<ExperienciaProfissional> experienciasProfissionais) {
		this.experienciasProfissionais = experienciasProfissionais;
	}

	public ArrayList<Formacao> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(ArrayList<Formacao> formacoes) {
		this.formacoes = formacoes;
	}

	public ArrayList<FormacaoComplementar> getFormacoesComplementares() {
		return formacoesComplementares;
	}

	public void setFormacoesComplementares(ArrayList<FormacaoComplementar> formacoesComplementares) {
		this.formacoesComplementares = formacoesComplementares;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
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

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
