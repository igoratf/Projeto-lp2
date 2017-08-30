package projeto.bluray;

import java.io.Serializable;

/**
 * Classe que possui informações para a construção de objetos do tipo BlurayEpisodio que irá
 * compor objetos do tipo BluraySeries
 * 
 * @author igoratf
 *
 */

public class BlurayEpisodio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 567546905171239219L;
	public int duracao;

	/**
	 * Construtor de objetos da classe BlurayEpisodio
	 * 
	 * @param duracao
	 *            é a duração do bluray
	 */

	public BlurayEpisodio(int duracao) {
		if (duracao <= 0) throw new IllegalArgumentException("Duracao invalida");
		this.duracao = duracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
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
		BlurayEpisodio other = (BlurayEpisodio) obj;
		if (duracao != other.duracao)
			return false;
		return true;
	}
	
}
