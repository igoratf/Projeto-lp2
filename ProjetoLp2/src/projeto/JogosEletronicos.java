package projeto;



public class JogosEletronicos extends Item {
	
	private Plataforma plataforma;
	
	
	public JogosEletronicos(String nome, int valor, Plataforma plataforma){
		super(nome, valor);
		this.plataforma = plataforma;
	}
	



	public String getNome() {
		return this.getNome();
	}
	
	public Plataforma getPlataforma() {
		return plataforma;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getNome() == null) ? 0 : this.getNome().hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() == obj.getClass()) {
			JogosEletronicos je = (JogosEletronicos) obj;
			return je.getPlataforma().equals(getPlataforma()) && je.getNome().equals(getNome());
			
		} else {
			return false;
		}	
	}
	
	@Override
	public String toString() {
		return "JogosEletronicos [nome=" + this.getNome() + ", plataforma=" + plataforma + "]";
	}
	
	
}
