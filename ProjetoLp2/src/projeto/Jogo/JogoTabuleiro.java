package projeto.Jogo;

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
	private List<String> pecasPerdidas = new ArrayList<>();
	private boolean completo;

	public JogoTabuleiro(String nome, double valor) {
		super(nome, valor);
		this.completo = true;
	
	}

	/**
	 * Método que compara uma lista de peças perdidas com a lista de peças
	 * perdidas do jogo
	 * 
	 * @param lista
	 *            é a lista de peças perdidas
	 * @return boolean correspondente ao resultado da comparação
	 */
	public boolean comparaPecasPerdidas(List<String> lista) {
		Collections.sort(lista);
		Collections.sort(pecasPerdidas);
		for (int i = 0; i < lista.size(); i++) {
			if (!(lista.get(i).equals(pecasPerdidas.get(i)))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (completo ? 1231 : 1237);
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
		return result;
	}

	public boolean equals(JogoTabuleiro jogo) {
		if (jogo.getNome().equals(this.getNome()) && comparaPecasPerdidas(jogo.pecasPerdidas)) {
			return true;
		}
		return false;
	}
<<<<<<< HEAD:ProjetoLp2/src/projeto/JogoTabuleiro.java

=======
	
	public String existePecasPerdidas(){
		if(pecasPerdidas.size() > 0){
			return "COM PECAS PERDIDAS";
		} return "COMPLETO";
	}
	
>>>>>>> 4c13af4fbfddd82cffcf3b2be0c9e0412d4040cb:ProjetoLp2/src/projeto/Jogo/JogoTabuleiro.java
	/**
	 * Adiciona uma peça perdida à lista de peças perdidas
	 * 
	 * @param pecaPerdida
	 */
	public void adicionarPecaPerdida(String pecaPerdida) {
		this.pecasPerdidas.add(pecaPerdida);
	}
	
	@Override
	public String toString(){
		return String.format("JOGO DE TABULEIRO: %s, R$ %.1f, %s, %s", getNome(),getValor(),getEstado(),existePecasPerdidas());
	}

	public String completoToString() {

		if (this.completo) {
			return "COMPLETO";
		}

		return "COM PECAS PERDIDAS";
	}

	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + getNome() + ", R$ " + getValor() + ", " + estadoDeEmprestimoToString() + ", "
				+ completoToString() + "|";
	}

}
