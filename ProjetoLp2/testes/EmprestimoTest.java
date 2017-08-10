

import static org.junit.Assert.*;

import org.junit.Test;


import projeto.Emprestimo;

import projeto.Item;
import projeto.JogoTabuleiro;
import projeto.Usuario;

public class EmprestimoTest {
	private Emprestimo emprestimo;

	/**
	 * Teste de validade do Objeto dono caso seja nulo.
	 */
	@Test
	public void testValidadeAtributoDono() {
		try{
			Usuario dono = null;
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			emprestimo = new Emprestimo(dono, requerente, item, "10/08/2017", 5);
			fail("Exceção de dono nulo não lançada!");
		} catch(NullPointerException e){
			assertEquals("Dono nulo", e.getMessage());
		}
	}
	/**
	 * Teste de validade do Objeto requerente caso seja nulo.
	 */
	@Test
	public void testValidadeAtributoRequerente() {
		try{
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = null;
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			emprestimo = new Emprestimo(dono, requerente, item, "10/08/2017", 5);
			fail("Exceção de Requerente nulo não lançada!");
		} catch(NullPointerException e){
			assertEquals("Requerente nulo", e.getMessage());
		}
	}
	
	/**
	 * Teste de validade do Objeto Item caso seja nulo.
	 */
	@Test
	public void testValidadeAtributoItem() {
		try{
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			Item item = null;
			emprestimo = new Emprestimo(dono, requerente, item, "10/08/2017", 5);
			fail("Exceção de Item nulo não lançada!");
		} catch(NullPointerException e){
			assertEquals("Item nulo", e.getMessage());
		}
	}
	
	/**
	 * Teste de validade do atributo data de emprestimo caso seja nulo.
	 */
	@Test (expected = NullPointerException.class )
	public void testValidadeAtributoData() {
		
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			emprestimo = new Emprestimo(dono, requerente, item, null, 5);
		
		}
	
	/**
	 * Teste de validade do atributo data de emprestimo caso seja vazia.
	 */
	@Test
	public void testValidadeAtributoDataVazia() {
		try{
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			emprestimo = new Emprestimo(dono, requerente, item, "  ", 5);
			fail("Exceção de data inicial vazia não lançada!");
		} catch(IllegalArgumentException e){
			assertEquals("Data inicial vazia", e.getMessage());
		}
	}
	
	/**
	 * Teste de validade do atributo periodo caso seja negativo.
	 */
	@Test
	public void testValidadeAtributoPeriodo() {
		try{
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			emprestimo = new Emprestimo(dono, requerente, item, "10/08/2017", -1);
			fail("Exceção de periodo invalido não lançada!");
		} catch(IllegalArgumentException e){
			assertEquals("Periodo invalido", e.getMessage());
		}
	}
	
	/**
	 * Teste de equidade de dois emprestimos caso possuam os atributos necessario para serem iguais,
	 * são eles: Donos, Requerentes, Item e dataEmprestimo iguais.
	 */
	@Test
	public void testEmprestimos() {
		
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			Emprestimo emprestimo1 = new Emprestimo(dono, requerente, item, "10/08/2017", 7);
			Emprestimo emprestimo2 = new Emprestimo(dono, requerente, item, "10/08/2017", 5);
		
			assertTrue(emprestimo1.equals(emprestimo2));
		}

}
