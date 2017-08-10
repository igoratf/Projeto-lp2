package projeto;

public class Bluray extends Item {

	private int duracao;
	private Classificacao classificacao;

	public Bluray(String nome, double valor, int duracao, String classificacao) {
		super(nome, valor);
		validaBluray(nome, valor, duracao, classificacao);
		this.duracao = duracao;
		this.classificacao = Classificacao.valueOf(classificacao);
	}
	
	public int getDuracao(){
		return this.duracao;
	}
	public String getClassificao(){
		return this.classificacao.getValor();
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

	@Override
	public String toString() {
		return "Bluray [duracao=" + duracao + ", classificacao=" + classificacao + "]";
	}
	
	public void validaBluray(String nome, double valor, int duracao, String classificacao) {
		if (nome == null) throw new NullPointerException("Nome nulo");
		if (classificacao == null) throw new NullPointerException("Classificacao nula");
		if (nome.trim().equals("")) throw new IllegalArgumentException("Nome vazio");
		if (classificacao.trim().equals("")) throw new IllegalArgumentException("Classificacao vazia");
		if (valor <= 0) throw new IllegalArgumentException("Valor invalido");
		if (duracao <= 0) throw new IllegalArgumentException("Duracao invalida");
	}

}
