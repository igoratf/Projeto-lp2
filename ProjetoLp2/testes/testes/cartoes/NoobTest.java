package testes.cartoes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import projeto.cartao.Noob;

/**
 * Classe de Testes do Cartão Free Ryder.
 * 
 * @author caiosbl
 *
 */

public class NoobTest {
	private Noob noob;

	@Before
	public void instancia() {
		noob = new Noob();
	}

	/**
	 * Testa se o método retorna true para emprestimo liberado.
	 */
	@Test

	public void emprestimoLiberadoTest() {
		assertTrue(noob.emprestimoLiberado());
	}

	/**
	 * Testa se o período de empréstimo recebido é validado corretamente de acordo
	 * com o cartão.
	 * 
	 * @param periodo
	 */
	@Test
	public void validaPeriodo() {

		assertFalse(noob.validaPeriodo(8));
		assertTrue(noob.validaPeriodo(7));
		assertTrue(noob.validaPeriodo(6));
		assertTrue(noob.validaPeriodo(5));
		assertTrue(noob.validaPeriodo(4));
		assertTrue(noob.validaPeriodo(3));
		assertTrue(noob.validaPeriodo(2));
		assertTrue(noob.validaPeriodo(1));
	}

	/**
	 * Testa se o método retorna corretamente a representação em string do cartão.
	 * 
	 * @return
	 */
	@Test
	public void getTipoTest() {
		assertEquals("Noob", noob.getTipo());

	}

}
