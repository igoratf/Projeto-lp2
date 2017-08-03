package projeto;

public enum Genero {
	
	 ACAO(1), ANIMACAO(2), AVENTURA(3), COMEDIA(4), DOCUMENTARIO(5), DRAMA(6), EROTICO(7),
	 FAROESTE(8), FICCAO(9), MUSICAL(10), POLICIAL(11), ROMANCE(12), SUSPENSE(13), TERROR(14), OUTRO(15);
	
	public final int valor;
	
	Genero(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return this.valor;
	}
	
}

