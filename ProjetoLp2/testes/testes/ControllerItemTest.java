package testes;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import projeto.Item;
import projeto.Sistema;
import projeto.bluray.BluraySeries;
import projeto.controllers.ControllerItem;
import projeto.jogo.JogoTabuleiro;

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
	 * Verifica se o cadastramento de um BlurayFilme está ocorrendo corretamente
	 * e retornando as devidas exceções em caso de parâmetro inválido
	 */
	@Test
	public void cadastrarBlurayFilmeTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarBluRayFilme("Star Wars", 80.00, 200, "AVENTURA", "LIVRE", 1969, mapaItens);
		assertEquals("Star Wars", cItem.getInfoItem("Star Wars", "Nome", mapaItens));
		assertEquals("80.0", cItem.getInfoItem("Star Wars", "Preco", mapaItens));
		/*
		 * Verifica se preço inválido está retornando exceção, o que é válido
		 * para todos os tipos de Bluray
		 */
		try {
			cItem.cadastrarBluRayFilme("Harry Potter", -1, 200, "AVENTURA", "LIVRE", 1969, mapaItens);
		} catch (Exception e) {
			assertEquals("Preco invalido", e.getMessage());
		}
		/*
		 * Verifica se preço inválido está retornando exceção, o que é válido
		 * para todos os tipos de Bluray
		 */
		try {
			cItem.cadastrarBluRayFilme("Senhor dos Aneis", 200.00, -3, "AVENTURA", "LIVRE", 1969, mapaItens);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se duração menor ou igual a 0 está retornando exceção, o que
		 * é válido para todos os tipos de Bluray
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
	 * Verifica se o cadastramento de um BlurayShow está ocorrendo corretamente
	 * e lançando as devidas exceções em caso de parâmetros inválidos
	 */
	@Test
	public void cadastrarBlurayShowTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarBlurayShow("Show do Tom", 20.00, 80, 3, "Tom", "LIVRE", mapaItens);
		assertEquals("Show do Tom", cItem.getInfoItem("Show do Tom", "Nome", mapaItens));
		assertEquals("20.0", cItem.getInfoItem("Show do Tom", "Preco", mapaItens));
		try {
			cItem.cadastrarBlurayShow("Show do Rafinha", 20.00, 80, -2, "Rafinha Bastos", "DEZESSEIS_ANOS", mapaItens);
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
	 * Verifica se o cadastramento de um BluraySerie está ocorrendo corretamente
	 * e lançando as devidas exceções em caso de parâmetros inválidos
	 */
	@Test
	public void cadastrarBluraySerieTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarBluraySerie("Game of Thrones", 999.00, "Melhor série", 90, "DEZESSEIS_ANOS", "AVENTURA", 7,
				mapaItens);
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
			cItem.cadastrarBluraySerie("House of Cards", 80.00, "Politics", 120, "LIVRE", "OUTRO", -2, mapaItens);
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
		cItem.cadastrarBluraySerie("Game of Thrones", 99.00, "Sabe de nada Jon Snow", 200, "LIVRE", "AVENTURA", 7,
				mapaItens);
		BluraySeries bluray = (BluraySeries) cItem.getItem("Game of Thrones", mapaItens);
		assertEquals(false, bluray.contemEpisodio());
		cItem.adicionarBluray("Game of Thrones", 60, mapaItens);
		assertEquals(true, bluray.contemEpisodio());
		/*
		 * Verifica se a tentativa de adicionar um episódio com duração menor ou
		 * igual a 0 está retornando exceção
		 */
		try {
			cItem.adicionarBluray("Game of Thrones", 0, mapaItens);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se a tentativa de adicionar um episódio a uma série não
		 * existente está retornando exceção
		 */
		try {
			cItem.adicionarBluray("The Get Down", 20, mapaItens);
		} catch (Exception e) {
			assertEquals("Item nao encontrado", e.getMessage());
		}
	}

	/**
	 * Verifica se o cadastro de um JogoEletronico no Usuario está ocorrendo
	 * corretamente
	 */
	@Test
	public void cadastrarEletronicoTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarEletronico("Pokemon Gold", 99.00, "PC", mapaItens);
		assertEquals("Pokemon Gold", cItem.getInfoItem("Pokemon Gold", "Nome", mapaItens));
		assertEquals("99.0", cItem.getInfoItem("Pokemon Gold", "Preco", mapaItens));
		/*
		 * Verifica se plataforma nula está lançando exceção
		 */
		try {
			cItem.cadastrarEletronico("Starcraft", 77.0, null, mapaItens);
		} catch (NullPointerException e) {
			assertEquals("Plataforma Nula", e.getMessage());
		}
		/*
		 * Verifica se plataforma vazia está lançando exceção
		 */
		try {
			cItem.cadastrarEletronico("Age of Empires", 80.50, "", mapaItens);
		} catch (IllegalArgumentException e) {
			assertEquals("Plataforma Vazia Invalida", e.getMessage());
		}
	}

	/**
	 * Verifica se o cadastro de um JogoTabuleiro está ocorrendo corretamente
	 */
	@Test
	public void cadastrarJogoTabuleiroTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarJogoTabuleiro("Zombiecide", 300.0, mapaItens);
		assertEquals("Zombiecide", cItem.getInfoItem("Zombiecide", "Nome", mapaItens));
		assertEquals("300.0", cItem.getInfoItem("Zombiecide", "Preco", mapaItens));
	}

	/**
	 * Verifica se a adição de uma peça perdida a um JogoTabuleiro está
	 * ocorrendo corretamente
	 */
	@Test
	public void adicionarPecaPerdidaTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarJogoTabuleiro("King of Tokyo", 169.0, mapaItens);
		JogoTabuleiro jogo = (JogoTabuleiro) cItem.getItem("King of Tokyo", mapaItens);
		assertEquals("COMPLETO", jogo.existePecasPerdidas());
		cItem.adicionarPecaPerdida("King of Tokyo", "Gigazaur", mapaItens);
		assertEquals("COM PECAS PERDIDAS", jogo.existePecasPerdidas());
		/*
		 * Verifica se a tentativa de adicionar uma peça perdida a um jogo que
		 * não foi cadastrado está lançando exceção
		 */
		try {
			cItem.adicionarPecaPerdida("Camel Cup", "Camelo azul", mapaItens);
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
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		/*
		 * Verifica se a modificação do nome do item está ocorrendo
		 */
		cItem.cadastrarJogoTabuleiro("Mysterium", 200.0, mapaItens);
		assertEquals("Mysterium", cItem.getInfoItem("Mysterium", "Nome", mapaItens));
		cItem.atualizarItem("Mysterium", "Nome", "Mysterium 2", mapaItens);
		assertEquals("Mysterium 2", cItem.getInfoItem("Mysterium 2", "Nome", mapaItens));
		/*
		 * Verifica se a modificação do valor do item está ocorrendo
		 */
		assertEquals("200.0", cItem.getInfoItem("Mysterium 2", "Preco", mapaItens));
		cItem.atualizarItem("Mysterium 2", "Preco", "250.0", mapaItens);
		assertEquals("250.0", cItem.getInfoItem("Mysterium 2", "Preco", mapaItens));
	}

	/**
	 * Verifica se as informações dos itens estão sendo exibidas corretamente
	 */
	@Test
	public void getInfoItemTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarEletronico("SimCity 4", 90.0, "PC", mapaItens);
		assertEquals("SimCity 4", cItem.getInfoItem("SimCity 4", "Nome", mapaItens));
		assertEquals("90.0", cItem.getInfoItem("SimCity 4", "Preco", mapaItens));
		try {
			cItem.getInfoItem("SimCity 4", "Atributo", mapaItens);
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
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarJogoTabuleiro("Manilla", 300.0, mapaItens);
		assertEquals("JOGO DE TABULEIRO: Manilla, R$ 300.0, Nao emprestado, COMPLETO",
				cItem.pesquisarDetalhesItem("Manilla", mapaItens));
		try {
			cItem.pesquisarDetalhesItem("Item", mapaItens);
		} catch (Exception e) {
			assertEquals("Item nao encontrado", e.getMessage());
		}
	}

	/**
	 * Verifica se o empréstimo de um item está ocorrendo corretamente
	 */
	@Test
	public void emprestarItemTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarEletronico("The Sims 3", 70.0, "PC", mapaItens);
		cItem.emprestarItem("The Sims 3", mapaItens);
		Item meuItem = cItem.getItem("The Sims 3", mapaItens);
		assertEquals("Emprestado", meuItem.getEstado());
		assertEquals(1, meuItem.getNumEmprestimos());
		/*
		 * Verifica se a tentativa de emprestar um item já emprestado está
		 * retornando exceção
		 */
		try {
			cItem.emprestarItem("The Sims 3", mapaItens);
		} catch (Exception e) {
			assertEquals("Item emprestado no momento", e.getMessage());
		}
	}

	/**
	 * Verifica se a devolução de um item emprestado está ocorrendo corretamente
	 */
	@Test
	public void devolverItemTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarEletronico("The Sims 4", 70.0, "PC", mapaItens);
		cItem.emprestarItem("The Sims 4", mapaItens);
		Item meuItem = cItem.getItem("The Sims 4", mapaItens);
		assertEquals("Emprestado", meuItem.getEstado());
		cItem.devolverItem("The Sims 4", mapaItens);
		assertEquals("Nao emprestado", meuItem.getEstado());
		/*
		 * Verifica se a tentativa de devolução de um item não cadastrado está
		 * retornando exceção
		 */
		try {
			cItem.devolverItem("Age of Empires IV", mapaItens);
		} catch (Exception e) {
			assertEquals("Item nao encontrado", e.getMessage());
		}
	}

	/**
	 * Verifica se a listagem de itens ordenados por nome está ocorrendo
	 * corretamente
	 */
	@Test
	public void listarItensOrdenadosPorNomeTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarEletronico("Pokemon Ruby", 99.0, "PC", mapaItens);
		cItem.cadastrarJogoTabuleiro("Zombiecide", 300.0, mapaItens);
		List<Item> itensUsuarios = sistema.getItensUsuarios();
		assertEquals(
				"JOGO ELETRONICO: Pokemon Ruby, R$ 99.0, Nao emprestado, PC|JOGO DE TABULEIRO: Zombiecide, R$ 300.0, Nao emprestado, COMPLETO|",
				cItem.listarItensOrdenadosPorNome(itensUsuarios));
	}

	/**
	 * Verifica se a listagem de itens ordenados por valor está ocorrendo
	 * corretamente
	 */
	@Test
	public void listarItensOrdenadosPorValor() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarJogoTabuleiro("Dead of Winter", 300.0, mapaItens);
		cItem.cadastrarJogoTabuleiro("Sheriff of Nottingham", 179.0, mapaItens);
		cItem.cadastrarEletronico("Fifa 17", 79.99, "PS4", mapaItens);
		List<Item> itensUsuarios = sistema.getItensUsuarios();
		assertEquals(
				"JOGO ELETRONICO: Fifa 17, R$ 80.0, Nao emprestado, PS4|JOGO DE TABULEIRO: Sheriff of Nottingham, R$ 179.0, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: Dead of Winter, R$ 300.0, Nao emprestado, COMPLETO|",
				cItem.listarItensOrdenadosPorValor(itensUsuarios));
	}

	/**
	 * Verifica se a listagem de itens emprestados está ocorrendo corretamente
	 */
	@Test
	public void listarItensEmprestados() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarJogoTabuleiro("Bloodrage", 300.0, mapaItens);
		cItem.cadastrarEletronico("Dota 2", 10.0, "PC", mapaItens);
		cItem.cadastrarEletronico("Diablo 3", 120.0, "PC", mapaItens);
		cItem.cadastrarJogoTabuleiro("Zombiecide", 300.0, mapaItens);
		cItem.emprestarItem("Zombiecide", mapaItens);
		cItem.emprestarItem("Diablo 3", mapaItens);
		List<Item> itensUsuarios = sistema.getItensUsuarios();
		assertEquals(
				"JOGO ELETRONICO: Diablo 3, R$ 120.0, Emprestado, PC|JOGO DE TABULEIRO: Zombiecide, R$ 300.0, Emprestado, COMPLETO|",
				cItem.listarItensEmprestados(itensUsuarios));
	}

	/**
	 * Verifica se a listagem de itens não emprestados está ocorrendo
	 * corretamente
	 */
	@Test
	public void listarItensNaoEmprestados() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarJogoTabuleiro("Bloodrage", 300.0, mapaItens);
		cItem.cadastrarEletronico("Dota 2", 10.0, "PC", mapaItens);
		cItem.cadastrarEletronico("Diablo 3", 120.0, "PC", mapaItens);
		cItem.cadastrarJogoTabuleiro("Zombiecide", 300.0, mapaItens);
		cItem.emprestarItem("Zombiecide", mapaItens);
		cItem.emprestarItem("Diablo 3", mapaItens);
		List<Item> itensUsuarios = sistema.getItensUsuarios();
		assertEquals(
				"JOGO DE TABULEIRO: Bloodrage, R$ 300.0, Nao emprestado, COMPLETO|JOGO ELETRONICO: Dota 2, R$ 10.0, Nao emprestado, PC|",
				cItem.listarItensNaoEmprestados(itensUsuarios));
	}

	/**
	 * Verifica se a listagem do top 10 itens mais emprestados está ocorrendo
	 * corretamente
	 */
	@Test
	public void listarTop10ItensTest() {
		Map<String, Item> mapaItens = sistema.getItensUsuario("Magaiver", "333");
		cItem.cadastrarEletronico("Pokemon Ruby", 20.00, "PS4", mapaItens);
		cItem.emprestarItem("Pokemon Ruby", mapaItens);
		cItem.cadastrarJogoTabuleiro("Zombiecide", 300.00, mapaItens);
		cItem.emprestarItem("Zombiecide", mapaItens);
		List<Item> itensUsuarios = sistema.getItensUsuarios();
		assertEquals(
				"1) 1 emprestimos - JOGO ELETRONICO: Pokemon Ruby, R$ 20.0, Emprestado, PS4|2) 1 emprestimos - JOGO DE TABULEIRO: Zombiecide, R$ 300.0, Emprestado, COMPLETO|",
				cItem.listarTop10Itens(itensUsuarios));
	}

}
