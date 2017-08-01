package projeto;

public class BlurayTemporada extends Bluray {

	public int temporada;

	public BlurayTemporada(String nome, int valor, boolean estadoDeEmprestimo, int duracao, String classificacao,
			int temporada) {
		super(nome, valor, estadoDeEmprestimo, duracao, classificacao);
		this.temporada = temporada;
	}

}
