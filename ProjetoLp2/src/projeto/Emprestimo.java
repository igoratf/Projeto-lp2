package projeto;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import projeto.utilitarios.ChaveUsuario;

/**
 * Classe de Emprestimo.
 * 
 * 
 * @author lucasvsa
 *
 */

public class Emprestimo implements Comparable<Emprestimo>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6021029249976516649L;
	private ChaveUsuario dono;
	private ChaveUsuario requerente;
	private String item;
	private LocalDate dataEmprestimo;
	private int periodo;
	private LocalDate dataDevolucao;

	/**
	 * Metodo construtor da classe Emprestimo.
	 * 
	 * @param dono,
	 *            objeto repassado por parametro.
	 * @param requerente,
	 *            objeto repassado por parametro.
	 * @param item,
	 *            objeto repassado por parametro.
	 * @param dataInicial,
	 *            String repassado por parametro.
	 * @param periodo,
	 *            inteiro repassado por parametro.
	 */
	public Emprestimo(ChaveUsuario dono, ChaveUsuario requerente, String item, String dataInicial, int periodo) {
		checaValidadeAtributos(dono, requerente, item, dataInicial, periodo);

		this.dono = dono;
		this.requerente = requerente;
		this.item = item;
		this.dataEmprestimo = LocalDate.parse(dataInicial, getFormatoData());
		this.periodo = periodo;
		this.dataDevolucao = null;

	}

	/**
	 * Metodo para retornar o Objeto Usuario. @return, retorna o Objeto dono.
	 */
	public ChaveUsuario getDono() {
		return dono;
	}

	/**
	 * Metodo para retornar o Objeto Usuario. @return, retorna o Objeto
	 * requerente.
	 */
	public ChaveUsuario getRequerente() {
		return requerente;
	}

	/**
	 * Metodo para retornar o Objeto Item. @return, retorna o Objeto item.
	 */
	public String getItem() {
		return item;
	}

	private DateTimeFormatter getFormatoData() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}

	/**
	 * Metodo para retornar a string da data do emprestimo. @return, retorna a
	 * string dataEmprestimo.
	 */
	public String getDataEmprestimo() {
		return getFormatoData().format(dataEmprestimo);
	}

	/**
	 * Metodo para retornar o periodo do emprestimo em dias. @return, retorna o
	 * inteiro de dias.
	 */
	public int getPeriodo() {
		return periodo;
	}

	public boolean periodoIsVazio(){
		return periodo == 0;
	}

	/**
	 * Metodo para retornar a data de devolução de um emprestimo. @return,
	 * retorna a string dataDevolução.
	 */
	public String getDataDevolucao() {
		if (dataDevolucao == null) {
			return "Emprestimo em andamento";
		}

		return getFormatoData().format(dataDevolucao);

	}

	/**
	 * Metodo para alterar a data de devolução de um emprestimo conforme o
	 * usuario do sistema deseje.
	 * 
	 * @param data,
	 *            String a ser alterado passado por paramtro.
	 */
	public void setDataDevolucao(String data) throws ParseException {
		this.dataDevolucao = LocalDate.parse(data, getFormatoData());
	}

	/**
	 * Metodo para comparar um emprestimo caso o dono, o requerente, o item e a
	 * data sejam iguais.
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
		if ((this.dono.equals(other.dono)) && (this.requerente.equals(other.requerente))
				&& (this.item.equals(other.item)) && (this.dataEmprestimo.equals(other.dataEmprestimo)))
			return true;
		else
			return false;

	}

	/**
	 * Metodo sobreescrito de hashCode() de emprestimo.
	 */
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
	 * 
	 * @param dono,
	 *            valor passado por parametro.
	 * @param requerente,
	 *            valor passado por parametro.
	 * @param item,
	 *            valor passado por parametro.
	 * @param dataInicial,
	 *            valor passado por parametro.
	 * @param periodo,
	 *            valor passado por parametro.
	 */

	public void checaValidadeAtributos(ChaveUsuario dono, ChaveUsuario requerente, String item, String dataInicial,
			int periodo) {

		if (dono == null)
			throw new NullPointerException("Dono nulo");
		if (requerente == null)
			throw new NullPointerException("Requerente nulo");
		if (item == null)
			throw new NullPointerException("Item nulo");
		if (dataInicial == null)
			throw new NullPointerException("Data inicial nulo");
		if (dataInicial.trim().equals(""))
			throw new IllegalArgumentException("Data inicial vazia");
		if (periodo < 0)
			throw new IllegalArgumentException("Periodo invalido");
	}

	/**
	 * Metodo para sobreescrever o toString() de acordo com o padrão necessitado
	 * pelo sistema.
	 */
	@Override
	public String toString() {
		return String.format("EMPRESTIMO - De: %s, Para: %s, %s, %s, %d dias, ENTREGA: %s", getDono().getNome(),
				getRequerente().getNome(), this.getItem(), getDataEmprestimo(), this.periodo, getDataDevolucao());

	}

	/**
	 * Metodo para comparar os emprestimos da coleção de acordo com o nome do
	 * Dono do Item.
	 */
	@Override
	public int compareTo(Emprestimo o) {

		return this.getDono().getNome().compareTo(o.getDono().getNome());
	}
}
