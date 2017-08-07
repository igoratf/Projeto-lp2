package projeto;

/**
 * Define um item genérico.
 * 
 * @author javanktl
 *
 */
public class Item implements Comparable<Item> {

	private String nome;

	private double valor;
	private boolean EstadoDeEmprestimo;

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

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		if (EstadoDeEmprestimo) {
			return "Emprestado";
		}
		return "Nao emprestado";
	}

	@Override
	public String toString() {
		return "Item [nome=" + nome + ", valor=" + valor + ", EstadoDeEmprestimo=" + EstadoDeEmprestimo + "]";
	}

	@Override
	public int compareTo(Item item) {
		return this.nome.compareTo(item.nome);
	}

}
