package projeto.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import projeto.ChaveUsuario;
import projeto.Emprestimo;

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
	public int devolverItem(ChaveUsuario dono, ChaveUsuario requerente, String nomeItem, String dataEmprestimo,
			String dataDevolucao) throws ParseException{
		Emprestimo emprestimo = new Emprestimo(dono, requerente, nomeItem, dataEmprestimo, 0);
		
		if (!emprestimos.contains(emprestimo)) throw new IllegalArgumentException("Emprestimo nao encontrado");
		
		getEmprestimoEspecifico(emprestimo).setDataDevolucao(dataDevolucao);
		
		SimpleDateFormat formatoData =  new SimpleDateFormat("dd/MM/yyyy");

		Date dataEmprestimo1 = formatoData.parse(dataEmprestimo);

		Date dataDevolucao1 = formatoData.parse(dataDevolucao);

		

		int diasAtraso = (int)((dataDevolucao1.getTime() - dataEmprestimo1.getTime()) / 86400000L) - getEmprestimoEspecifico(emprestimo).getPeriodo() ;

		return diasAtraso;
		
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
		retonarEmprestimosOrdenadosPorNome(emprestimosTemp);
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
		retonarEmprestimosOrdenadosPorNome(emprestimosTemp);
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
	
	/**
	 * Metodo para encontrar um emprestimo em especifico no historico de emprestimos do Controller.
	 * @param emprestimo, Emprestimo passado por parametro.
	 * @return, retorna o emprestimo encontrado.
	 */
	public Emprestimo getEmprestimoEspecifico(Emprestimo emprestimo){
		for (Emprestimo emprestimoLista : emprestimos) {
			if (emprestimoLista.equals(emprestimo))
				return emprestimoLista;
		}
		throw new IllegalArgumentException("Emprestimo nao encontrado");
	}
	
	/**
	 * Metodo para listar os emprestimos associados ao item de acordo com o nome do mesmo.
	 * @return, retorna a lista de emprestimos encontrados naquele item.
	 */
	public String listarEmprestimosItem(String nomeItem) {
		String retorno = "Emprestimos associados ao item: ";
		for (Emprestimo emprestimo: emprestimos) {
			if (emprestimo.getItem().equals(nomeItem))
				retorno += emprestimo.toString() + "|";
		}
		if (retorno.equals("Emprestimos associados ao item: "))
			return "Nenhum emprestimos associados ao item";
		
		return retorno;
	}

	/**
	 * Metodo para listar todos os itens emprestados nesse momento.
	 * @return, retorna a lista de itens emprestados junto com o nome do dono.
	 */
	public String listarItensEmprestados(){
		String itens = "";
		ArrayList<Emprestimo> emprestimosTemp = (ArrayList<Emprestimo>) emprestimos;
		Collections.sort(emprestimosTemp);
		for (Emprestimo emprestimo : emprestimosTemp) {
			if (emprestimo.getDataDevolucao().equals("Emprestimo em andamento")) {
				itens += "Dono do item: " + emprestimo.getDono().getNome() + ", Nome do item emprestado: " 
						+ emprestimo.getItem() + "|";
			}
		}
		
		return itens;
	}
	
	/**
	 * Metodo para ordenar uma lista de emprestimos por nome.
	 * @param emprestimos, Lista de emprestimos passado por parametro.
	 * @return, retorna a lista ordenada.
	 */
	public List<Emprestimo> retonarEmprestimosOrdenadosPorNome(ArrayList<Emprestimo> emprestimos){
		ArrayList<Emprestimo> emprestimosTemp = emprestimos;
		Collections.sort(emprestimosTemp);
		return emprestimosTemp;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}



}
