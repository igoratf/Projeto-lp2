package testes;

import static org.junit.Assert.*;
/**
 * Classe de Testes de Sistema
 */

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import projeto.Item;
import projeto.Sistema;
import projeto.bluray.BluraySeries;
import projeto.jogo.JogoTabuleiro;

public class SistemaTest {

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
		 * Verifica se preço inválido está retornando exceção, o que é válido para todos
		 * os tipos de Bluray
		 */
		try {
			sistema.cadastrarBluRayFilme("Magaiver", "333", "Harry Potter", -1, 200, "AVENTURA", "LIVRE", 1969);
		} catch (Exception e) {
			assertEquals("Preco invalido", e.getMessage());
		}
		/*
		 * Verifica se preço inválido está retornando exceção, o que é válido para todos
		 * os tipos de Bluray
		 */
		try {
			sistema.cadastrarBluRayFilme("Magaiver", "333", "Senhor dos Aneis", 200.00, -3, "AVENTURA", "LIVRE", 1969);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se duração menor ou igual a 0 está retornando exceção, o que é
		 * válido para todos os tipos de Bluray
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
		sistema.cadastrarBluRaySerie("Magaiver", "333", "Game of Thrones", 99.00, "Sabe de nada Jon Snow", 200, "LIVRE",
				"AVENTURA", 7);
		Map<String, Item> mapa = sistema.getItensUsuario("Magaiver", "333");
		BluraySeries bluray = (BluraySeries) mapa.get("Game of Thrones");
		assertEquals(false, bluray.contemEpisodio());
		sistema.adicionarBluRay("Magaiver", "333", "Game of Thrones", 60);
		assertEquals(true, bluray.contemEpisodio());
		/*
		 * Verifica se a tentativa de adicionar um episódio com duração menor ou igual a
		 * 0 está retornando exceção
		 */
		try {
			sistema.adicionarBluRay("Magaiver", "333", "Game of Thrones", 0);
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
		/*
		 * Verifica se a tentativa de adicionar um episódio a uma série não existente
		 * está retornando exceção
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
	 * Verifica se a adição de uma peça perdida a um JogoTabuleiro está ocorrendo
	 * corretamente
	 */

	@Test
	public void adicionarPecaPerdidaTest() {
		Map<String, Item> mapa = sistema.getItensUsuario("Magaiver", "333");
		sistema.cadastrarJogoTabuleiro("Magaiver", "333", "King of Tokyo", 169.0);
		JogoTabuleiro jogo = (JogoTabuleiro) mapa.get("King of Tokyo");
		assertEquals("COMPLETO", jogo.existePecasPerdidas());
		sistema.adicionarPecaPerdida("Magaiver", "333", "King of Tokyo", "Gigazaur");
		assertEquals("COM PECAS PERDIDAS", jogo.existePecasPerdidas());
		/*
		 * Verifica se a tentativa de adicionar uma peça perdida a um jogo que não foi
		 * cadastrado está lançando exceção
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

	/**
	 * Testa se o sistema cadastra corretamente um usuário, e se o método
	 * checaSeUsuarioJaExiste é funcional.
	 */
	@Test
	public void cadastrarUsuarioTest() {
		try {
			sistema.checaSeUsuarioJaExiste("Caio", "190");
		} catch (IllegalArgumentException e) {
			assertEquals("Usuario invalido", e.getMessage());
		}
		sistema.cadastrarUsuario("Caio", "190", "caio@caio.com");
		assertTrue(sistema.checaSeUsuarioJaExiste("Caio", "190"));

	}

	/**
	 * Testa se o método getInfoUsuario retorna os atributos requeridos corretamente
	 * de um usuário, e a se ao pedir-se um atributo de um usuário inexiste, ou um
	 * atributo inexistente o método lança a devida exceção.
	 */
	@Test
	public void getInfoUsuarioTest() {
		sistema.cadastrarUsuario("Caio", "980677", "caio@redhat.com");

		assertEquals("Caio", sistema.getInfoUsuario("Caio", "980677", "Nome"));
		assertEquals("980677", sistema.getInfoUsuario("Caio", "980677", "Telefone"));
		assertEquals("caio@redhat.com", sistema.getInfoUsuario("Caio", "980677", "Email"));
		assertEquals("0.0", sistema.getInfoUsuario("Caio", "980677", "Reputacao"));

		try {
			sistema.getInfoUsuario("Joao", "980677", "Nome");
			fail("Exceção de Usuario Inválido não lançada!");
		} catch (IllegalArgumentException e) {
			assertEquals("Usuario invalido", e.getMessage());
		}

		try {
			sistema.getInfoUsuario("Caio", "980677", "Invalido");
			fail("Exceção de Atributo Inválido não lançada!");
		} catch (IllegalArgumentException e) {
			assertEquals("Atributo invalido", e.getMessage());
		}
	}

	/**
	 * Testa se o método getItensUsuario retorna corretamente o mapa de Itens de um
	 * usuário.
	 */
	@Test
	public void getItensUsuarioTest() {
		sistema.cadastrarUsuario("Caio", "8398056654", "djcaiopb@gmail.com");
		HashMap<String, Item> mapaTest = new HashMap<>();

		assertEquals(mapaTest, sistema.getItensUsuario("Caio", "8398056654"));

		sistema.cadastrarJogoTabuleiro("Caio", "8398056654", "War", 100);
		JogoTabuleiro jogo = new JogoTabuleiro("War", 100);
		mapaTest.put("War", jogo);
		assertEquals(sistema.getItensUsuario("Caio", "8398056654"), mapaTest);
	}

	/**
	 * Testa se o método getItensUsuarios retorna corretamente a lista de Itens de
	 * todos os usuários.
	 */
	@Test
	public void getItensUsuariosTest() {
		sistema.cadastrarUsuario("Caio", "8398056654", "djcaiopb@gmail.com");
		sistema.cadastrarUsuario("Joao", "8398056654", "djcaiopb@gmail.com");

		ArrayList<Item> listaTest = new ArrayList<Item>();
		assertEquals(listaTest, sistema.getItensUsuarios());

		sistema.cadastrarJogoTabuleiro("Caio", "8398056654", "War", 190);
		sistema.cadastrarJogoTabuleiro("Joao", "8398056654", "War", 190);

		Item jogo = new JogoTabuleiro("War", 190);
		Item jogo1 = new JogoTabuleiro("Guerra", 190);
		listaTest.add(jogo);
		listaTest.add(jogo1);

		assertEquals(listaTest, sistema.getItensUsuarios());
	}

	/**
	 * Testa o método removerUsuario, testa se ao remover um Usuário com mesmo nome
	 * porém número diferente, o usuário com mesmo nome e telefone diferente se
	 * mantém, e o usuário com mesmo nome e telefone é removido.
	 */
	@Test
	public void removerUsuarioTest() {
		sistema.cadastrarUsuario("Igor", "190", "igor@ventila.com");
		sistema.cadastrarUsuario("Igor", "191", "igor@ventila.com");
		assertTrue(sistema.checaSeUsuarioJaExiste("Igor", "190"));
		sistema.removerUsuario("Igor", "190");
		assertTrue(sistema.checaSeUsuarioJaExiste("Igor", "191"));
		try {
			sistema.checaSeUsuarioJaExiste("Igor", "190");
			fail("Usuario não removido");
		} catch (IllegalArgumentException e) {
			assertEquals("Usuario invalido", e.getMessage());
		}
	}

	/**
	 * Testa se o método atualiza os atributos requeridos podendo ser este: em um
	 * usuário, nome,telefone ou email e se lança exceção ao tentar atualizar um
	 * usuário inexistente ou um atributo inválido
	 */
	@Test
	public void atualizarUsuarioTest() {
		sistema.cadastrarUsuario("Igor", "190", "igor@ventila.com");
		assertTrue(sistema.checaSeUsuarioJaExiste("Igor", "190"));

		sistema.atualizarUsuario("Igor", "190", "Nome", "Lucas");

		try {
			sistema.checaSeUsuarioJaExiste("Igor", "190");
			fail("Usuario não removido");
		} catch (IllegalArgumentException e) {
			assertEquals("Usuario invalido", e.getMessage());
		}

		assertTrue(sistema.checaSeUsuarioJaExiste("Lucas", "190"));
		sistema.atualizarUsuario("Lucas", "190", "Telefone", "999");
		assertTrue(sistema.checaSeUsuarioJaExiste("Lucas", "999"));

		sistema.atualizarUsuario("Lucas", "999", "Email", "lucas@ventila.com");
		assertEquals("lucas@ventila.com", sistema.getInfoUsuario("Lucas", "999", "Email"));

		try {
			sistema.atualizarUsuario("Lucas", "999", "Invalido", "lucas2@ventila.com");
			fail("Exceção de atributo invalido não lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Atributo invalido", e.getMessage());
		}

	}

	/**
	 * Testa de a lista retornada realmente esta ordenada pelo nome
	 */
	@Test
	public void listarItensOrdenadosPorNomeTest() {

		Sistema sis = new Sistema();
		sis.cadastrarUsuario("Javan", "87008519", "javan.lacerda@ccc.ufcg.edu.br");
		sis.cadastrarUsuario("Joao", "11112222", "joao@joao.com");
		sis.cadastrarBluRayShow("Javan", "87008519", "DDG", 29.99, 105, 19, "OficinaG3", "LIVRE");
		sis.cadastrarJogoTabuleiro("Javan", "87008519", "Xadrez", 29.99);
		sis.cadastrarEletronico("Joao", "11112222", "Dota 2", 2000, "PC");
		sis.cadastrarBluRayFilme("Joao", "11112222", "Sherlock Holmes", 29.99, 120, "ACAO", "LIVRE", 2011);
		assertEquals(
				"SHOW: DDG, R$ 29.99, Nao emprestado, 105 min, LIVRE, OficinaG3, 19 faixas|JOGO ELETRONICO: Dota 2, R$ 2000.0, Nao emprestado, PC|FILME: Sherlock Holmes, R$ 29.99, Nao emprestado, 120 min, LIVRE, ACAO, 2011|JOGO DE TABULEIRO: Xadrez, R$ 30.0, Nao emprestado, COMPLETO|",
				sis.listarItensOrdenadosPorNome());
	}

	/**
	 * Testa de a lista retornada realmente esta ordenada pelo valor
	 */
	@Test
	public void listarItensOrdenadosPorValorTest() {

		Sistema sis = new Sistema();

		sis.cadastrarUsuario("Javan", "87008519", "javan.lacerda@ccc.ufcg.edu.br");
		sis.cadastrarUsuario("Joao", "11112222", "joao@joao.com");

		sis.cadastrarBluRayShow("Javan", "87008519", "DDG", 20, 105, 19, "OficinaG3", "LIVRE");
		sis.cadastrarJogoTabuleiro("Javan", "87008519", "Xadrez", 70);
		sis.cadastrarEletronico("Joao", "11112222", "Dota 2", 50, "PC");
		sis.cadastrarBluRayFilme("Joao", "11112222", "Sherlock Holmes", 500, 120, "ACAO", "LIVRE", 2011);

		assertEquals(
				"SHOW: DDG, R$ 20.00, Nao emprestado, 105 min, LIVRE, OficinaG3, 19 faixas|JOGO ELETRONICO: Dota 2, R$ 50.0, Nao emprestado, PC|JOGO DE TABULEIRO: Xadrez, R$ 70.0, Nao emprestado, COMPLETO|FILME: Sherlock Holmes, R$ 500.00, Nao emprestado, 120 min, LIVRE, ACAO, 2011|",
				sis.listarItensOrdenadosPorValor());
	}

	/**
	 * Testa se o metodo listarEmprestimosUsuarioEmprestando realmente está
	 * retornando os emprestimos realizados pelo usuario
	 * 
	 * @throws ParseException
	 */
	@Test
	public void listarEmprestimosUsuarioEmprestandoTest() throws ParseException {

		Sistema sis = new Sistema();

		sis.cadastrarUsuario("Javan", "87008519", "javan.lacerda@ccc.ufcg.edu.br");
		sis.cadastrarUsuario("Joao", "11112222", "joao@joao.com");

		sis.cadastrarBluRayShow("Javan", "87008519", "DDG", 20, 105, 19, "OficinaG3", "LIVRE");
		sis.cadastrarJogoTabuleiro("Javan", "87008519", "Xadrez", 70);

		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", 5);
		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "Xadrez", "17/07/2017", 5);

		assertEquals(
				"Emprestimos: EMPRESTIMO - De: Javan, Para: Joao, DDG, 17/07/2017, 5 dias, ENTREGA: Emprestimo em andamento|EMPRESTIMO - De: Javan, Para: Joao, Xadrez, 17/07/2017, 5 dias, ENTREGA: Emprestimo em andamento|",
				sis.listarEmprestimosUsuarioEmprestando("Javan", "87008519"));
	}

	/**
	 * Testa se o metodo listarEmprestimosUsuarioPegandoEmprestado realmente está
	 * retornando os emprestimos feitos pelo requerente
	 * 
	 */
	@Test
	public void listarEmprestimosUsuarioPegandoEmprestadoTest() throws ParseException {

		Sistema sis = new Sistema();

		sis.cadastrarUsuario("Javan", "87008519", "javan.lacerda@ccc.ufcg.edu.br");
		sis.cadastrarUsuario("Joao", "11112222", "joao@joao.com");

		sis.cadastrarBluRayShow("Javan", "87008519", "DDG", 20, 105, 19, "OficinaG3", "LIVRE");

		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", 5);
		sis.devolverItem("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", "22/07/2017");
		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "DDG", "22/07/2017", 5);

		assertEquals(
				"Emprestimos associados ao item: EMPRESTIMO - De: Javan, Para: Joao, DDG, 17/07/2017, 5 dias, ENTREGA: 22/07/2017|EMPRESTIMO - De: Javan, Para: Joao, DDG, 22/07/2017, 5 dias, ENTREGA: Emprestimo em andamento|",
				sis.listarEmprestimosItem("DDG"));
	}

	/**
	 * Testa se o metodo listaItensEmprestados realmente está retornando os itens
	 * que estão emprestados no momento
	 * 
	 */
	@Test
	public void listarItensEmprestadosTest() throws ParseException {

		Sistema sis = new Sistema();

		sis.cadastrarUsuario("Javan", "87008519", "javan.lacerda@ccc.ufcg.edu.br");
		sis.cadastrarUsuario("Joao", "11112222", "joao@joao.com");

		sis.cadastrarBluRayShow("Javan", "87008519", "DDG", 20, 105, 19, "OficinaG3", "LIVRE");
		sis.cadastrarJogoTabuleiro("Javan", "87008519", "Xadrez", 70);
		sis.cadastrarEletronico("Joao", "11112222", "Dota 2", 50, "PC");

		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", 5);
		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "Xadrez", "22/07/2017", 5);
		sis.registrarEmprestimo("Joao", "11112222", "Javan", "87008519", "Dota 2", "22/07/2017", 5);

		assertEquals(
				"Dono do item: Javan, Nome do item emprestado: DDG|Dono do item: Javan, Nome do item emprestado: Xadrez|Dono do item: Joao, Nome do item emprestado: Dota 2|",
				sis.listarItensEmprestados());
	}

