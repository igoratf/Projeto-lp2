package projeto;

import java.util.Comparator;

/**
 * Classe comparadora de Item por número de empréstimos
 * 
 * @author igoratf
 *
 */

public class ComparaItemNumEmprestimos implements Comparator<Item> {

	@Override
	/**
	 * Compara os itens de acordo com o que possui maior número de empréstimos
	 */
	public int compare(Item item1, Item item2) {
		if (item1.getNumEmprestimos() > item2.getNumEmprestimos()) {
			return -1;
		} else if (item1.getNumEmprestimos() < item2.getNumEmprestimos()) {
			return 1;
		} else {
			return 0;
		}
	}
}
