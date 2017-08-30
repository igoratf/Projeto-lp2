package projeto.comparadores;

import java.io.Serializable;
import java.util.Comparator;

import projeto.Item;

/**
 * Classe comparadora de Item por número de empréstimos
 * 
 * @author igoratf
 *
 */

public class ComparaItemNumEmprestimos implements Comparator<Item>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6002311180570234961L;

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
