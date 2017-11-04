package br.uva.rsuva.controller.rest;

import java.util.List;
import br.uva.rsuva.model.entity.ProcessoSeletivo;

/*
Renato Nascimento - 11/03
Implementando endpoint ProcessoSeletivo
*/

public interface ProcessoSeletivoEndPoint {
	
	public ProcessoSeletivo getProcessoSeletivo(int id);
	
	public List<ProcessoSeletivo> getProcessos();
	
	public int incluirProcessoSeletivo(ProcessoSeletivo processoSeletivo);
	
	public boolean alterarProcessoSeletivo (ProcessoSeletivo processoSeletivo);
	
	public boolean removerProcessoSeletivo (ProcessoSeletivo processoSeletivo);
	
}
