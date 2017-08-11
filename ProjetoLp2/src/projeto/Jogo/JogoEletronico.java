package projeto.Jogo;

import projeto.Item;
import projeto.enums.Plataforma;

/**
 * Classe criada referente ao jogo eletronico que é uma subclasse de Item.
 * 
 * @author lucasvsa
 *
 */
public class JogoEletronico extends Item {

	
	private Plataforma plataforma;
	
	/**
	 * Construtor de JogoEletronico.
	 * @param nome, String passsado por parametro.
	 * @param valor, Double passsado por parametro.
	 * @param plataforma, String passsado por parametro.
	 */
	public JogoEletronico(String nome, double valor, String plataforma) {
		super(nome, valor);
		validaAtributo(plataforma);
		this.plataforma = Plataforma.valueOf(plataforma);
	}
	
	
	/**
	 * Metodo para retornar a plataforma desse objeto.
	 * @return, retorna a String plataforma.
	 */
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
		if (this.getNome().equals(other.getNome()) && this.plataforma.equals(other.plataforma))
			return true;
		return false;
	}
	
	/**
	 * Metodo sobreescrito do toString() para mostrar o nome do Jogo com padrão alterado.
	 */
	@Override
	public String toString() {
		return String.format("JOGO ELETRONICO: %s, R$ %.1f, %s, %s",getNome(),getValor(),getEstado(),this.plataforma.getPlataforma());
	}
	
	/**
	 * Metodo para validar os atributos passados no construtor de JogoEletronico.
	 * @param plataforma, , String passsado por parametro.
	 * @return, , retorna true ou false dependendo da validade dos atributos passados.
	 */
	public boolean validaAtributo(String plataforma){
		if (plataforma == null)
			throw new NullPointerException("Plataforma Nula");
		else if(plataforma.trim().equals("")){
			throw new NullPointerException("Plataforma Vazia Invalida");
		}
		
		
		return true;
	}
}
