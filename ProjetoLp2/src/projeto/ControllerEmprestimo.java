package projeto;

import java.util.ArrayList;
import java.util.List;

public class ControllerEmprestimo {
	
	private List<Emprestimo> emprestimos;
	
	
	public ControllerEmprestimo() {
		emprestimos = new ArrayList<>();
	}
	
	/**
	 * Metodo para registrar um emprestimo entre um Usuario dono e um Usuario
	 * requerente, passando o item que pertence ao dono para um estado de
	 * emprestimo true.
	 * 
	 * @param nomeDono,
	 *            String passsado por parametro.
	 * @param telefoneDono,
	 *            String passsado por parametro.
	 * @param nomeRequerente,
	 *            String passsado por parametro.
	 * @param telefoneRequerente,
	 *            String passsado por parametro.
	 * @param nomeItem,
	 *            String passsado por parametro.
	 * @param dataEmprestimo,
	 *            String passsado por parametro.
	 * @param periodo,
	 *            Inteiro passado por paramtro.
	 */
	public void registrarEmprestimo(ChaveUsuario dono, ChaveUsuario requerente, String nomeItem, String dataEmprestimo, int periodo) {


		dono.emprestarItem(nomeItem);


		Emprestimo emprestimo = new Emprestimo(dono, requerente, item, dataEmprestimo, periodo);
		dono.cadastroEmprestimo(emprestimo);
		requerente.cadastroEmprestimo(emprestimo);

	}

	/**
	 * Metodo para devolver um item que já esteja emprestado, tornado o item que
	 * pertence ao Usuario dono para um estado de emprestimo false.
	 * 
	 * @param nomeDono,
	 *            String passsado por parametro.
	 * @param telefoneDono,
	 *            String passsado por parametro.
	 * @param nomeRequerente,
	 *            String passsado por parametro.
	 * @param telefoneRequerente,
	 *            String passsado por parametro.
	 * @param nomeItem,
	 *            String passsado por parametro.
	 * @param dataEmprestimo,
	 *            String passsado por parametro.
	 * @param dataDevolucao,
	 *            String passsado por parametro.
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {

		
		Usuario dono = this.mapaUsuarios.get(chaveDono);
		Usuario requerente = this.mapaUsuarios.get(chaveRequerente);
		Item item = dono.getItem(nomeItem);
		dono.devolverItem(nomeItem);

		dono.getEmprestimo(dono, requerente, item, dataEmprestimo).setDataDevolucao(dataDevolucao);
		requerente.getEmprestimo(dono, requerente, item, dataEmprestimo).setDataDevolucao(dataDevolucao);
	}
	
	
	
	
	
	
	
	
	
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	

}
