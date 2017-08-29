package testes.blurays;
import static org.junit.Assert.*;

import org.junit.Test;

import projeto.bluray.Bluray;
/**
 * Classe de teste de Bluray
 * @author igoratf
 *
 */
public class BlurayTest {

	/**
	 * Verifica se parâmetros nulos estão retornando exceção
	 */
	@Test
	public void BlurayNullTest() {
		try {
			Bluray bluray = new Bluray(null, 20, 30, "Desc");
		} catch (Exception e) {
			assertEquals("Nome nulo", e.getMessage());
		}
		try {
			Bluray bluray = new Bluray("Nome", 20.00, 200, null);
		} catch (Exception e) {
			assertEquals("Classificacao nula", e.getMessage());
		}
		

	}
	
	/**
	 * Verifica se nome e classificação vazios estão retornando exceção
	 */
	@Test
	public void BlurayVazioTest() {
		try {
			Bluray bluray = new Bluray("", 200, 200, "Desc");
		} catch (Exception e) {
			assertEquals("Nome vazio", e.getMessage());
		}
		try {
			Bluray bluray = new Bluray("Nome", 200, 200, "");
		} catch (Exception e) {
			assertEquals("Classificacao vazia", e.getMessage());
		}
	}
	
	/**
	 * Verifica se números inválidos estão retornando exceção
	 */
	@Test
	public void BlurayNumbersTest() {
		try {
			Bluray bluray = new Bluray("Nome", -3, 200, "Desc");
		} catch (Exception e) {
			assertEquals("Valor invalido", e.getMessage());
		}
		try {
			Bluray bluray = new Bluray("Nome", 60.00, 0, "Desc");
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
	}
}
