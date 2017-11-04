package br.uva.rsuva.controller.rest;

import java.util.List;

import br.uva.rsuva.model.entity.Candidato;
import br.uva.rsuva.model.entity.ExperienciaProfissional;

/*
Renato Nascimento - 11/02
Adequando endpoint ExperienciaProfissional de acordo com CandidatoEndPoint.
*/

public interface ExperienciaProfissionalEndPoint {
	
	public ExperienciaProfissional getExperienciaProfissional(int id);
	
	public List<ExperienciaProfissional> getExperiencias();
	
	public int incluirExperienciaProfissional(ExperienciaProfissional experienciaprofissional, Candidato candidato);
	
	public boolean alterarExperienciaProfissional (ExperienciaProfissional experienciaprofissional);
	
	public boolean removerExperienciaProfissional (ExperienciaProfissional experienciaprofissional);
	
}
