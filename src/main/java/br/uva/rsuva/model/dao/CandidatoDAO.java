package br.uva.rsuva.model.dao;

import java.util.List;

import br.uva.rsuva.model.entity.Candidato;

public interface CandidatoDAO {

	public int incluir(Candidato candidato);
	
	public boolean alterar(Candidato candidato);

	public boolean excluir(Candidato candidato);
	
	public List<Candidato> listar();
	
	public Candidato getCandidato(int id);
}
