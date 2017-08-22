package projeto.enums;

/**
 * Classe enum para classificações.
 * 
 * @author lucasvsa
 *
 */
public enum Classificacao {
	/**
	 * Classe enum criada para manter as plataformas como variaveis constantes.
	 */
	
	
	LIVRE("LIVRE"), DEZ_ANOS("DEZ_ANOS"), DOZE_ANOS("DOZE_ANOS"), QUATORZE_ANOS("QUATORZE_ANOS"), DEZESSEIS_ANOS("DEZESSEIS_ANOS"), DEZOITO_ANOS("DEZOITO_ANOS");
	
	private final String valor;

	Classificacao(String valor){
		this.valor = valor;
	}

	/**
	 * Metodo para retornar as classificações dessa classe.
	 * @return, retorna o valor em String.
	 */
	public String getValor(){
		return this.valor;
	}
	
}
