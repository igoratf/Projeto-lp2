package projeto;

import java.util.ArrayList;

/**
 * Classe de Usuário.
 * 
 * @author CAIO SANCHES BATISTA DE LIRA - MATRICULA: 116210403
 * @version 1.0
 *
 */

public class Usuario {
	private String nome;
	private String email;
	private String numCelular;
	private ControllerItem controllerItem;

	/**
	 * Construtor da Classe Usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param email
	 *            Email do Usuário.
	 * @param numCelular
	 *            Número do celular do Usuário.
	 */
	public Usuario(String nome, String email, String numCelular) {
		ValidaParametros.validaParametrosUsuario(nome, email, numCelular);
		this.nome = nome.trim();
		this.email = email.trim();
		this.numCelular = numCelular.trim();
		this.controllerItem = new ControllerItem();

	}

	/**
	 * Retorna o nome do usuário.
	 * 
	 * @return nome Nome do Usuário.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do Usuário.
	 * 
	 * @param nome
	 *            Novo nome do Usuário.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o Email de um Usuário.
	 * 
	 * @return email Email do Usuário.
	 */
	public String getEmail() {
		return email;
	}

	/**try {
			Usuario usuario = new Usuario("Caio", null, "numCelular");
			fail("E
	 * Altera o Email do Usuário.
	 * 
	 * @param email
	 *            Novo Email do Usuário.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna o número do celular do Usuário.
	 * 
	 * @return numCelular Número do Celular do Usuário.
	 */
	public String getNumCelular() {
		return numCelular;
	}

	/**
	 * Altera o número do Celular de um usuário.
	 * 
	 * @param numCelular
	 *            Novo número de celular do Usuário.
	 */
	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	/**
	 * Cadastra um novo Jogo Eletrônico no Controller de Itens.
	 * 
	 * @param nomeItem
	 *            Nome do Jogo Eletrônico.
	 * @param preco
	 *            Preço do Jogo Eletrônico.
	 * @param plataforma
	 *            Plataforma do Jogo Eletrônico.
	 */
	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		controllerItem.cadastrarEletronico(nomeItem, preco, plataforma);
	}

	/**
	 * Cadastra um novo Jogo de Tabuleiro no Controller de Itens.
	 * 
	 * @param nomeItem
	 *            Nome do Jogo de Tabuleiro.
	 * @param preco
	 *            Preço do Jogo de Tabuleiro.
	 */
	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		controllerItem.cadastrarJogoTabuleiro(nomeItem, preco);
	}

	/**
	 * Cadastra um novo Bluray de Filme no Controller de Itens.
	 * 
	 * @param nomeItem
	 *            Nome do Bluray de filme.
	 * @param preco
	 *            Preço do Bluray de filme.
	 * @param duracao
	 *            Duração do Filme.
	 * @param genero
	 *            Gênero do Filme.
	 * @param classificacao
	 *            Classificação do Filme.
	 * @param anoLancamento
	 *            Ano de Lançamento do Filme.
	 */
	public void cadastrarBluRayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {
		controllerItem.cadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	/**
	 * Adiciona uma peça perdida de um Jogo de Tabuleiro no Controller de Itens.
	 * 
	 * @param nomeItem
	 *            Nome do Jogo de Tabuleiro.
	 * @param nomePeca
	 *            Nome da peça perdida.
	 */
	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		controllerItem.adicionarPecaPerdida(nomeItem, nomePeca);
	}

	/**
	 * Remove um item do Controller de Itens.
	 * 
	 * @param nomeItem
	 *            Nome do Item a ser removido.
	 */
	public void removerItem(String nomeItem) {
		controllerItem.removerItem(nomeItem);
	}

	/**
	 * Atualiza informações de um Item.
	 * 
	 * @param nomeItem
	 *            Nome do Item.
	 * @param atributo
	 *            Atributo a ser atualizado.
	 * @param valor
	 *            Novo valor do Atributo.
	 */
	public void atualizarItem(String nomeItem, String atributo, String valor) {
		controllerItem.atualizarItem(nomeItem, atributo, valor);
	}

	/**
	 * Retorna Informações de um Item.
	 * 
	 * @param nomeItem
	 *            Nome do Item.
	 * @param atributo
	 *            Atributo da Informação desejada.
	 * @return Informação.
	 */
	public String getInfoItem(String nomeItem, String atributo) {
		return controllerItem.getInfoItem(nomeItem, atributo);
	}

	/**
	 * Cadastra um Bluray de um Show em Controller de Itens.
	 * 
	 * @param nomeItem
	 *            Nome do Bluray de Show.
	 * @param preco
	 *            Preço do Bluray de Show.
	 * @param duracao
	 *            Duração do Show.
	 * @param numFaixas
	 *            Número de Faixas do Show.
	 * @param nomeArtista
	 *            Nome do Artista do Show.
	 * @param classificacao
	 *            Classificação do Show.
	 */
	public void cadastrarBlurayShow(String nomeItem, double preco, int duracao, int numFaixas, String nomeArtista,
			String classificacao) {
		controllerItem.cadastrarBlurayShow(nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);

	}

	/**
	 * Cadastra um Bluray de Serie em Controller de Itens.
	 * 
	 * @param nomeItem
	 *            Nome do Bluray de Serie.
	 * @param preco
	 *            Preço do Bluray de Serie.
	 * @param descricao
	 *            Descrição do Bluray de Serie.
	 * @param duracao
	 *            Duração da Serie.
	 * @param classificacao
	 *            Classificação da Serie.
	 * @param genero
	 *            Genero da Serie.
	 * @param temporada
	 *            Temporada da Serie.
	 */
	public void cadastrarBluraySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		controllerItem.cadastrarBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}

	/**
	 * Adiciona um Bluray de Episódio a um Bluray de Serie em Controller de
	 * Itens.
	 * 
	 * @param serie
	 *            Nome da Serie.
	 * @param duracao
	 *            Duração do Episodio.
	 */
	public void adicionarBluray(String serie, int duracao) {
		controllerItem.adicionarBluray(serie, duracao);
	}
	
	public String pesquisarDetalhesItem(String nomeItem) {
		return controllerItem.pesquisarDetalhesItem(nomeItem);
	}
	
	public ArrayList<Item> getListaItens(){
		return controllerItem.getListaItens();
	}

	/**
	 * Calcula o HashCode do Objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numCelular == null) ? 0 : numCelular.hashCode());
		return result;
	}

	/**
	 * Retorna a Igualdade do Objeto em relação a outro.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numCelular == null) {
			if (other.numCelular != null)
				return false;
		} else if (!numCelular.equals(other.numCelular))
			return false;
		return true;
	}

	/**
	 * Retorna a Representação em String do Objeto.
	 */
	@Override
	public String toString() {
		return String.format("%s , %s ,%s", nome, email, numCelular);
	}




}
