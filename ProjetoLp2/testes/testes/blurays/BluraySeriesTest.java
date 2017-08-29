package testes.blurays;
import static org.junit.Assert.*;


import org.junit.Test;

import projeto.bluray.BlurayEpisodio;
import projeto.bluray.BluraySeries;
/**
 * Classe de teste de BluraySeries
 * @author igoratf
 *
 */
public class BluraySeriesTest {
	
	BluraySeries bluraySerie = new BluraySeries("Game of Thrones", 90.00, 120, "Melhor série", "DEZESSEIS_ANOS", "AVENTURA", 7);

	/**
	 * Verifica se os blurays de episódio estão sendo adicionados corretamente à lista de blurays
	 */
	@Test
	public void adicionarBlurayTest() {
		BlurayEpisodio episodio1 = new BlurayEpisodio(50);
		bluraySerie.adicionarBluray(episodio1);
		assertEquals(1, bluraySerie.getTamanho());
		BlurayEpisodio episodio2 = new BlurayEpisodio(55);
		BlurayEpisodio episodio3 = new BlurayEpisodio(55);
		bluraySerie.adicionarBluray(episodio2);
		bluraySerie.adicionarBluray(episodio3);
		assertEquals(3, bluraySerie.getTamanho());
	}
	
	/**
	 * Verifica se o método que diz se o bluray contém episódios está funcionando corretamente
	 */
	@Test
	public void contemEpisodioTest() {
		BluraySeries bluraySerie2 = new BluraySeries("House of Cards", 90.00, 120, "Massa demais", "DEZESSEIS_ANOS", "OUTRO", 5);
		assertEquals(false, bluraySerie2.contemEpisodio());
		BlurayEpisodio episodio1 = new BlurayEpisodio(60);
		bluraySerie2.adicionarBluray(episodio1);
		assertEquals(true, bluraySerie2.contemEpisodio());
	}
	
	/**
	 * Verifica se parâmetros nulos estão retornando exceção
	 */
	@Test
	public void BlurayNullTest() {
		try {
			BluraySeries bluraySerie3 = new BluraySeries(null,90.00, 120, "Serio","LIVRE", "OUTRO", 1);
		} catch (Exception e) {
			assertEquals("Nome nulo", e.getMessage());
		}
		try {
			BluraySeries bluraySerie3 = new BluraySeries("Get Down", 200.0, 120, "Serio", null, "OUTRO", 2);
		} catch (Exception e) {
			assertEquals("Classificacao nula", e.getMessage());
		}
		try {
			BluraySeries bluraySerie = new BluraySeries("GetDown", 200, 120, null, "LIVRE", "OUTRO", 2);
		} catch (Exception e) {
			assertEquals("Descricao nula", e.getMessage());
		}
	}
	
	/**
	 * Verifica se nome e classificação vazios estão retornando exceção
	 */
	@Test
	public void BlurayVazioTest() {
		try {
			BluraySeries bluray = new BluraySeries("", 90.00, 120, "Serio", "LIVRE", "OUTRO", 1);
		} catch (Exception e) {
			assertEquals("Nome vazio", e.getMessage());
		}
		try {
			BluraySeries bluray = new BluraySeries("Nome", 90.00, 120, "","LIVRE", "OUTRO", 1);
		} catch (Exception e) {
			assertEquals("Descricao vazia", e.getMessage());
		}
	}
	
	/**
	 * Verifica se números inválidos estão retornando exceção
	 */
	@Test
	public void BlurayNumbersTest() {
		try {
			BluraySeries bluray = new BluraySeries("Nome", -1, 120, "Serio", "LIVRE", "OUTRO", 1);
		} catch (Exception e) {
			assertEquals("Valor invalido", e.getMessage());
		}
		
		try {
			BluraySeries bluray = new BluraySeries("Nome", 90.00, -300, "Serio", "LIVRE", "OUTRO", 1);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
	}

}
