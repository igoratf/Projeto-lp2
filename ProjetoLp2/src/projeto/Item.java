package projeto;

/**
 * Define um item genérico.
 * 
 * @author javanktl
 *
 */
public class Item {

	private String nome;

	private double valor;
	private boolean estadoDeEmprestimo;

	public boolean isEstadoDeEmprestimo() {
		return estadoDeEmprestimo;
	}

	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		this.estadoDeEmprestimo = false;
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

	public String estadoDeEmprestimoToString() {

		if (this.estadoDeEmprestimo) {

			return "Emprestado";

		}
		return "Nao emprestado";

	}

	@Override
	public String toString() {
		return "Item [nome=" + nome + ", valor=" + valor + ", EstadoDeEmprestimo=" + estadoDeEmprestimo + "]";
	}

}
