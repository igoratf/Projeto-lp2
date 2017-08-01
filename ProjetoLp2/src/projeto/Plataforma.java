package projeto;



public enum Plataforma {
	
	PC(1), MAC(2), PS3(3), PS4(4), XBOX360(5), XBOX_ONE(6), NINTENDO_3DS(7), OUTRO(8);
	
	private final int valor;
	
	Plataforma(int valor){
		this.valor = valor;
		
	}

	public int getValor(){
		return this.valor;
	}
}
