package projeto;

public class BlurayFilme extends Bluray {

	private Genero genero;

	public BlurayFilme(String nome, double valor, int duracao, String classificacao, String genero) {
		super(nome, valor, duracao, classificacao);
		this.genero = Genero.valueOf(genero);
	}

}
