package projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Classe de Usuário.
 * 
 * @author CAIO SANCHES BATISTA DE LIRA - MATRICULA: 116210403, igoratf
 * @version 2.0
 *
 */

public class Usuario {
	private String nome;
	private String email;
	private String numCelular;
	private List<Item> listaItens;
	private List<Emprestimo> emprestimos;

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
		this.listaItens = new ArrayList<Item>();
		this.emprestimos = new ArrayList<>();

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
		validaPreco(preco);
		Item jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		listaItens.add(jogoEletronico);
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
		validaPreco(preco);
		Item jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		listaItens.add(jogoTabuleiro);
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
		validaPreco(preco);
		Bluray blurayFilme = new BlurayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento);
		listaItens.add(blurayFilme);
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
		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem)) {
				((JogoTabuleiro) item).adicionarPecaPerdida(nomePeca);
			}
		}
	}

	/**
	 * Metodo para devolver item de um usuario.
	 * 
	 * @param nomeItem
	 *            Nome do item.
	 */
	public void devolverItem(String nomeItem) {
		Item meuItem = getItem(nomeItem);
		validaItem(nomeItem);
		meuItem.setEstadoDeEmprestimo(false);
	}

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
		validaPreco(preco);
		Bluray blurayShow = new BlurayShow(nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
		listaItens.add(blurayShow);
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
		validaPreco(preco);
		Bluray bluraySerie = new BluraySeries(nomeItem, preco, duracao, descricao, classificacao, genero, temporada);
		listaItens.add(bluraySerie);
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
		BlurayEpisodio blurayEpisodio = new BlurayEpisodio(duracao);
		for (Item item : listaItens) {
			if (item.getNome().equals(serie)) {
				((BluraySeries) item).adicionarBluray(blurayEpisodio);
			}
		}
	}

	/**
	 * Remove um item do Usuario.
	 * 
	 * @param nomeItem
	 *            Nome do Item a ser removido.
	 */
	public void removerItem(String nomeItem) {
		validaItem(nomeItem);
		Item meuItem = getItem(nomeItem);
		listaItens.remove(meuItem);
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
		validaItem(nomeItem);
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
		validaItem(nomeItem);
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
		validaItem(nomeItem);
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
	public void cadastroEmprestimo(Emprestimo emprestimo) {
		this.emprestimos.add(emprestimo);
	}

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

	public ArrayList<Item> getListaItens() {
		return new ArrayList<Item>(listaItens);
	}

	public Item getItem(String nomeItem) {
		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem))
				return item;
		}
		throw new RuntimeException("Item nao encontrado");
	}

	public Emprestimo getEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo) {
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getDono().getNome().equals(nomeDono)
					&& emprestimo.getDono().getNumCelular().equals(telefoneDono)
					&& emprestimo.getRequerente().getNumCelular().equals(telefoneRequerente)
					&& emprestimo.getRequerente().getNome().equals(nomeRequerente)
					&& emprestimo.getItem().getNome().equals(nomeItem)
					&& emprestimo.getDataEmprestimo().equals(dataEmprestimo))
				return emprestimo;
		}
		throw new IllegalArgumentException("Emprestimo nao encontrado");
	}

	/**
	 * Verifica se o preço inserido é válido
	 * 
	 * @param preco
	 */
	private void validaPreco(double preco) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
	}

	/**
	 * Verifica se um item existe na lista de itens a partir de seu nome
	 * 
	 * @param nomeItem
	 */
	private void validaItem(String nomeItem) {
		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem))
				return;
		}
		throw new IllegalArgumentException("Item nao encontrado");
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
