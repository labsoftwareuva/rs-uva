package br.uva.rsuva.controller.rest;

import java.util.List;

import br.uva.rsuva.model.entity.Candidato;

public interface CandidatoEndPoint {
	public Candidato getCandidato(int id);
	
	public List<Candidato> getCandidatos();
	
	public int incluirCandidato(Candidato candidato);
	
	public boolean alterarUsuario(Candidato candidato);
	
	public boolean removerUsuario(Candidato candidato);
}
