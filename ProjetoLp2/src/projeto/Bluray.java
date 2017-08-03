package projeto;

public class Bluray extends Item {

	private int duracao;
	private String classificacao;
	
	
	@Override
	public String toString() {
		return "Bluray [duracao=" + duracao + ", classificacao=" + classificacao + "]";
	}

	public Bluray(String nome, int valor, int duracao, String classificacao) {

		super(nome, valor);

		this.duracao = duracao;
		this.classificacao = classificacao;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getNome() == null) ? 0 : getNome().hashCode());
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
		if (getNome() == null) {
			if (other.getNome() != null)
				return false;
		} else if (!getNome().equals(other.getNome()))
			return false;
		return true;
	}

}
