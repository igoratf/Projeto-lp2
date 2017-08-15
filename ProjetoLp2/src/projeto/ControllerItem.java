package projeto;

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

}
