package testes;
import static org.junit.Assert.*;

import org.junit.Test;

import projeto.jogo.JogoEletronico;

public class JogoEletronicoTest {
	
	/**
	 * Teste de equidade de dois jogos eletronicos caso eles possuam a mesma plataforma e nome.
	 */
	@Test
	public void testJogoEletronico() {
		JogoEletronico jogo1 = new JogoEletronico("Doom", 100.90, "PC");
		JogoEletronico jogo2 = new JogoEletronico("Doom", 0, "PS3");
		JogoEletronico jogo3 = new JogoEletronico("Doom", 80.90, "PC");
		
		assertEquals("Erro", false, jogo1.equals(jogo2));
		assertEquals("Erro", true, jogo1.equals(jogo3));
	}

	/**
	 * Teste de validade do atributo plataforma caso seja 
	 */
	@Test
	public void testJogoEletronicoAtributos() {
		try{
		JogoEletronico jogo1 = new JogoEletronico("Doom", 100.90, null);
		fail("Exceção de plataforma nula não lançada!");
		} catch (Exception e){
			assertEquals("Plataforma Nula", e.getMessage());
		}
	}

}
