

import static org.junit.Assert.*;

import org.junit.Test;


import projeto.Emprestimo;

import projeto.Item;
import projeto.JogoTabuleiro;
import projeto.Usuario;

public class EmprestimoTest {
	private Emprestimo emprestimo;

	
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
	
	@Test (expected = NullPointerException.class )
	public void testValidadeAtributoData() {
		
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			emprestimo = new Emprestimo(dono, requerente, item, null, 5);
		
		}
	
	
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
	
	@Test
	public void testEmprestimos() {
		
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			Emprestimo emprestimo1 = new Emprestimo(dono, requerente, item, "10/08/2017", 5);
			Emprestimo emprestimo2 = new Emprestimo(dono, requerente, item, "10/08/2017", 5);
		
			assertTrue(emprestimo1.equals(emprestimo2));
		}

}
