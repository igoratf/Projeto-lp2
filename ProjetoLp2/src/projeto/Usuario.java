package projeto;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import projeto.Jogo.*;
import projeto.bluray.*;


/**
 * Classe de Usuário.
 * 
 * @author caiosbl, igoratf
 * @version 2.0
 *
 */

public class Usuario {
	private String nome;
	private String email;
	private String numCelular;
	private Map<String, Item> mapaItens;


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
		Locale.setDefault(new Locale("en", "US"));
		this.nome = nome.trim();
		this.email = email.trim();
		this.numCelular = numCelular.trim();
		this.mapaItens = new HashMap<String, Item>();


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
	 * imo("João", "8345", "João", "8345", "Lucas", "8345", "Guerra",
	 * "10/08/2017") Altera o nome do Usuário.
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

	/**
	 * Altera o Email do Usuário.
	 * 
	 * @param email
	 *            Novo Email do Usuário.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna o número do celular do Usuário. imo("João", "8345", "João",
	 * "8345", "Lucas", "8345", "Guerra", "10/08/2017")
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
	 * Cadastra um novo Jogo Eletrônico na lista de itens do Usuario.
	 * 
	 * @param nomeItem
	 *            Nome do Jogo Eletrônico.
	 * @param preco
	 *            Preço do Jogo Eletrônico.
	 * @param plataforma
	 *            Plataforma do Jogo Eletrônico.
	 */
	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		ValidaParametros.validaPreco(preco);
		JogoEletronico jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		mapaItens.put(nomeItem, jogoEletronico);
	}

	/**
	 * Cadastra um novo Jogo de Tabuleiro na lista de itens do Usuario.
	 * 
	 * @param nomeItem
	 *            Nome do Jogo de Tabuleiro.
	 * @param preco
	 *            Preço do Jogo de Tabuleiro.
	 */
	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		ValidaParametros.validaPreco(preco);
		Item jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		mapaItens.put(nomeItem, jogoTabuleiro);
	}

	/**
	 * Cadastra um novo Bluray de Filme na lista de itens do Usuario.
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
		ValidaParametros.validaPreco(preco);
		Bluray blurayFilme = new BlurayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento);
		mapaItens.put(nomeItem, blurayFilme);
	}

	/**
	 * Adiciona uma peça perdida de um Jogo de Tabuleiro do Usuario.
	 * 
	 * @param nomeItem
	 *            Nome do Jogo de Tabuleiro.
	 * @param nomePeca
	 *            Nome da peça perdida.
	 */
	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		if (!mapaItens.containsKey(nomeItem)) {
			throw new IllegalArgumentException("Jogo Inválido!");
		}
		((JogoTabuleiro) mapaItens.get(nomeItem)).adicionarPecaPerdida(nomePeca);
	}

	/**
	 * Metodo para devolver item de um usuario.
	 * 
	 * @param nomeItem
	 *            Nome do item.
	 */
	/*
	 * public void devolverItem(String nomeItem) {
	 *
	 * Item meuItem = getItem(nomeItem); getItem(nomeItem);
	 * meuItem.setEstadoDeEmprestimo(false); }
	 */

	/**
	 * Cadastra um Bluray de um Show na lista de itens do Usuario.
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
		ValidaParametros.validaPreco(preco);
		Bluray blurayShow = new BlurayShow(nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
		mapaItens.put(nomeItem, blurayShow);
	}

	/**
	 * Cadastra um Bluray de Serie na lista de itens do Usuario
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
		ValidaParametros.validaPreco(preco);
		Bluray bluraySerie = new BluraySeries(nomeItem, preco, duracao, descricao, classificacao, genero, temporada);
		mapaItens.put(nomeItem, bluraySerie);
	}

	/**
	 * Adiciona um Bluray de Episódio a um Bluray de Serie à lista de itens do
	 * Usuario
	 * 
	 * @param serie
	 *            Nome da Serie.
	 * @param duracao
	 *            Duração do Episodio.
	 */
	public void adicionarBluray(String serie, int duracao) {
		if (!mapaItens.containsKey(serie)) {
			throw new IllegalArgumentException("Serie invalida!");
		}
		BlurayEpisodio blurayEpisodio = new BlurayEpisodio(duracao);
		((BluraySeries) mapaItens.get(serie)).adicionarBluray(blurayEpisodio);
	}

	/**
	 * Remove um item do Usuario.
	 * 
	 * @param nomeItem
	 *            Nome do Item a ser removido.
	 */
	public void removerItem(String nomeItem) {
		mapaItens.remove(nomeItem);
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
		Item meuItem = getItem(nomeItem);
		if (atributo.equalsIgnoreCase("preco")) {
			meuItem.setValor(Float.parseFloat(valor));
		}
		if (atributo.equalsIgnoreCase("nome")) {
			meuItem.setNome(valor);
		}
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
		Item meuItem = getItem(nomeItem);
		switch (atributo) {
		case "Preco":
			return String.valueOf(meuItem.getValor());
		case "Nome":
			return meuItem.getNome();
		default:
			throw new IllegalArgumentException("Atributo invalido");
		}
	}

	/**
	 * Metodo para realizar um emprestimo de um item do Usuario.
	 * 
	 * @param nomeItem
	 *            Nome do item.
	 */
	public void emprestarItem(String nomeItem) {
		Item meuItem = getItem(nomeItem);
		if (meuItem.getEstado().equals("Emprestado"))
			throw new IllegalArgumentException("Item emprestado no momento");
		else
			meuItem.setEstadoDeEmprestimo(true);
	}

	/**
	 * Cadastra um empréstimo na lista de empréstimos
	 * 
	 * @param emprestimo
	 */


	/**
	 * Exibe informações sobre um item
	 * 
	 * @param nomeItem
	 *            é o nome do item
	 * @return informações do item
	 */
	public String pesquisarDetalhesItem(String nomeItem) {
		Item meuItem = getItem(nomeItem);
		return meuItem.toString();
	}

	/**
	 * Metodo para retornar a lista de itens que o usuario possui. @return,
	 * lista de itens do usuario.
	 */
	public ArrayList<Item> getListaItens() {
		return new ArrayList<Item>(mapaItens.values());
	}

	/**
	 * Metodo para retornar um item baseado em seu nome pertencente a esse
	 * usuario.
	 * 
	 * @param nomeItem,
	 *            String passado por parametro. @return, retorna o item
	 *            desejado.
	 */
	public Item getItem(String nomeItem) {
		if (!mapaItens.containsKey(nomeItem)) {
			throw new RuntimeException("Item nao encontrado");
		}
		return mapaItens.get(nomeItem);

	}


	public Map getItens() {
		return mapaItens;
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
