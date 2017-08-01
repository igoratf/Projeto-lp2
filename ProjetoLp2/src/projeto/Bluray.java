package projeto;

public class Bluray extends Item {

	private int duracao;
	private String classificacao;

	public Bluray(String nome, int valor, boolean estadoDeEmprestimo, int duracao, String classificacao) {

		super(nome, valor, estadoDeEmprestimo);

		this.duracao = duracao;
		this.classificacao = classificacao;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bluray other = (Bluray) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
