package projeto;

import java.util.ArrayList;

public class BluraySeries extends Bluray {

	private ArrayList<BlurayEpisodio> episodios;
	private int temporada;
	private String descricao;

	public BluraySeries(String nome, double valor, int duracao, String descricao, String classificacao, String genero, int temporada) {
		super(nome, valor, duracao, classificacao);
		episodios = new ArrayList<BlurayEpisodio>();
		this.descricao = descricao;
	}

	public void adicionarBluray(BlurayEpisodio blurayEpisodio) {
		this.episodios.add(blurayEpisodio);
	}

}
