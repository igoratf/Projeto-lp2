package projeto;

public enum Classificaçao {
	
	LIVRE(1), DEZ_ANOS(2), DOZE_ANOS(3), QUATORZE_ANOS(4), DEZESSEIS_ANOS(5), DEZOITO_ANOS(6);
	
	private final int valor;

	Classificaçao(int valor){
		this.valor = valor;
	}

	public int getValor(){
		return this.valor;
	}
	
}
