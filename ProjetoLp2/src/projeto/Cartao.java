package projeto;

/**
 * Interface de um Cartão.
 * 
 * @author caiosbl
 * @version 1.0
 *
 */

public interface Cartao {

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
