package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import projeto.Jogo.*;
import projeto.bluray.*;

/**
 * Classe controladora de itens, responsável por gerenciar funções relacionadas
 * à manipulação de itens
 * 
 * @author igoratf
 *
 */

public class ControllerItem {
	private Sistema sistema;

	public ControllerItem(Sistema sistema) {
		this.sistema = sistema;

	}

	/**
	 * Cadastra um JogoEletronico no Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do jogo
	 * @param preco
	 *            é o valor do jogo
	 * @param plataforma
	 *            é a plataforma do jogo
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		ValidaParametros.validaPreco(preco);
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		JogoEletronico jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		mapaItens.put(nomeItem, jogoEletronico);
	}

	/**
	 * Cadastra um JogoTabuleiro no Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do jogo
	 * @param preco
	 *            é o valor do jogo
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		ValidaParametros.validaPreco(preco);
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		Item jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		mapaItens.put(nomeItem, jogoTabuleiro);
	}

	/**
	 * Cadastra um BlurayFilme no Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do filme
	 * @param preco
	 *            é o valor do bluray
	 * @param duracao
	 *            é a duração do filme
	 * @param genero
	 *            é o gênero do filme
	 * @param classificacao
	 *            é a classificação indicativa do filme
	 * @param anoLancamento
	 *            é o ano de lançamento do filme
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		ValidaParametros.validaPreco(preco);
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		Bluray blurayFilme = new BlurayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento);
		mapaItens.put(nomeItem, blurayFilme);
	}

	/**
	 * Cadastra um BlurayShow no Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do show
	 * @param preco
	 *            é o valor do bluray
	 * @param duracao
	 *            é a duração do bluray
	 * @param numFaixas
	 *            é o número de faixas do bluray
	 * @param nomeArtista
	 *            é o nome do artista
	 * @param classificacao
	 *            é a classificação indicativa do show
	 */
	public void cadastrarBlurayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numFaixas, String nomeArtista, String classificacao) {
		ValidaParametros.validaPreco(preco);
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		Bluray blurayShow = new BlurayShow(nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
		mapaItens.put(nomeItem, blurayShow);
	}

	/**
	 * Cadastra um BluraySerie no Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome da série
	 * @param preco
	 *            é o valor da série
	 * @param descricao
	 *            é a descrição da série
	 * @param duracao
	 *            é a duração da série
	 * @param classificacao
	 *            é a classificação indicativa da série
	 * @param genero
	 *            é o gênero da série
	 * @param temporada
	 *            é a temporada da série que corresponde o bluray
	 */
	public void cadastrarBluraySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		ValidaParametros.validaPreco(preco);
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		Bluray bluraySerie = new BluraySeries(nomeItem, preco, duracao, descricao, classificacao, genero, temporada);
		mapaItens.put(nomeItem, bluraySerie);
	}

	/**
	 * Adiciona um BlurayEpisodio em um BluraySeries de um Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param serie
	 *            é o nome da série
	 * @param duracao
	 *            é a duração do episódio
	 */
	public void adicionarBluray(String nome, String telefone, String serie, int duracao) {
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		ValidaParametros.validaItem(mapaItens, serie);
		BluraySeries bluraySerie = (BluraySeries) mapaItens.get(serie);
		BlurayEpisodio blurayEpisodio = new BlurayEpisodio(duracao);
		bluraySerie.adicionarBluray(blurayEpisodio);
	}

	/**
	 * Remove um item de um Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do item
	 */
	public void removerItem(String nome, String telefone, String nomeItem) {
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		ValidaParametros.validaItem(mapaItens, nomeItem);
		mapaItens.remove(nomeItem);
	}

	/**
	 * Adiciona uma peça perdida a um JogoTabuleiro
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do jogo
	 * @param nomePeca
	 *            é o nome da peça perdida
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		if (!mapaItens.containsKey(nomeItem)) {
			throw new IllegalArgumentException("Jogo Inválido!");
		}
		((JogoTabuleiro) mapaItens.get(nomeItem)).adicionarPecaPerdida(nomePeca);
	}

	/**
	 * Atualiza informações de um item de um Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do item
	 * @param atributo
	 *            é o atributo que será atualizado
	 * @param valor
	 *            é o novo atributo atualizado após a modificação
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		ValidaParametros.validaItem(mapaItens, nomeItem);
		Item meuItem = mapaItens.get(nomeItem);
		if (atributo.equalsIgnoreCase("preco")) {
			meuItem.setValor(Float.parseFloat(valor));
		}
		if (atributo.equalsIgnoreCase("nome")) {
			mapaItens.remove(nomeItem);
			meuItem.setNome(valor);
			mapaItens.put(valor, meuItem);
		}
	}

	/**
	 * Retorna informações de um item de um Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do item
	 * @param atributo
	 *            é o atributo cuja informação será exibida
	 * @return informação correspondente a um atributo do item
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		ValidaParametros.validaItem(mapaItens, nomeItem);
		switch (atributo) {
		case "Preco":
			return String.valueOf(mapaItens.get(nomeItem).getValor());
		case "Nome":
			return mapaItens.get(nomeItem).getNome();
		default:
			throw new IllegalArgumentException("Atributo invalido");
		}

	}

	/**
	 * Retorna uma informações detalhadas de um item
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do itme
	 * @return representação textual do item
	 */
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		ValidaParametros.validaItem(mapaItens, nomeItem);
		Item meuItem = mapaItens.get(nomeItem);
		return meuItem.toString();
	}

	/**
	 * Empresta um item de um Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do item
	 */
	public void emprestarItem(String nome, String telefone, String nomeItem) {
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		ValidaParametros.validaItem(mapaItens, nomeItem);
		Item meuItem = mapaItens.get(nomeItem);
		if (meuItem.getEstado().equals("Emprestado"))
			throw new IllegalArgumentException("Item emprestado no momento");
		else
			meuItem.setEstadoDeEmprestimo(true);
	}
	
	public void devolverItem(String nome, String telefone, String nomeItem){
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		ValidaParametros.validaItem(mapaItens, nomeItem);
		Item meuItem = mapaItens.get(nomeItem);
		
		meuItem.setEstadoDeEmprestimo(false);
	}

	/**
	 * Retorna um item pertencente ao Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do item
	 * @return item do Usuario
	 */
	public Item getItem(String nome, String telefone, String nomeItem) {
		Map<String, Item> mapaItens = sistema.getItensUsuario(nome, telefone);
		ValidaParametros.validaItem(mapaItens, nomeItem);
		return mapaItens.get(nomeItem);
	}

	/**
	 * Lista os itens dos usuários ordenados por nome
	 * 
	 * @return informações dos itens ordenados por nome
	 */
	public String listarItensOrdenadosPorNome() {
		String itens = "";
		ArrayList<Item> itensUsuarios = (ArrayList<Item>) sistema.getItensUsuarios();
		Collections.sort(itensUsuarios);
		for (Item item : itensUsuarios) {
			itens += item.toString() + "|";
		}
		return itens;
	}

	/**
	 * Lista os itens dos usuários ordenados por valor
	 * 
	 * @return informações dos itens ordenados por valor
	 */
	public String listarItensOrdenadosPorValor() {
		String itens = "";
		ArrayList<Item> itensUsuarios = (ArrayList<Item>) sistema.getItensUsuarios();
		itensUsuarios.sort(new ComparaItemValor());
		for (Item item : itensUsuarios) {
			itens += item.toString() + "|";
		}
		return itens;
	}

}
