package projeto;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class Sistema {

	private ControllerUsuario cUsuario;
	private ControllerItem cItem;
	private ControllerEmprestimo cEmprestimo;

	public Sistema() {

		this.cUsuario = new ControllerUsuario();
		this.cItem = new ControllerItem(this);
		this.cEmprestimo = new ControllerEmprestimo();

	}

	public void iniciarSistema() {
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		cUsuario.cadastrarUsuario(nome, telefone, email);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return cUsuario.getInfoUsuario(nome, telefone, atributo);
	}

	public Map<String, Item> getItensUsuario(String nome, String telefone) {
		return cUsuario.getItensUsuario(nome, telefone);
	}

	public List<Item> getItensUsuarios() {
		return cUsuario.getItensUsuarios();
	}

	public void removerUsuario(String nome, String telefone) {
		cUsuario.removerUsuario(nome, telefone);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		cUsuario.atualizarUsuario(nome, telefone, atributo, valor);
	}
	
	public boolean checaSeUsuarioJaExiste(String nome,String telefone){
		return cUsuario.checaSeUsuarioJaExiste(nome, telefone);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		cItem.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		cItem.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		cItem.cadastrarBluraySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero,
				temporada);
	}

	// L
	public void adicionarBluRay(String nome, String telefone, String serie, int duracao) {
		cItem.adicionarBluray(nome, telefone, serie, duracao);
	}

	// L
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		cItem.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numFaixas, String nomeArtista, String classificacao) {
		cItem.cadastrarBlurayShow(nome, telefone, nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		cItem.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		cItem.removerItem(nome, telefone, nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		cItem.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return cItem.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	public String listarItensOrdenadosPorNome() {
		return cItem.listarItensOrdenadosPorNome();
	}

	public String listarItensOrdenadosPorValor() {
		return cItem.listarItensOrdenadosPorValor();
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return cItem.pesquisarDetalhesItem(nome, telefone, nomeItem);
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ParseException {
		checaSeUsuarioJaExiste(nomeDono, telefoneDono);
		checaSeUsuarioJaExiste(nomeRequerente, telefoneRequerente);
		ChaveUsuario dono = new ChaveUsuario(nomeDono, telefoneDono);
		ChaveUsuario requerente = new ChaveUsuario(nomeRequerente, telefoneRequerente);
		
		cItem.emprestarItem(nomeDono, telefoneDono, nomeItem);
		cEmprestimo.registrarEmprestimo(dono, requerente, nomeItem,dataEmprestimo, periodo);

	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws ParseException  {
		
		checaSeUsuarioJaExiste(nomeDono, telefoneDono);
		checaSeUsuarioJaExiste(nomeRequerente, telefoneRequerente);
		ChaveUsuario dono = new ChaveUsuario(nomeDono, telefoneDono);
		ChaveUsuario requerente = new ChaveUsuario(nomeRequerente, telefoneRequerente);
		
		cEmprestimo.devolverItem(dono, requerente, nomeItem, dataEmprestimo, dataDevolucao);
		cItem.devolverItem(nomeDono, telefoneDono, nomeItem);
	}

	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		return cEmprestimo.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		return cEmprestimo.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}
	
	public String listarEmprestimosItem(String nomeItem) {
		return cEmprestimo.listarEmprestimosItem(nomeItem);
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
	 * public String listarTop10Itens() { return controller.listarTop10itens();
	 * }
	 */

	public void fecharSistema() {

	}

}
