package testes.jogos;

import static org.junit.Assert.*;

import org.junit.Test;

import projeto.jogo.JogoTabuleiro;

/**
 * Classe de teste de JogoTabuleiro
 * @author igoratf
 *
 */

public class JogoTabuleiroTest {
	JogoTabuleiro jogo = new JogoTabuleiro("Zombiecide", 300.0);

	/**
	 * Verifica se a verificação de peças perdidas e a adição de uma peça perdida estão ocorrendo corretamente
	 */
	
	@Test
	public void existePecasPerdidasTest() {
		assertEquals("COMPLETO", jogo.existePecasPerdidas());
		jogo.adicionarPecaPerdida("Token");
		assertEquals("COM PECAS PERDIDAS", jogo.existePecasPerdidas());
	}
	
}
