package br.uva.rsuva.controller.rest;

import java.util.List;

import br.uva.rsuva.model.entity.Oportunidade;

public interface OportunidadeEndPoint {
	public Oportunidade getOportunidade(int id);
	
	public List<Oportunidade> getOportunidades();
	
	public int incluirOportunidade(Oportunidade oportunidade);
	
	public boolean alterarOportunidade(Oportunidade oportunidade);
	
	public boolean removerOportunidade(Oportunidade oportunidade);
}
