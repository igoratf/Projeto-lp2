package projeto;

import java.util.Comparator;

public class ComparaUsuarioReputacao implements Comparator<Usuario> {

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
