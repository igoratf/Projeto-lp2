package projeto;

import java.io.Serializable;

/**
 * Interface de um Cartão.
 * 
 * @author caiosbl
 * @version 1.0
 *
 */

public interface Cartao extends Serializable {

	/**
	 * Retorna se o cartão pode pegar um item emprestado.
	 * 
	 * @return boolean
	 */
	public boolean emprestimoLiberado();

	/**
	 * Valida um período de empréstimo de acordo com o cartão.
	 * 
	 * @param periodo
	 *            Perído de emprestimo
	 * @return boolean
	 */
	public boolean validaPeriodo(int periodo);
	
	/**
	 * Retorna em String o tipo do Cartão.
	 * @return
	 */
	public String getTipo();

}
