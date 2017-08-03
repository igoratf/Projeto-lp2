package projeto;

public class BlurayTemporada extends Bluray {

	public int temporada;

	public BlurayTemporada(String nome, int valor, boolean estadoDeEmprestimo, int duracao, String classificacao,
			int temporada) {
		super(nome, valor, duracao, classificacao);
		this.temporada = temporada;
	}

	@Override
	public String toString() {
		return "BlurayTemporada [temporada=" + temporada + "]";
	}

}
