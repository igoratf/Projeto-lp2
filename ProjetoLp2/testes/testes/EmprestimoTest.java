package testes;


import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;


import projeto.Emprestimo;


import projeto.jogo.JogoTabuleiro;
import projeto.utilitarios.ChaveUsuario;

public class EmprestimoTest {
	@SuppressWarnings("unused")
	private Emprestimo emprestimo;

	/**
	 * Teste de validade do Objeto dono caso seja nulo.
	 * @throws ParseException 
	 */
	@Test
	public void testValidadeAtributoDono() throws ParseException {
		try{
			ChaveUsuario dono = null;
			ChaveUsuario requerente = new ChaveUsuario("Carlos",  "83955558877");
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			emprestimo = new Emprestimo(dono, requerente, item.getNome(), "10/08/2017", 5);
			fail("Exceção de dono nulo não lançada!");
		} catch(NullPointerException e){
			assertEquals("Dono nulo", e.getMessage());
		}
	}
	/**
	 * Teste de validade do Objeto requerente caso seja nulo.
	 * @throws ParseException 
	 */
	@Test
	public void testValidadeAtributoRequerente() throws ParseException {
		try{
			ChaveUsuario dono = new ChaveUsuario("Joao","8399995555" );
			ChaveUsuario requerente = null;
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			emprestimo = new Emprestimo(dono, requerente, item.getNome(), "10/08/2017", 5);
			fail("Exceção de Requerente nulo não lançada!");
		} catch(NullPointerException e){
			assertEquals("Requerente nulo", e.getMessage());
		}
	}

		/**
	 * Teste de validade do Objeto requerente caso seja nulo e Vazio.
	 * @throws ParseException 
	 */
	@Test
	public void testValidadeAtributoRequerenteNuloVazio() throws ParseException {
		try{
			ChaveUsuario dono = new ChaveUsuario(null,"" );
			ChaveUsuario requerente = null;
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			emprestimo = new Emprestimo(dono, requerente, item.getNome(), "10/08/2017", 5);
			fail("Exceção de Requerente nulo não lançada!");
		} catch(NullPointerException e){
			assertEquals("Nome nulo invalido!", e.getMessage());
		}
	}
	
	/**
	 * Teste de validade do Objeto Item caso seja nulo.
	 * @throws ParseException 
	 */
	@Test
	public void testValidadeAtributoItem() throws ParseException {
		try{
			ChaveUsuario dono = new ChaveUsuario("Joao","8399995555" );
			ChaveUsuario requerente = new ChaveUsuario("Carlos", "83955558877");
			String item = null;
			emprestimo = new Emprestimo(dono, requerente, item, "10/08/2017", 5);
			fail("Exceção de Item nulo não lançada!");
		} catch(NullPointerException e){
			assertEquals("Item nulo", e.getMessage());
		}
	}
	
	/**
	 * Teste de validade do atributo data de emprestimo caso seja nulo.
	 * @throws ParseException 
	 */
	@Test (expected = NullPointerException.class )
	public void testValidadeAtributoData() throws ParseException {
		
			ChaveUsuario dono = new ChaveUsuario("Joao","8399995555" );
			ChaveUsuario requerente = new ChaveUsuario("Carlos", "83955558877");
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			emprestimo = new Emprestimo(dono, requerente, item.getNome(), null, 5);
		
		}
	
	/**
	 * Teste de validade do atributo data de emprestimo caso seja vazia.
	 * @throws ParseException 
	 */
	@Test
	public void testValidadeAtributoDataVazia() throws ParseException {
		try{
			ChaveUsuario dono = new ChaveUsuario("Joao","8399995555" );
			ChaveUsuario requerente = new ChaveUsuario("Carlos", "83955558877");
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			emprestimo = new Emprestimo(dono, requerente, item.getNome(), "  ", 5);
			fail("Exceção de data inicial vazia não lançada!");
		} catch(IllegalArgumentException e){
			assertEquals("Data inicial vazia", e.getMessage());
		}
	}
	
	/**
	 * Teste de validade do atributo periodo caso seja negativo.
	 * @throws ParseException 
	 */
	@Test
	public void testValidadeAtributoPeriodo() throws ParseException {
		try{
			ChaveUsuario dono = new ChaveUsuario("Joao","8399995555" );
			ChaveUsuario requerente = new ChaveUsuario("Carlos", "83955558877");
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			emprestimo = new Emprestimo(dono, requerente, item.getNome(), "10/08/2017", -1);
			fail("Exceção de periodo invalido não lançada!");
		} catch(IllegalArgumentException e){
			assertEquals("Periodo invalido", e.getMessage());
		}
	}
	
	/**
	 * Teste de equidade de dois emprestimos caso possuam os atributos necessario para serem iguais,
	 * são eles: Donos, Requerentes, Item e dataEmprestimo iguais.
	 * @throws ParseException 
	 */
	@Test
	public void testEmprestimos() throws ParseException {
		
			ChaveUsuario dono = new ChaveUsuario("Joao","8399995555" );
			ChaveUsuario requerente = new ChaveUsuario("Carlos", "83955558877");
			JogoTabuleiro item = new JogoTabuleiro("Uar", 89.99);
			Emprestimo emprestimo1 = new Emprestimo(dono, requerente, item.getNome(), "10/08/2017", 7);
			Emprestimo emprestimo2 = new Emprestimo(dono, requerente, item.getNome(), "10/08/2017", 5);
		
			assertTrue(emprestimo1.equals(emprestimo2));
		}

}
