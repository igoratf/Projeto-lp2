package projeto.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import projeto.Item;
import projeto.Usuario;
import projeto.comparadores.ComparaUsuarioReputacaoMelhorMenor;
import projeto.comparadores.ComparaUsuarioReputacaoMenorMelhor;
import projeto.utilitarios.ChaveUsuario;
import projeto.utilitarios.ValidaParametros;

/**
 * Classe Controladora de Usuarios
 * 
 * @author caiosbl
 * @version 2.0
 *
 */

public class ControllerUsuario {
	private Map<ChaveUsuario, Usuario> mapaUsuarios;

	/**
	 * Construtor de Usuario.
	 */
	public ControllerUsuario() {
		this.mapaUsuarios = new HashMap<>();
	}

	/**
	 * Cadastra um usuario no Mapa de Usuarios.
	 * 
	 * @param nome
	 *            Nome do Usuario.
	 * @param telefone
	 *            Telefone do Usuario.
	 * @param email
	 *            Email do Usuario.
	 * @throws IllegalArgumentException
	 *             Caso o usuario ja esteja cadastrado.
	 */
	public void cadastrarUsuario(String nome, String telefone, String email) {
		Usuario usuario = new Usuario(nome, email, telefone);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);

		if (mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
		mapaUsuarios.put(chave, usuario);
	}

	/**
	 * Retorna informacoes de um usuario.
	 * 
	 * @param nome
	 *            Nome do Usuario.
	 * @param telefone
	 *            Telefone do Usuario.
	 * @param atributo
	 *            Atributo que se refere a informacao desejada.
	 * @return Informacao.
	 * @throws IllegalArgument
	 *             Caso o atributo seja invalido
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		ValidaParametros.validaParametrosGetInfoUsuario(nome, telefone, atributo);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		checaSeUsuarioJaExiste(nome, telefone);

		Usuario usuario = mapaUsuarios.get(chave);

		switch (atributo) {
		case "Email":
			return usuario.getEmail();
		case "Nome":
			return usuario.getNome();
		case "Telefone":
			return usuario.getNumCelular();
		case "Reputacao":
			return String.valueOf(usuario.getReputacao());
		case "Cartao":
			return usuario.getCartao();

		default:
			throw new IllegalArgumentException("Atributo invalido");
		}
	}

	/**
	 * Remove um usuario do mapa de Usuarios.
	 * 
	 * @param nome
	 *            Nome do usuario.
	 * @param telefone
	 *            Telefone do Usuario.
	 * @throws IllegalArgumentException
	 *             Caso os dados nao remetam a um usuario valido.
	 */
	public void removerUsuario(String nome, String telefone) {
		ValidaParametros.validaDados(nome, telefone);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);

		if (!mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		mapaUsuarios.remove(chave);
	}

	/**
	 * Atualiza informacoes de um Usuario.
	 * 
	 * @param nome
	 *            Nome do Usuario.
	 * @param telefone
	 *            Telefone do Usuario.
	 * @param atributo
	 *            Atributo que sera atulizado
	 * @param valor
	 *            Novo valor do Atributo.
	 * @throws IllegalArgumentException
	 *             Caso as informacoes do usuario nao remetam a um usuario
	 *             valido.
	 * @throws IllegalArgumentException
	 *             Caso o Atributo informado seja invalido.
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		ValidaParametros.validaParametrosRemoverUsuario(nome, telefone, atributo, valor);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		if (!mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}

		switch (atributo) {
		case "Nome":
			mapaUsuarios.get(chave).setNome(valor);
			Usuario usuarioTemporario = mapaUsuarios.get(chave);
			mapaUsuarios.remove(chave);
			chave.setNome(valor);
			mapaUsuarios.put(chave, usuarioTemporario);
			break;
		case "Telefone":
			mapaUsuarios.get(chave).setNumCelular(valor);
			usuarioTemporario = mapaUsuarios.get(chave);
			mapaUsuarios.remove(chave);
			chave.setTelefone(valor);
			mapaUsuarios.put(chave, usuarioTemporario);
			break;
		case "Email":
			mapaUsuarios.get(chave).setEmail(valor);
			break;

		default:
			throw new IllegalArgumentException("Atributo invalido");
		}

	}

	/**
	 * Checa se uma chave esta contida no Mapa.
	 * 
	 * @param chave
	 * @throws IllegalArgumentException
	 *             Excecao informando que o usuario nao esta cadastrado.
	 */
	public boolean checaSeUsuarioJaExiste(String nome, String telefone) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		if (!this.mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return true;
	}

	/**
	 * Retorna um Usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @return Usuário.
	 */
	public Usuario getUsuario(String nome, String telefone) {
		checaSeUsuarioJaExiste(nome, telefone);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		return mapaUsuarios.get(chave);
	}

	/**
	 * Retorna o mapa de itens de um Usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @return Mapa de Itens.
	 */
	public Map<String, Item> getItensUsuario(String nome, String telefone) {
		checaSeUsuarioJaExiste(nome, telefone);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		return mapaUsuarios.get(chave).getItens();
	}

	/**
	 * Retorna uma lista com os itens de todos os usuários.
	 * 
	 * @return itensUsuarios
	 */
	public List<Item> getItensUsuarios() {
		ArrayList<Item> itensUsuarios = new ArrayList<>();
		for (Usuario usuario : mapaUsuarios.values()) {
			ArrayList<Item> itensUsuario = new ArrayList<>(usuario.getItens().values());
			for (Item item : itensUsuario) {
				itensUsuarios.add(item);
			}
		}
		return itensUsuarios;
	}

