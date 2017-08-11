package testes;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.bluray.BlurayShow;
/**
 * Testes de BluRayShow
 * 
 * @author caiosbl
 *
 */

public class BlurayShowTest {
	private BlurayShow bluRay;

	@Before
	public void instanciaBlurayShow() {
		bluRay = new BlurayShow("Anitta Live", 199, 120, 20, "Anitta", "LIVRE");
	}

	/**
	 * Testa se o construtor de BluRayShow lança devidamente as exceções para parâmetros
	 * inválidos.
	 */
	@Test
	public void criaBlurayShowInvalidoTest() {

		try {
			bluRay = new BlurayShow("", 199, 120, 20, "Anitta", "Livre");
			fail("Exceção de Nome Vazio não lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Nome vazio", e.getMessage());
		}
		try {
			bluRay = new BlurayShow(null, 199, 120, 20, "Anitta", "Livre");
			fail("Exceção de Nome Vazio não lançada");
		} catch (NullPointerException e) {
			assertEquals("Nome nulo", e.getMessage());
		}
		try {
			bluRay = new BlurayShow("AN LIVE", 0, 120, 20, "Anitta", "LIVRE");
			fail("Exceção de Valor invalido não lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Valor invalido", e.getMessage());
		}
		try {
			bluRay = new BlurayShow("AN LIVE", 20, 0, 20, "Anitta", "LIVRE");
			fail("Exceção de Duração invalida não lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		try {
			bluRay = new BlurayShow("AN LIVE", 20, 100, 0, "Anitta", "LIVRE");
			fail("Exceção de Numero de faixas invalida não lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Numero de faixas invalido", e.getMessage());
		}
		try {
			bluRay = new BlurayShow("AN LIVE", 20, 100, 5, "" + "", "LIVRE");
			fail("Exceção de Duração invalida não lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Nome do artista vazio", e.getMessage());
		}
		try {
			bluRay = new BlurayShow("AN LIVE", 20, 100, 5, null, "LIVRE");
			fail("Exceção de Duração invalida não lançada");
		} catch (NullPointerException e) {
			assertEquals("Nome do artista nulo", e.getMessage());
		}

	}
	/**
	 * Testa o método equals.
	 */
	@Test
	public void equalsTest(){
		BlurayShow bluRay1 = new BlurayShow("Anitta Live", 199, 120, 20, "Anitta", "LIVRE");
		assertTrue(bluRay.equals(bluRay1));
	}
	/**
	 * Testa o método toString.
	 */
	@Test
	public void toStringTest(){
		assertEquals("SHOW: Anitta Live, R$ 199,00, Nao emprestado, 120 min, LIVRE, Anitta, 20 faixas",bluRay.toString());
	}

}
