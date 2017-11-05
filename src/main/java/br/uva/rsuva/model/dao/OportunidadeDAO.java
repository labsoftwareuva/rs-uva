package br.uva.rsuva.model.dao;

import java.util.List;

import br.uva.rsuva.model.entity.Oportunidade;

public interface OportunidadeDAO {

	public int incluir(Oportunidade oportunidade);
	
	public boolean alterar(Oportunidade oportunidade);

	public boolean excluir(Oportunidade oportunidade);
	
	public List<Oportunidade> listar();
	
	public Oportunidade getOportunidade(int id);
}
