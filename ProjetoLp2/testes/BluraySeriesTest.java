import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.BlurayEpisodio;
import projeto.BluraySeries;

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

}
