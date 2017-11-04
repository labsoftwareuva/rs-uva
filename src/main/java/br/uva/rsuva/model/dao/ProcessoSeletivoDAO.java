package br.uva.rsuva.model.dao;

import java.util.List;
import br.uva.rsuva.model.entity.ProcessoSeletivo;

/*
Renato Nascimento - 11/03
Implementando DAO ProcessoSeletivo
*/


public interface ProcessoSeletivoDAO {

	public int incluir(ProcessoSeletivo processoSeletivo);
	
	public boolean alterar(ProcessoSeletivo processoSeletivo);

	public boolean excluir(ProcessoSeletivo processoSeletivo);
	
	public List<ProcessoSeletivo> listar();
	
	public ProcessoSeletivo getProcessoSeletivo(int id);
}
