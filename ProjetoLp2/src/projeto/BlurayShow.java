package projeto;

public class BlurayShow extends Bluray {

	private String nomeArtista;
	private int numFaixas;
	
	public BlurayShow(String nome, double valor, int duracao,int numFaixas, 
			String nomeArtista, String classificacao) {
		super(nome, valor, duracao, classificacao);
		this.nomeArtista = nomeArtista;
		this.numFaixas = numFaixas;

	}

	@Override
	public String toString() {
		return "SHOW: " + getNome() + ", R$ " + getValor() + ", " + estadoDeEmprestimoToString() + ", " + getDuracao() + "min" + ", " + getClassificacao() + ", " + this.nomeArtista + ", " + this.numFaixas + " faixas|" ;
	}

}
