package testes;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;

import projeto.Emprestimo;
import projeto.Item;
import projeto.Usuario;
import projeto.Jogo.JogoTabuleiro;
import projeto.bluray.BluraySeries;

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

	/**
	 * Testa se o método cadastrarBluRayFilme cadastra corretamente um filme.
	 */
	@Test
	public void cadastraBluRayFilmeTest() {
		usuario.cadastrarBluRayFilme("Avatar", 20.99, 120, "ACAO", "LIVRE", 2009);
		usuario.getItem("Avatar");

	}

	/**
	 * Testa se o método adicionarPecaPerdida adiciona corretamente uma peça em
	 * um jogo de Xadrez.
	 */
	@Test
	public void adicionarPecaPerdidaTest() {
		usuario.cadastrarJogoTabuleiro("War", 22.90);
		assertEquals("COMPLETO", ((JogoTabuleiro) usuario.getItem("War")).existePecasPerdidas());
		usuario.adicionarPecaPerdida("War", "Peca");
		assertEquals("COM PECAS PERDIDAS", ((JogoTabuleiro) usuario.getItem("War")).existePecasPerdidas());
	}

	/**
	 * Método devolverItem já testado em Controller Usuário.
	 */
	/**
	 * Testa se o método cadastrarBlurayShow cadastra um Item de BlurayShow
	 * corretamente.
	 */
	@Test
	public void cadastrarBlurayShowTest() {
		usuario.cadastrarBlurayShow("Roberto Carlos", 60.99, 80, 19, "Roberto Carlos", "LIVRE");
		usuario.getItem("Roberto Carlos");
	}

	/**
	 * Testa se o método cadastrarBluraySerie cadastra um Item de Bluray Série
	 * corretamente.
	 */
	@Test
	public void cadastrarBluraySerieTest() {
		usuario.cadastrarBluraySerie("24 Horas", 199, "Topzera", 265, "LIVRE", "ACAO", 2);
		usuario.getItem("24 Horas");
	}

	/**
	 * Testa se o método cadastra corretamente um Bluray de episódio em um
	 * bluray de séries.
	 */
	@Test
	public void adicionarBluRayTest() {
		usuario.cadastrarBluraySerie("Narcos", 199.90, "Soy el fuego", 160, "LIVRE", "ACAO", 1);

		assertFalse(((BluraySeries) usuario.getItem("Narcos")).contemEpisodio());
		usuario.adicionarBluray("Narcos", 120);
		assertTrue(((BluraySeries) usuario.getItem("Narcos")).contemEpisodio());
	}

	/**
	 * Testa se o metódo removerItem remove corretamente um item de um usuário.
	 */
	@Test
	public void removerItemTest() {
		try {
			usuario.getItem("Spider");
			fail("Exceção de Item não encontrado não lançada");

		} catch (RuntimeException e) {
		}
		usuario.cadastrarJogoTabuleiro("Spider", 120);
		usuario.getItem("Spider");
	}

	/**
	 * Testa se o método atualizarItem atualiza corretamente as informações de
	 * um item e getInfo Item retorna corretamente as informações desejadas.
	 */
	@Test
	public void atualizarItemTest() {
		usuario.cadastrarJogoTabuleiro("Damas", 10.0);

		usuario.atualizarItem("Damas", "Nome", "Xadrez");
		usuario.getItem("Xadrez");

		try {
			usuario.getItem("Damas");
			fail("Item com nome Antigo não removido");
		} catch (RuntimeException e) {
			assertEquals("Item nao encontrado", e.getMessage());
		}

		assertEquals("10.0", usuario.getInfoItem("Xadrez", "Preco"));
		assertEquals("Xadrez", usuario.getInfoItem("Xadrez", "Nome"));

		usuario.atualizarItem("Xadrez", "preco", "15.0");
		assertEquals("15.0", usuario.getInfoItem("Xadrez", "Preco"));
	}

	/**
	 * Testa se o método emprestarItem seta corretamente o estado de empréstimo
	 * de um Item.
	 */
	@Test
	public void emprestarItemTest() {
		usuario.cadastrarJogoTabuleiro("Jogo", 10);
		assertEquals("Nao emprestado", usuario.getItem("Jogo").getEstado());
		usuario.emprestarItem("Jogo");
		assertEquals("Emprestado", usuario.getItem("Jogo").getEstado());
	}

	/**
	 * Testa se o método cadastroEmprestimo cadastra corretamente um Empréstimo
	 * e se o método contemEmprestimo funciona como esperado.
	 */
	@Test
	public void cadastroEmprestimo() {
		assertFalse(usuario.contemEmprestimo());
		Emprestimo emprestimo = new Emprestimo(new Usuario("nome", "email", "numCelular"),
				new Usuario("nomew", "email", "numCelular"), new JogoTabuleiro("nome", 10), "10/08/98", 7);
		usuario.cadastroEmprestimo(emprestimo);
		assertTrue(usuario.contemEmprestimo());

	}

	/**
	 * Testa se o método pequisarDetalhesItem funciona como esperado.
	 */
	@Test
	public void pesquisarDetalhesItem() {
		usuario.cadastrarBluraySerie("Narcos", 199.90, "Soy el fuego", 160, "LIVRE", "ACAO", 1);

		String esperado = "SERIE: Narcos, R$ 199.90, Nao emprestado, 160 min, LIVRE, ACAO, Temporada 1";
		assertEquals(esperado, usuario.pesquisarDetalhesItem("Narcos"));
	}

	/**
	 * Testa se o método getListaItens retorna corretamente a lista de Itens de
	 * Usuário.
	 */
	@Test
	public void getListaItensTest() {
		ArrayList<Item> lista = new ArrayList<>();

		JogoTabuleiro jogo = new JogoTabuleiro("game", 1);
		lista.add(jogo);
		usuario.cadastrarJogoTabuleiro("game", 1);

		assertEquals(lista.size(), usuario.getListaItens().size());

	}

	/**
	 * getEmprestimo ,contemEmprestimo e getItem testados nos testes anteriores.
	 */

}
