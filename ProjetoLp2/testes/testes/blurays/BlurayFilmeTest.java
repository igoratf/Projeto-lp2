package testes.blurays;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.bluray.BlurayFilme;
/**
 * Testes de BlurayFilme
 * 
 * @author caiosbl
 *
 */


public class BlurayFilmeTest {

	private BlurayFilme blurayFilme;

	/**
	 * Instancia um BlurayFilme
	 */
	@Before
	public void instanciaBlurayFilme() {
		blurayFilme = new BlurayFilme("Avatar", 10.50, 60, "LIVRE", "ACAO", 2010);
	}

	/**
	 * Testa se as devidas exceções são lançadas ao criar-se um blurayFilme com
	 * parâmetros inválidos.
	 */
	@Test
	public void criaBlurayFilmeInvalidoTest() {
		try {
			blurayFilme = new BlurayFilme("", 10.50, 60, "LIVRE", "ACAO", 2010);
			fail("Exceção de Nome Vazio não lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Nome vazio", e.getMessage());
		}
		try {
			blurayFilme = new BlurayFilme(null, 10.50, 60, "LIVRE", "ACAO", 2010);
			fail("Exceção de Nome Vazio não lançada");
		} catch (NullPointerException e) {
			assertEquals("Nome nulo", e.getMessage());
		}
		try {
			blurayFilme = new BlurayFilme("Avatar", 0, 60, "LIVRE", "ACAO", 2010);
			fail("Exceção de Valor invalido não lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Valor invalido", e.getMessage());
		}
		try {
			blurayFilme = new BlurayFilme("Avatar", 10.50, 0, "LIVRE", "ACAO", 2010);
			fail("Exceção de Duração invalida não lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		try {
			blurayFilme = new BlurayFilme("Avatar", 10.50, 60, "LIVRE", "ACAO", 0);
			fail("Exceção de Ano invalido não lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Ano invalido", e.getMessage());
		}

	}
	/**
	 * Testa o método equals.
	 */
	@Test
	public void equalsTest(){
		BlurayFilme teste = new BlurayFilme("Avatar", 10.50, 60, "LIVRE", "ACAO", 2010);
		assertTrue(teste.equals(blurayFilme));
	}
	/**
	 * Testa o método toString
	 */
	@Test
	public void toStringTest(){
		assertEquals("FILME: Avatar, R$ 10,50, Nao emprestado, 60 min, LIVRE, ACAO, 2010",blurayFilme.toString());
	}

}
