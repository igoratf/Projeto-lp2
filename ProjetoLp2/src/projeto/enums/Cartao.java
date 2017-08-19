package projeto.enums;

public enum Cartao {
	NOOB("Noob"), CALOTEIRO("Caloteiro"), BOM_AMIGO("BomAmigo"), FREE_RIDER("FreeRyder");

	private final String valor;

	Cartao(String valor) {
		this.valor = valor;
	}
	
	public String getValor(){
		return this.valor;
	}

}
