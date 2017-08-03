package projeto;

public class Item {

	protected String nome;
	private double valor;
	private boolean EstadoDeEmprestimo;

	public boolean isEstadoDeEmprestimo() {
		return EstadoDeEmprestimo;
	}

	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		this.EstadoDeEmprestimo = false;
	}

	public void setEstadoDeEmprestimo(boolean estadoDeEmprestimo) {
		EstadoDeEmprestimo = estadoDeEmprestimo;
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}

}
