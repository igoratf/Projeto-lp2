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
		Map mapaItensDono = cUsuario.getItensUsuario(nome, telefone);
		
		cItem.cadastrarEletronico(nomeItem, preco, plataforma, mapaItensDono);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		Map mapaItensDono = cUsuario.getItensUsuario(nome, telefone);
		
		cItem.cadastrarJogoTabuleiro(nomeItem, preco, mapaItensDono);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		Map mapaItensDono = cUsuario.getItensUsuario(nome, telefone);
		
		cItem.cadastrarBluraySerie(nomeItem, preco, descricao, duracao, classificacao, genero,
				temporada, mapaItensDono);
	}

	
	public void adicionarBluRay(String nome, String telefone, String serie, int duracao) {
		
		Map mapaItensDono = cUsuario.getItensUsuario(nome, telefone);
		cItem.adicionarBluray(serie, duracao, mapaItensDono);
	}

	
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		Map mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.cadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento, mapaItensDono);
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numFaixas, String nomeArtista, String classificacao) {
		Map mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.cadastrarBlurayShow(nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao, mapaItensDono);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		Map mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.adicionarPecaPerdida(nomeItem, nomePeca, mapaItensDono);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		Map mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.removerItem(nomeItem, mapaItensDono);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		Map mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.atualizarItem(nomeItem, atributo, valor, mapaItensDono);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		Map mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		return cItem.getInfoItem(nomeItem, atributo, mapaItensDono);
	}

	public String listarItensOrdenadosPorNome() {
		List listItens = cUsuario.getItensUsuarios();

		return cItem.listarItensOrdenadosPorNome(listItens);
	}

	public String listarItensOrdenadosPorValor() {
		List listItens = cUsuario.getItensUsuarios();
		return cItem.listarItensOrdenadosPorValor(listItens);
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		Map mapaItensUsuario = cUsuario.getItensUsuario(nome, telefone);
		return cItem.pesquisarDetalhesItem(nome, telefone, nomeItem, mapaItensUsuario);
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ParseException {
		checaSeUsuarioJaExiste(nomeDono, telefoneDono);
		checaSeUsuarioJaExiste(nomeRequerente, telefoneRequerente);
		ChaveUsuario dono = new ChaveUsuario(nomeDono, telefoneDono);
		ChaveUsuario requerente = new ChaveUsuario(nomeRequerente, telefoneRequerente);
		Map mapaItensDono = cUsuario.getItensUsuario(nomeDono, telefoneDono);
		
		cItem.emprestarItem(nomeDono, telefoneDono, nomeItem, mapaItensDono);
		cEmprestimo.registrarEmprestimo(dono, requerente, nomeItem,dataEmprestimo, periodo);

	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws ParseException  {
		
		checaSeUsuarioJaExiste(nomeDono, telefoneDono);
		checaSeUsuarioJaExiste(nomeRequerente, telefoneRequerente);
		ChaveUsuario dono = new ChaveUsuario(nomeDono, telefoneDono);
		ChaveUsuario requerente = new ChaveUsuario(nomeRequerente, telefoneRequerente);
		Map mapaItensDono = cUsuario.getItensUsuario(nomeDono, telefoneDono);	
		
		cEmprestimo.devolverItem(dono, requerente, nomeItem, dataEmprestimo, dataDevolucao);
		cItem.devolverItem(nomeDono, telefoneDono, nomeItem, mapaItensDono);
		
		
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
