package projeto;

import java.io.Serializable;

/**
 * Define um item genérico.
 * 
 * @author javanktl, igoratf
 *
 */
public abstract class Item implements Comparable<Item>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1208559691278520724L;
	private String nome;
	private int numEmprestimos;
	private double valor;
	private boolean estadoDeEmprestimo;

	/**
	 * Constroi um item generico
	 * @param nome
	 * 		nome do item a ser construido
	 * @param valor
	 * 		valor do item a ser construido
	 */
	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		this.estadoDeEmprestimo = false;
		this.numEmprestimos = 0;
	}
	
	/**
	 * Altera o estado de emprestimo de um item
	 * @param estadoDeEmprestimo
	 * 		boleano com o novo estado de emprestimo
	 */
	public void setEstadoDeEmprestimo(boolean estadoDeEmprestimo) {
		this.estadoDeEmprestimo = estadoDeEmprestimo;
	}

	/**
	 * Busca o nome do item
	 * @return
	 * 		retorna o nome do item
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Busca o valor do item
	 * @return
	 * 		retorna o valor do item
	 */
	public double getValor() {
		return valor;
	}
	/**
	 * Altera o valor do item
	 * @param valor
	 * 		novo valor do item
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * Altera nome do item
	 * @param nome
	 * 		novo nome do item
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Busca estado de emprestimo do item
	 * @return
	 * 		retorna a string que representa o estado de emprestimo do item
	 */
	public String getEstado() {
		if (estadoDeEmprestimo) {
			return "Emprestado";
		}
		return "Nao emprestado";
	}
	
	/**
	 * Busca o numero de emprestimos do item
	 * @return
	 * 		retorna o numero de emprestimos do item
	 */
	public int getNumEmprestimos() {
		return this.numEmprestimos;
	}
	
	/**
	 * Conta o numero de vezes que o item foi emprestado
	 */
	public void contaEmprestimos() {
		this.numEmprestimos += 1;
	}

	/**
	 * retorna a String que representa o item
	 */
	@Override
	public String toString() {
		return "Item [nome=" + nome + ", valor=" + valor + ", EstadoDeEmprestimo=" + estadoDeEmprestimo + "]";
	}

	/**
	 * Sobrescreve o metodo compareTo para a classe item
	 */
	@Override
	public int compareTo(Item item) {
		return this.nome.compareTo(item.nome);
	}

}
