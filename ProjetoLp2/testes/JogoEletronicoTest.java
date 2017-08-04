import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import projeto.JogoEletronico;

public class JogoEletronicoTest {
	
	@Test
	public void testJogoEletronico() {
		JogoEletronico jogo1 = new JogoEletronico("Doom", 100.90, "PC");
		JogoEletronico jogo2 = new JogoEletronico("Doom", 0, "PS3");
		JogoEletronico jogo3 = new JogoEletronico("Doom", 80.90, "PC");
		
		assertEquals("Erro", false, jogo1.equals(jogo2));
		assertEquals("Erro", true, jogo1.equals(jogo3));
	}

	@Test
	public void testJogoEletronicoAtributos() {
		try{
		JogoEletronico jogo1 = new JogoEletronico("Doom", 100.90, "PC");
		} catch (Exception e){
			Assert.assertEquals("Plataforma Nula", e.getMessage());
		}
	}

}
