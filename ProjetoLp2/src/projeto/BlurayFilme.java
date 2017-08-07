package projeto;

public class BlurayFilme extends Bluray {

	private Genero genero;
	private int anoLancamento;

	public BlurayFilme(String nome, double valor, int duracao, String classificacao, String genero, int anoLancamento) {
		super(nome, valor, duracao, classificacao);
		this.genero = Genero.valueOf(genero);
		this.anoLancamento = anoLancamento;

	}

	@Override


	public String toString() {
		return String.format("FILME: %s, R$ %.2f, %s, %d min, %s, %s, %d|", getNome(), getValor(), getEstado(),
				getDuracao(), getClassificao(), this.genero.getValor(), this.anoLancamento);
	}

}
