package projeto;

public class BlurayFilme extends Bluray {

	private Genero genero;

	public BlurayFilme(String nome, double valor, int duracao, Classificacao classificacao, Genero genero) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
	}

}
