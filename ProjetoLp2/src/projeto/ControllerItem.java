package projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ControllerItem {
	private List<Item> listaItens;

	public ControllerItem() {
		this.listaItens = new ArrayList<>();
		Locale.setDefault(new Locale("en", "US"));
	}


	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		validaPreco(preco);
		Item jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		listaItens.add(jogoEletronico);
	}

	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		validaPreco(preco);
		Item jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		listaItens.add(jogoTabuleiro);
	}

	public void cadastrarBluRayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		validaPreco(preco);
		Bluray blurayFilme = new BlurayFilme(nomeItem, preco, duracao, classificacao, genero);
		listaItens.add(blurayFilme);
	}
	
	public void cadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		validaPreco(preco);
		Bluray bluraySerie = new BluraySeries(nomeItem, preco, duracao, descricao, classificacao, genero, temporada);
		listaItens.add(bluraySerie);
	}
	
	public void cadastrarBlurayShow(String nomeItem, double preco, int duracao,int numFaixas,String nomeArtista,String classificacao) {
		validaPreco(preco);
		Bluray blurayShow = new BlurayShow(nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
		listaItens.add(blurayShow);
	}
	
	public void adicionarBluray(String serie, int duracao) {
		BlurayEpisodio blurayEpisodio = new BlurayEpisodio(duracao);
		for (Item item : listaItens) {
			if (item.getNome().equals(serie)) {
				((BluraySeries) item).adicionarBluray(blurayEpisodio);
			}
		}

	}

	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem)) {
				((JogoTabuleiro) item).adicionarPecaPerdida(nomePeca);
			}
		}
	}

	private void validaItem(String nomeItem) {
		Item meuItem = getItem(nomeItem);
		if (!(listaItens.contains(meuItem))) {
			throw new RuntimeException("Item nao encontrado");
		}
	}

	public void removerItem(String nomeItem) {
		validaItem(nomeItem);
		Item meuItem = getItem(nomeItem);
		listaItens.remove(meuItem);
	}

	public Item getItem(String nomeItem) {
		boolean existe = false;
		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem))
				existe = true;
				return item;
		}
		if (!existe) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		return null;
		
	}

	/**
	 * Metodo criado para atualizar o item de acordo com o atributo desejado
	 * passado por parametro.
	 * 
	 * @param nomeItem,
	 *            nome do item a ser atualizado.
	 * @param atributo,
	 *            atributo que deseja ser alterado.
	 * @param valor,
	 *            valor do atributo para ser alterado.
	 */
	public void atualizarItem(String nomeItem, String atributo, String valor) {
		Item meuItem = getItem(nomeItem);
		
		checaSeItemExiste(nomeItem); //MARCA
		if (atributo.equalsIgnoreCase("preco")) {
			meuItem.setValor(Float.parseFloat(valor));
		}
		if (atributo.equalsIgnoreCase("nome")) {
			meuItem.setNome(valor);
		}
	}

	public String getInfoItem(String nomeItem, String atributo) {
		Item meuItem = getItem(nomeItem);
		
		checaSeItemExiste(nomeItem); //MARCA
		switch (atributo) {
		case "Preco":
			return String.valueOf(meuItem.getValor());
		case "Nome":
			return meuItem.getNome();
		default:
			throw new IllegalArgumentException("Atributo invalido");
		}

	}
	
	public void validaPreco(double preco) {
		if (preco <=0) {
			throw new IllegalArgumentException("Preco invalido");
		}
	}
	
	public boolean checaSeItemExiste(String nomeItem){
		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem))
				return true;
	}
		throw new IllegalArgumentException("Item nao encontrado");
  }
	
}
