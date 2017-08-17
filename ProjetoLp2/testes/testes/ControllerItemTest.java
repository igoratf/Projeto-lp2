package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.ControllerItem;
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
	ControllerItem cItem = new ControllerItem(sistema);

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
		cItem.cadastrarBluRayFilme("Magaiver", "333", "Star Wars", 80.00, 200, "AVENTURA", "LIVRE", 1969);
		assertEquals("Star Wars", cItem.getInfoItem("Magaiver", "333", "Star Wars", "Nome"));
		assertEquals("80.0", cItem.getInfoItem("Magaiver", "333", "Star Wars", "Preco"));
		/*
		 * Verifica se preço inválido está retornando exceção, o que é válido para todos
		 * os tipos de Bluray
		 */
		try {
			cItem.cadastrarBluRayFilme("Magaiver", "333", "Harry Potter", -1, 200, "AVENTURA", "LIVRE", 1969);
		} catch (Exception e) {
			assertEquals("Preco invalido", e.getMessage());
		}
		/*
		 * Verifica se preço inválido está retornando exceção, o que é válido para todos
		 * os tipos de Bluray
		 */
		try {
			cItem.cadastrarBluRayFilme("Magaiver", "333", "Senhor dos Aneis", 200.00, -3, "AVENTURA", "LIVRE", 1969);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se duração menor ou igual a 0 está retornando exceção, o que é
		 * válido para todos os tipos de Bluray
		 */
		try {
			cItem.cadastrarBluRayFilme("Magaiver", "333", "MIB", 22.00, -2, "FICCAO", "LIVRE", 2002);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se gênero nulo está retornando exceção
		 */
		try {
			cItem.cadastrarBluRayFilme("Magaiver", "333", "MIB", 99.0, 120, null, "LIVRE", 2002);
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
		cItem.cadastrarBlurayShow("Magaiver", "333", "Show do Tom", 20.00, 80, 3, "Tom", "LIVRE");
		assertEquals("Show do Tom", cItem.getInfoItem("Magaiver", "333", "Show do Tom", "Nome"));
		assertEquals("20.0", cItem.getInfoItem("Magaiver", "333", "Show do Tom", "Preco"));
		try {
			cItem.cadastrarBlurayShow("Magaiver", "333", "Show do Rafinha", 20.00, 80, -2, "Rafinha Bastos",
					"DEZESSEIS_ANOS");
		} catch (Exception e) {
			assertEquals("Numero de faixas invalido", e.getMessage());
		}
		try {
			cItem.cadastrarBlurayShow("Magaiver", "333", "Show do Angra", 99.00, 180, 3, "", "LIVRE");
		} catch (Exception e) {
			assertEquals("Nome do artista vazio", e.getMessage());
		}
		try {
			cItem.cadastrarBlurayShow("Magaiver", "333", "Show do Angra", 99.00, 180, 10, null, "LIVRE");
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
		cItem.cadastrarBluraySerie("Magaiver", "333", "Game of Thrones", 999.00, "Melhor série", 90, "DEZESSEIS_ANOS",
				"AVENTURA", 7);
		assertEquals("Game of Thrones", cItem.getInfoItem("Magaiver", "333", "Game of Thrones", "Nome"));
		assertEquals("999.0", cItem.getInfoItem("Magaiver", "333", "Game of Thrones", "Preco"));
		/*
		 * Verifica se descrição vazia está retornando exceção
		 */
		try {
			cItem.cadastrarBluraySerie("Magaiver", "333", "The Walking Dead", 80.00, "", 120, "LIVRE", "AVENTURA", 1);
		} catch (Exception e) {
			assertEquals("Descricao vazia", e.getMessage());
		}
		/*
		 * Verifica se descrição nula está retornando exceção
		 */
		try {
			cItem.cadastrarBluraySerie("Magaiver", "333", "Breaking Bad", 200.0, null, 120, "LIVRE", "ACAO", 2);
		} catch (Exception e) {
			assertEquals("Descricao nula", e.getMessage());
		}
		/*
		 * Verifica se temporada menor ou igual a 0 está retornando exceção
		 */
		try {
			cItem.cadastrarBluraySerie("Magaiver", "333", "House of Cards", 80.00, "Politics", 120, "LIVRE", "OUTRO",
					-2);
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
		cItem.cadastrarBluraySerie("Magaiver", "333", "Game of Thrones", 99.00, "Sabe de nada Jon Snow", 200, "LIVRE",
				"AVENTURA", 7);
		BluraySeries bluray = (BluraySeries) cItem.getItem("Magaiver", "333", "Game of Thrones");
		assertEquals(false, bluray.contemEpisodio());
		cItem.adicionarBluray("Magaiver", "333", "Game of Thrones", 60);
		assertEquals(true, bluray.contemEpisodio());
		/*
		 * Verifica se a tentativa de adicionar um episódio com duração menor ou igual a
		 * 0 está retornando exceção
		 */
		try {
			cItem.adicionarBluray("Magaiver", "333", "Game of Thrones", 0);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se a tentativa de adicionar um episódio a uma série não existente
		 * está retornando exceção
		 */
		try {
			cItem.adicionarBluray("Magaiver", "333", "The Get Down", 20);
		} catch (Exception e) {
			assertEquals("Item nao encontrado", e.getMessage());
		}
	}

}
