package projeto;

import java.util.ArrayList;
import java.util.List;

public class ControllerItem {
	private List<Item> listaItem = new ArrayList<>();

	public ControllerItem(List<Item> listaItem) {
		this.listaItem = listaItem;
	}
	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, ) {
		
	}
	
	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		Item jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
}
	
	
}
