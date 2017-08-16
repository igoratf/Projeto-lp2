package projeto;

import java.util.Comparator;
/**
 * Classe para comparar emprestimos.
 * 
 * @author lucasvsa
 *
 */

public class ComparaNomeEmprestimo implements Comparator<Emprestimo>{

	public int compare(Emprestimo o1, Emprestimo o2) {
			
		
	return o1.getDono().getNome().compareTo(o2.getDono().getNome());
	}
	
	

}
