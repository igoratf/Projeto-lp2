package projeto;

import java.util.Map;

/**
 * Classe utilitária para validar Parâmetros.
 * 
 * @author caiosbl
 *
 */

public class ValidaParametros {
	/**
	 * Valida parâmetros para o método getInfoUsuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param atributo
	 *            Atributo a se obter informação.
	 */
	public static void validaParametrosGetInfoUsuario(String nome, String telefone, String atributo) {
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

	/**
	 * Valida parâmetros para o método removerUsuario.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param atributo
	 *            Atributo a se obter informação.
	 */
	public static void validaParametrosRemoverUsuario(String nome, String telefone, String atributo, String valor) {
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

	/**
	 * Valida Dados de um Usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 */
	public static void validaDados(String nome, String telefone) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo invalido");
		} else if (telefone == null) {
			throw new NullPointerException("Telefone nulo invalido");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome vazio invalido");
		} else if (telefone.trim().equals("")) {
			throw new IllegalArgumentException("Telefone vazio invalido");
		}
	}

	/**
	 * Valida Parâmetros para construção de um usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param email
	 *            Email do Usuário.
	 * @param numCelular
	 *            Número do Celular do Usuário.
	 */
	public static void validaParametrosUsuario(String nome, String email, String numCelular) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo invalido!");
		} else if (email == null) {
			throw new NullPointerException("Email nulo invalido!");
		} else if (numCelular == null) {
			throw new NullPointerException("Numero de Celular nulo invalido!");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome vazio invalido!");
		} else if (email.trim().equals("")) {
			throw new IllegalArgumentException("Email vazio invalido!");
		} else if (numCelular.trim().equals("")) {
			throw new IllegalArgumentException("Telefone vazio invalido!");
		}
	}

	public static void validaPreco(double preco) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
	}

	public static void validaItem(Map<String, Item> mapaItens, String nomeItem) {
		if (!(mapaItens.containsKey(nomeItem))) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
	}

	/**
	 * Valida os parâmetros da chave de um usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 */
	public static void validaChaveUsuario(String nome, String telefone) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo invalido!");
		} else if (telefone == null) {
			throw new NullPointerException("Telefone nulo invalido!");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome vazio invalido!");
		} else if (telefone.trim().equals("")) {
			throw new IllegalArgumentException("Telefone vazio invalido!");
		}

	}

}
