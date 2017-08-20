package projeto;

import java.util.Comparator;

/**
 * Classe Comparadora de Usuario por Reputação ordenando da menor para melhor.
 * 
 * @author caiosbl
 * @version 2.0
 *
 */

public class ComparaUsuarioReputacaoMenorMelhor implements Comparator<Usuario> {
	/**
	 * Compara dois usuários retorna positivo para o segundo usuário
	 * menor que o primeiro.
	 */
	@Override
	public int compare(Usuario usr1, Usuario usr2) {
		if (usr1.getReputacao() > usr2.getReputacao()) {
			return 1;
		} else if (usr1.getReputacao() == usr2.getReputacao()) {
			return 0;
		}
		return -1;
	}

}
