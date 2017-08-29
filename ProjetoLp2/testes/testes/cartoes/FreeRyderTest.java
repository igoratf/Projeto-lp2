package testes.cartoes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import projeto.cartao.FreeRyder;

/**
 * Classe de Testes do Cartão Free Ryder.
 * 
 * @author caiosbl
 *
 */

public class FreeRyderTest {
	private FreeRyder freeRyder;

	@Before
	public void instancia() {
		freeRyder = new FreeRyder();
	}

	/**
	 * Testa se o método retorna true para emprestimo liberado.
	 */
	@Test

	public void emprestimoLiberadoTest() {
		assertTrue(freeRyder.emprestimoLiberado());
	}

	/**
	 * Testa se o período de empréstimo recebido é validado corretamente de acordo
	 * com o cartão.
	 * 
	 * @param periodo
	 */
	@Test
	public void validaPeriodo() {

		assertFalse(freeRyder.validaPeriodo(6));
		assertTrue(freeRyder.validaPeriodo(5));
		assertTrue(freeRyder.validaPeriodo(4));
		assertTrue(freeRyder.validaPeriodo(3));
		assertTrue(freeRyder.validaPeriodo(2));
		assertTrue(freeRyder.validaPeriodo(1));
	}

	/**
	 * Testa se o método retorna corretamente a representação em string do cartão.
	 * 
	 * @return
	 */
	@Test
	public void getTipoTest() {
		assertEquals("FreeRyder", freeRyder.getTipo());

	}

}
