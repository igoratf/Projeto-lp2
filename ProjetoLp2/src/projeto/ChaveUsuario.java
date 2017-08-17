package projeto;

/**
 * Chave de um Usuário
 * 
 * @author caiosbl
 *
 */

public class ChaveUsuario {
	private String nome;
	private String telefone;

	/**
	 * Construtor da Classe.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param telefone
	 *            Telefone do Usuário.
	 */
	public ChaveUsuario(String nome, String telefone) {
		ValidaParametros.validaChaveUsuario(nome, telefone);
		this.nome = nome;
		this.telefone = telefone;
	}

	/**
	 * Retorna o nome da Chave.
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome da Chave.
	 * 
	 * @param nome
	 *            Novo nome.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o telefone da chave.
	 * 
	 * @return telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Altera o telefone da chave.
	 * 
	 * @param telefone
	 *            Novo telefone.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Calcula o HashCode da Chave.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/**
	 * Método Equals da Chave.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChaveUsuario other = (ChaveUsuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

}
