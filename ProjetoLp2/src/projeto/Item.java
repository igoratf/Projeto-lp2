package projeto;

/**
 * Define um item genérico.
 * 
 * @author javanktl
 *
 */
public abstract class Item implements Comparable<Item> {

	private String nome;

	private double valor;
	private boolean estadoDeEmprestimo;

<<<<<<< HEAD
	public boolean isEstadoDeEmprestimo() {
		return estadoDeEmprestimo;
	}

=======
>>>>>>> 4c13af4fbfddd82cffcf3b2be0c9e0412d4040cb
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

<<<<<<< HEAD
	public String estadoDeEmprestimoToString() {

		if (this.estadoDeEmprestimo) {

			return "Emprestado";

		}
		return "Nao emprestado";

	}

=======
	public String getEstado() {
		if (EstadoDeEmprestimo) {
			return "Emprestado";
		}
		return "Nao emprestado";
	}

	

>>>>>>> 4c13af4fbfddd82cffcf3b2be0c9e0412d4040cb
	@Override
	public String toString() {
		return "Item [nome=" + nome + ", valor=" + valor + ", EstadoDeEmprestimo=" + estadoDeEmprestimo + "]";
	}

	@Override
	public int compareTo(Item item) {
		return this.nome.compareTo(item.nome);
	}

}
