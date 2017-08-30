package projeto.cartao;

import projeto.Cartao;

/**
 * Cartão do tipo Bom Amigo.
 * 
 * @author caiosbl
 * @version 1.0
 *
 */

public class BomAmigo implements Cartao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2240242013756870518L;

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
		if (periodo > 14) {
			return false;
		}
		return true;
	}

	/**
	 * Retorna em String o tipo do Cartão.
	 * @return
	 */
	@Override
	public String getTipo() {
		return "BomAmigo";
	}

}
