package projeto;

import java.util.HashSet;
import java.util.Set;

public class ControllerUsuario {
	private Set<Usuario> conjuntoUsuarios;

	public ControllerUsuario() {
		conjuntoUsuarios = new HashSet<>();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		Usuario usuario = new Usuario(nome, email, telefone);
		for (Usuario usuario2 : conjuntoUsuarios) {
			if (usuario2.getNome().equals(nome) && usuario2.getNumCelular().equals(telefone)) {
				throw new IllegalArgumentException("Usuario ja cadastrado");
			}
		}
		conjuntoUsuarios.add(usuario);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		validaParametrosGetInfoUsuario(nome, telefone, atributo);

		Usuario usuario = null;

		for (Usuario usuario3 : conjuntoUsuarios) {
			if (usuario3.getNome().equals(nome) && usuario3.getNumCelular().equals(telefone)) {
				usuario = usuario3;
			}
		}
		if (usuario == null) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		switch (atributo) {
		case "Email":
			return usuario.getEmail();
		case "Nome":
			return usuario.getNome();
		case "Telefone":
			return usuario.getNumCelular();

		default:
			throw new IllegalArgumentException("Atributo invalido");
		}
	}

	private void validaParametrosGetInfoUsuario(String nome, String telefone, String atributo) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo invalido!");
		} else if (telefone == null) {
			throw new NullPointerException("Telefone nulo invalido!");
		} else if (atributo == null) {
			throw new NullPointerException("Atributo nulo invalido!");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome vazio invalido!");
		} else if (telefone.trim().equals("")) {
			throw new IllegalArgumentException("Telefone vazio invalido!");
		} else if (atributo.trim().equals("")) {
			throw new IllegalArgumentException("Atributo vazio invalido!");
		}

	}

	private void validaParametrosRemoverUsuario(String nome, String telefone, String atributo, String valor) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo invalido!");
		} else if (telefone == null) {
			throw new NullPointerException("Telefone nulo invalido!");
		} else if (valor == null) {
			throw new NullPointerException("Valor nulo invalido!");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome vazio invalido!");
		} else if (telefone.trim().equals("")) {
			throw new IllegalArgumentException("Telefone vazio invalido!");
		} else if (valor.trim().equals("")) {
			throw new IllegalArgumentException("Valor vazio invalido!");
		} else if (atributo == null) {
			throw new NullPointerException("Atributo nulo invalido");
		}

	}

	public void removerUsuario(String nome, String telefone) {
		for (Usuario usuario : conjuntoUsuarios) {
			if (usuario.getNome().equals(nome) && usuario.getNumCelular().equals(telefone)) {
				conjuntoUsuarios.remove(usuario);
				return;
			}
		}
		throw new IllegalArgumentException("Usuario invalido");
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		validaParametrosRemoverUsuario(nome, telefone, atributo, valor);
		Usuario usuario = null;

		for (Usuario usuario2 : conjuntoUsuarios) {
			if (usuario2.getNome().equals(nome) && usuario2.getNumCelular().equals(telefone)) {
				usuario = usuario2;
			}
		}
		if (usuario == null) {
			throw new NullPointerException("Usuario invalido");
		}

		switch (atributo) {
		case "Nome":
			usuario.setNome(valor);
			break;
		case "Telefone":
			usuario.setNumCelular(valor);
			break;
		case "Email":
			usuario.setEmail(valor);
			break;

		default:
			throw new IllegalArgumentException("Atributo invalido");
		}

	}

}
