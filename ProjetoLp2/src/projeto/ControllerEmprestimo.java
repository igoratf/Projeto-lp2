package projeto;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControllerEmprestimo {

	private List<Emprestimo> emprestimos;

	public ControllerEmprestimo() {
		emprestimos = new ArrayList<>();
	}

	/**
	 * Metodo para registrar um emprestimo nessa classe.
	 * @param dono, ChaveUsuario passado por parametro.
	 * @param requerente, ChaveUsuario passado por parametro.
	 * @param nomeItem, String passado por parametro.
	 * @param dataEmprestimo, String passado por parametro.
	 * @param periodo, Integer passado por parametro.
	 * @throws ParseException
	 */
	public void registrarEmprestimo(ChaveUsuario dono, ChaveUsuario requerente, String nomeItem, String dataEmprestimo,
			int periodo) throws ParseException {
		Emprestimo emprestimo = new Emprestimo(dono, requerente, nomeItem, dataEmprestimo, periodo);
		emprestimos.add(emprestimo);

	}
	
	/**
	 * Metodo para registrar um fechamento de um emprestimo realizado com a data de devolução.
	 * @param dono, ChaveUsuario passado por parametro.
	 * @param requerente, ChaveUsuario passado por parametro.
	 * @param nomeItem, String passado por parametro.
	 * @param dataEmprestimo, String passado por parametro.
	 * @param dataDevolucao,  String passado por parametro.
	 * @throws ParseException
	 */
	public void devolverItem(ChaveUsuario dono, ChaveUsuario requerente, String nomeItem, String dataEmprestimo,
			String dataDevolucao) throws ParseException{
		Emprestimo emprestimo = new Emprestimo(dono, requerente, nomeItem, dataEmprestimo, 0);
		
		if (!emprestimos.contains(emprestimo)) throw new IllegalArgumentException("Emprestimo nao encontrado");
		
		getEmprestimoEspecifico(emprestimo).setDataDevolucao(dataDevolucao);
		
	}

	/**
	 * Metodo para verificar se o Usuario passado por parametro emprestou algum item.
	 * @param dono, ChaveUsuario passado por parametro. 
	 * @return, retorna a lista de emprestimos realizado ordenados em ordem lexicografica.
	 */
	public ArrayList<Emprestimo> getEmprestimosFeitos(ChaveUsuario dono) {
		ArrayList<Emprestimo> emprestimosTemp = new ArrayList<>();
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getDono().equals(dono)) {
				emprestimosTemp.add(emprestimo);
			}
		}
		emprestimosTemp.sort(new ComparaNomeEmprestimo());
		return emprestimosTemp;
	}

	/**
	 * Metodo para verificar se o Usuario passado por parametro pegou algum item emprestado.
	 * @param dono, ChaveUsuario passado por parametro. 
	 * @return, retorna a lista de emprestimos realizado ordenados em ordem lexicografica.
	 */
	public ArrayList<Emprestimo> getEmprestimosPegos(ChaveUsuario requerente) {
		ArrayList<Emprestimo> emprestimosTemp = new ArrayList<>();
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getRequerente().equals(requerente)) {
				emprestimosTemp.add(emprestimo);
			}
		}
		emprestimosTemp.sort(new ComparaNomeEmprestimo());
		return emprestimosTemp;
	}

	/**
	 * Listagem dos emprestimo em que o Usuario era o dono do item.
	 * @param nome, String passado por parametro.
	 * @param telefone, String passado por parametro.
	 * @return, retorna a lista de emprestimos realizados em ordem lexicografica.
	 */
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		String retorno = "Emprestimos: ";
		ArrayList<Emprestimo> emprestimos = getEmprestimosFeitos(chave);
		for (Emprestimo emprestimo : emprestimos) {
			retorno += emprestimo.toString() + "|";
		}
		if (emprestimos.size() == 0) {
			return "Nenhum item emprestado";
		}

		return retorno;

	}

