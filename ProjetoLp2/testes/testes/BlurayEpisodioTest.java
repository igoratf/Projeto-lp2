package testes;
import static org.junit.Assert.*;

import org.junit.Test;

import projeto.bluray.BlurayEpisodio;
/**
 * Classe de teste de BlurayEpisodio
 * @author igoratf
 *
 */
public class BlurayEpisodioTest {
	
	/**
	 * Verifica se duração inválida está retornando exceção
	 */
	@Test
	public void BlurayEpisodioTest() {
		try {
			BlurayEpisodio bluray = new BlurayEpisodio(0);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		try {
			BlurayEpisodio bluray = new BlurayEpisodio(-5);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
	}

}
