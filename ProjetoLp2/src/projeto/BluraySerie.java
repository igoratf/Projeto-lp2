package projeto;

public class BluraySerie extends Bluray {

	public int temporada;

	public BluraySerie(String nome, int valor, int duracao, String classificacao,
			int temporada) {
		super(nome, valor, duracao, classificacao);
		this.temporada = temporada;
	}

	@Override
	public String toString() {
		return "BlurayTemporada [temporada=" + temporada + "]";
	}

}