	/**
	 * Testa se o metodo listarTop10Itens está retornando o 10 itens com maior
	 * numero de emprestimos de forma rankeada
	 * 
	 */
	@Test
	public void listarTop10ItensTest() throws ParseException {

		Sistema sis = new Sistema();

		sis.cadastrarUsuario("Javan", "87008519", "javan.lacerda@ccc.ufcg.edu.br");
		sis.cadastrarUsuario("Joao", "11112222", "joao@joao.com");

		sis.cadastrarBluRayShow("Javan", "87008519", "DDG", 20, 105, 19, "OficinaG3", "LIVRE");
		sis.cadastrarJogoTabuleiro("Javan", "87008519", "Xadrez", 70);

		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", 5);
		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "Xadrez", "22/07/2017", 5);
		sis.devolverItem("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", "22/07/2017");
		sis.devolverItem("Javan", "87008519", "Joao", "11112222", "Xadrez", "22/07/2017", "27/07/2017");
		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", 5);

		assertEquals(
				"1) 2 emprestimos - SHOW: DDG, R$ 20.00, Emprestado, 105 min, LIVRE, OficinaG3, 19 faixas|2) 1 emprestimos - JOGO DE TABULEIRO: Xadrez, R$ 70.0, Nao emprestado, COMPLETO|",
				sis.listarTop10Itens());
	}

	/**
	 * Testa se o metodo listarItensNaoEmprestados está retornando a lista de itens
	 * que não estao emprestados
	 * 
	 */
	@Test
	public void listarItensNaoEmprestadosTest() throws ParseException {

		Sistema sis = new Sistema();

		sis.cadastrarUsuario("Javan", "87008519", "javan.lacerda@ccc.ufcg.edu.br");
		sis.cadastrarUsuario("Joao", "11112222", "joao@joao.com");

		sis.cadastrarBluRayShow("Javan", "87008519", "DDG", 20, 105, 19, "OficinaG3", "LIVRE");
		sis.cadastrarJogoTabuleiro("Javan", "87008519", "Xadrez", 70);
		sis.cadastrarEletronico("Joao", "11112222", "Dota 2", 2000, "PC");
		sis.cadastrarBluRayFilme("Joao", "11112222", "Sherlock Holmes", 29.99, 120, "ACAO", "LIVRE", 2011);

		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", 5);
		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "Xadrez", "22/07/2017", 5);

		assertEquals(
				"JOGO ELETRONICO: Dota 2, R$ 2000.0, Nao emprestado, PC|FILME: Sherlock Holmes, R$ 29.99, Nao emprestado, 120 min, LIVRE, ACAO, 2011|",
				sis.listarItensNaoEmprestados());
	}

	/**
	 * Testa se o metodo listarCaloteiros está retornando a lista de usuarios com
	 * nivel de reputacao negativo
	 * 
	 */
	@Test
	public void listarCaloteirosTest() throws ParseException {

		Sistema sis = new Sistema();

		sis.cadastrarUsuario("Javan", "87008519", "javan.lacerda@ccc.ufcg.edu.br");
		sis.cadastrarUsuario("Joao", "11112222", "joao@joao.com");
		sis.cadastrarUsuario("Joca", "11113333", "joca@joao.com");

		sis.cadastrarBluRayShow("Javan", "87008519", "DDG", 20, 105, 19, "OficinaG3", "LIVRE");
		sis.cadastrarJogoTabuleiro("Javan", "87008519", "Xadrez", 70);
		sis.cadastrarEletronico("Joao", "11112222", "Dota 2", 22, "PC");
		sis.cadastrarBluRayFilme("Joao", "11112222", "Sherlock Holmes", 29.99, 120, "ACAO", "LIVRE", 2011);

		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", 5);
		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "Xadrez", "22/07/2017", 5);
		sis.registrarEmprestimo("Joao", "11112222", "Joca", "11113333", "Dota 2", "17/07/2017", 5);
		sis.devolverItem("Joao", "11112222", "Joca", "11113333", "Dota 2", "17/07/2017", "25/07/2017");
		sis.devolverItem("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", "25/07/2017");
		sis.devolverItem("Javan", "87008519", "Joao", "11112222", "Xadrez", "22/07/2017", "30/10/2017");

		assertEquals(
				"Lista de usuarios com reputacao negativa: Joao, joao@joao.com, 11112222|Joca, joca@joao.com, 11113333|",
				sis.listarCaloteiros());
	}

	/**
	 * Testa se o metodo listarTop10MelhoresUsuarios está retornando a lista de
	 * usuarios com maior nível de reputação de forma rankeada
	 * 
	 */
	@Test
	public void listarTop10MelhoresTest() throws ParseException {

		Sistema sis = new Sistema();

		sis.cadastrarUsuario("Javan", "87008519", "javan.lacerda@ccc.ufcg.edu.br");
		sis.cadastrarUsuario("Joao", "11112222", "joao@joao.com");
		sis.cadastrarUsuario("Joca", "11113333", "joca@joao.com");
		sis.cadastrarUsuario("Juca", "11114444", "juca@joao.com");
		sis.cadastrarUsuario("Jaca", "11115555", "jaca@joao.com");
		sis.cadastrarUsuario("Jica", "11116666", "jica@joao.com");
		sis.cadastrarUsuario("Jesica", "11117777", "jessica@joao.com");
		sis.cadastrarUsuario("Jeca", "11118888", "jeca@joao.com");
		sis.cadastrarUsuario("Jyca", "11119999", "jyca@joao.com");
		sis.cadastrarUsuario("Jwaca", "11111010", "jwaca@joao.com");

		sis.cadastrarBluRayShow("Javan", "87008519", "DDG", 20, 105, 19, "OficinaG3", "LIVRE");
		sis.cadastrarJogoTabuleiro("Javan", "87008519", "Xadrez", 70);
		sis.cadastrarEletronico("Joao", "11112222", "Dota 2", 22, "PC");
		sis.cadastrarBluRayFilme("Joao", "11112222", "Sherlock Holmes", 29.99, 120, "ACAO", "LIVRE", 2011);

		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", 5);
		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "Xadrez", "22/07/2017", 5);
		sis.registrarEmprestimo("Joao", "11112222", "Joca", "11113333", "Dota 2", "17/07/2017", 5);
		sis.devolverItem("Joao", "11112222", "Joca", "11113333", "Dota 2", "17/07/2017", "25/07/2017");
		sis.devolverItem("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", "25/07/2017");
		sis.devolverItem("Javan", "87008519", "Joao", "11112222", "Xadrez", "22/07/2017", "30/10/2017");

		assertEquals(
				"1: Javan - Reputacao: 13,50|2: Jesica - Reputacao: 0,00|3: Juca - Reputacao: 0,00|4: Jyca - Reputacao: 0,00|5: Jaca - Reputacao: 0,00|6: Jica - Reputacao: 0,00|7: Jwaca - Reputacao: 0,00|8: Jeca - Reputacao: 0,00|9: Joca - Reputacao: -0,66|10: Joao - Reputacao: -62,30|",
				sis.listarTop10MelhoresUsuarios());
	}

	/**
	 * Testa se o metodo listarTop10PioresUsuarios está retornando a lista de
	 * usuarios com menor nível de reputação de forma rankeada
	 * 
	 */
	@Test
	public void listarTop10PioresTest() throws ParseException {

		Sistema sis = new Sistema();

		sis.cadastrarUsuario("Javan", "87008519", "javan.lacerda@ccc.ufcg.edu.br");
		sis.cadastrarUsuario("Joao", "11112222", "joao@joao.com");
		sis.cadastrarUsuario("Joca", "11113333", "joca@joao.com");
		sis.cadastrarUsuario("Juca", "11114444", "juca@joao.com");
		sis.cadastrarUsuario("Jaca", "11115555", "jaca@joao.com");
		sis.cadastrarUsuario("Jica", "11116666", "jica@joao.com");
		sis.cadastrarUsuario("Jesica", "11117777", "jessica@joao.com");
		sis.cadastrarUsuario("Jeca", "11118888", "jeca@joao.com");
		sis.cadastrarUsuario("Jyca", "11119999", "jyca@joao.com");
		sis.cadastrarUsuario("Jwaca", "11111010", "jwaca@joao.com");

		sis.cadastrarBluRayShow("Javan", "87008519", "DDG", 20, 105, 19, "OficinaG3", "LIVRE");
		sis.cadastrarJogoTabuleiro("Javan", "87008519", "Xadrez", 70);
		sis.cadastrarEletronico("Joao", "11112222", "Dota 2", 22, "PC");
		sis.cadastrarBluRayFilme("Joao", "11112222", "Sherlock Holmes", 29.99, 120, "ACAO", "LIVRE", 2011);

		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", 5);
		sis.registrarEmprestimo("Javan", "87008519", "Joao", "11112222", "Xadrez", "22/07/2017", 5);
		sis.registrarEmprestimo("Joao", "11112222", "Joca", "11113333", "Dota 2", "17/07/2017", 5);
		sis.devolverItem("Joao", "11112222", "Joca", "11113333", "Dota 2", "17/07/2017", "25/07/2017");
		sis.devolverItem("Javan", "87008519", "Joao", "11112222", "DDG", "17/07/2017", "25/07/2017");
		sis.devolverItem("Javan", "87008519", "Joao", "11112222", "Xadrez", "22/07/2017", "30/10/2017");

		assertEquals(
				"1: Joao - Reputacao: -62,30|2: Joca - Reputacao: -0,66|3: Jesica - Reputacao: 0,00|4: Juca - Reputacao: 0,00|5: Jyca - Reputacao: 0,00|6: Jaca - Reputacao: 0,00|7: Jica - Reputacao: 0,00|8: Jwaca - Reputacao: 0,00|9: Jeca - Reputacao: 0,00|10: Javan - Reputacao: 13,50|",
				sis.listarTop10PioresUsuarios());
	}

}
