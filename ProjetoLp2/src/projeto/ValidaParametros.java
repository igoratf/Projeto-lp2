package projeto;

public class ValidaParametros {
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
	public static void validaParametrosUsuario(String nome,String email,String numCelular){
		if (nome == null) {
			throw new NullPointerException("Nome nulo invalido!");
		} else if (email == null) {
			throw new NullPointerException("Email nulo invalido!");
		} else if(numCelular == null) {
			throw new NullPointerException("Numero de Celular nulo invalido!");
		} else if(nome.trim().equals("")){
			throw new IllegalArgumentException("Nome vazio invalido!");
		} else if(email.trim().equals("")){
			throw new IllegalArgumentException("Email vazio invalido!");
		} else if(numCelular.trim().equals("")){
			throw new IllegalArgumentException("Telefone vazio invalido!");
		}
	}

}
