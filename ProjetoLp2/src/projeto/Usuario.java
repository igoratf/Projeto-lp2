package projeto;

public class Usuario {
	private String nome;
	private String email;
	private String numCelular;
	private ControllerItem controllerItem;

	public Usuario(String nome, String email, String numCelular) {
		this.nome = nome;
		this.email = email;
		this.numCelular = numCelular;
		this.controllerItem = new ControllerItem();

	}

	public String getNome() {
		return nome;
	}

	public boolean setNome(String nome) {
		this.nome = nome;
		return true;
	}

	public String getEmail() {
		return email;
	}

	public boolean setEmail(String email) {
		this.email = email;
		return true;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public boolean setNumCelular(String numCelular) {
		this.numCelular = numCelular;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numCelular == null) ? 0 : numCelular.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numCelular == null) {
			if (other.numCelular != null)
				return false;
		} else if (!numCelular.equals(other.numCelular))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s , %s ,%s", nome, email, numCelular);
	}

}
