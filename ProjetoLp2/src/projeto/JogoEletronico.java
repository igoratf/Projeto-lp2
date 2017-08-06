package projeto;


/**
 * Classe criada referente ao jogo eletronico que é uma subclasse de Item.
 * 
 * @author lucasvsa
 *
 */
public class JogoEletronico extends Item {

	
	private Plataforma plataforma;
	
	
	public JogoEletronico(String nome, double valor, String plataforma) {
		super(nome, valor);
		this.plataforma = Plataforma.valueOf(plataforma);
	}
	
	
	
	public Plataforma getPlataforma() {
		return plataforma;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getNome() == null) ? 0 :this.getNome().hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		return result;
	}
	
	/**
	 * Metodo sobreescrito do Equals() para comparar se um jogo eletronico é igual ao outro se o nome e a plataforma
	 * forem iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoEletronico other = (JogoEletronico) obj;
		if (!this.getNome().equals(other.getNome()) && this.plataforma.equals(other.plataforma))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "JogosEletronicos [nome=" + this.getNome() + ", plataforma=" + plataforma + "]";
	}
	
	
}
