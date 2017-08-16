package projeto;

import java.text.ParseException;
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

		

		Usuario dono = this.mapaUsuarios.get(chaveDono);
		Usuario requerente = this.mapaUsuarios.get(chaveRequerente); 
		
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
	
	/*
	 * public Emprestimo getEmprestimo(Usuario dono, Usuario requerente, Item item, String dataEmprestimo)
			throws ParseException {
		Emprestimo emprestimoParametro = new Emprestimo(dono, requerente, item, dataEmprestimo, 0);
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.equals(emprestimoParametro))
				return emprestimo;
		}
		throw new IllegalArgumentException("Emprestimo nao encontrado");
	}
	
	public Emprestimo getEmprestimo(String nome, String telefone, Usuario dono, Usuario requerente, Item item,
			String dataEmprestimo) throws ParseException {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);

		return mapaUsuarios.get(chave).getEmprestimo(dono, requerente, item, dataEmprestimo);
	}
	 */
	/*
	 * public ArrayList<Emprestimo> getEmprestimosFeitos() {
		ArrayList<Emprestimo> emprestimosTemp = new ArrayList<>();
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getDono().getNome().equals(this.nome)
					&& emprestimo.getDono().getNumCelular() == this.numCelular) {
				emprestimosTemp.add(emprestimo);
			}
		}
		return emprestimosTemp;
	}

	public ArrayList<Emprestimo> getEmprestimosPegos() {
		ArrayList<Emprestimo> emprestimosTemp = new ArrayList<>();
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getRequerente().getNome().equals(this.nome)
					&& emprestimo.getRequerente().getNumCelular() == this.numCelular) {
				emprestimosTemp.add(emprestimo);
			}
		}
		return emprestimosTemp;
	}

	 * 	/**
	
	
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ParseException {

		checaSeUsuarioJaExiste(nomeDono, telefoneDono);
		checaSeUsuarioJaExiste(nomeRequerente, telefoneRequerente);

		ChaveUsuario chaveDono = new ChaveUsuario(nomeDono, telefoneDono);
		ChaveUsuario chaveRequerente = new ChaveUsuario(nomeRequerente, telefoneRequerente);
		Usuario dono = this.mapaUsuarios.get(chaveDono);
		Usuario requerente = this.mapaUsuarios.get(chaveRequerente);
		dono.emprestarItem(nomeItem);
		Item item = dono.getItem(nomeItem);

		Emprestimo emprestimo = new Emprestimo(dono, requerente, item, dataEmprestimo, periodo);
		dono.cadastroEmprestimo(emprestimo);
		requerente.cadastroEmprestimo(emprestimo);

	}
	
	/**

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws ParseException {
		checaSeUsuarioJaExiste(nomeDono, telefoneDono);
		checaSeUsuarioJaExiste(nomeRequerente, telefoneRequerente);

		ChaveUsuario chaveDono = new ChaveUsuario(nomeDono, telefoneDono);
		ChaveUsuario chaveRequerente = new ChaveUsuario(nomeRequerente, telefoneRequerente);
		Usuario dono = this.mapaUsuarios.get(chaveDono);
		Usuario requerente = this.mapaUsuarios.get(chaveRequerente);
		Item item = dono.getItem(nomeItem);
		dono.devolverItem(nomeItem);

		dono.getEmprestimo(dono, requerente, item, dataEmprestimo).setDataDevolucao(dataDevolucao);
		requerente.getEmprestimo(dono, requerente, item, dataEmprestimo).setDataDevolucao(dataDevolucao);
	}
	
		public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		String retorno = "Emprestimos: ";
		ArrayList<Emprestimo> emprestimos = mapaUsuarios.get(chave).getEmprestimosFeitos();
		for (Emprestimo emprestimo : emprestimos) {
			retorno += emprestimo.toString() + "|";
		}
		if (emprestimos.size() == 0) {
			return "Nenhum item emprestado";
		}

		return retorno;

	}
	
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		String retorno = "Emprestimos pegos: ";
		ArrayList<Emprestimo> emprestimos = mapaUsuarios.get(chave).getEmprestimosPegos();
		for (Emprestimo emprestimo : emprestimos) {
			retorno += emprestimo.toString() + "|";
		}
		if (emprestimos.size() == 0) {
			return "Nenhum item pego emprestado";
		}

		return retorno;
	}
	 */
	

}
