package testes.cartoes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import projeto.cartao.Caloteiro;

/**
 * Classe de Testes do Cartão Caloteiro.
 * 
 * @author caiosbl
 *
 */

public class CaloteiroTest {
	private Caloteiro caloteiro;

	@Before
	public void instancia() {
		caloteiro = new Caloteiro();
	}

	/**
	 * Testa se o método retorna true para emprestimo liberado.
	 */
	@Test

	public void emprestimoLiberadoTest() {
		assertFalse(caloteiro.emprestimoLiberado());
	}

	/**
	 * Testa se o período de empréstimo recebido é validado corretamente de acordo
	 * com o cartão.
	 * 
	 * @param periodo
	 */
	@Test
	public void validaPeriodo() {

		assertFalse(caloteiro.validaPeriodo(15));
		assertFalse(caloteiro.validaPeriodo(13));
		assertFalse(caloteiro.validaPeriodo(12));
		assertFalse(caloteiro.validaPeriodo(11));
		assertFalse(caloteiro.validaPeriodo(10));
		assertFalse(caloteiro.validaPeriodo(9));
		assertFalse(caloteiro.validaPeriodo(8));
		assertFalse(caloteiro.validaPeriodo(7));
		assertFalse(caloteiro.validaPeriodo(6));
		assertFalse(caloteiro.validaPeriodo(5));
		assertFalse(caloteiro.validaPeriodo(4));
		assertFalse(caloteiro.validaPeriodo(3));
		assertFalse(caloteiro.validaPeriodo(2));
		assertFalse(caloteiro.validaPeriodo(1));
	}

	/**
	 * Testa se o método retorna corretamente a representação em string do cartão.
	 * 
	 * @return
	 */
	@Test
	public void getTipoTest() {
		assertEquals("Caloteiro", caloteiro.getTipo());

	}

}
