package projeto;

import projeto.cartao.BomAmigo;
import projeto.cartao.Caloteiro;
import projeto.cartao.FreeRyder;
import projeto.cartao.Noob;

public class Cartao {
	private TipoCartao cartaoReputacao;

	public Cartao() {
		this.cartaoReputacao = new FreeRyder();
	}

	public boolean emprestimoLiberado() {
		return cartaoReputacao.emprestimoLiberado();
	}

	public boolean validaPeriodo(int periodo) {
		return cartaoReputacao.validaPeriodo(periodo);
	}

	public void setTipo(String tipoCartao) {
		switch (tipoCartao) {
		case "Caloteiro":
			this.cartaoReputacao = new Caloteiro();
			break;
		case "BomAmigo":
			this.cartaoReputacao = new BomAmigo();
			break;
		case "Noob":
			this.cartaoReputacao = new Noob();
			break;
		case "FreeRyder":
			this.cartaoReputacao = new FreeRyder();
			break;
		default:
			throw new IllegalArgumentException("Tipo de cartão inválido");
		}
	}
	
	public String getTipo() {
		return this.cartaoReputacao.getTipo();
	}
}
