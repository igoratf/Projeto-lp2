package testes;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import projeto.ChaveUsuario;
import projeto.controllers.ControllerEmprestimo;

/**
 * Teste da classe ControllerEmprestimo
 * 
 * @author lucasvsa
 *
 */
public class ControllerEmprestimoTest {

	private ControllerEmprestimo cEmprestimo;
	
	/**
	 * Instancia o Controller dos emprestimos.
	 */
	@Before
	public void instanciarControllerEmprestimo(){
		cEmprestimo = new ControllerEmprestimo();

	}
	
	@Test
	public void test() throws ParseException {
		ChaveUsuario dono1 = new ChaveUsuario("MC Lon", "51996995555");
		ChaveUsuario requerente1 = new ChaveUsuario("Chester", "51999995555");
		String nomeItem1 = "War";
		cEmprestimo.registrarEmprestimo(dono1, requerente1, nomeItem1, "10/02/2018", 7);
		
		ChaveUsuario dono2 = new ChaveUsuario("Cabeça", "51996995555");
		ChaveUsuario requerente2 = new ChaveUsuario("Ventila", "51999995555");
		String nomeItem2 = "Dota";
		cEmprestimo.registrarEmprestimo(dono2, requerente2, nomeItem2, "10/03/2017", 5);
		
		
		//Teste de um emprestimo registrado de acordo com os dados do dono.
			assertEquals("Erro", "Emprestimos: EMPRESTIMO - De: MC Lon, Para: Chester, War, 10/02/2018, 7 dias, ENTREGA: Emprestimo em andamento|" , cEmprestimo.listarEmprestimosUsuarioEmprestando(dono1.getNome(), dono1.getTelefone()));
		
		//Teste de um emprestimo registrado de acordo com os dados do dono porém com os dados do requerente.
			assertEquals("Erro", "Nenhum item emprestado" , cEmprestimo.listarEmprestimosUsuarioEmprestando(requerente1.getNome(), requerente1.getTelefone()));
		
		
		//Teste de um emprestimo registrado de acordo com os dados do requerente.
			assertEquals("Erro", "Emprestimos pegos: EMPRESTIMO - De: MC Lon, Para: Chester, War, 10/02/2018, 7 dias, ENTREGA: Emprestimo em andamento|" , cEmprestimo.listarEmprestimosUsuarioPegandoEmprestado(requerente1.getNome(), requerente1.getTelefone()));
		
		//Teste do listarItensEmprestados no momento.
			assertEquals("Erro", "Dono do item: Cabeça, Nome do item emprestado: Dota|Dono do item: MC Lon, Nome do item emprestado: War|", cEmprestimo.listarItensEmprestados());
		
		//Teste de entrega de item com dias de atraso.
			assertEquals("Erro", 6 , cEmprestimo.devolverItem(dono1, requerente1, nomeItem1, "10/02/2018", "23/02/2018"));
		
		//Teste do listarItensEmprestados após a devolução de um deles.
			assertEquals("Erro", "Dono do item: Cabeça, Nome do item emprestado: Dota|", cEmprestimo.listarItensEmprestados());
				
		//Teste para devolução de um emprestimo que não existe.
			try {
				cEmprestimo.devolverItem(dono1, requerente1, nomeItem1, "05/02/2018" , "20/02/2018");
				fail("Exceção não lançada");
			} catch (IllegalArgumentException e) {
				assertEquals("Emprestimo nao encontrado", e.getMessage());
			}
	}

}