	/**
	 * Adiciona ao atributo reputação de um Usuário a porcentagem de 5%
	 * referente ao valor do item adicionado.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param valorItem
	 *            Valor do Item.
	 */
	public void addReputacaoItemAdicionado(String nome, String telefone, double valorItem) {
		checaSeUsuarioJaExiste(nome, telefone);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).addReputacaoItemAdicionado(valorItem);
	}

	/**
	 * Adiciona ao atributo reputação de um Usuário a porcentagem de 10%
	 * referente ao valor do item emprestado.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param valorItem
	 *            Valor do Item.
	 */
	public void addReputacaoItemEmprestado(String nome, String telefone, double valorItem) {
		checaSeUsuarioJaExiste(nome, telefone);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		Usuario usuario = this.mapaUsuarios.get(chave);
		usuario.addReputacaoItemEmprestado(valorItem);
	}

	/**
	 * Adiciona ao atributo reputação do Usuário a porcentagem de 5% referente
	 * ao valor do Item devolvido.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param valorItem
	 *            Valor do item devolvido.
	 */
	public void addReputacaoItemDevolvidoNoPrazo(String nome, String telefone, double valorItem) {
		checaSeUsuarioJaExiste(nome, telefone);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).addReputacaoItemDevolvidoNoPrazo(valorItem);
	}

	/**
	 * Decrementa o atributo reputação do Usuário o valor calculado referente a
	 * porcentagem de 1% vezes o número de dias em atraso da devolução vezes o
	 * valor do Item devolvido.
	 * 
	 * @param valorItem
	 *            Valor do Item devolvido.
	 * @param diasAtraso
	 *            Dias em Atraso da devolução.
	 */
	public void addReputacaoItemDevolvidoAtrasado(String nome, String telefone, double valorItem, int diasAtraso) {
		checaSeUsuarioJaExiste(nome, telefone);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).addReputacaoItemDevolvidoAtrasado(valorItem, diasAtraso);
	}

	/**
	 * Atualiza o Cartão de um Usuário.
	 * 
	 * @param nome
	 *            Nome do usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 */
	public void atualizaCartaoUsuario(String nome, String telefone) {
		checaSeUsuarioJaExiste(nome, telefone);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).atualizaCartao();
	}

	/**
	 * Retorna o valor booleano que indica se o usuário pode pegar um item
	 * emprestado.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @return valor Booleano.
	 */
	public boolean podePegarItemEmprestado(String nome, String telefone) {
		checaSeUsuarioJaExiste(nome, telefone);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		Usuario usuario = mapaUsuarios.get(chave);

		if (usuario.getCartao().equals("Caloteiro")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Retorna um valor booleano se o período de empréstimo requerido é valido
	 * para o atual cartão do Usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param periodo
	 *            Período de Empréstimo.
	 * @return boolean
	 */
	public boolean validaPeriodoEmprestimo(String nome, String telefone, int periodo) {
		checaSeUsuarioJaExiste(nome, telefone);
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);

		Usuario usuario = mapaUsuarios.get(chave);
		String cartao = usuario.getCartao();

		if (periodo > 14) {
			return false;
		} else if (cartao.equals("Noob") && periodo > 7) {
			return false;
		} else if (cartao.equals("FreeRyder") && periodo > 5) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Lista os usuários com reputação negativa.
	 * 
	 * @return lista de caloteiros
	 */
	public String listarCaloteiros() {
		String listagem = "Lista de usuarios com reputacao negativa: ";
		ArrayList<Usuario> listaCaloteiros = new ArrayList<>();
		for (Usuario usuario : mapaUsuarios.values()) {
			if (usuario.getReputacao() < 0) {
				listaCaloteiros.add(usuario);
			}
		}
		Collections.sort(listaCaloteiros);
		for (Usuario usuario : listaCaloteiros) {
			listagem += usuario.toString() + "|";
		}

		return listagem;
	}

	/**
	 * Lista os usuários com melhores reputações.
	 * 
	 * @return listagem
	 * @throws IndexOutOfBoundsException
	 * Lança a exceção se tiver menos que 10 usuários cadastrados no mapaUsuarios
	 */
	public String listarTop10MelhoresUsuarios() {
		if(mapaUsuarios.size() < 10){
			throw new IndexOutOfBoundsException("Menos de 10 usuários cadastrados!");
		}
		String listagem = "";
		Locale.setDefault(new Locale("pt", "BR"));
		ArrayList<Usuario> listaTop10Usuarios = new ArrayList<>(mapaUsuarios.values());
		listaTop10Usuarios.sort(new ComparaUsuarioReputacaoMelhorMenor());

		for (int i = 0; i < 10; i++) {
			Usuario usuario = listaTop10Usuarios.get(i);
			listagem += String.format("%d: %s - Reputacao: %.2f|", i + 1, usuario.getNome(), usuario.getReputacao());
		}
		return listagem;

	}

	/**
	 * Lista os 10 piores Usuários.
	 * 
	 * @return listagem
	 * @throws IndexOutOfBoundsException
	 * Lança a exceção se tiver menos que 10 usuários cadastrados no mapaUsuarios
	 */
	public String listarTop10PioresUsuarios() {
		if(mapaUsuarios.size() < 10){
			throw new IndexOutOfBoundsException("Menos de 10 usuários cadastrados!");
		}
		String listagem = "";
		Locale.setDefault(new Locale("pt", "BR"));
		ArrayList<Usuario> listaTop10PioresUsuarios = new ArrayList<>(mapaUsuarios.values());
		listaTop10PioresUsuarios.sort(new ComparaUsuarioReputacaoMenorMelhor());

		for (int i = 0; i < 10; i++) {
			Usuario usuario = listaTop10PioresUsuarios.get(i);
			listagem += String.format("%d: %s - Reputacao: %.2f|", i + 1, usuario.getNome(), usuario.getReputacao());
		}

		return listagem;
	}

}
