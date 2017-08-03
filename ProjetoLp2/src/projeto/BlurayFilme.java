package projeto;

public class BlurayFilme extends Bluray {

	private String genero;

	public BlurayFilme(String nome, int valor, boolean estadoDeEmprestimo, int duracao, String classificacao,
			String genero) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
	}

}
