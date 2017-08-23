package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import projeto.Item;
import projeto.Sistema;
import projeto.jogo.JogoTabuleiro;

public class TestesCaio {
	private Sistema sistema;

	@Before
	public void instanciaSistema() {
		sistema = new Sistema();
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
	 * Testa se o método getInfoUsuario retorna os atributos requeridos
	 * corretamente de um usuário, e a se ao pedir-se um atributo de um usuário
	 * inexiste, ou um atributo inexistente o método lança a devida exceção.
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
	 * Testa se o método getItensUsuario retorna corretamente o mapa de Itens de
	 * um usuário.
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
	 * Testa se o método getItensUsuarios retorna corretamente a lista de Itens
	 * de todos os usuários.
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
	 * Testa o método removerUsuario, testa se ao remover um Usuário com mesmo
	 * nome porém número diferente, o usuário com mesmo nome e telefone
	 * diferente se mantém, e o usuário com mesmo nome e telefone é removido.
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
	 * Testa se o método atualiza os atributos requeridos podendo ser este: em
	 * um usuário, nome,telefone ou email e se lança exceção ao tentar atualizar
	 * um usuário inexistente ou um atributo inválido
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

}
