package testes;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import projeto.Item;
import projeto.Sistema;
import projeto.bluray.BluraySeries;
import projeto.controllers.ControllerItem;
import projeto.controllers.ControllerUsuario;
import projeto.jogo.JogoTabuleiro;

public class Testes_Igor {
	Sistema sistema = new Sistema();

	@Before
	public void setup() {
		sistema.cadastrarUsuario("Magaiver", "333", "magaiver@gmail.com");
	}

	/**
	 * Testa o cadastramento de um BlurayFilme
	 */
	@Test
	public void cadastrarBlurayFilmeTest() {
		sistema.cadastrarBluRayFilme("Magaiver", "333", "Star Wars", 80.00, 200, "AVENTURA", "LIVRE", 1969);
		assertEquals("Star Wars", sistema.getInfoItem("Magaiver", "333", "Star Wars", "Nome"));
		assertEquals("80.0", sistema.getInfoItem("Magaiver", "333", "Star Wars", "Preco"));
		/*
		 * Verifica se preço inválido está retornando exceção, o que é válido
		 * para todos os tipos de Bluray
		 */
		try {
			sistema.cadastrarBluRayFilme("Magaiver", "333", "Harry Potter", -1, 200, "AVENTURA", "LIVRE", 1969);
		} catch (Exception e) {
			assertEquals("Preco invalido", e.getMessage());
		}
		/*
		 * Verifica se preço inválido está retornando exceção, o que é válido
		 * para todos os tipos de Bluray
		 */
		try {
			sistema.cadastrarBluRayFilme("Magaiver", "333", "Senhor dos Aneis", 200.00, -3, "AVENTURA", "LIVRE", 1969);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se duração menor ou igual a 0 está retornando exceção, o que
		 * é válido para todos os tipos de Bluray
		 */
		try {
			sistema.cadastrarBluRayFilme("Magaiver", "333", "MIB", 22.00, -2, "FICCAO", "LIVRE", 2002);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se gênero nulo está retornando exceção
		 */
		try {
			sistema.cadastrarBluRayFilme("Magaiver", "333", "MIB", 99.0, 120, null, "LIVRE", 2002);
		} catch (Exception e) {
			assertEquals("Genero nulo", e.getMessage());
		}
	}

	/**
	 * Testa o cadastramento de um BlurayShow
	 */
	@Test
	public void cadastrarBluRayShowTest() {
		sistema.cadastrarBluRayShow("Magaiver", "333", "Show do Tom", 20.00, 80, 3, "Tom", "LIVRE");
		assertEquals("Show do Tom", sistema.getInfoItem("Magaiver", "333", "Show do Tom", "Nome"));
		assertEquals("20.0", sistema.getInfoItem("Magaiver", "333", "Show do Tom", "Preco"));
		try {
			sistema.cadastrarBluRayShow("Magaiver", "333", "Show do Rafinha", 20.00, 80, -2, "Rafinha Bastos",
					"DEZESSEIS_ANOS");
		} catch (Exception e) {
			assertEquals("Numero de faixas invalido", e.getMessage());
		}
		try {
			sistema.cadastrarBluRayShow("Magaiver", "333", "Show do Angra", 99.00, 180, 3, "", "LIVRE");
		} catch (Exception e) {
			assertEquals("Nome do artista vazio", e.getMessage());
		}
		try {
			sistema.cadastrarBluRayShow("Magaiver", "333", "Show do Angra", 99.00, 180, 10, null, "LIVRE");
		} catch (Exception e) {
			assertEquals("Nome do artista nulo", e.getMessage());
		}
	}

	/**
	 * Testa o cadastramento de um BluraySerie
	 */
	@Test
	public void cadastrarBluRaySerieTest() {
		sistema.cadastrarBluRaySerie("Magaiver", "333", "Game of Thrones", 999.00, "Melhor série", 90, "DEZESSEIS_ANOS",
				"AVENTURA", 7);
		assertEquals("Game of Thrones", sistema.getInfoItem("Magaiver", "333", "Game of Thrones", "Nome"));
		assertEquals("999.0", sistema.getInfoItem("Magaiver", "333", "Game of Thrones", "Preco"));
		/*
		 * Verifica se descrição vazia está retornando exceção
		 */
		try {
			sistema.cadastrarBluRaySerie("Magaiver", "333", "The Walking Dead", 80.00, "", 120, "LIVRE", "AVENTURA", 1);
		} catch (Exception e) {
			assertEquals("Descricao vazia", e.getMessage());
		}
		/*
		 * Verifica se descrição nula está retornando exceção
		 */
		try {
			sistema.cadastrarBluRaySerie("Magaiver", "333", "Breaking Bad", 200.0, null, 120, "LIVRE", "ACAO", 2);
		} catch (Exception e) {
			assertEquals("Descricao nula", e.getMessage());
		}
		/*
		 * Verifica se temporada menor ou igual a 0 está retornando exceção
		 */
		try {
			sistema.cadastrarBluRaySerie("Magaiver", "333", "House of Cards", 80.00, "Politics", 120, "LIVRE", "OUTRO",
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
	public void adicionarBluRayTest() {
		sistema.cadastrarBluRaySerie("Magaiver", "333","Game of Thrones", 99.00, "Sabe de nada Jon Snow", 200, "LIVRE", "AVENTURA", 7);
		Map<String, Item>  = sistema.getItensUsuario("Magaiver", "333");
		BluraySeries bluray = (BluraySeries) .get("Game of Thrones");
		assertEquals(false, bluray.contemEpisodio());
		sistema.adicionarBluRay("Magaiver", "333", "Game of Thrones", 60);
		assertEquals(true, bluray.contemEpisodio());
		/*
		 * Verifica se a tentativa de adicionar um episódio com duração menor ou
		 * igual a 0 está retornando exceção
		 */
		try {
			sistema.adicionarBluRay("Magaiver", "333", "Game of Thrones", 0);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se a tentativa de adicionar um episódio a uma série não
		 * existente está retornando exceção
		 */
		try {
			sistema.adicionarBluRay("Magaiver", "333", "The Get Down", 20);
		} catch (Exception e) {
			assertEquals("Item nao encontrado", e.getMessage());
		}
	}

	/**
	 * Testa o cadastramento de um jogo eletrônico
	 */

	@Test
	public void cadastrarEletronicoTest() {
		sistema.cadastrarEletronico("Magaiver", "333", "Pokemon Gold", 99.00, "PC");
		assertEquals("Pokemon Gold", sistema.getInfoItem("Magaiver", "333", "Pokemon Gold", "Nome"));
		assertEquals("99.0", sistema.getInfoItem("Magaiver", "333", "Pokemon Gold", "Preco"));
		/*
		 * Verifica se plataforma nula está lançando exceção
		 */
		try {
			sistema.cadastrarEletronico("Magaiver", "333", "Starcraft", 77.0, null);
		} catch (NullPointerException e) {
			assertEquals("Plataforma Nula", e.getMessage());
		}
		/*
		 * Verifica se plataforma vazia está lançando exceção
		 */
		try {
			sistema.cadastrarEletronico("Magaiver", "333", "Age of Empires", 80.50, "");
		} catch (IllegalArgumentException e) {
			assertEquals("Plataforma Vazia Invalida", e.getMessage());
		}
	}

	/**
	 * Verifica se o cadastro de um JogoTabuleiro está ocorrendo corretamente
	 */
	@Test
	public void cadastrarJogoTabuleiroTest() {
		sistema.cadastrarJogoTabuleiro("Magaiver", "333", "Zombiecide", 300.0);
		assertEquals("Zombiecide", sistema.getInfoItem("Magaiver", "333", "Zombiecide", "Nome"));
		assertEquals("300.0", sistema.getInfoItem("Magaiver", "333", "Zombiecide", "Preco"));
	}

	/**
	 * Verifica se a adição de uma peça perdida a um JogoTabuleiro está
	 * ocorrendo corretamente
	 */
	
	@Test
	public void adicionarPecaPerdidaTest() {
		Map<String, Item>   = sistema.getItensUsuario("Magaiver", "333");
		sistema.cadastrarJogoTabuleiro("Magaiver", "333", "King of Tokyo", 169.0);
		JogoTabuleiro jogo = (JogoTabuleiro) .get("King of Tokyo");
		assertEquals("COMPLETO", jogo.existePecasPerdidas());
		sistema.adicionarPecaPerdida("Magaiver", "333", "King of Tokyo", "Gigazaur");
		assertEquals("COM PECAS PERDIDAS", jogo.existePecasPerdidas());
		/*
		 * Verifica se a tentativa de adicionar uma peça perdida a um jogo que
		 * não foi cadastrado está lançando exceção
		 */
		try {
			sistema.adicionarPecaPerdida("Magaiver", "333", "Camel Cup", "Camelo azul");
		} catch (Exception e) {
			assertEquals("Jogo Inválido!", e.getMessage());
		}
	}

	/**
	 * Verifica se a atualização de informações de um item está ocorrendo
	 * corretamente
	 */

	@Test
	public void atualizarItemTest() {
		/*
		 * Verifica se a modificação do nome do item está ocorrendo
		 */
		sistema.cadastrarJogoTabuleiro("Magaiver", "333", "Mysterium", 200.0);
		assertEquals("Mysterium", sistema.getInfoItem("Magaiver", "333", "Mysterium", "Nome"));
		sistema.atualizarItem("Magaiver", "333", "Mysterium", "Nome", "Mysterium 2");
		assertEquals("Mysterium 2", sistema.getInfoItem("Magaiver", "333", "Mysterium 2", "Nome"));
		/*
		 * Verifica se a modificação do valor do item está ocorrendo
		 */
		assertEquals("200.0", sistema.getInfoItem("Magaiver", "333", "Mysterium 2", "Preco"));
		sistema.atualizarItem("Magaiver", "333", "Mysterium 2", "Preco", "250.0");
		assertEquals("250.0", sistema.getInfoItem("Magaiver", "333", "Mysterium 2", "Preco"));
	}

	/**
	 * Verifica se as informações dos itens estão sendo exibidas corretamente
	 */

	@Test
	public void getInfoItemTest() {
		sistema.cadastrarEletronico("Magaiver", "333", "SimCity 4", 90.0, "PC");
		assertEquals("SimCity 4", sistema.getInfoItem("Magaiver", "333", "SimCity 4", "Nome"));
		assertEquals("90.0", sistema.getInfoItem("Magaiver", "333", "SimCity 4", "Preco"));
		try {
			sistema.getInfoItem("Magaiver", "333", "SimCity 4", "Atributo");
		} catch (Exception e) {
			assertEquals("Atributo invalido", e.getMessage());
		}
	}

	/**
	 * Verifica se a representação textual de um item está sendo exibida
	 * corretamente
	 */

	@Test
	public void pesquisarDetalhesItemTest() {
		sistema.cadastrarJogoTabuleiro("Magaiver", "333", "Manilla", 300.0);
		assertEquals("JOGO DE TABULEIRO: Manilla, R$ 300.0, Nao emprestado, COMPLETO",
				sistema.pesquisarDetalhesItem("Magaiver", "333", "Manilla"));
		try {
			sistema.pesquisarDetalhesItem("Magaiver", "333", "Item");
		} catch (Exception e) {
			assertEquals("Item nao encontrado", e.getMessage());
		}
	}
}
