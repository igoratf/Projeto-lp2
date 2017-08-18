package projeto;

/**
 * Define um item genérico.
 * 
 * @author javanktl, igoratf
 *
 */
public abstract class Item implements Comparable<Item> {

	private String nome;
	private int numEmprestimos;
	private double valor;
	private boolean estadoDeEmprestimo;

	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		this.estadoDeEmprestimo = false;
		this.numEmprestimos = 0;
	}

	public void setEstadoDeEmprestimo(boolean estadoDeEmprestimo) {
		this.estadoDeEmprestimo = estadoDeEmprestimo;
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		if (estadoDeEmprestimo) {
			return "Emprestado";
		}
		return "Nao emprestado";
	}
	
	public int getNumEmprestimos() {
		return this.numEmprestimos;
	}
	
	public void contaEmprestimos() {
		this.numEmprestimos += 1;
	}

	@Override
	public String toString() {
		return "Item [nome=" + nome + ", valor=" + valor + ", EstadoDeEmprestimo=" + estadoDeEmprestimo + "]";
	}

	@Override
	public int compareTo(Item item) {
		return this.nome.compareTo(item.nome);
	}

}
