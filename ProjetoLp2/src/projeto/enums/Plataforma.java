package projeto.enums;

import java.io.Serializable;

/**
 * Classe enum das Plataformas.
 * 
 * @author lucasvsa
 *
 */

public enum Plataforma implements Serializable {
	/**
	 * Classe enum criada para manter as plataformas como variaveis constantes.
	 */
	
	PC("PC"), MAC("MAC"), PS3("PS3"), PS4("PS4"), XBOX360("XBOX360"), XBOX_ONE("XBOX_ONE"), NINTENDO_3DS("NINTENDO_3DS"), OUTRO("OUTRO");
	
	private final String plataforma;
	
	Plataforma(String plataforma){
		this.plataforma = plataforma;
		
	}

	/**
	 * Metodo para retonar a plataforma da classe.
	 * @return, retorna o valor em String.
	 */
	public String getPlataforma(){
		return this.plataforma;
	}
}
