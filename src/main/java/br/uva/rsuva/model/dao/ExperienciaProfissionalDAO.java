package br.uva.rsuva.model.dao;

import java.util.List;

import br.uva.rsuva.model.entity.Candidato;
import br.uva.rsuva.model.entity.ExperienciaProfissional;

public interface ExperienciaProfissionalDAO {
	public int incluir(ExperienciaProfissional experienciaProfissional, Candidato candidato);

	public boolean alterar(ExperienciaProfissional experienciaProfissional);

	public boolean excluir(ExperienciaProfissional experienciaProfissional);
	
	public List<ExperienciaProfissional> listar(int id);
	
	public ExperienciaProfissional getExperienciaProfissional(int id);
}
