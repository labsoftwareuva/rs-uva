package br.uva.rsuva.model.entity;

public class Beneficios {

	private boolean valeTransporte;
	private boolean valeAlimentacao;
	private boolean valeRefeicao;
	private boolean comissaoDeVendas;
	private boolean auxilioCombustivel;
	private boolean auxilioMoradia;
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
