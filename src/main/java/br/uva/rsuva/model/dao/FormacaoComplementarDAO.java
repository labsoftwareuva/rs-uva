package br.uva.rsuva.model.dao;

import java.util.List;

import br.uva.rsuva.model.entity.Candidato;
import br.uva.rsuva.model.entity.FormacaoComplementar;

public interface FormacaoComplementarDAO {
	public int incluir(FormacaoComplementar formacaoComplementar, Candidato candidato);

	public boolean alterar(FormacaoComplementar formacaoComplementar);

	public boolean excluir(FormacaoComplementar formacaoComplementar);
	
	public List<FormacaoComplementar> listar(int id);
	
	public FormacaoComplementar getFormacaoComplementar(int id);
}
