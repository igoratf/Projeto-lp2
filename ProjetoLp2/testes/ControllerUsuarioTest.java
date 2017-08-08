import static org.junit.Assert.*;

import org.junit.Before;

import projeto.ControllerUsuario;
import projeto.Usuario;

import org.junit.Test;

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

}
