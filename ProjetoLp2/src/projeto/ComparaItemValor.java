package projeto;

import java.util.Comparator;

/**
 * Classe Comparadora de um Item por Valor
 * 
 * @author caiosbl
 *
 */

public class ComparaItemValor implements Comparator<Item> {

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
