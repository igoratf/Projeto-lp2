import static org.junit.Assert.*;

import org.junit.Test;

import projeto.BlurayFilme;
import projeto.ControllerItem;

public class ControllerItemTest {
	ControllerItem controller = new ControllerItem();
	
	
	@Test
	public void getInfoTest() {
		controller.cadastrarBluRaySerie("The Walking Dead", 70.00, "Zumbis", 60, "DEZESSEIS_ANOS", "SUSPENSE", 1);
		assertEquals("The Walking Dead", controller.getInfoItem("The Walking Dead", "Nome"));
		assertEquals("70.0", controller.getInfoItem("The Walking Dead", "Preco"));
	}

	@Test
	public void atualizarItemTest() {
		controller.cadastrarEletronico("Pokemon Emerald", 40.00, "OUTRO");
		controller.atualizarItem("Pokemon Emerald", "Nome", "Pokemon Ruby");
		assertEquals(controller.getInfoItem("Pokemon Ruby", "Nome"), "Pokemon Ruby");
	}
	
	@Test
	public void removerItemTest() {
		controller.cadastrarEletronico("Pokemon Sun", 80.00, "NINTENDO_3DS");
		assertEquals(controller.getInfoItem("Pokemon Sun", "Nome"), "Pokemon Sun");
		controller.removerItem("Pokemon Sun");
		try {
			controller.getInfoItem("Pokemon Sun", "Nome");
		} catch (Exception e) {
			assertEquals("Item nao encontrado", e.getMessage());
		}
	}
	
	@Test
	public void pesquisarDetalhesItemTest() {
		controller.cadastrarBluRayFilme("Avengers", 1.99, 120, "ACAO", "QUATORZE_ANOS", 2016);
		assertEquals("FILME: Avengers, R$ 1.99, Nao emprestado, 120 min, QUATORZE_ANOS, ACAO, 2016", controller.pesquisarDetalhesItem("Avengers"));
		
	}

}
