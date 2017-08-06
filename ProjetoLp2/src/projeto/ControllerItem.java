package projeto;

import java.util.ArrayList;
import java.util.List;

public class ControllerItem {
	private List<Item> listaItens = new ArrayList<>();

	public ControllerItem() {
	}

	
	
	
	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		Item jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		listaItens.add(jogoEletronico);
	}

	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		Item jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		listaItens.add(jogoTabuleiro);
	}
	
	public void cadastrarBluRayFilme(String nomeItem, double preco, int duracao, Genero genero, Classificacao classificacao, int anoLancamento) {
		// Bluray blurayFilme = new BlurayFilme();
		// Quando ajeitar o BlurayFilme eu termino
	}

	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem)) {
				((JogoTabuleiro) item).adicionarPecaPerdida(nomePeca);
			}
		}
	}

	private void validaItem(String nomeItem) {
		if (!(listaItens.contains(nomeItem))) {
			throw new RuntimeException("Item nao encontrado");
		}
	}

	public void removerItem(String nomeItem) {
		validaItem(nomeItem);
		Item meuItem = getItem(nomeItem);
		listaItens.remove(meuItem);
	}

	public Item getItem(String nomeItem) {
		Item meuItem = null;
		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem))
				meuItem = item;
			return meuItem;
		}
		return meuItem;
	}
	
	/**
	 * Metodo criado para atualizar o item de acordo com o atributo desejado passado por parametro.
	 * @param nomeItem, nome do item a ser atualizado.
	 * @param atributo, atributo que deseja ser alterado.
	 * @param valor, valor do atributo para ser alterado.
	 */
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
