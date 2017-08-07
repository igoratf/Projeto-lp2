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
	/**
	 * Testa os métodos getNome e setNome.
	 */
	public void getAndSetNomeTest(){
		assertEquals("Teste do getNome","Caio",usuario.getNome());
		usuario.setNome("João");
		assertEquals("Teste do setNome","João", usuario.getNome());
	}

}
