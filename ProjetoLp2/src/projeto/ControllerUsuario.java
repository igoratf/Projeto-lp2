package projeto;

import java.util.HashMap;
import java.util.Map;

public class ControllerUsuario {
	private Map<NomeTelefone, Usuario> mapaUsuarios;

	public ControllerUsuario() {
		mapaUsuarios = new HashMap<NomeTelefone, Usuario>();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		NomeTelefone chave = new NomeTelefone(nome,telefone);
		if (mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
		Usuario usuario = new Usuario(nome, email, telefone);
		mapaUsuarios.put(chave, usuario);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {

		NomeTelefone chave = new NomeTelefone(nome,telefone);
		validaParametrosGetInfoUsuario(nome, telefone, atributo);

		if (!atributo.equals("Email")) {
			throw new IllegalArgumentException("Atributo Invalido");
		} else if (!mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return mapaUsuarios.get(chave).getEmail();

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
		String chave = nome + telefone;
		if (!mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		mapaUsuarios.remove(chave);
	}

	public String atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		NomeTelefone chave = new NomeTelefone(nome,telefone);
		validaParametrosRemoverUsuario(nome, telefone, atributo, valor);

		if (!mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}

		switch (atributo) {
		case "Nome":
			mapaUsuarios.get(chave).setNome(valor);
		case "Telefone":
			mapaUsuarios.get(chave).setNumCelular(valor);
		case "Email":
			mapaUsuarios.get(chave).setEmail(valor);

		default:
			throw new IllegalArgumentException("Atributo invalido");
		}

	}

}
