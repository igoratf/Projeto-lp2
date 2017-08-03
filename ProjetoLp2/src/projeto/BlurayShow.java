package projeto;

public class BlurayShow extends Bluray {

	private String nomeArtista;
	private int numFaixas;

	public BlurayShow(String nome, int valor, boolean estadoDeEmprestimo, int duracao, String classificacao,
			String nomeArtista, int numFaixas) {
		super(nome, valor, duracao, classificacao);

		this.nomeArtista = nomeArtista;
		this.numFaixas = numFaixas;

	}

}
