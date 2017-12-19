package br.uva.rsuva.model.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Beneficios {

	@XmlElement
	private boolean valeTransporte;
	
	@XmlElement
	private boolean valeAlimentacao;
	
	@XmlElement
	private boolean valeRefeicao;
	
	@XmlElement
	private boolean comissaoDeVendas;
	
	@XmlElement
	private boolean auxilioCombustivel;
	
	@XmlElement
	private boolean auxilioMoradia;
	
	@XmlElement
	private boolean planoDeSaude;

	public Beneficios() {
		// TODO Auto-generated constructor stub
	}

	public Beneficios(boolean valeTransporte, boolean valeAlimentacao, boolean valeRefeicao, boolean comissaoDeVendas,
			boolean auxilioCombustivel, boolean auxilioMoradia, boolean planoDeSaude) {
		super();
		this.valeTransporte = valeTransporte;
		this.valeAlimentacao = valeAlimentacao;
		this.valeRefeicao = valeRefeicao;
		this.comissaoDeVendas = comissaoDeVendas;
		this.auxilioCombustivel = auxilioCombustivel;
		this.auxilioMoradia = auxilioMoradia;
		this.planoDeSaude = planoDeSaude;
	}

	public boolean isValeTransporte() {
		return valeTransporte;
	}

	public void setValeTransporte(boolean valeTransporte) {
		this.valeTransporte = valeTransporte;
	}

	public boolean isValeAlimentacao() {
		return valeAlimentacao;
	}

	public void setValeAlimentacao(boolean valeAlimentacao) {
		this.valeAlimentacao = valeAlimentacao;
	}

	public boolean isValeRefeicao() {
		return valeRefeicao;
	}

	public void setValeRefeicao(boolean valeRefeicao) {
		this.valeRefeicao = valeRefeicao;
	}

	public boolean isComissaoDeVendas() {
		return comissaoDeVendas;
	}

	public void setComissaoDeVendas(boolean comissaoDeVendas) {
		this.comissaoDeVendas = comissaoDeVendas;
	}

	public boolean isAuxilioCombustivel() {
		return auxilioCombustivel;
	}

	public void setAuxilioCombustivel(boolean auxilioCombustivel) {
		this.auxilioCombustivel = auxilioCombustivel;
	}

	public boolean isAuxilioMoradia() {
		return auxilioMoradia;
	}

	public void setAuxilioMoradia(boolean auxilioMoradia) {
		this.auxilioMoradia = auxilioMoradia;
	}

	public boolean isPlanoDeSaude() {
		return planoDeSaude;
	}

	public void setPlanoDeSaude(boolean planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}

	@Override
	public String toString() {
		return valeTransporte + "-" + valeAlimentacao + "-" + valeRefeicao + "-" + comissaoDeVendas + "-"
				+ auxilioCombustivel + "-" + auxilioMoradia + "-" + planoDeSaude;
	}

}
