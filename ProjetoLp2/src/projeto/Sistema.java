package projeto;

import java.text.ParseException;

public class Sistema {

	private ControllerUsuario cUsuario;

	public Sistema() {

		this.cUsuario = new ControllerUsuario();
	}

	public void iniciarSistema() {
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		cUsuario.cadastrarUsuario(nome, telefone, email);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return cUsuario.getInfoUsuario(nome, telefone, atributo);
	}

	public void removerUsuario(String nome, String telefone) {
		cUsuario.removerUsuario(nome, telefone);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		cUsuario.atualizarUsuario(nome, telefone, atributo, valor);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		cUsuario.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		cUsuario.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		cUsuario.cadastrarBluraySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero,
				temporada);
	}

	// L
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		cUsuario.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}

	// L
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		cUsuario.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numFaixas, String nomeArtista, String classificacao) {
		cUsuario.cadastrarBlurayShow(nome, telefone, nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		cUsuario.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		cUsuario.removerItem(nome, telefone, nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		cUsuario.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return cUsuario.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	public String listarItensOrdenadosPorNome() {
		return cUsuario.listarItensOrdenadosPorNome();
	}

	public String listarItensOrdenadosPorValor() {
		return cUsuario.listarItensOrdenadosPorValor();
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return cUsuario.pesquisarDetalhesItem(nome, telefone, nomeItem);
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ParseException {
		cUsuario.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
				dataEmprestimo, periodo);

	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws ParseException {
		cUsuario.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo,
				dataDevolucao);
	}

	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		return cUsuario.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		return cUsuario.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}
	/*
	 * public String listarEmprestimosItem(String nomeItem) { return
	 * controller.listarEmprestimosItem(nomeItem); }
	 * 
	 * public String listarItensEmprestados() { return
	 * controller.listarItensEmprestados(); }
	 * 
	 * public String listarItensNaoEmprestados() { return
	 * controller.listarItensNaoEmprestados(); }
	 * 
	 * public String listarTop10Itens() { return controller.listarTop10itens(); }
	 */

	public void fecharSistema() {

	}

}
