package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;

import projeto.Item;
import projeto.Sistema;
import projeto.Usuario;
import projeto.controllers.ControllerUsuario;
import projeto.jogo.JogoTabuleiro;

import org.junit.Test;

/**
 * Testes da classe Controller Usuário.
 * 
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
		assertEquals("0.0", controllerUsuario.getInfoUsuario("Caio", "980677", "Reputacao"));

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
	 * Testa se o método chaca corretamente se um usuário existe no mapa de
	 * Usuários, e caso não existe, lança a devida exceção.
	 */
	@Test
	public void checaSeUsuarioJaExisteTest() {
		controllerUsuario.cadastrarUsuario("Caio", "8398056654", "caio@caio.com");
		assertTrue(controllerUsuario.checaSeUsuarioJaExiste("Caio", "8398056654"));

		try {
			controllerUsuario.checaSeUsuarioJaExiste("Caioo", "8398056654");
			fail("Não lançou a exceção de usuário inexistente!");
		} catch (IllegalArgumentException e) {
			assertEquals("Usuario invalido", e.getMessage());
		}
	}

	/**
	 * Testa se o método getUsuario retorna um usuário corretamente.
	 */
	@Test
	public void getUsuarioTest() {
		controllerUsuario.cadastrarUsuario("Caio", "8398056654", "caio@caio.com");
		Usuario usuario = new Usuario("Caio", "caio@caio.com", "8398056654");
		assertEquals(usuario, controllerUsuario.getUsuario("Caio", "8398056654"));
	}

	/**
	 * Testa se o método getItensUsuario retorna corretamente o mapa de Itens de
	 * um usuário.
	 */
	public void getItensUsuarioTest() {
		Sistema sistema = new Sistema();
		sistema.cadastrarUsuario("Caio", "8398056654", "djcaiopb@gmail.com");
		HashMap<String, Item> mapaTest = new HashMap<>();

		assertEquals(mapaTest, sistema.getItensUsuario("Caio", "8398056654"));

		sistema.cadastrarJogoTabuleiro("Caio", "8398056554", "War", 100);
		JogoTabuleiro jogo = new JogoTabuleiro("War", 100);
		mapaTest.put("War", jogo);
		assertEquals(sistema.getItensUsuario("Caio", "8398056654"), mapaTest);
	}

	/**
	 * Testa se o método getItensUsuario retorna corretamente a lista de Itens
	 * de todos os usuários.
	 */
	@Test
	public void getItensUsuariosTest() {
		Sistema sistema = new Sistema();
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
	 * Testa se o método addReputacaoItemAdicionado adiciona corretamente a taxa
	 * de 5% do valor do Item adicionado.
	 */
	@Test
	public void addReputacaoItemAdicionadoTest() {
		controllerUsuario.cadastrarUsuario("Caio", "190", "caio@caio.com");

		String reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("0.0", reputacao);

		controllerUsuario.addReputacaoItemAdicionado("Caio", "190", 100);
		reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("5.0", reputacao);

		controllerUsuario.addReputacaoItemAdicionado("Caio", "190", 1000);
		reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("55.0", reputacao);
	}

	/**
	 * Testa se o método addReputacaoItemEmprestado adiciona corretamente o
	 * valor de 10% do Item emprestado ao atributo Reputação.
	 */
	@Test
	public void addReputacaoItemEmprestadoTest() {
		controllerUsuario.cadastrarUsuario("Caio", "190", "caio@caio.com");

		String reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("0.0", reputacao);

		controllerUsuario.addReputacaoItemEmprestado("Caio", "190", 1000);
		reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("100.0", reputacao);
	}

	@Test
	public void addReputacaoItemDevolvidoNoPrazo() {
		controllerUsuario.cadastrarUsuario("Caio", "190", "caio@caio.com");

		String reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("0.0", reputacao);

		controllerUsuario.addReputacaoItemDevolvidoNoPrazo("Caio", "190", 10000);
		reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("500.0", reputacao);

		controllerUsuario.addReputacaoItemDevolvidoNoPrazo("Caio", "190", 1000);
		reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("550.0", reputacao);
	}

	/**
	 * Testa se o método addReputacaoItemDevolvidoAtrasado calcula corretamente
	 * a porcentagem em relação aos dias atrasados e decrementa do valor de
	 * Reputação.
	 */
	@Test
	public void addReputacaoItemDevolvidoAtrasado() {
		controllerUsuario.cadastrarUsuario("Caio", "190", "caio@caio.com");

		String reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("0.0", reputacao);

		controllerUsuario.addReputacaoItemDevolvidoAtrasado("Caio", "190", 1000, 1);
		reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("-10.0", reputacao);

		controllerUsuario.addReputacaoItemDevolvidoAtrasado("Caio", "190", 1000, 2);
		reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("-30.0", reputacao);

		controllerUsuario.addReputacaoItemDevolvidoAtrasado("Caio", "190", 1000, 100);
		reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("-1030.0", reputacao);

		controllerUsuario.addReputacaoItemAdicionado("Caio", "190", 100);
		reputacao = controllerUsuario.getInfoUsuario("Caio", "190", "Reputacao");
		assertEquals("-1025.0", reputacao);

	}

	/**
	 * Testa se o método atualizarCartaoUsuarioTest atualiza corretamente o
	 * cartão de um usuário.
	 */
	@Test
	public void atualizaCartaoUsuarioTest() {
		controllerUsuario.cadastrarUsuario("Caio", "190", "caio@caio.com");
		assertEquals("FreeRyder", controllerUsuario.getInfoUsuario("Caio", "190", "Cartao"));

		controllerUsuario.getItensUsuario("Caio", "190").put("Teste", new JogoTabuleiro("Jogo", 1));
		controllerUsuario.atualizaCartaoUsuario("Caio", "190");
		assertEquals("Noob", controllerUsuario.getInfoUsuario("Caio", "190", "Cartao"));

	}

	/**
	 * Testa se o método podePegarItemEmprestado retorna false corretamente
	 * quando o cartão do Usuário é caloteiro.
	 */
	@Test
	public void podePegarItemEmprestadoTest() {
		controllerUsuario.cadastrarUsuario("Caio", "190", "caio@caio.com");
		assertTrue(controllerUsuario.podePegarItemEmprestado("Caio", "190"));

		controllerUsuario.addReputacaoItemDevolvidoAtrasado("Caio", "190", 100, 1);
		assertFalse(controllerUsuario.podePegarItemEmprestado("Caio", "190"));

	}

	/**
	 * Testa se o método validaPeriodoEmprestimo retorna corretamente o valor
	 * booleano que informa se o usuário pode ou não pegar o empréstimo pelo
	 * período informado de acordo com seu cartão atual.
	 */
	@Test
	public void validaPeriodoEmprestimoTest() {
		controllerUsuario.cadastrarUsuario("Caio", "190", "caio@caio.com");

		assertFalse(controllerUsuario.validaPeriodoEmprestimo("Caio", "190", 15));
		assertTrue(controllerUsuario.validaPeriodoEmprestimo("Caio", "190", 2));
		assertFalse(controllerUsuario.validaPeriodoEmprestimo("Caio", "190", 6));

		controllerUsuario.getItensUsuario("Caio", "190").put("Teste", new JogoTabuleiro("Jogo", 1));
		controllerUsuario.atualizaCartaoUsuario("Caio", "190");
		assertTrue(controllerUsuario.validaPeriodoEmprestimo("Caio", "190", 7));
		assertFalse(controllerUsuario.validaPeriodoEmprestimo("Caio", "190", 8));

		controllerUsuario.addReputacaoItemEmprestado("Caio", "190", 10000);
		assertTrue(controllerUsuario.validaPeriodoEmprestimo("Caio", "190", 7));
		assertFalse(controllerUsuario.validaPeriodoEmprestimo("Caio", "190", 15));

	}

	/**
	 * Testa se o método listarCaloteiros retorna corretamente a lista de
	 * usuários com reputação negativa ordenados por ordem lexicográfica dos
	 * nomes.
	 */
	@Test
	public void listarCaloteirosTest() {
		controllerUsuario.cadastrarUsuario("Caio", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Joao", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Lucas", "190", "caio@caio.com");

		controllerUsuario.addReputacaoItemDevolvidoAtrasado("Caio", "190", 200, 90);
		controllerUsuario.addReputacaoItemDevolvidoAtrasado("Joao", "190", 100, 90);

		String esperado = "Lista de usuarios com reputacao negativa: Caio, caio@caio.com, 190|Joao, caio@caio.com, 190|";

		assertEquals(esperado, controllerUsuario.listarCaloteiros());
		controllerUsuario.addReputacaoItemDevolvidoAtrasado("Lucas", "190", 1000, 9000);
		esperado = "Lista de usuarios com reputacao negativa: Caio, caio@caio.com, 190|Joao, caio@caio.com, 190|Lucas, caio@caio.com, 190|";
		assertEquals(esperado, controllerUsuario.listarCaloteiros());
	}

	/**
	 * Testa se o método lança corretamente a exceção aon tentar-se fazer uma
	 * listagem com menos de 10 usuários cadastrados, testa se a listagem vem na
	 * ordenação correta, da maior reputação para menor.
	 */
	@Test
	public void listarTop10MelhoresUsuariosTest() {
		controllerUsuario.cadastrarUsuario("Caio", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Joao", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Lucas", "190", "caio@caio.com");

		try {
			controllerUsuario.listarTop10MelhoresUsuarios();
			fail("Exceção de menos que 10 usuários cadastrados não lançada!");
		} catch (IndexOutOfBoundsException e) {
			assertEquals("Menos de 10 usuários cadastrados!", e.getMessage());
		}

		controllerUsuario.cadastrarUsuario("Marcelo", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Igor", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Javan", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Ana", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Layslla", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Brenda", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Maria", "190", "caio@caio.com");

		controllerUsuario.addReputacaoItemAdicionado("Caio", "190", 10000);
		controllerUsuario.addReputacaoItemAdicionado("Joao", "190", 10001);
		controllerUsuario.addReputacaoItemAdicionado("Lucas", "190", 10002);
		controllerUsuario.addReputacaoItemAdicionado("Marcelo", "190", 10003);
		controllerUsuario.addReputacaoItemAdicionado("Igor", "190", 10004);
		controllerUsuario.addReputacaoItemAdicionado("Javan", "190", 10005);
		controllerUsuario.addReputacaoItemAdicionado("Ana", "190", 10006);
		controllerUsuario.addReputacaoItemAdicionado("Layslla", "190", 10007);
		controllerUsuario.addReputacaoItemAdicionado("Brenda", "190", 10008);
		controllerUsuario.addReputacaoItemAdicionado("Maria", "190", 10009);

		String esperado = "1: Maria - Reputacao: 500,45|2: Brenda - Reputacao: 500,40|3: Layslla - Reputacao: 500,35|"
				+ "4: Ana - Reputacao: 500,30|5: Javan - Reputacao: 500,25|6: Igor - Reputacao: 500,20"
				+ "|7: Marcelo - Reputacao: 500,15|8: Lucas - Reputacao: 500,10|9: Joao - Reputacao: 500,05|"
				+ "10: Caio - Reputacao: 500,00|";

		assertEquals(esperado, controllerUsuario.listarTop10MelhoresUsuarios());

	}

	/**
	 * Testa se o método lança corretamente a exceção aon tentar-se fazer uma
	 * listagem com menos de 10 usuários cadastrados, testa se a listagem vem na
	 * ordenação correta, da menor reputação para maior.
	 */
	@Test
	public void listarTop10PioresUsuarios() {
		controllerUsuario.cadastrarUsuario("Caio", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Joao", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Lucas", "190", "caio@caio.com");

		try {
			controllerUsuario.listarTop10MelhoresUsuarios();
			fail("Exceção de menos que 10 usuários cadastrados não lançada!");
		} catch (IndexOutOfBoundsException e) {
			assertEquals("Menos de 10 usuários cadastrados!", e.getMessage());
		}

		controllerUsuario.cadastrarUsuario("Marcelo", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Igor", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Javan", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Ana", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Layslla", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Brenda", "190", "caio@caio.com");
		controllerUsuario.cadastrarUsuario("Maria", "190", "caio@caio.com");

		controllerUsuario.addReputacaoItemAdicionado("Caio", "190", 10000);
		controllerUsuario.addReputacaoItemAdicionado("Joao", "190", 10001);
		controllerUsuario.addReputacaoItemAdicionado("Lucas", "190", 10002);
		controllerUsuario.addReputacaoItemAdicionado("Marcelo", "190", 10003);
		controllerUsuario.addReputacaoItemAdicionado("Igor", "190", 10004);
		controllerUsuario.addReputacaoItemAdicionado("Javan", "190", 10005);
		controllerUsuario.addReputacaoItemAdicionado("Ana", "190", 10006);
		controllerUsuario.addReputacaoItemAdicionado("Layslla", "190", 10007);
		controllerUsuario.addReputacaoItemAdicionado("Brenda", "190", 10008);
		controllerUsuario.addReputacaoItemAdicionado("Maria", "190", 10009);

		String esperado = "1: Caio - Reputacao: 500,00|2: Joao - Reputacao: 500,05|3: Lucas - Reputacao: 500,10|"
				+ "4: Marcelo - Reputacao: 500,15|5: Igor - Reputacao: 500,20|6: Javan - Reputacao: 500,25|"
				+ "7: Ana - Reputacao: 500,30|8: Layslla - Reputacao: 500,35|9: Brenda - Reputacao: 500,40|"
				+ "10: Maria - Reputacao: 500,45|";

		assertEquals(esperado, controllerUsuario.listarTop10PioresUsuarios());

	}

}
