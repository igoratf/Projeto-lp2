package projeto;

import java.util.ArrayList;

public class BluraySeries extends Bluray {

	private ArrayList<BluraySerie> episodios;
	private int temporada;
	private String descricao;

	public BluraySeries(String nome, double valor, int duracao, String descricao, String classificacao, String genero, int temporada) {
		super(nome, valor, duracao, classificacao);
		episodios = new ArrayList<BluraySerie>();
		this.descricao = descricao;
	}

	public void adicionarBluray(BluraySerie blurayEpisodio) {
		this.episodios.add(blurayEpisodio);
	}

}
