package projeto.enums;

public enum Classificacao {
<<<<<<< HEAD:ProjetoLp2/src/projeto/Classificacao.java

	LIVRE("LIVRE"), DEZ_ANOS("DEZ_ANOS"), DOZE_ANOS("DOZE_ANOS"), QUATORZE_ANOS("QUARTOZE_ANOS"), DEZESSEIS_ANOS(
			"DEZESSEIS_ANOS"), DEZOITO_ANOS("DEZOITO_ANOS");

=======
	
	LIVRE("LIVRE"), DEZ_ANOS("DEZ_ANOS"), DOZE_ANOS("DOZE_ANOS"), QUATORZE_ANOS("QUATORZE_ANOS"), DEZESSEIS_ANOS("DEZESSEIS_ANOS"), DEZOITO_ANOS("DEZOITO_ANOS");
	
>>>>>>> 4c13af4fbfddd82cffcf3b2be0c9e0412d4040cb:ProjetoLp2/src/projeto/enums/Classificacao.java
	private final String valor;

	Classificacao(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}

}
