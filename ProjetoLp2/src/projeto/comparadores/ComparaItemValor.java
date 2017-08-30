package projeto.comparadores;

import java.io.Serializable;
import java.util.Comparator;

import projeto.Item;

/**
 * Classe Comparadora de um Item por Valor
 * 
 * @author caiosbl
 *
 */

public class ComparaItemValor implements Comparator<Item>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6779657597861156898L;

	@Override
	/**
	 * Compara um item por que tiver maior valor.
	 */
	public int compare(Item item1, Item item2) {
		if (item2.getValor() > item1.getValor()) {
			return -1;
		} else if (item2.getValor() < item1.getValor()) {
			return 1;
		}
		return 0;
	}

}
