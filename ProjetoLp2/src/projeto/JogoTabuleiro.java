package projeto;

import java.util.ArrayList;
import java.util.List;

public class JogoTabuleiro extends Item {
	private List<String> pecasPerdidas = new ArrayList<>();
	private boolean completo;

	public JogoTabuleiro(String nome, int valor, boolean estadoDeEmprestimo, List<String> pecasPerdidas,
			boolean completo) {
		super(nome, valor, estadoDeEmprestimo);
		this.pecasPerdidas = pecasPerdidas;
		this.completo = completo;
	}

	public boolean comparaLista(List<String> lista) {
		for (String string : lista) {
			if (!(this.pecasPerdidas.contains(string))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (completo ? 1231 : 1237);
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
		return result;
	}

	public boolean equals(JogoTabuleiro jogo) {
		if (jogo.getNome().equals(this.nome) && comparaLista(jogo.pecasPerdidas)) {
			return true;
		}
		return false;
	}

}
