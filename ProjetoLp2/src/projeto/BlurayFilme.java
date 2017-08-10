package projeto;

/**
 * Classe que serve como modelo para a criação de objetos do tipo BlurayFilme
 * 
 * @author igoratf
 *
 */

public class BlurayFilme extends Bluray {

	private Genero genero;
	private int anoLancamento;

	/**
	 * Construtor da classe BlurayFilme
	 * 
	 * @param nome
	 *            é o nome do bluray
	 * @param valor
	 *            é o valor do bluray
	 * @param duracao
	 *            é a duração do bluray em minutos
	 * @param classificacao
	 *            é a classificação indicativa do bluray
	 * @param genero
	 *            é o gênero do filme
	 * @param anoLancamento
	 *            é o ano de lançamento do filme
	 */

	public BlurayFilme(String nome, double valor, int duracao, String classificacao, String genero, int anoLancamento) {
		super(nome, valor, duracao, classificacao);
		this.genero = Genero.valueOf(genero);
		this.anoLancamento = anoLancamento;

	}

	@Override
	public String toString() {
		return String.format("FILME: %s, R$ %.2f, %s, %d min, %s, %s, %d", getNome(), getValor(), getEstado(),
				getDuracao(), getClassificao(), this.genero.getValor(), this.anoLancamento);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + anoLancamento;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
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
		BlurayFilme other = (BlurayFilme) obj;
		if (anoLancamento != other.anoLancamento)
			return false;
		if (genero != other.genero)
			return false;
		return true;
	}

}
