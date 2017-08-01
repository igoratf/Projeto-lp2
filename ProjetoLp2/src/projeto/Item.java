package projeto;

public class Item {

	protected String nome;
	private int valor;
	private boolean EstadoDeEmprestimo = false;

	public boolean isEstadoDeEmprestimo() {
		return EstadoDeEmprestimo;
	}

	public Item(String nome, int valor, boolean estadoDeEmprestimo) {
		super();
		this.nome = nome;
		this.valor = valor;
		EstadoDeEmprestimo = estadoDeEmprestimo;
	}

	public void setEstadoDeEmprestimo(boolean estadoDeEmprestimo) {
		EstadoDeEmprestimo = estadoDeEmprestimo;
	}

	public String getNome() {
		return nome;
	}

	public int getValor() {
		return valor;
	}

}
