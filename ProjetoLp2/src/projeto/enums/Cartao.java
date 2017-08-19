package projeto.enums;

public enum Cartao {
	NOOB("noob"), CALOTEIRO("caloteiro"), BOM_AMIGO("bomAmigo"), FREE_RIDER("freeRider");

	private final String valor;

	Cartao(String valor) {
		this.valor = valor;
	}
	
	public String getValor(){
		return this.valor;
	}

}
