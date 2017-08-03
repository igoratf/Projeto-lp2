package projeto;



public class JogosEletronicos extends Item {
	
	private String nome;
	private Plataforma plataforma;
	
	
	public JogosEletronicos(String nome, int valor, boolean estadoDeEmprestimo, String nomeJogo, Plataforma plataforma){
		super(nome, valor, estadoDeEmprestimo);
		this.nome = nomeJogo;
		this.plataforma = plataforma;
	}
	



	public String getNome() {
		return nome;
	}
	
	public Plataforma getPlataforma() {
		return plataforma;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
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
		JogosEletronicos other = (JogosEletronicos) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "JogosEletronicos [nome=" + nome + ", plataforma=" + plataforma + "]";
	}
	
	
}
