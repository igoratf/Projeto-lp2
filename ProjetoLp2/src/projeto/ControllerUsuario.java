package projeto;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe Controladora de Usu�rios
 * 
 * @author CAIO SANCHES BATISTA DE LIRA - 116210403
 * @version 1.0
 *
 */

public class ControllerUsuario {
	private Map<ChaveUsuario, Usuario> mapaUsuarios;

	/**
	 * Construtor de Usu�rio.
	 */
	public ControllerUsuario() {
		this.mapaUsuarios = new HashMap<>();
	}

	/**
	 * Cadastra um usu�rio no Mapa de Usu�rios.
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
	 * @param email
	 *            Email do Usu�rio.
	 * @throws IllegalArgumentException
	 *             Caso o usu�rio j� esteja cadastrado.
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
	 * Retorna informa��es de um usu�rio.
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
	 * @param atributo
	 *            Atributo que se refere a informa��o desejada.
	 * @return Informa��o.
	 * @throws IllegalArgument
	 *             Caso o atributo seja inv�lido
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
	 * Remove um usu�rio do mapa de Usu�rios.
	 * 
	 * @param nome
	 *            Nome do usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
	 * @throws IllegalArgumentException
	 *             Caso os dados n�o remetam a um usu�rio v�lido.
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
	 * Atualiza informa��es de um Usu�rio.
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
	 * @param atributo
	 *            Atributo que ser� atulizado
	 * @param valor
	 *            Novo valor do Atributo.
	 * @throws IllegalArgumentException
	 *             Caso as informa��es do usu�rio n�o remetam a um usu�rio
	 *             v�lido.
	 * @throws IllegalArgumentException
	 *             Caso o Atributo informado seja inv�lido.
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
	 * Cadastra um Jogo Eletr�nico em um Usu�rio
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
	 * @param nomeItem
	 *            Nome do Jogo Eletr�nico.
	 * @param preco
	 *            Pre�o do Jogo Eletr�nico.
	 * 
	 * @param plataforma
	 *            Tipo da plataforma do Jogo Eletr�nico.
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {

		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).cadastrarEletronico(nomeItem, preco, plataforma);
	}

	/**
	 * Cadastra um jogo de Tabuleiro em um Usu�rio.
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
	 * @param nomeItem
	 *            Nome do Jogo de Tabuleiro.
	 * @param preco
	 *            Pre�o do Jogo de Tabuleiro.
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		checaSeUsuarioJaExiste(chave);
		mapaUsuarios.get(chave).cadastrarJogoTabuleiro(nomeItem, preco);
	}

	/**
	 * Cadastra um BluRay de Filme em um Usu�rio.
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
	 * @param nomeItem
	 *            Nome do BluRay de Filme.
	 * @param preco
	 *            Pre�od o BluRay de Filme.
	 * @param duracao
	 *            Dura��o do Filme.
	 * @param genero
	 *            G�nero do Filme.
	 * @param classificacao
	 *            Classifica��o do Filme.
	 * @param anoLancamento
	 *            Ano de Lan�amento de um filme.
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).cadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	/**
	 * Cadastra um BluRay de S�rie em um Usu�rio.
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
	 * @param nomeItem
	 *            Nome do BluRay de S�rie.
	 * @param preco
	 *            Pre�o do BluRay de S�rie.
	 * @param descricao
	 *            Decri��o do BluRay de S�rie.
	 * @param duracao
	 *            Dura��o do BluRay de S�rie.
	 * @param classificacao
	 *            Classifica��o do BluRay de S�rie.
	 * @param genero
	 *            G�nero do BluRau de S�rie.
	 * @param temporada
	 */
	public void cadastrarBluraySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).cadastrarBluraySerie(nomeItem, preco, descricao, duracao, classificacao, genero,
				temporada);
	}

	/**
	 * Adiciona uma pe�a perdida de um Jogo de Tabuleiro.
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
	 * @param nomeItem
	 *            Nome do Jogo de Tabuleiro.
	 * @param nomePeca
	 *            Nome da Pe�a.
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).adicionarPecaPerdida(nomeItem, nomePeca);
	}

	/**
	 * Remove um Item da Cole��o de Itens de um Usu�rio.
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
	 * @param nomeItem
	 *            Nome do Item a ser removido.
	 */
	public void removerItem(String nome, String telefone, String nomeItem) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		checaSeUsuarioJaExiste(chave);
		mapaUsuarios.get(chave).removerItem(nomeItem);
	}

	/**
	 * Atualiza informa��es de um Item
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
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
	 * Retorna informa��es de um item.
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
	 * @param nomeItem
	 *            Nome do Item.
	 * @param atributo
	 *            Atributo referente a informa��o desejada.
	 * @return Representa��o em String da Informa��o desejada.
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		return mapaUsuarios.get(chave).getInfoItem(nomeItem, atributo);

	}

	/**
	 * Cadastra um BluRay de um Show
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio
	 * @param nomeItem
	 *            Nome do BluRay de Show.
	 * @param preco
	 *            Pre�o do BluRau de Show.
	 * @param duracao
	 *            Dura��o do BluRay de Show.
	 * @param numFaixas
	 *            N�mero de Faixas do BluRay de Show.
	 * @param nomeArtista
	 *            Nome de Artista do BluRay de Show.
	 * @param classificacao
	 *            Classifica��o do BluRay de Show.
	 */
	public void cadastrarBlurayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numFaixas, String nomeArtista, String classificacao) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).cadastrarBlurayShow(nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
	}

	/**
	 * Adiciona um BluRay de um episodio a uma temporada de um s�rie.
	 * 
	 * @param nome
	 *            Nome do Usu�rio.
	 * @param telefone
	 *            Telefone do Usu�rio.
	 * @param nomeBlurayTemporada
	 *            Nome do BluRay de Temporada da S�rie.
	 * @param duracao
	 *            Dura��o do Epis�dio.
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		mapaUsuarios.get(chave).adicionarBluray(nomeBlurayTemporada, duracao);
	}

	/**
	 * Checa se uma chave est� contida no Mapa.
	 * 
	 * @param chave
	 * @throws IllegalArgumentException
	 *             Exce��o informando que o usu�rio n�o est� cadastrado.
	 */
	private void checaSeUsuarioJaExiste(ChaveUsuario chave) {
		if (!this.mapaUsuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

}
