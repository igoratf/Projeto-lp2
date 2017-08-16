package projeto;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * Classe de Usuário.
 * 
 * @author caiosbl, igoratf
 * @version 2.0
 *
 */

public class Usuario {
	private String nome;
	private String email;
	private String numCelular;
	private Map<String, Item> mapaItens;

	/**
	 * Construtor da Classe Usuário.
	 * 
	 * @param nome
	 *            Nome do Usuário.
	 * @param email
	 *            Email do Usuário.
	 * @param numCelular
	 *            Número do celular do Usuário.
	 */
	public Usuario(String nome, String email, String numCelular) {
		ValidaParametros.validaParametrosUsuario(nome, email, numCelular);
		Locale.setDefault(new Locale("en", "US"));
		this.nome = nome.trim();
		this.email = email.trim();
		this.numCelular = numCelular.trim();
		this.mapaItens = new HashMap<String, Item>();

	}

	/**
	 * Retorna o nome do usuário.
	 * 
	 * @return nome Nome do Usuário.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * imo("João", "8345", "João", "8345", "Lucas", "8345", "Guerra",
	 * "10/08/2017") Altera o nome do Usuário.
	 * 
	 * @param nome
	 *            Novo nome do Usuário.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o Email de um Usuário.
	 * 
	 * @return email Email do Usuário.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Altera o Email do Usuário.
	 * 
	 * @param email
	 *            Novo Email do Usuário.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna o número do celular do Usuário. imo("João", "8345", "João",
	 * "8345", "Lucas", "8345", "Guerra", "10/08/2017")
	 * 
	 * @return numCelular Número do Celular do Usuário.
	 */
	public String getNumCelular() {
		return numCelular;
	}

	/**
	 * Altera o número do Celular de um usuário.
	 * 
	 * @param numCelular
	 *            Novo número de celular do Usuário.
	 */
	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	/**
	 * Metodo para retornar um item baseado em seu nome pertencente a esse
	 * usuario.
	 * 
	 * @param nomeItem,
	 *            String passado por parametro. @return, retorna o item
	 *            desejado.
	 */
	public Item getItem(String nomeItem) {
		if (!mapaItens.containsKey(nomeItem)) {
			throw new RuntimeException("Item nao encontrado");
		}
		return mapaItens.get(nomeItem);

	}

	public Map<String, Item> getItens() {
		return mapaItens;
	}

	/**
	 * Calcula o HashCode do Objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numCelular == null) ? 0 : numCelular.hashCode());
		return result;
	}

	/**
	 * Retorna a Igualdade do Objeto em relação a outro.
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

	/**
	 * Retorna a Representação em String do Objeto.
	 */
	@Override
	public String toString() {
		return String.format("%s , %s ,%s", nome, email, numCelular);
	}

}
