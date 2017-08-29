package projeto.cartao;

import projeto.TipoCartao;

/**
 * Cartão do tipo Free Ryder.
 * 
 * @author caiosbl
 * @version 1.0
 *
 */

public class FreeRyder implements TipoCartao {

	/**
	 * Retorna se o cartão pode pegar um item emprestado.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean emprestimoLiberado() {
		return true;
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
		if (periodo > 5) {
			return false;
		}
		return true;
	}

	/**
	 * Retorna em String o tipo do Cartão.
	 * 
	 * @return
	 */
	@Override
	public String getTipo() {
		return "FreeRyder";
	}

}
