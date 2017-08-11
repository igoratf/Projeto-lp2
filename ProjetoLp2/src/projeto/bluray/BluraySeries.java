package projeto.bluray;

import java.util.ArrayList;

import projeto.enums.Genero;

/**
 * Classe que irá modelar objetos do tipo BluraySeries, que terá uma coleção de
 * BlurayEpisodios
 * 
 * @author igoratf, javanlacerda
 *
 */

public class BluraySeries extends Bluray {

	private ArrayList<BlurayEpisodio> episodios;
	private int temporada;
	private String descricao;
	private Genero genero;

	/**
	 * Construtor de objetos do tipo BluraySeries
	 * 
	 * @param nome
	 * @param valor
	 * @param duracao
	 * @param descricao
	 * @param classificacao
	 * @param genero
	 * @param temporada
	 */
	public BluraySeries(String nome, double valor, int duracao, String descricao, String classificacao, String genero,
			int temporada) {
		super(nome, valor, duracao, classificacao);
		validaBluray(nome, valor, duracao, descricao, classificacao, genero, temporada);
		episodios = new ArrayList<BlurayEpisodio>();
		this.descricao = descricao;
		this.genero = Genero.valueOf(genero);
		this.temporada = temporada;
	}

	/**
	 * Adiciona um BlurayEpisodio à lista de blurays
	 * 
	 * @param blurayEpisodio
	 */

	public void adicionarBluray(BlurayEpisodio blurayEpisodio) {
		this.episodios.add(blurayEpisodio);
	}

	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Verifica se o bluray contém blurays de episódios
	 * 
	 * @return boolean
	 */
	public boolean contemEpisodio() {
		if (episodios.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("SERIE: %s, R$ %.2f, %s, %d min, %s, %s, Temporada %d", getNome(), getValor(), getEstado(),
				getDuracao(), getClassificao(), this.genero.getValor(), this.temporada);
	}
	
	/**
	 * Retorna o tamanho da coleção de BlurayEpisodios
	 * @return int
	 */
	public int getTamanho() {
		return episodios.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((episodios == null) ? 0 : episodios.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + temporada;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BluraySeries other = (BluraySeries) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (episodios == null) {
			if (other.episodios != null)
				return false;
		} else if (!episodios.equals(other.episodios))
			return false;
		if (genero != other.genero)
			return false;
		if (temporada != other.temporada)
			return false;
		return true;
	}
	
	/**
	 * Método de validação do bluray
	 * @param nome é o nome do bluray
	 * @param valor é o valor do bluray
	 * @param duracao é a duração do bluray
	 * @param descricao é a descrição do bluray
	 * @param classificacao é a classificação do bluray
	 * @param genero é o gênero do bluray
	 * @param temporada é a temporada do bluray
	 */
	public void validaBluray(String nome, double valor, int duracao, String descricao, String classificacao, String genero, int temporada) {
		super.validaBluray(nome, valor, duracao, classificacao);
		if (descricao == null) throw new NullPointerException("Descricao nula");
		if (genero == null) throw new NullPointerException("Genero nulo");
		if (descricao.trim().equals("")) throw new IllegalArgumentException("Descricao vazia");
		if (genero.trim().equals("")) throw new IllegalArgumentException("Genero vazio");
		if (temporada <= 0) throw new IllegalArgumentException("Temporada invalida");
	}
	

}
