package projeto;

public class Emprestimo {
	private Usuario dono;
	private Usuario requerente;
	private Item item;
	private String dataEmprestimo;
	private int periodo;
	private String dataDevolucao;
	
	/**
	 * Metodo construtor da classe Emprestimo.
	 * @param dono, objeto repassado por parametro.
	 * @param requerente, objeto repassado por parametro.
	 * @param item, objeto repassado por parametro.
	 * @param dataInicial, String repassado por parametro.
	 * @param periodo, inteiro repassado por parametro.
	 */
	public Emprestimo(Usuario dono, Usuario requerente, Item item,
			String dataInicial, int periodo){
		checaValidadeAtributos(dono, requerente, item, dataInicial, periodo);
		
		this.dono = dono;
		this.requerente = requerente;
		this.item = item;
		this.dataEmprestimo = dataInicial;
		this.periodo = periodo;
		this.dataDevolucao = "";
	
	}

	public Usuario getDono() {
		return dono;
	}

	public Usuario getRequerente() {
		return requerente;
	}

	public Item getItem() {
		return item;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public int getPeriodo() {
		return periodo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String data){
		this.dataDevolucao = data;
	}
	
	/**
	 * Metodo para comparar um emprestimo caso o dono, o requerente, o item e a data sejam
	 * iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (this.dono.equals(other.dono) && (this.requerente.equals(other.requerente)) 
				&& (this.item.equals(other.item) && this.dataEmprestimo.equals(other.dataEmprestimo)))
					return true;
		else
			return false;
		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDevolucao == null) ? 0 : dataDevolucao.hashCode());
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + periodo;
		result = prime * result + ((requerente == null) ? 0 : requerente.hashCode());
		return result;
	}
	
	/**
	 * Metodo para validar os atributos repassados como parametro.
	 * @param dono, valor passado por parametro.
	 * @param requerente, valor passado por parametro.
	 * @param item, valor passado por parametro.
	 * @param dataInicial, valor passado por parametro.
	 * @param periodo, valor passado por parametro.
	 */
	public void checaValidadeAtributos(Usuario dono, Usuario requerente, Item item,
			String dataInicial, int periodo){
			
		if (dono == null) throw new NullPointerException("Dono nulo");
		if (requerente == null) throw new NullPointerException("Requerente nulo");
		if (item == null) throw new NullPointerException("Item nulo");
		if (dataInicial == null) throw new NullPointerException("Data inicial nulo");
		if (dataInicial.trim().equals("")) throw new IllegalArgumentException("Data inicial vazia");
		if (periodo < 0) throw new IllegalArgumentException("Periodo invalido");
		
	}
}
