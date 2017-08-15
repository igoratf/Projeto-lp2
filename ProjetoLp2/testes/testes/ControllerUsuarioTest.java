package testes;



import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;

import projeto.ControllerUsuario;


import org.junit.Test;

/**
 * Testes da classe Controller Usuário.
 * @author caiosbl
 *
 */

public class ControllerUsuarioTest {
	private ControllerUsuario controllerUsuario;

	/**
	 * Instancia o Controller de Usuário.
	 */
	@Before
	public void instanciaControllerUsuario() {
		controllerUsuario = new ControllerUsuario();
	}

	/**
	 * Testa o método CadastraUsuario em situações válidas, se este lança a
	 * devida exceção, e se cadastra corretamente, e se a verficação de um
	 * usuário já contido é por nome e telefone.
	 */
	@Test
	public void cadastraUsuarioTest() {
		controllerUsuario.cadastrarUsuario("Caio", "8398056654", "cs@caio.com");
		assertTrue(controllerUsuario.checaSeUsuarioJaExiste("Caio", "8398056654"));
		controllerUsuario.cadastrarUsuario("Caio", "8398056655", "cs@caio.com");
		assertTrue(controllerUsuario.checaSeUsuarioJaExiste("Caio", "8398056655"));

		try {
			controllerUsuario.cadastrarUsuario("Caio", "8398056654", "cs@caio.com");
			fail("Exceção não lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Usuario ja cadastrado", e.getMessage());
		}

		try {
			controllerUsuario.checaSeUsuarioJaExiste("Caio", "8398056653");
			fail("Exceção de Usuário não existeste não lançada");
		}

		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Usuario invalido");

		}

	}

	/**
	 * Testa se o método getInfoUsuario retorna os atributos requeridos
	 * corretamente de um usuário, e a se ao pedir-se um atributo de um usuário
	 * inexiste, ou um atributo inexistente o método lança a devida exceção.
	 */
	@Test
	public void getInfoUsuarioTest() {
		controllerUsuario.cadastrarUsuario("Caio", "980677", "caio@redhat.com");

		assertEquals("Caio", controllerUsuario.getInfoUsuario("Caio", "980677", "Nome"));
		assertEquals("980677", controllerUsuario.getInfoUsuario("Caio", "980677", "Telefone"));
		assertEquals("caio@redhat.com", controllerUsuario.getInfoUsuario("Caio", "980677", "Email"));

		try {
			controllerUsuario.getInfoUsuario("Joao", "980677", "Nome");
			fail("Exceção de Usuario Inválido não lançada!");
		} catch (IllegalArgumentException e) {
			assertEquals("Usuario invalido", e.getMessage());
		}

		try {
			controllerUsuario.getInfoUsuario("Caio", "980677", "Invalido");
			fail("Exceção de Atributo Inválido não lançada!");
		} catch (IllegalArgumentException e) {
			assertEquals("Atributo invalido", e.getMessage());
		}
	}

	/**
	 * Testa o método removerUsuario, testa se ao remover um Usuário com mesmo
	 * nome porém número diferente, o usuário com mesmo nome e telefone
	 * diferente se mantém, e o usuário com mesmo nome e telefone é removido.
	 */
	@Test
	public void removerUsuarioTest() {
		controllerUsuario.cadastrarUsuario("Igor", "190", "igor@ventila.com");
		controllerUsuario.cadastrarUsuario("Igor", "191", "igor@ventila.com");
		assertTrue(controllerUsuario.checaSeUsuarioJaExiste("Igor", "190"));
		controllerUsuario.removerUsuario("Igor", "190");
		assertTrue(controllerUsuario.checaSeUsuarioJaExiste("Igor", "191"));
		try {
			controllerUsuario.checaSeUsuarioJaExiste("Igor", "190");
			fail("Usuario não removido");
		} catch (IllegalArgumentException e) {
			assertEquals("Usuario invalido", e.getMessage());
		}

	}

	/**
	 * Testa se o método atualiza os atributos requeridos podendo ser este: em
	 * um usuário, nome,telefone ou email e se lança exceção ao tentar atualizar
	 * um usuário inexistente ou um atributo inválido
	 */
	@Test
	public void atualizarUsuarioTest() {
		controllerUsuario.cadastrarUsuario("Igor", "190", "igor@ventila.com");
		assertTrue(controllerUsuario.checaSeUsuarioJaExiste("Igor", "190"));

		controllerUsuario.atualizarUsuario("Igor", "190", "Nome", "Lucas");

		try {
			controllerUsuario.checaSeUsuarioJaExiste("Igor", "190");
			fail("Usuario não removido");
		} catch (IllegalArgumentException e) {
			assertEquals("Usuario invalido", e.getMessage());
		}

		assertTrue(controllerUsuario.checaSeUsuarioJaExiste("Lucas", "190"));
		controllerUsuario.atualizarUsuario("Lucas", "190", "Telefone", "999");
		assertTrue(controllerUsuario.checaSeUsuarioJaExiste("Lucas", "999"));

		controllerUsuario.atualizarUsuario("Lucas", "999", "Email", "lucas@ventila.com");
		assertEquals("lucas@ventila.com", controllerUsuario.getInfoUsuario("Lucas", "999", "Email"));

		try {
			controllerUsuario.atualizarUsuario("Lucas", "999", "Invalido", "lucas2@ventila.com");
			fail("Exceção de atributo invalido não lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Atributo invalido", e.getMessage());
		}

	}

	/**
	 * Testa se o método cadastrarEletronico cadastra corretamente um item em um
	 * usuário.
	 */
	public void cadastrarEletronicoTest() {
		controllerUsuario.cadastrarUsuario("Caio", "8398", "caiolira@d.c");
		controllerUsuario.cadastrarEletronico("Mario", "8398", "Mario", 2.99, "PS");
		controllerUsuario.validaItemUsuario("Caio", "8398", "Mario");
	}

	/**
	 * Testa se o método cadastrarJogoTabuleiro cadastra corretamente um item em
	 * um usuário.
	 */
	@Test
	public void cadastrarJogoTabuleiroTest() {
		controllerUsuario.cadastrarUsuario("Caio", "8398", "caiolira@d.c");
		controllerUsuario.cadastrarJogoTabuleiro("Caio", "8398", "War", 25.99);
		controllerUsuario.validaItemUsuario("Caio", "8398", "War");
	}

	/**
	 * Testa se o método cadastrarBluRayFilme cadastra corretamente um item em
	 * um usuário.
	 */
	@Test
	public void cadastrarBluRayFilmeTest() {
		controllerUsuario.cadastrarUsuario("Caio", "8398", "caiolira@d.c");
		controllerUsuario.cadastrarBluRayFilme("Caio", "8398", "Avatar", 59.90, 120, "DRAMA", "LIVRE", 2009);
		controllerUsuario.validaItemUsuario("Caio", "8398", "Avatar");
	}

	/**
	 * Testa se o método cadastraBluRaySerie cadastra corretamente um item em um
	 * usuário.
	 */
	@Test
	public void cadastraBluRaySerieTest() {
		controllerUsuario.cadastrarUsuario("Caio", "8398", "caiolira@d.c");
		controllerUsuario.cadastrarBluraySerie("Caio", "8398", "Prision Break", 10.99, "Srie desc", 200, "LIVRE",
				"ACAO", 1);
		controllerUsuario.validaItemUsuario("Caio", "8398", "Prision Break");
	}

	/**
	 * Testa se o método adiciona corretamente uma peça perdida em um jogo de
	 * tabuleiro.
	 */
	@Test
	public void adicionarPecaPerdidaTest() {
		controllerUsuario.cadastrarUsuario("Caio", "8398", "caiolira@d.c");
		controllerUsuario.cadastrarJogoTabuleiro("Caio", "8398", "War", 22.90);

		assertEquals("COMPLETO", controllerUsuario.haPecasPerdidasItem("Caio", "8398", "War"));
		controllerUsuario.adicionarPecaPerdida("Caio", "8398", "War", "Peca");
		assertEquals("COM PECAS PERDIDAS", controllerUsuario.haPecasPerdidasItem("Caio", "8398", "War"));
	}

	/**
	 * Testa se o método removerItem remove corretamente um item.
	 */
	@Test
	public void removerItemTest() {
		controllerUsuario.cadastrarUsuario("Caio", "8398", "caiolira@d.c");
		controllerUsuario.cadastrarJogoTabuleiro("Caio", "8398", "Damas", 10.0);
		controllerUsuario.validaItemUsuario("Caio", "8398", "Damas");

		controllerUsuario.removerItem("Caio", "8398", "Damas");
		try {
			controllerUsuario.validaItemUsuario("Caio", "8398", "Damas");
			fail("Item não removido");
		} catch (RuntimeException e) {
			assertEquals("Item nao encontrado", e.getMessage());
		}
	}

	/**
	 * Testa se o método atualizarItem e getInfoItem se comporta como esperado.
	 */
	public void atualizarItemTest() {
		controllerUsuario.cadastrarUsuario("Caio", "8398", "caiolira@d.c");
		controllerUsuario.cadastrarJogoTabuleiro("Caio", "8398", "Damas", 10.0);

		controllerUsuario.atualizarItem("Caio", "8398", "Damas", "nome", "Xadrez");
		controllerUsuario.validaItemUsuario("Caio", "8398", "Xadrez");

		try {
			controllerUsuario.validaItemUsuario("Caio", "8398", "Damas");
			fail("Item com nome Antigo não removido");
		} catch (RuntimeException e) {
			assertEquals("Item nao encontrado", e.getMessage());
		}

		assertEquals(10.0, controllerUsuario.getInfoItem("Caio", "8398", "Xadrez", "Valor"));

		controllerUsuario.atualizarItem("Caio", "8398", "Xadrez", "Valor", "15.0");
		assertEquals(15.0, controllerUsuario.getInfoItem("Caio", "8398", "Xadrez", "Valor"));
	}

	/**
	 * Testa se o método cadastrarBluRayShow cadastra corretamente um item em
	 * usuário.
	 */
	@Test
	public void cadastrarBluRayShowTest() {
		controllerUsuario.cadastrarUsuario("João", "8345", "joao@joa.com");
		controllerUsuario.cadastrarBlurayShow("João", "8345", "Alok Live", 199.90, 90, 21, "Alok", "LIVRE");
		controllerUsuario.validaItemUsuario("João", "8345", "Alok Live");
	}

	/**
	 * Testa se o método cadastra corretamente um Bluray de episódio em um
	 * bluray de séries.
	 */
	public void cadastrarBluRayTest() {
		controllerUsuario.cadastrarUsuario("João", "8345", "joao@joa.com");
		controllerUsuario.cadastrarBluraySerie("João", "8345", "Narcos", 199.90, "Soy el fuego", 160, "LIVRE", "ACAO",
				1);

		assertFalse(controllerUsuario.haEpisodiosBluRaySeries("João", "8345", "Narcos"));
		controllerUsuario.adicionarBluRay("João", "8345", "Narcos", 60);
		assertTrue((controllerUsuario.haEpisodiosBluRaySeries("João", "8345", "Narcos")));
	}

	/**
	 * Testa se o método pesquisarDetalhesItens retorna o toString do Item
	 * desejado, e lança a devida
	 */
	public void pesquisarDetalhesItensTest() {
		controllerUsuario.cadastrarUsuario("João", "8345", "joao@joa.com");
		controllerUsuario.cadastrarBluraySerie("João", "8345", "Narcos", 199.90, "Soy el fuego", 160, "LIVRE", "ACAO",
				1);

		String esperado = "SERIE: Narcos, R$ 199.90, Nao emprestado, 160 min, LIVRE, ACAO, Temporada 1";
		assertEquals(esperado, controllerUsuario.pesquisarDetalhesItem("João", "8345", "Narcos"));

		try {
			controllerUsuario.pesquisarDetalhesItem("Joã", "8345", "Narcos");
			fail("Exceção de usuário inválido não foi lançada");
		} catch (IllegalArgumentException e) {
			assertEquals("Usuario invalido", e.getMessage());
		}
	}

	/**
	 * Testa se o método listarItensOrdenadosPorValor retorna a lista de itens
	 * ordenada corretamente.
	 */
	@Test
	public void listarItensOrdenadosPorValorTest() {
		controllerUsuario.cadastrarUsuario("João", "8345", "joao@joa.com");
		controllerUsuario.cadastrarUsuario("Joã", "8345", "joao@joa.com");
		controllerUsuario.cadastrarBluraySerie("João", "8345", "Narcos", 199.90, "Soy el fuego", 160, "LIVRE", "ACAO",
				1);
		controllerUsuario.cadastrarBluraySerie("Joã", "8345", "Narcos 2", 199.80, "Soy el fuego", 160, "LIVRE", "ACAO",
				1);

		String esperado = "SERIE: Narcos 2, R$ 199.80, Nao emprestado, 160 min, LIVRE, ACAO, Temporada 1" + "|"
				+ "SERIE: Narcos, R$ 199.90, Nao emprestado, 160 min, LIVRE, ACAO, Temporada 1" + "|";

		assertEquals(esperado, controllerUsuario.listarItensOrdenadosPorValor());

	}

	/**
	 * Testa se o método listarItensOrdenadosPorNome retorna a lista de itens
	 * ordenada corretamente.
	 */
	@Test
	public void listarItensOrdenadosPorNomeTest() {
		controllerUsuario.cadastrarUsuario("João", "8345", "joao@joa.com");
		controllerUsuario.cadastrarUsuario("Joã", "8345", "joao@joa.com");
		controllerUsuario.cadastrarBluraySerie("João", "8345", "Ave", 199.90, "Soy el fuego", 160, "LIVRE", "ACAO", 1);
		controllerUsuario.cadastrarBluraySerie("Joã", "8345", "Brasil", 199.80, "Soy el fuego", 160, "LIVRE", "ACAO",
				1);

		String esperado = "SERIE: Ave, R$ 199.90, Nao emprestado, 160 min, LIVRE, ACAO, Temporada 1" + "|"
				+ "SERIE: Brasil, R$ 199.80, Nao emprestado, 160 min, LIVRE, ACAO, Temporada 1" + "|";

		assertEquals(esperado, controllerUsuario.listarItensOrdenadosPorNome());

	}

	/**
	 * Testa se o método registrarEmprestimo registra os empréstimos em Dono e
	 * em Requerente.
	 * @throws ParseException 
	 */
	@Test
	public void registrarEmprestimoTest() throws ParseException {
		controllerUsuario.cadastrarUsuario("João", "8345", "joao@joa.com");
		controllerUsuario.cadastrarUsuario("Lucas", "8345", "joao@joa.com");

		controllerUsuario.cadastrarJogoTabuleiro("João", "8345", "Guerra", 15);
		controllerUsuario.registrarEmprestimo("João", "8345", "Lucas", "8345", "Guerra", "10/08/2017", 7);

		assertTrue(controllerUsuario.contemEmprestimo("João", "8345"));
		assertTrue(controllerUsuario.contemEmprestimo("Lucas", "8345"));
	}

	/**
	 * Testa se o método devolverItem se comporta corretamente a data de devolução de
	 * um empréstimo
	 * @throws ParseException 
	 */
	@Test
	public void devolverItemTest() throws ParseException {
		controllerUsuario.cadastrarUsuario("João", "8345", "joao@joa.com");
		controllerUsuario.cadastrarUsuario("Lucas", "8345", "joao@joa.com");
		controllerUsuario.cadastrarJogoTabuleiro("João", "8345", "Guerra", 15);
		controllerUsuario.registrarEmprestimo("João", "8345", "Lucas", "8345", "Guerra", "10/08/2017", 7);


	}

}
