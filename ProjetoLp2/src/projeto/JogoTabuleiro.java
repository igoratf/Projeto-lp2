package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		this.pecasPerdidas = pecasPerdidas;
		this.completo = completo;
	}
	
	/**
	 * Método que compara uma lista de peças perdidas com a lista de peças perdidas do jogo
	 * @param lista é a lista de peças perdidas
	 * @return boolean correspondente ao resultado da comparação
	 */
	public boolean comparaPecasPerdidas(List<String> lista) {
		Collections.sort(lista);
		Collections.sort(pecasPerdidas);
		for (int i=0; i<lista.size(); i++) {
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
	
	public String haPecasPerdidas(){
		if(pecasPerdidas.size() > 0){
			return "COM PECAS PERDIDAS";
		} return "COMPLETO";
	}
	
	/**
	 * Adiciona uma peça perdida à lista de peças perdidas
	 * @param pecaPerdida
	 */
	public void adicionarPecaPerdida(String pecaPerdida) {
		this.pecasPerdidas.add(pecaPerdida);
	}
	
	@Override
	public String toString(){
		return String.format("JOGO DE TABULEIRO: %s, R$ %.1f, %s, %s|", getNome(),getValor(),getEstado(),haPecasPerdidas());
	}

}
