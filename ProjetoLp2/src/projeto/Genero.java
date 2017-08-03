package projeto;

public enum Genero {
	
	 ACAO("ACAO"), ANIMACAO("ANIMACAO"), AVENTURA("AVENTURA"), COMEDIA("COMEDIA"), DOCUMENTARIO("DOCUMENTARIO"),
	 DRAMA("DRAMA"), EROTICO("EROTICO"), FAROESTE("FAROESTE"), FICCAO("FICCAO"), MUSICAL("MUSICAL"), POLICIAL("POLICIAL"),
	 ROMANCE("ROMANCE"), SUSPENSE("SUSPENSE"), TERROR("TERROR"), OUTRO("OUTRO");
	
	public final String valor;
	
	Genero(String valor){
		this.valor = valor;
	}
	
	public String getValor(){
		return this.valor;
	}
	
}

