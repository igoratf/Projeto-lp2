package testes.cartoes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import projeto.cartao.BomAmigo;

/**
 * Classe de Testes do Cartão Bom Amigo.
 * 
 * @author caiosbl
 *
 */

public class BomAmigoTest {
	private BomAmigo bomAmigo;

	@Before
	public void instancia() {
		this.bomAmigo = new BomAmigo();
	}

	/**
	 * Testa se o método retorna true para emprestimo liberado.
	 */
	@Test
	public void emprestimoLiberadoTest() {
		assertTrue(bomAmigo.emprestimoLiberado());
	}

	/**
	 * Testa se o período de empréstimo recebido é validado corretamente de acordo
	 * com o cartão.
	 * 
	 * @param periodo
	 */
	@Test
	public void validaPeriodo() {

		assertFalse(bomAmigo.validaPeriodo(15));
		assertTrue(bomAmigo.validaPeriodo(13));
		assertTrue(bomAmigo.validaPeriodo(12));
		assertTrue(bomAmigo.validaPeriodo(11));
		assertTrue(bomAmigo.validaPeriodo(10));
		assertTrue(bomAmigo.validaPeriodo(9));
		assertTrue(bomAmigo.validaPeriodo(8));
		assertTrue(bomAmigo.validaPeriodo(7));
		assertTrue(bomAmigo.validaPeriodo(6));
		assertTrue(bomAmigo.validaPeriodo(5));
		assertTrue(bomAmigo.validaPeriodo(4));
		assertTrue(bomAmigo.validaPeriodo(3));
		assertTrue(bomAmigo.validaPeriodo(2));
		assertTrue(bomAmigo.validaPeriodo(1));

	}

	/**
	 * Testa se o método retorna corretamente a representação em string do cartão.
	 * 
	 * @return
	 */
	@Test
	public void getTipoTest() {
		assertEquals("BomAmigo", bomAmigo.getTipo());

	}

}
