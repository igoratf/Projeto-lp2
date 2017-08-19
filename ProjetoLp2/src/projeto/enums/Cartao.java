package projeto.enums;

/**
 * Enumerador de Cartões.
 * 
 * @author caiosbl
 */

public enum Cartao {
	NOOB("Noob"), CALOTEIRO("Caloteiro"), BOM_AMIGO("BomAmigo"), FREE_RIDER("FreeRyder");

	private final String valor;

	/**
	 * Construtor da classe.
	 * 
	 * @param valor
	 *            Valor do cartão.
	 */
	Cartao(String valor) {
		this.valor = valor;
	}

	/**
	 * Retorna o valor do cartão.
	 * 
	 * @return
	 */
	public String getValor() {
		return this.valor;
	}

}
