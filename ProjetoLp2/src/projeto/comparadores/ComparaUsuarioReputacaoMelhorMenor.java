package projeto.comparadores;

import java.util.Comparator;

import projeto.Usuario;

/**
 * Classe Comparadora de Usuario por Reputação ordenando da melhor para menor.
 * 
 * @author caiosbl
 * @version 2.0
 *
 */

public class ComparaUsuarioReputacaoMelhorMenor implements Comparator<Usuario> {

	/**
	 * Compara dois usuários retorna positivo para o segundo usuário maior que o
	 * primeiro.
	 */
	@Override
	public int compare(Usuario usr1, Usuario usr2) {
		if (usr1.getReputacao() > usr2.getReputacao()) {
			return -1;
		} else if (usr1.getReputacao() == usr2.getReputacao()) {
			return 0;
		}
		return 1;
	}

}
