package testes;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;

import projeto.Item;
import projeto.Usuario;
import projeto.Jogo.JogoTabuleiro;

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
	 * Testa os métodos getNumCelular e setNumCelular.
	 */
	@Test
	public void getAndSetTelefoneTest() {
		assertEquals("8398056654", usuario.getNumCelular());
		usuario.setNumCelular("8398056655");
		assertEquals("8398056655", usuario.getNumCelular());
	}

	/**
	 * Testa os métodos getEmail e setEmail.
	 */
	@Test
	public void getAndSetEmailTest() {
		assertEquals("caio@caio.com.br", usuario.getEmail());
		usuario.setEmail("caio@splab.com.br");
		assertEquals("caio@splab.com.br", usuario.getEmail());
	}

	/**
	 * Testa se o método getItens retorna corretamente o mapa de Itens do
	 * Usuário.
	 */
	@Test
	public void getItensTest() {
		HashMap<String, Item> mapa = new HashMap<>();
		JogoTabuleiro jogo = new JogoTabuleiro("Teste", 1);
		mapa.put("Teste", jogo);
		usuario.getItens().put("Teste", jogo);
		assertEquals(mapa, usuario.getItens());

	}

	/**
	 * Testa o método Equals de Usuário.
	 */
	@Test
	public void equalsTest() {
		Usuario usuario1 = new Usuario("Caio", "caio@caio.com.br", "8398056654");
		Usuario usuario2 = new Usuario("Caioo", "caio@caio.com.br", "8398056654");
		assertEquals(usuario, usuario1);
		assertFalse(usuario.equals(usuario2));
	}

	/**
	 * Testa o método toString de Usuário.
	 */
	@Test
	public void toStringTest() {
		assertEquals("Caio , caio@caio.com.br ,8398056654", usuario.toString());

	}

	/**
	 * Testa se o método addReputacaoItemAdicionada calcula corretamente a
	 * porcentagem de 5% sobre o valor do Item e a incrementa ao atributo
	 * Reputação.
	 */
	@Test
	public void addReputacaoItemAdicionadoTest() {
		usuario.addReputacaoItemAdicionado(2000);
		assertEquals(100.0, usuario.getReputacao(), 0.0);
		usuario.addReputacaoItemAdicionado(1000);
		assertEquals(150.0, usuario.getReputacao(), 0.0);
	}

	/**
	 * Testa se o método addReputacaoItemEmprestado calcula corretamente a
	 * porcentagem de 10% sobre o valor do Item e a incrementa em Reputação.
	 */
	@Test
	public void addReputacaoItemEmprestadoTest() {
		usuario.addReputacaoItemEmprestado(100);
		assertEquals(10.0, usuario.getReputacao(), 0.0);

	}
	/**
	 * Testa se o método addReputacaoItemDevolvidoNoPrazo calcula corretamente a
	 * porcentagem de 5% sobre o valor do Item e a incrementa ao atributo
	 * Reputação.
	 */
	@Test
	public void addReputacaoItemDevolvidoNoPrazoTest() {
		usuario.addReputacaoItemDevolvidoNoPrazo(2000);
		assertEquals(100.0, usuario.getReputacao(), 0.0);
		usuario.addReputacaoItemDevolvidoNoPrazo(1000);
		assertEquals(150.0, usuario.getReputacao(), 0.0);
	}
	
	

}
