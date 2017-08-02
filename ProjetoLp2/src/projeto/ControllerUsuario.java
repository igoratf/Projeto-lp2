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
		boolean status = conjuntoUsuarios.add(usuario);
		if (!status) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		Usuario usuarioEsperado = new Usuario(nome, "email", telefone);

		if (!atributo.equals("Email")) {
			throw new IllegalArgumentException("Atributo Invalido");
		}
		for (Usuario usuario : conjuntoUsuarios) {
			if (usuario.equals(usuarioEsperado)) {
				return usuario.getEmail();
			}
		}

		throw new IllegalArgumentException("Usuário Invalido");
	}

}
