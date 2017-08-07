package projeto;

public class BlurayFilme extends Bluray {

	private Genero genero;
	private int anoDeLancamento;

	public BlurayFilme(String nome, double valor, int duracao, String classificacao, String genero,
			int anoDeLancamento) {
		super(nome, valor, duracao, classificacao);
		this.genero = Genero.valueOf(genero);
		this.anoDeLancamento = anoDeLancamento;

	}

	@Override
	public String toString() {
		return "FILME: " + getNome() + ", R$ " + getValor() + ", " + estadoDeEmprestimoToString() + ", " + getDuracao()
				+ " min, " + getClassificacao() + ", " + this.genero + ", " + this.anoDeLancamento + "|";
	}

}