/**
 * 	 * Listagem dos emprestimo em que o Usuario pegou um item emprestado.
	 * @param nome, String passado por parametro.
	 * @param telefone, String passado por parametro.
	 * @return, retorna a lista de emprestimos realizados em ordem lexicografica.
	 
 */
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		String retorno = "Emprestimos pegos: ";
		ArrayList<Emprestimo> emprestimos = getEmprestimosPegos(chave);
		for (Emprestimo emprestimo : emprestimos) {
			retorno += emprestimo.toString() + "|";
		}
		if (emprestimos.size() == 0) {
			return "Nenhum item pego emprestado";
		}

		return retorno;
	}
	
	public Emprestimo getEmprestimoEspecifico(Emprestimo emprestimo){
		for (Emprestimo emprestimoLista : emprestimos) {
			if (emprestimoLista.equals(emprestimo))
				return emprestimoLista;
		}
		throw new IllegalArgumentException("Emprestimo nao encontrado");
	}


	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	/*
	 * public Emprestimo getEmprestimo(Usuario dono, Usuario requerente, Item
	 * item, String dataEmprestimo) throws ParseException { Emprestimo
	 * emprestimoParametro = new Emprestimo(dono, requerente, item,
	 * dataEmprestimo, 0); for (Emprestimo emprestimo : emprestimos) { if
	 * (emprestimo.equals(emprestimoParametro)) return emprestimo; } throw new
	 * IllegalArgumentException("Emprestimo nao encontrado"); }
	 * 
	 * public Emprestimo getEmprestimo(String nome, String telefone, Usuario
	 * dono, Usuario requerente, Item item, String dataEmprestimo) throws
	 * ParseException { ChaveUsuario chave = new ChaveUsuario(nome, telefone);
	 * 
	 * return mapaUsuarios.get(chave).getEmprestimo(dono, requerente, item,
	 * dataEmprestimo); }
	 */
	/*
	 * public ArrayList<Emprestimo> getEmprestimosFeitos() {
	 * ArrayList<Emprestimo> emprestimosTemp = new ArrayList<>(); for
	 * (Emprestimo emprestimo : emprestimos) { if
	 * (emprestimo.getDono().getNome().equals(this.nome) &&
	 * emprestimo.getDono().getNumCelular() == this.numCelular) {
	 * emprestimosTemp.add(emprestimo); } } return emprestimosTemp; }
	 * 
	 * public ArrayList<Emprestimo> getEmprestimosPegos() {
	 * ArrayList<Emprestimo> emprestimosTemp = new ArrayList<>(); for
	 * (Emprestimo emprestimo : emprestimos) { if
	 * (emprestimo.getRequerente().getNome().equals(this.nome) &&
	 * emprestimo.getRequerente().getNumCelular() == this.numCelular) {
	 * emprestimosTemp.add(emprestimo); } } return emprestimosTemp; }
	 * 
	 * /**
	 * 
	 * 
	 * public void registrarEmprestimo(String nomeDono, String telefoneDono,
	 * String nomeRequerente, String telefoneRequerente, String nomeItem, String
	 * dataEmprestimo, int periodo) throws ParseException {
	 * 
	 * checaSeUsuarioJaExiste(nomeDono, telefoneDono);
	 * checaSeUsuarioJaExiste(nomeRequerente, telefoneRequerente);
	 * 
	 * ChaveUsuario chaveDono = new ChaveUsuario(nomeDono, telefoneDono);
	 * ChaveUsuario chaveRequerente = new ChaveUsuario(nomeRequerente,
	 * telefoneRequerente); Usuario dono = this.mapaUsuarios.get(chaveDono);
	 * Usuario requerente = this.mapaUsuarios.get(chaveRequerente);
	 * dono.emprestarItem(nomeItem); Item item = dono.getItem(nomeItem);
	 * 
	 * Emprestimo emprestimo = new Emprestimo(dono, requerente, item,
	 * dataEmprestimo, periodo); dono.cadastroEmprestimo(emprestimo);
	 * requerente.cadastroEmprestimo(emprestimo);
	 * 
	 * }
	 * 
	 * /**
	 * 
	 * public void devolverItem(String nomeDono, String telefoneDono, String
	 * nomeRequerente, String telefoneRequerente, String nomeItem, String
	 * dataEmprestimo, String dataDevolucao) throws ParseException {
	 * checaSeUsuarioJaExiste(nomeDono, telefoneDono);
	 * checaSeUsuarioJaExiste(nomeRequerente, telefoneRequerente);
	 * 
	 * ChaveUsuario chaveDono = new ChaveUsuario(nomeDono, telefoneDono);
	 * ChaveUsuario chaveRequerente = new ChaveUsuario(nomeRequerente,
	 * telefoneRequerente); Usuario dono = this.mapaUsuarios.get(chaveDono);
	 * Usuario requerente = this.mapaUsuarios.get(chaveRequerente); Item item =
	 * dono.getItem(nomeItem); dono.devolverItem(nomeItem);
	 * 
	 * dono.getEmprestimo(dono, requerente, item,
	 * dataEmprestimo).setDataDevolucao(dataDevolucao);
	 * requerente.getEmprestimo(dono, requerente, item,
	 * dataEmprestimo).setDataDevolucao(dataDevolucao); }
	 * 
	 * public String listarEmprestimosUsuarioEmprestando(String nome, String
	 * telefone) { ChaveUsuario chave = new ChaveUsuario(nome, telefone); String
	 * retorno = "Emprestimos: "; ArrayList<Emprestimo> emprestimos =
	 * mapaUsuarios.get(chave).getEmprestimosFeitos(); for (Emprestimo
	 * emprestimo : emprestimos) { retorno += emprestimo.toString() + "|"; } if
	 * (emprestimos.size() == 0) { return "Nenhum item emprestado"; }
	 * 
	 * return retorno;
	 * 
	 * }
	 * 
	 * public String listarEmprestimosUsuarioPegandoEmprestado(String nome,
	 * String telefone) { ChaveUsuario chave = new ChaveUsuario(nome, telefone);
	 * String retorno = "Emprestimos pegos: "; ArrayList<Emprestimo> emprestimos
	 * = mapaUsuarios.get(chave).getEmprestimosPegos(); for (Emprestimo
	 * emprestimo : emprestimos) { retorno += emprestimo.toString() + "|"; } if
	 * (emprestimos.size() == 0) { return "Nenhum item pego emprestado"; }
	 * 
	 * return retorno; }
	 * 
	 * 
	 * public void devolverItem(String nomeItem) {
	 * 
	 * Item meuItem = getItem(nomeItem); getItem(nomeItem);
	 * meuItem.setEstadoDeEmprestimo(false); }
	 */

}
