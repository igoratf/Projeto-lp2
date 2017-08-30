package projeto.cartao;

import projeto.Cartao;

/**
 * Cartão do tipo Caloteiro.
 * 
 * @author caiosbl
 * @version 1.0
 *
 */

public class Caloteiro implements Cartao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2785723660903700843L;

	/**
	 * Retorna se o cartão pode pegar um item emprestado.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean emprestimoLiberado() {
		return false;
	}

	/**
	 * Valida um período de empréstimo de acordo com o cartão.
	 * 
	 * @param periodo
	 *            Perído de emprestimo
	 * @return boolean
	 */
	@Override
	public boolean validaPeriodo(int periodo) {
		return false;
	}

	/**
	 * Retorna em String o tipo do Cartão.
	 * 
	 * @return
	 */
	@Override
	public String getTipo() {
		return "Caloteiro";
	}

}
