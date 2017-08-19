package projeto;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import projeto.enums.Cartao;

/**
 * Classe de Usuário.
 * 
 * @author caiosbl
 * @version 4.0
 *
 */

public class Usuario {
	private String nome;
	private String email;
	private String numCelular;
	private double reputacao;
	private Cartao cartao;
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
		this.reputacao = 0.0;
		this.cartao = Cartao.FREE_RIDER;
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
	 * Altera o nome do Usuário.
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
	 * Retorna o número do Celular do Usuário.
	 * 
	 * @return numCelular.
	 */
	public String getNumCelular() {
		return numCelular;
	}

	/**
	 * Altera o número do Celular do Usuário.
	 * 
	 * @param numCelular
	 *            Novo número de celular do Usuário.
	 */
	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	/**
	 * Retorna o mapa de Itens do Usuário.
	 * 
	 * @return mapaItens
	 */
	public Map<String, Item> getItens() {
		return mapaItens;
	}

	/**
	 * Retorna a reputação de um usuário.
	 * 
	 * @return
	 */
	public double getReputacao() {
		return this.reputacao;
	}

	/**
	 * Adiciona ao atributo reputação a porcentagem de 5% referente ao valor do
	 * item adicionado.
	 * 
	 * @param valorItem
	 *            Valor do Item.
	 */
	public void addReputacaoItemAdicionado(double valorItem) {
		this.reputacao += valorItem * 0.05;
	}

	/**
	 * Adiciona ao atributo reputação a porcentagem de 10% referente ao valor
	 * item emprestado.
	 * 
	 * @param valorItem
	 *            Valor do Item.
	 */
	public void addReputacaoItemEmprestado(double valorItem) {
		this.reputacao += valorItem * 0.1;

	}

	/**
	 * Adiciona ao atributo reputação a porcentagem de 5% referente ao valor do
	 * Item devolvido.
	 * 
	 * @param valorItem
	 *            Valor do item devolvido.
	 */
	public void addReputacaoItemDevolvidoNoPrazo(double valorItem) {
		this.reputacao += valorItem * 0.05;

	}

	/**
	 * Decrementa o atributo reputação o valor calculado referente a porcentagem
	 * de 1% vezes o número de dias em atraso da devolução vezes o valor do Item
	 * devolvido.
	 * 
	 * @param valorItem
	 *            Valor do Item devolvido.
	 * @param diasAtraso
	 *            Dias em Atraso da devolução.
	 */
	public void addReputacaoItemDevolvidoAtrasado(double valorItem, int diasAtraso) {
		this.reputacao -= valorItem * (0.01 * diasAtraso);
	}

	/**
	 * Retorna o cartão atual do Usuário.
	 * 
	 * @return cartao
	 */
	public String getCartao() {
		return this.cartao.getValor();
	}

	/**
	 * Atualiza o valor do cartão do usuário de acordo com sua situação atual.
	 */
	public void atualizaCartao() {
		if (reputacao < 0) {
			this.cartao = Cartao.CALOTEIRO;
		} else if (reputacao > 100) {
			this.cartao = Cartao.BOM_AMIGO;
		} else if (mapaItens.size() > 0) {
			this.cartao = Cartao.NOOB;
		} else {
			this.cartao = Cartao.FREE_RIDER;
		}
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
