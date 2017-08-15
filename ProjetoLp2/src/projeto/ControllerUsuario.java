package projeto;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import projeto.Jogo.JogoTabuleiro;
import projeto.bluray.BluraySeries;

/**
 * Classe Controladora de Usuarios
 * 
 * @author caiosbl
 * @version 1.0
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

		if (!mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		switch (atributo) {
		case "Email":
			return mapaUsuarios.get(chave).getEmail();
		case "Nome":
			return mapaUsuarios.get(chave).getNome();
		case "Telefone":
			return mapaUsuarios.get(chave).getNumCelular();

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
	 * Cadastra um Jogo Eletronico em um Usuario
	 * 
	 * @param nome
	 *            Nome do Usuario.
	 * @param telefone
	 *            Telefone do Usuario.
	 * @param nomeItem
	 *            Nome do Jogo Eletronico.
	 * @param preco
	 *            Preco do Jogo Eletronico.
	 * 
	 * @param plataforma
	 *            Tipo da plataforma do Jogo Eletronico.
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {

		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).cadastrarEletronico(nomeItem, preco, plataforma);
	}

	/**
	 * Adiciona uma peca perdida de um Jogo de Tabuleiroo> emprestimos =
	 * mapaUsuarios.get(chave).getEmprestimosFeitos();
	 * 
	 * @param nome
	 *            Nome do Usuario.
	 * @param telefone
	 *            Telefone do Usuario.
	 * @param nomeItem
	 *            Nome do Jogo de Tabuleiro.
	 * @param nomePeca
	 *            Nome da Peca.
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).adicionarPecaPerdida(nomeItem, nomePeca);
	}

	/**
	 * Atualiza informacoes de um Item
	 * 
	 * @param nome
	 *            Nome do Usuario.
	 * @param telefone
	 *            Telefone do Usuario.
	 * @param nomeItem
	 *            Nome do Item.
	 * @param atributo
	 *            Atributo a ser Atualizado.
	 * @param valor
	 *            Novo valor do Atributo atualizado.
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		checaSeUsuarioJaExiste(nome, telefone);
		mapaUsuarios.get(chave).atualizarItem(nomeItem, atributo, valor);
	}

	/**
	 * Retorna informacoes de um item.
	 * 
	 * @param nome
	 *            Nome do Usuario.
	 * @param telefone
	 *            Telefone do Usuario.
	 * @param nomeItem
	 *            Nome do Item.
	 * @param atributo
	 *            Atributo referente a informacao desejada.
	 * @return Representacao em String da Informacao desejada.
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		return mapaUsuarios.get(chave).getInfoItem(nomeItem, atributo);

	}

	/**
	 * Pesquisa detalhes de um Item
	 * 
	 * @param nome
	 *            Nome do usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeItem
	 *            Nome do Item a ser Pesquisado.
	 * @return Detalhes do Item.
	 */
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		checaSeUsuarioJaExiste(nome, telefone);
		return mapaUsuarios.get(chave).pesquisarDetalhesItem(nomeItem);
	}

	private ArrayList<Item> itensSistema() {
		ArrayList<Item> itensSistema = new ArrayList<>();
		for (ChaveUsuario chave : mapaUsuarios.keySet()) {
			ArrayList<Item> itensUsuario = mapaUsuarios.get(chave).getListaItens();
			for (Item item : itensUsuario) {
				itensSistema.add(item);
			}
		}
		return itensSistema;
	}

	/**
	 * Retorna em String os Itens do Sistema ordenados por Nome.
	 * 
	 * @return String listaItensOrdenadosNome
	 */
	public String listarItensOrdenadosPorNome() {
		String itens = "";
		ArrayList<Item> itensSistema = itensSistema();
		Collections.sort(itensSistema);
		for (Item item : itensSistema) {
			itens += item.toString() + "|";
		}
		return itens;
	}

	/**
	 * Retorna em String os Itens do Sistema ordenados por Valor.
	 * 
	 * @return String listaItensOrdenadosValor
	 */
	public String listarItensOrdenadosPorValor() {
		String itens = "";
		ArrayList<Item> itensSistema = itensSistema();
		itensSistema.sort(new ComparaItemValor());
		for (Item item : itensSistema) {
			itens += item.toString() + "|";
		}
		return itens;
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
	 * Valida a presença de um Item em um Usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeItem
	 *            Nome do Item.
	 */
	public void validaItemUsuario(String nome, String telefone, String nomeItem) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).getItem(nomeItem);
	}

	/**
	 * Retorna se o jogo está completo ou não.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeItem
	 *            Nome do Item.
	 * @return String estado do Jogo de Tabuleiro.
	 */
	public String haPecasPerdidasItem(String nome, String telefone, String nomeItem) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		return ((JogoTabuleiro) mapaUsuarios.get(chave).getItem(nomeItem)).existePecasPerdidas();
	}

	/**
	 * Retorna um valor booleano que indica se há algum episódio cadastrado
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeItem
	 *            Nome do Item.
	 * @return valor Booleano.
	 */
	public boolean haEpisodiosBluRaySeries(String nome, String telefone, String nomeItem) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		return ((BluraySeries) mapaUsuarios.get(chave).getItem(nomeItem)).contemEpisodio();
	}

	public Usuario getUsuario(String nome, String telefone) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		if (mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuário inválido");
		}
		return mapaUsuarios.get(chave);
	}

	public Map getItensUsuario(String nome, String telefone) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		return mapaUsuarios.get(chave).getItens();
	}

}
