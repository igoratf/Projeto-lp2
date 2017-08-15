package projeto.bluray;

/**
 * Classe que modela a construção de objetos do tipo BlurayShow
 * 
 * @author igoratf, javanlacerda
 *
 */
public class BlurayShow extends Bluray {

	private String nomeArtista;
	private int numFaixas;

	/**
	 * Construtor de objetos BlurayShow
	 * 
	 * @param nome
	 *            é o nome do bluray
	 * @param valor
	 *            é o valor do bluray
	 * @param duracao
	 *            é a duração do bluray em minutos
	 * @param numFaixas
	 *            é o número de faixas que o bluray contém
	 * @param nomeArtista
	 *            é o nome do artista correspondente ao bluray
	 * @param classificacao
	 *            é a classificação indicativa do bluray
	 */

	public BlurayShow(String nome, double valor, int duracao, int numFaixas, String nomeArtista, String classificacao) {
		super(nome, valor, duracao, classificacao);
		validaBluray(nome, valor, duracao, numFaixas, nomeArtista, classificacao);
		this.nomeArtista = nomeArtista;
		this.numFaixas = numFaixas;

	}

	@Override
	public String toString() {
		return String.format("SHOW: %s, R$ %.2f, %s, %d min, %s, %s, %d faixas", getNome(), getValor(), getEstado(),
				getDuracao(), getClassificao(), this.nomeArtista, this.numFaixas);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nomeArtista == null) ? 0 : nomeArtista.hashCode());
		result = prime * result + numFaixas;
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
		BlurayShow other = (BlurayShow) obj;
		if (nomeArtista == null) {
			if (other.nomeArtista != null)
				return false;
		} else if (!nomeArtista.equals(other.nomeArtista))
			return false;
		if (numFaixas != other.numFaixas)
			return false;
		return true;
	}

	/**
	 * Valida os parâmetros que constroem o objeto BlurayShow
	 * 
	 * @param nome
	 *            Nome do Bluray
	 * @param valor
	 *            Valor do Bluray
	 * @param duracao
	 *            Duração do Bluray
	 * @param numFaixas
	 *            Número de faixas do Bluray
	 * @param nomeArtista
	 *            Nome do Artista
	 * @param classificacao
	 *            Classificação do Bluray.
	 */
	public void validaBluray(String nome, double valor, int duracao, int numFaixas, String nomeArtista,
			String classificacao) {
		super.validaBluray(nome, valor, duracao, classificacao);
		if (nomeArtista == null)
			throw new NullPointerException("Nome do artista nulo");
		if (classificacao == null)
			throw new NullPointerException("Classificacao nula");
		if (nomeArtista.trim().equals(""))
			throw new IllegalArgumentException("Nome do artista vazio");
		if (classificacao.trim().equals(""))
			throw new IllegalArgumentException("Classificacao vazia");
		if (numFaixas <= 0)
			throw new IllegalArgumentException("Numero de faixas invalido");
	}

}
