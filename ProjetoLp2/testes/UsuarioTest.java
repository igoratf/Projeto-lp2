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
		usuario = new Usuario(nome, email, numCelular);
	}

	/**
	 * Testa se ao cadastrar um Usuário com Parâmetros inválidos ele lança a
	 * devida exceção.
	 */
	@Test
	public void cadastraUsuarioInvalidoTest() {
		try {
			usuario = new Usuario(null, "email", "numCelular");
			fail("Exceção devida não lançada para Nome nulo!");
		} catch (NullPointerException e) {
			assertEquals("Nome nulo invalido!", e.getMessage());
		}
		try {
			usuario = new Usuario("Caio", null, "numCelular");
			fail("Exceção devida não lançada para Email nulo!");
		} catch (NullPointerException e) {
			assertEquals("Email nulo invalido!", e.getMessage());
		}
		try {
			usuario = new Usuario("Caio", "email", null);
			fail("Exceção devida não lançada para numCelular nulo!");
		} catch (NullPointerException e) {
			assertEquals("Numero de Celular nulo invalido!", e.getMessage());
		}
	}

	/**
	 * Testa os métodos getNome e setNome.
	 */
	@Test
	public void getAndSetNomeTest() {
		assertEquals("Teste do getNome", "Caio", usuario.getNome());
		usuario.setNome("João");
		assertEquals("Teste do setNome", "João", usuario.getNome());
	}

	/**
	 * Testa se o método cadastrarEletronico cadastra corretamente um Jogo
	 * ELetrônico e lança a devida exceção para plataformas inválidas.
	 */
	@Test
	public void cadastrarEletronicoTest() {
		usuario.cadastrarEletronico("FIFA", 190, "PS4");
		usuario.getItem("FIFA");
		usuario.cadastrarEletronico("STAR WARS", 190, "XBOX360");
		usuario.getItem("STAR WARS");
		usuario.cadastrarEletronico("STAR WARSS", 191, "PS4");
		usuario.getItem("STAR WARSS");
		try {
			usuario.cadastrarEletronico("STAR WARSS", 191, "PS1");
			fail("Exceção de Constante de Plataforma Inválida não lançada");
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Testa se o método cadastrarJogoTabuleiro cadastra corretamente um jogo de
	 * Tabuleiro.
	 */
	@Test
	public void cadastrarJogoTabuleiroTest() {
		usuario.cadastrarJogoTabuleiro("DAMAS", 100);
		usuario.getItem("DAMAS");
		usuario.cadastrarJogoTabuleiro("XADREZ", 100);
		usuario.getItem("XADREZ");
	}

}
