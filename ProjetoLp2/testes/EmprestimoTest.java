import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import projeto.Emprestimo;
/**
 * 			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			Item item = new Item("Uar", 89.99);
 */
import projeto.Item;
import projeto.Usuario;

public class EmprestimoTest {

	@Test
	public void testValidadeAtributoDono() {
		try{
			Usuario dono = null;
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			Item item = new Item("Uar", 89.99);
			Emprestimo emprestimo = new Emprestimo(dono, requerente, item, "10/08/2017", 5);
		} catch(NullPointerException e){
			Assert.assertEquals("Dono nulo", e.getMessage());
		}
	}
	
	@Test
	public void testValidadeAtributoRequerente() {
		try{
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = null;
			Item item = new Item("Uar", 89.99);
			Emprestimo emprestimo = new Emprestimo(dono, requerente, item, "10/08/2017", 5);
		} catch(NullPointerException e){
			Assert.assertEquals("Requerente nulo", e.getMessage());
		}
	}
	
	@Test
	public void testValidadeAtributoItem() {
		try{
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			Item item = null;
			Emprestimo emprestimo = new Emprestimo(dono, requerente, item, "10/08/2017", 5);
		} catch(NullPointerException e){
			Assert.assertEquals("Item nulo", e.getMessage());
		}
	}
	
	@Test (expected = NullPointerException.class )
	public void testValidadeAtributoData() {
		
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			Item item = new Item("Uar", 89.99);
			Emprestimo emprestimo = new Emprestimo(dono, requerente, item, null, 5);
		
		}
	
	
	@Test
	public void testValidadeAtributoDataVazia() {
		try{
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			Item item = new Item("Uar", 89.99);
			Emprestimo emprestimo = new Emprestimo(dono, requerente, item, "  ", 5);
		} catch(IllegalArgumentException e){
			Assert.assertEquals("Data inicial vazia", e.getMessage());
		}
	}
	
	@Test
	public void testValidadeAtributoPeriodo() {
		try{
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			Item item = new Item("Uar", 89.99);
			Emprestimo emprestimo = new Emprestimo(dono, requerente, item, "10/08/2017", -1);
		} catch(IllegalArgumentException e){
			Assert.assertEquals("Periodo invalido", e.getMessage());
		}
	}
	
	@Test
	public void testEmprestimos() {
		
			Usuario dono = new Usuario("Joao", "joao@gmail.com" ,"8399995555" );
			Usuario requerente = new Usuario("Carlos", "carlos@gmail.com", "83955558877");
			Item item = new Item("Uar", 89.99);
			Emprestimo emprestimo1 = new Emprestimo(dono, requerente, item, "10/08/2017", 5);
			Emprestimo emprestimo2 = new Emprestimo(dono, requerente, item, "10/08/2017", 5);
		
			assertEquals("Erro", true, emprestimo1.equals(emprestimo2));
		}

}
