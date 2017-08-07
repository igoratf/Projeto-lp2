import static org.junit.Assert.*;

import org.junit.Before;

import projeto.Usuario;

import org.junit.Test;

public class UsuarioTest {
	private Usuario usuario;

	/**
	 * Instancia um Usuário.
	 */
	@Before
	public void instanciaUsuario() {
		String nome = "Caio";
		String email = "caio@caio.com.br";
		String numCelular = "8398056654";
		Usuario usuario = new Usuario(nome, email, numCelular);
	}

	@Test
	public void cadastraUsuarioInvalidoTest() {
		try {
			Usuario usuario = new Usuario(null, "email", "numCelular");
			fail("Exceção devida não lançada para Nome nulo!");
		} catch (NullPointerException e) {
			assertEquals("Nome nulo invalido!", e.getMessage());
		} try {
			Usuario usuario = new Usuario("Caio", null, "numCelular");
			fail("Exceção devida não lançada para Email nulo!");
		} catch (NullPointerException e) {
			assertEquals("Email nulo invalido!", e.getMessage());
		}try {
			Usuario usuario = new Usuario("Caio", "email", null);
			fail("Exceção devida não lançada para numCelular nulo!");
		}catch (NullPointerException e) {
			assertEquals("Numero de Celular nulo invalido!",e.getMessage());
		}
	}

	/**
	 * Testa os métodos getNome e setNome.
	 */
	public void getAndSetNomeTest() {
		assertEquals("Teste do getNome", "Caio", usuario.getNome());
		usuario.setNome("João");
		assertEquals("Teste do setNome", "João", usuario.getNome());
	}

}
