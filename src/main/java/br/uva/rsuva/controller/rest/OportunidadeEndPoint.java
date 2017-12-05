package br.uva.rsuva.controller.rest;

import java.util.List;

import br.uva.rsuva.model.entity.Oportunidade;

public interface OportunidadeEndPoint {
	
	public List<Oportunidade> getOportunidades();
	
	public int incluirOportunidade(Oportunidade oportunidade);
	
	public boolean alterarOportunidade(Oportunidade oportunidade);

	boolean removerOportunidade(int id);
}
