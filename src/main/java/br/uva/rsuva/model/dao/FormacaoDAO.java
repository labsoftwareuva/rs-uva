package br.uva.rsuva.model.dao;

import java.util.List;

import br.uva.rsuva.model.entity.Candidato;
import br.uva.rsuva.model.entity.Formacao;

public interface FormacaoDAO {
	public int incluir(Formacao formacao, Candidato candidato);

	public boolean alterar(Formacao formacao);

	public boolean excluir(Formacao formacao);
	
	public List<Formacao> listar(int id);
	
	public Formacao getFormacao(int id);
}
