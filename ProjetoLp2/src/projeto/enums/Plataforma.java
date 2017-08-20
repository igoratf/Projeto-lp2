package projeto.enums;

/**
 * Classe enum das Plataformas.
 * 
 * @author lucasvsa
 *
 */

public enum Plataforma {
	/**
	 * Classe enum criada para manter as plataformas como variaveis constantes.
	 */
	
	PC("PC"), MAC("MAC"), PS3("PS3"), PS4("PS4"), XBOX360("XBOX360"), XBOX_ONE("XBOX_ONE"), NINTENDO_3DS("NINTENDO_3DS"), OUTRO("OUTRO");
	
	private final String plataforma;
	
	Plataforma(String plataforma){
		this.plataforma = plataforma;
		
	}

	public String getPlataforma(){
		return this.plataforma;
	}
}
