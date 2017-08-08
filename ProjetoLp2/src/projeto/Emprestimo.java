package projeto;

public class Emprestimo {
	private Usuario dono;
	private Usuario requerente;
	private Item item;
	private String dataEmprestimo;
	private int periodo;
	private String dataDevolucao;
	
	public Emprestimo(Usuario dono, Usuario requerente, Item item,
			String dataInicial, int periodo){
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
				&& (this.item.equals(other.item)))
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
	
}
