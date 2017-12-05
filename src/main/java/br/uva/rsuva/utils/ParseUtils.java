package br.uva.rsuva.utils;

import br.uva.rsuva.model.entity.Beneficios;

public class ParseUtils {
	
	public static Beneficios buildBeneficios(String toString) {
		
		boolean valeTransporte = Boolean.parseBoolean(toString.split("-")[0]);
		boolean valeAlimentacao = Boolean.parseBoolean(toString.split("-")[1]);
		boolean valeRefeicao = Boolean.parseBoolean(toString.split("-")[2]);  
		boolean comissaoDeVendas = Boolean.parseBoolean(toString.split("-")[3]);  
		boolean auxilioCombustivel = Boolean.parseBoolean(toString.split("-")[4]); 
		boolean auxilioMoradia = Boolean.parseBoolean(toString.split("-")[5]); 
		boolean planoDeSaude = Boolean.parseBoolean(toString.split("-")[6]);
		
		return new Beneficios(
					valeTransporte, 
					valeAlimentacao, 
					valeRefeicao, 
					comissaoDeVendas, 
					auxilioCombustivel, 
					auxilioMoradia, 
					planoDeSaude
				);
	}

}
