package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe Controladora de Usuários
 * 
 * @author CAIO SANCHES BATISTA DE LIRA - 116210403
 * @version 1.0
 *
 */

public class ControllerUsuario {
	private Map<ChaveUsuario, Usuario> mapaUsuarios;

	/**
	 * Construtor de Usuário.
	 */
	public ControllerUsuario() {
		this.mapaUsuarios = new HashMap<>();
	}

	/**
	 * Cadastra um usuário no Mapa de Usuários.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param email
	 *            Email do Usuário.
	 * @throws IllegalArgumentException
	 *             Caso o usuário já esteja cadastrado.
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
	 * Retorna informações de um usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param atributo
	 *            Atributo que se refere a informação desejada.
	 * @return Informação.
	 * @throws IllegalArgument
	 *             Caso o atributo seja inválido
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
	 * Remove um usuário do mapa de Usuários.
	 * 
	 * @param nome
	 *            Nome do usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @throws IllegalArgumentException
	 *             Caso os dados não remetam a um usuário válido.
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
	 * Atualiza informações de um Usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param atributo
	 *            Atributo que será atulizado
	 * @param valor
	 *            Novo valor do Atributo.
	 * @throws IllegalArgumentException
	 *             Caso as informações do usuário não remetam a um usuário
	 *             válido.
	 * @throws IllegalArgumentException
	 *             Caso o Atributo informado seja inválido.
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
	 * Cadastra um Jogo Eletrônico em um Usuário
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeItem
	 *            Nome do Jogo Eletrônico.
	 * @param preco
	 *            Preço do Jogo Eletrônico.
	 * 
	 * @param plataforma
	 *            Tipo da plataforma do Jogo Eletrônico.
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {

		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).cadastrarEletronico(nomeItem, preco, plataforma);
	}

	/**
	 * Cadastra um jogo de Tabuleiro em um Usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeItem
	 *            Nome do Jogo de Tabuleiro.
	 * @param preco
	 *            Preço do Jogo de Tabuleiro.
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		checaSeUsuarioJaExiste(chave);
		mapaUsuarios.get(chave).cadastrarJogoTabuleiro(nomeItem, preco);
	}

	/**
	 * Cadastra um BluRay de Filme em um Usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeItem
	 *            Nome do BluRay de Filme.
	 * @param preco
	 *            Preçod o BluRay de Filme.
	 * @param duracao
	 *            Duração do Filme.
	 * @param genero
	 *            Gênero do Filme.
	 * @param classificacao
	 *            Classificação do Filme.
	 * @param anoLancamento
	 *            Ano de Lançamento de um filme.
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).cadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	/**
	 * Cadastra um BluRay de Série em um Usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeItem
	 *            Nome do BluRay de Série.
	 * @param preco
	 *            Preço do BluRay de Série.
	 * @param descricao
	 *            Decrição do BluRay de Série.
	 * @param duracao
	 *            Duração do BluRay de Série.
	 * @param classificacao
	 *            Classificação do BluRay de Série.
	 * @param genero
	 *            Gênero do BluRau de Série.
	 * @param temporada
	 */
	public void cadastrarBluraySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).cadastrarBluraySerie(nomeItem, preco, descricao, duracao, classificacao, genero,
				temporada);
	}

	/**
	 * Adiciona uma peça perdida de um Jogo de Tabuleiro.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeItem
	 *            Nome do Jogo de Tabuleiro.
	 * @param nomePeca
	 *            Nome da Peça.
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).adicionarPecaPerdida(nomeItem, nomePeca);
	}

	/**
	 * Remove um Item da Coleção de Itens de um Usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeItem
	 *            Nome do Item a ser removido.
	 */
	public void removerItem(String nome, String telefone, String nomeItem) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		checaSeUsuarioJaExiste(chave);
		mapaUsuarios.get(chave).removerItem(nomeItem);
	}

	/**
	 * Atualiza informações de um Item
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeItem
	 *            Nome do Item.
	 * @param atributo
	 *            Atributo a ser Atualizado.
	 * @param valor
	 *            Novo valor do Atributo atualizado.
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		checaSeUsuarioJaExiste(chave);
		mapaUsuarios.get(chave).atualizarItem(nomeItem, atributo, valor);
	}

	/**
	 * Retorna informações de um item.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeItem
	 *            Nome do Item.
	 * @param atributo
	 *            Atributo referente a informação desejada.
	 * @return Representação em String da Informação desejada.
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		return mapaUsuarios.get(chave).getInfoItem(nomeItem, atributo);

	}

	/**
	 * Cadastra um BluRay de um Show
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário
	 * @param nomeItem
	 *            Nome do BluRay de Show.
	 * @param preco
	 *            Preço do BluRau de Show.
	 * @param duracao
	 *            Duração do BluRay de Show.
	 * @param numFaixas
	 *            Número de Faixas do BluRay de Show.
	 * @param nomeArtista
	 *            Nome de Artista do BluRay de Show.
	 * @param classificacao
	 *            Classificação do BluRay de Show.
	 */
	public void cadastrarBlurayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numFaixas, String nomeArtista, String classificacao) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).cadastrarBlurayShow(nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
	}

	/**
	 * Adiciona um BluRay de um episodio a uma temporada de um série.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 * @param nomeBlurayTemporada
	 *            Nome do BluRay de Temporada da Série.
	 * @param duracao
	 *            Duração do Episódio.
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).adicionarBluray(nomeBlurayTemporada, duracao);
	}

	public String listarItensOrdenadosPorNome() {
		String itens = "";
		ArrayList<Item> itensSistema = new ArrayList<>();
		for (ChaveUsuario chave : mapaUsuarios.keySet()) {
			ArrayList<Item> itensUsuario = mapaUsuarios.get(chave).getListaItens();
			for (Item item : itensUsuario) {
				itensSistema.add(item);
			}
		}
		Collections.sort(itensSistema);

		for (Item item : itensSistema) {
			itens += item.toString();
		}
		return itens;
	}

	public String listarItensOrdenadosPorValor() {
		String itens = "";
		ArrayList<Item> itensSistema = new ArrayList<>();
		for (ChaveUsuario chave : mapaUsuarios.keySet()) {
			ArrayList<Item> itensUsuario = mapaUsuarios.get(chave).getListaItens();
			for (Item item : itensUsuario) {
				itensSistema.add(item);
			}
		}
		itensSistema.sort(new ComparaItemValor());

		for (Item item : itensSistema) {
			itens += item.toString();
		}
		return itens;
	}

	/**
	 * Checa se uma chave está contida no Mapa.
	 * 
	 * @param chave
	 * @throws IllegalArgumentException
	 *             Exceção informando que o usuário não está cadastrado.
	 */
	private void checaSeUsuarioJaExiste(ChaveUsuario chave) {
		if (!this.mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

}
