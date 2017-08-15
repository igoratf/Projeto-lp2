package projeto;

import java.util.Comparator;

public class OrdenaPorNome implements Comparator<Item>{

	@Override
	public int compare(Item item1, Item item2) {
		
		return item1.getNome().compareToIgnoreCase(item2.getNome());
	}
	
	
	

}
