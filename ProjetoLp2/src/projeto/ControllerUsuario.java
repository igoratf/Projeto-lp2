package projeto;

import java.util.HashMap;
import java.util.Map;

public class ControllerUsuario {
	private Map<String, Usuario> mapaUsuarios;

	public ControllerUsuario() {
		mapaUsuarios = new HashMap<String, Usuario>();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		Usuario usuario = new Usuario(nome, email, telefone);
		String chave = nome + telefone;
		if (mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
		mapaUsuarios.put(chave, usuario);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {

		String chave = nome + telefone;
		validaParametros(nome, telefone, atributo);

		if (!atributo.equals("Email")) {
			throw new IllegalArgumentException("Atributo Invalido");
		} else if (!mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario nao cadastrado");
		}
		return mapaUsuarios.get(chave).getEmail();

	}

	private void validaParametros(String nome, String telefone, String atributo) {
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

}
