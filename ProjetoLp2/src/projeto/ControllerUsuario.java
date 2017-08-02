package projeto;

import java.util.HashSet;
import java.util.Set;

public class ControllerUsuario {
	private Set<Usuario> conjuntoUsuarios;

	public ControllerUsuario() {
		conjuntoUsuarios = new HashSet<Usuario>();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		Usuario usuario = new Usuario(nome, email, telefone);
		conjuntoUsuarios.add(usuario);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		Usuario usuarioEsperado = new Usuario(nome, "email", telefone);

		if (atributo.equals("Email")) {
			for (Usuario usuario : conjuntoUsuarios) {
				if (usuario.equals(usuarioEsperado)) {
					return usuario.getEmail();
				}

			}
		}
		return null;
	}
	
	

}
