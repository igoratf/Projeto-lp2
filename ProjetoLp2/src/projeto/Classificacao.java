package projeto;

public enum Classificacao {

	LIVRE("LIVRE"), DEZ_ANOS("DEZ_ANOS"), DOZE_ANOS("DOZE_ANOS"), QUATORZE_ANOS("QUARTOZE_ANOS"), DEZESSEIS_ANOS(
			"DEZESSEIS_ANOS"), DEZOITO_ANOS("DEZOITO_ANOS");

	private final String valor;

	Classificacao(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}

}
