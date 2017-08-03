package projeto;

import java.util.ArrayList;
import java.util.List;

public class ControllerItem {
	private List<Item> listaItens = new ArrayList<>();

	public ControllerItem() {
	}

	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, Plataforma plataforma) {
	}
	
		

/**
 * Metodo para cadastrar um jogo Eletronico na lista de itens.
 * @param nomeItem, nome do jogo.
 * @param preco, valor do jogo.
 * @param plataforma, plataforma do jogo.
 */
	public void cadastrarEletronico(String nomeItem, double preco, Plataforma plataforma) {
		Item jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		listaItens.add(jogoEletronico);
	}

	/**
	 * Metodo para cadastrar um jogo de Tabuleiro na lista de itens.
	 * @param nomeItem, nome do jogo de tabuleiro.
	 * @param preco, valor do jogo de tabulero.
	 */
	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		Item jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		listaItens.add(jogoTabuleiro);
	}
	
	/**
	 * Metodo para cadastrar um filme BluRay na lista de itens.
	 * @param nomeItem, nome do filme bluray.
	 * @param preco, valor do filme.
	 * @param duracao, duração desse filme bluray.
	 * @param genero, genero baseado na classe enum Genero.
	 * @param classificacao, classificação baseado na classe enum Classificao.
	 * @param anoLancamento, ano de lançamento do filme.
	 */
	public void cadastrarBluRayFilme(String nomeItem, double preco, int duracao, Genero genero, Classificacao classificacao, int anoLancamento) {
		// Bluray blurayFilme = new BlurayFilme();
		// Quando ajeitar o BlurayFilme eu termino
	}

	/**
	 * Metodo para adicionar peça perdida ao jogo de tabuleiro na lista de itens.
	 * @param nomeItem, nome do jogo de tabuleiro.
	 * @param nomePeca, nome da peça a ser adicionada na lista de peças perdidas.
	 */
	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem)) {
				((JogoTabuleiro) item).adicionarPecaPerdida(nomePeca);
			}
		}
	}

	/**
	 * Metodo para verificar se existe um Item na lista de itens.
	 * @param nomeItem, nome do Item a ser buscado.
	 */
	public void validaItem(String nomeItem) {
		if (!(listaItens.contains(nomeItem))) {
			throw new RuntimeException("Item nao encontrado");
		}
	}

	/**
	 * Metodo para remover um Item da lista de itens.
	 * @param nomeItem, nome do item a ser removido.
	 */
	public void removerItem(String nomeItem) {
		validaItem(nomeItem);
		Item meuItem = getItem(nomeItem);
		listaItens.remove(meuItem);
	}

	/**
	 * Metodo para encontrar um item pelo nome passado por paramtro.
	 * @param nomeItem, nome do item a ser buscado.
	 * @return
	 */
	public Item getItem(String nomeItem) {
		Item meuItem = null;
		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem))
				meuItem = item;
			return meuItem;
		}
		return meuItem;
	}
	
	public void atualizarItem(String nomeItem, String atributo, String valor) {
		Item meuItem = getItem(nomeItem);
		if (atributo.equalsIgnoreCase("preco")) {
			meuItem.setValor(Float.parseFloat(valor));
		}
		if (atributo.equalsIgnoreCase("nome")) {
			meuItem.setNome("valor");
		}
	}
	
		

}
