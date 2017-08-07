package projeto;

import java.util.ArrayList;

public class BluraySeries extends Bluray {

	private ArrayList<BlurayEpisodio> episodios;
	private int temporada;
	private String descricao;
	private Genero genero;

	public BluraySeries(String nome, double valor, int duracao, String descricao, String classificacao, String genero, int temporada) {
		super(nome, valor, duracao, classificacao);
		episodios = new ArrayList<BlurayEpisodio>();
		this.descricao = descricao;
		this.genero = Genero.valueOf(genero);
		this.temporada = temporada;
	}

	public void adicionarBluray(BlurayEpisodio blurayEpisodio) {
		this.episodios.add(blurayEpisodio);
	}
	public String getDescricao(){
		return this.descricao;
	}
	
	@Override
	public String toString(){
		return String.format("SERIE: %s, R$ %.2f, %s, %d min, %s, %s, Temporada %d|",getNome(),getValor(),getEstado(),getDuracao(),getClassificao(),this.genero.getValor(),this.temporada);
	}

}
