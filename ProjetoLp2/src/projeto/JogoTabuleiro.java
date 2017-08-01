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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (completo ? 1231 : 1237);
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
		return result;
	}

	//Override
	// public boolean equals(Object obj) {
	// Falta criar o equals
	//}



}
