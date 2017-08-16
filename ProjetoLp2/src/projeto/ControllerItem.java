package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import projeto.Jogo.JogoEletronico;
import projeto.Jogo.JogoTabuleiro;
import projeto.bluray.Bluray;
import projeto.bluray.BlurayEpisodio;
import projeto.bluray.BlurayFilme;
import projeto.bluray.BluraySeries;
import projeto.bluray.BlurayShow;

public class ControllerItem {

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		ValidaParametros.validaPreco(preco);
		Map<String, Item> mapaItens = sistema.getItens(nome, telefone);
		JogoEletronico jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		mapaItens.put(nomeItem, jogoEletronico);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		ValidaParametros.validaPreco(preco);
		Map<String, Item> mapaItens = sistema.getItens(nome, telefone);
		Item jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		mapaItens.put(nomeItem, jogoTabuleiro);
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		ValidaParametros.validaPreco(preco);
		Map<String, Item> mapaItens = sistema.getItens(nome, telefone);
		Bluray blurayFilme = new BlurayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento);
		mapaItens.put(nomeItem, blurayFilme);
	}

	public Item cadastrarBlurayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numFaixas, String nomeArtista, String classificacao) {
		ValidaParametros.validaPreco(preco);
		Map<String, Item> mapaItens = sistema.getItens(nome, telefone);
		Bluray blurayShow = new BlurayShow(nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
		mapaItens.put(nomeItem, blurayShow);
	}

	public Item cadastrarBluraySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		ValidaParametros.validaPreco(preco);
		Map<String, Item> mapaItens = sistema.getItens(nome, telefone);
		Bluray bluraySerie = new BluraySeries(nomeItem, preco, duracao, descricao, classificacao, genero, temporada);
		mapaItens.put(nomeItem, bluraySerie);
	}

	public void adicionarBluray(String nome, String telefone, String serie, int duracao) {
		Map<String, Item> mapaItens = sistema.getItens(nome, telefone);
		BluraySeries bluraySerie = (BluraySeries) mapaItens.get(serie);
		BlurayEpisodio blurayEpisodio = new BlurayEpisodio(duracao);
		bluraySerie.adicionarBluray(blurayEpisodio);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		Map<String, Item> mapaItens = sistema.getItens(nome, telefone);
		Item meuItem = mapaItens.get(nomeItem);
		mapaItens.remove(meuItem);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		Map<String, Item> mapaItens = sistema.getItens(nome, telefone);
		if (!mapaItens.containsKey(nomeItem)) {
			throw new IllegalArgumentException("Jogo Inválido!");
		}
		((JogoTabuleiro) mapaItens.get(nomeItem)).adicionarPecaPerdida(nomePeca);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		Map<String, Item> mapaItens = sistema.getItens(nome, telefone);
		Item meuItem = mapaItens.get(nomeItem);
		if (atributo.equalsIgnoreCase("preco")) {
			meuItem.setValor(Float.parseFloat(valor));
		}
		if (atributo.equalsIgnoreCase("nome")) {
			meuItem.setNome(valor);
		}
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		Map<String, Item> mapaItens = sistema.getItens(nome, telefone);
		switch (atributo) {
		case "Preco":
			return String.format("%.2f", mapaItens.get(nomeItem).getValor());
		case "Nome":
			return mapaItens.get(nomeItem).getNome();
		default:
			throw new IllegalArgumentException("Atributo invalido");
		}

	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		Map<String, Item> mapaItens = sistema.getItens(nome, telefone);
		Item meuItem = mapaItens.get(nomeItem);
		return meuItem.toString();
	}

	public void emprestarItem(String nome, String telefone, String nomeItem) {
		Map<String, Item> mapaItens = sistema.getItens(nome, telefone);
		Item meuItem = mapaItens.get(nomeItem);
		if (meuItem.getEstado().equals("Emprestado"))
			throw new IllegalArgumentException("Item emprestado no momento");
		else
			meuItem.setEstadoDeEmprestimo(true);
	}

	public String listarItensOrdenadosPorNome() {
		String itens = "";
		ArrayList<Item> itensSistema = itensSistema();
		Collections.sort(itensSistema);
		for (Item item : itensSistema) {
			itens += item.toString() + "|";
		}
		return itens;
	}

	public String listarItensOrdenadosPorValor() {
		String itens = "";
		ArrayList<Item> itensSistema = itensSistema();
		itensSistema.sort(new ComparaItemValor());
		for (Item item : itensSistema) {
			itens += item.toString() + "|";
		}
		return itens;
	}

}
