package projeto.enums;

import java.io.Serializable;

/**
 * Classe enum para Generos.
 * 
 * @author lucasvsa
 *
 */
public enum Genero implements Serializable {
	/**
	 * Classe enum criada para manter as plataformas como variaveis constantes.
	 */
	
	
	 ACAO("ACAO"), ANIMACAO("ANIMACAO"), AVENTURA("AVENTURA"), COMEDIA("COMEDIA"), DOCUMENTARIO("DOCUMENTARIO"),
	 DRAMA("DRAMA"), EROTICO("EROTICO"), FAROESTE("FAROESTE"), FICCAO("FICCAO"), MUSICAL("MUSICAL"), POLICIAL("POLICIAL"),
	 ROMANCE("ROMANCE"), SUSPENSE("SUSPENSE"), TERROR("TERROR"), OUTRO("OUTRO");
	
	public final String valor;
	
	Genero(String valor){
		this.valor = valor;
	}
	
	/**
	 * Metodo para retornar o genero dessa classe.
	 * @return, retorna o valor em String.
	 */
	public String getValor(){
		return this.valor;
	}
	
}

