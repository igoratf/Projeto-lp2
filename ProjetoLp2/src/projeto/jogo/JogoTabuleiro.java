package projeto.jogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import projeto.Item;

/**
 * Classe correspondente a um jogo de tabuleiro, um tipo de item que pode ser
 * emprestado
 * 
 * @author igoratf
 */

public class JogoTabuleiro extends Item {
	private List<String> pecasPerdidas;
	private boolean completo;

	/**
	 * Construtor de um jogo de tabuleiro
	 * 
	 * @param nome
	 *            é o nome do jogo
	 * @param valor
	 *            é o valor do jogo
	 */
	public JogoTabuleiro(String nome, double valor) {
		super(nome, valor);
		this.completo = true;
		this.pecasPerdidas = new ArrayList<String>();

	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (completo ? 1231 : 1237);
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoTabuleiro other = (JogoTabuleiro) obj;
		if (completo != other.completo)
			return false;
		if (pecasPerdidas == null) {
			if (other.pecasPerdidas != null)
				return false;
		} else if (!pecasPerdidas.equals(other.pecasPerdidas))
			return false;
		return true;
	}

	/**
	 * Verifica se existem peças perdidas no jogo de tabuleiro
	 * 
	 * @return completo ou com peças perdidas
	 */
	public String existePecasPerdidas() {
		if (pecasPerdidas.size() > 0) {
			return "COM PECAS PERDIDAS";
		}
		return "COMPLETO";
	}

	/**
	 * Adiciona uma peça perdida à lista de peças perdidas
	 * 
	 * @param pecaPerdida
	 */
	public void adicionarPecaPerdida(String pecaPerdida) {
		this.pecasPerdidas.add(pecaPerdida);
	}

	public List<String> getPecasPerdidas() {
		return this.pecasPerdidas;
	}

	@Override
	public String toString() {
		return String.format("JOGO DE TABULEIRO: %s, R$ %.1f, %s, %s", getNome(), getValor(), getEstado(),
				existePecasPerdidas());
	}

}
