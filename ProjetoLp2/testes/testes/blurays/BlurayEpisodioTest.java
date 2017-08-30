package testes.blurays;
import static org.junit.Assert.*;

import org.junit.Test;

import projeto.bluray.BlurayEpisodio;
/**
 * Classe de teste de BlurayEpisodio
 * @author igoratf
 *
 */
public class BlurayEpisodioTest {
	@SuppressWarnings("unused")
	private BlurayEpisodio bluray;
	
	/**
	 * Verifica se duração inválida está retornando exceção
	 */
	@Test
	public void ConstrutorTest() {
		try {
			bluray = new BlurayEpisodio(0);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		try {
			bluray = new BlurayEpisodio(-5);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
	}

}
