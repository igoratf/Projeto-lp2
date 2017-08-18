package testes;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import projeto.ControllerItem;
import projeto.Item;
import projeto.Sistema;
import projeto.bluray.BluraySeries;

/**
 * Classe de testes da classe ControllerItem
 * 
 * @author igoratf
 *
 */
public class ControllerItemTest {
	Sistema sistema = new Sistema();
	ControllerItem cItem = new ControllerItem();

	/**
	 * Cria um usuário de nome "Magaiver", telefone "333" e email
	 * "magaiver@magaiver.com" para ser inicializado antes de cada teste
	 */
	@Before
	public void setup() {
		sistema.cadastrarUsuario("Magaiver", "333", "magaiver@magaiver.com");
		
	}

	/**
	 * Verifica se o cadastramento de um BlurayFilme está ocorrendo corretamente e
	 * retornando as devidas exceções em caso de parâmetro inválido
	 */
	@Test
	public void cadastrarBlurayFilmeTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarBluRayFilme("Star Wars", 80.00, 200, "AVENTURA", "LIVRE", 1969, mapaItens);
		assertEquals("Star Wars", cItem.getInfoItem("Star Wars", "Nome", mapaItens));
		assertEquals("80.0", cItem.getInfoItem("Star Wars", "Preco", mapaItens));
		/*
		 * Verifica se preço inválido está retornando exceção, o que é válido para todos
		 * os tipos de Bluray
		 */
		try {
			cItem.cadastrarBluRayFilme("Harry Potter", -1, 200, "AVENTURA", "LIVRE", 1969, mapaItens);
		} catch (Exception e) {
			assertEquals("Preco invalido", e.getMessage());
		}
		/*
		 * Verifica se preço inválido está retornando exceção, o que é válido para todos
		 * os tipos de Bluray
		 */
		try {
			cItem.cadastrarBluRayFilme("Senhor dos Aneis", 200.00, -3, "AVENTURA", "LIVRE", 1969, mapaItens);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se duração menor ou igual a 0 está retornando exceção, o que é
		 * válido para todos os tipos de Bluray
		 */
		try {
			cItem.cadastrarBluRayFilme("MIB", 22.00, -2, "FICCAO", "LIVRE", 2002, mapaItens);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se gênero nulo está retornando exceção
		 */
		try {
			cItem.cadastrarBluRayFilme("MIB", 99.0, 120, null, "LIVRE", 2002, mapaItens);
		} catch (Exception e) {
			assertEquals("Genero nulo", e.getMessage());
		}
	}

	/**
	 * Verifica se o cadastramento de um BlurayShow está ocorrendo corretamente e
	 * lançando as devidas exceções em caso de parâmetros inválidos
	 */
	@Test
	public void cadastrarBlurayShowTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarBlurayShow("Show do Tom", 20.00, 80, 3, "Tom", "LIVRE", mapaItens);
		assertEquals("Show do Tom", cItem.getInfoItem("Show do Tom", "Nome", mapaItens));
		assertEquals("20.0", cItem.getInfoItem("Show do Tom", "Preco", mapaItens));
		try {
			cItem.cadastrarBlurayShow("Show do Rafinha", 20.00, 80, -2, "Rafinha Bastos",
					"DEZESSEIS_ANOS", mapaItens);
		} catch (Exception e) {
			assertEquals("Numero de faixas invalido", e.getMessage());
		}
		try {
			cItem.cadastrarBlurayShow("Show do Angra", 99.00, 180, 3, "", "LIVRE", mapaItens);
		} catch (Exception e) {
			assertEquals("Nome do artista vazio", e.getMessage());
		}
		try {
			cItem.cadastrarBlurayShow("Show do Angra", 99.00, 180, 10, null, "LIVRE", mapaItens);
		} catch (Exception e) {
			assertEquals("Nome do artista nulo", e.getMessage());
		}
	}

	/**
	 * Verifica se o cadastramento de um BluraySerie está ocorrendo corretamente e
	 * lançando as devidas exceções em caso de parâmetros inválidos
	 */
	@Test
	public void cadastrarBluraySerieTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarBluraySerie("Game of Thrones", 999.00, "Melhor série", 90, "DEZESSEIS_ANOS",
				"AVENTURA", 7, mapaItens);
		assertEquals("Game of Thrones", cItem.getInfoItem("Game of Thrones", "Nome", mapaItens));
		assertEquals("999.0", cItem.getInfoItem("Game of Thrones", "Preco", mapaItens));
		/*
		 * Verifica se descrição vazia está retornando exceção
		 */
		try {
			cItem.cadastrarBluraySerie("The Walking Dead", 80.00, "", 120, "LIVRE", "AVENTURA", 1, mapaItens);
		} catch (Exception e) {
			assertEquals("Descricao vazia", e.getMessage());
		}
		/*
		 * Verifica se descrição nula está retornando exceção
		 */
		try {
			cItem.cadastrarBluraySerie("Breaking Bad", 200.0, null, 120, "LIVRE", "ACAO", 2, mapaItens);
		} catch (Exception e) {
			assertEquals("Descricao nula", e.getMessage());
		}
		/*
		 * Verifica se temporada menor ou igual a 0 está retornando exceção
		 */
		try {
			cItem.cadastrarBluraySerie("House of Cards", 80.00, "Politics", 120, "LIVRE", "OUTRO",
					-2, mapaItens);
		} catch (Exception e) {
			assertEquals("Temporada invalida", e.getMessage());
		}
	}

	/**
	 * Verifica se a adição de um BlurayEpisodio a um BluraySerie está ocorrendo
	 * corretamente
	 */
	@Test
	public void adicionarBlurayTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarBluraySerie("Game of Thrones", 99.00, "Sabe de nada Jon Snow", 200, "LIVRE",
				"AVENTURA", 7, mapaItens);
		BluraySeries bluray = (BluraySeries) cItem.getItem("Game of Thrones", mapaItens);
		assertEquals(false, bluray.contemEpisodio());
		cItem.adicionarBluray("Game of Thrones", 60, mapaItens);
		assertEquals(true, bluray.contemEpisodio());
		/*
		 * Verifica se a tentativa de adicionar um episódio com duração menor ou igual a
		 * 0 está retornando exceção
		 */
		try {
			cItem.adicionarBluray("Game of Thrones", 0, mapaItens);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se a tentativa de adicionar um episódio a uma série não existente
		 * está retornando exceção
		 */
		try {
			cItem.adicionarBluray("The Get Down", 20, mapaItens);
		} catch (Exception e) {
			assertEquals("Item nao encontrado", e.getMessage());
		}
	}

}
