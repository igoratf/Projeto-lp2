package projeto;

import java.util.Comparator;

public class ComparaItemValor implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {
		if (item2.getValor() > item1.getValor()) {
			return -1;
		} else if (item2.getValor() < item1.getValor()) {
			return 1;
		}
		return 0;
	}

}
