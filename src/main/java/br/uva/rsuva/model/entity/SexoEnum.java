package br.uva.rsuva.model.entity;

public enum SexoEnum {
	MASCULINO('m'),
	FEMININO('f');
	
	private final char sexo; 
	SexoEnum(char sexo){
		this.sexo = sexo;
	}
	
	public char getSigla(){
		return sexo;
	}
}
