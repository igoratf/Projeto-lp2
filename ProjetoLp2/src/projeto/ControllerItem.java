package projeto;

import java.util.ArrayList;
import java.util.Collections;

import projeto.Jogo.JogoEletronico;
import projeto.Jogo.JogoTabuleiro;
import projeto.bluray.Bluray;
import projeto.bluray.BlurayEpisodio;
import projeto.bluray.BlurayFilme;
import projeto.bluray.BluraySeries;
import projeto.bluray.BlurayShow;

public class ControllerItem {

	public Item cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		validaPreco(preco);
		JogoEletronico jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		return jogoEletronico;
	}

	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		validaPreco(preco);
		Item jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		return jogoTabuleiro;
	}

	public void cadastrarBluRayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {
		validaPreco(preco);
		Bluray blurayFilme = new BlurayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento);
		return blurayFilme;
	}

	public void cadastrarBlurayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int numFaixas, String nomeArtista,
			String classificacao) {
		validaPreco(preco);
		Bluray blurayShow = new BlurayShow(nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
		return blurayShow;
	}
	
	public void cadastrarBluraySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		validaPreco(preco);
		Bluray bluraySerie = new BluraySeries(nomeItem, preco, duracao, descricao, classificacao, genero, temporada);
		return bluraySerie;
	}
	
	public void adicionarBluray(String serie, int duracao) {
		Usuario usuario = sistema.getUsuario(String nome, String telefone);
		Bluray bluraySerie = usuario.getItem(serie);
		Bluray blurayEpisodio = new BlurayEpisodio(duracao);
		bluraySerie.adicionarBluray(blurayEpisodio);
	}
	
	public void removerItem(String nome, String telefone, String nomeItem) {
		Item meuItem = getItem(nomeItem);
		listaItens.remove(meuItem);
	}
	
	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		if (!mapaItens.containsKey(nomeItem)) {
			throw new IllegalArgumentException("Jogo Inválido!");
		}
		((JogoTabuleiro) mapaItens.get(nomeItem)).adicionarPecaPerdida(nomePeca);
	}
	
	public void atualizarItem(String nomeItem, String atributo, String valor) {
		Item meuItem = getItem(nomeItem);
		if (atributo.equalsIgnoreCase("preco")) {
			meuItem.setValor(Float.parseFloat(valor));
		}
		if (atributo.equalsIgnoreCase("nome")) {
			meuItem.setNome(valor);
		}
	}
	
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		return mapaUsuarios.get(chave).getInfoItem(nomeItem, atributo);

	}
	public String pesquisarDetalhesItem(String nomeItem) {
		Item meuItem = getItem(nomeItem);
		return meuItem.toString();
	}
	
	public void emprestarItem(String nomeItem) {
		Item meuItem = getItem(nomeItem);
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
