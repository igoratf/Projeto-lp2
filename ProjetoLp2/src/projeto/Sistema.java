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
		this.cItem = new ControllerItem();
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

	public boolean checaSeUsuarioJaExiste(String nome, String telefone) {
		return cUsuario.checaSeUsuarioJaExiste(nome, telefone);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.cadastrarEletronico(nomeItem, preco, plataforma, mapaItensDono);
		cUsuario.addReputacaoItemAdicionado(nome, telefone, preco);
		cUsuario.atualizaCartaoUsuario(nome, telefone);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.cadastrarJogoTabuleiro(nomeItem, preco, mapaItensDono);
		cUsuario.addReputacaoItemAdicionado(nome, telefone, preco);
		cUsuario.atualizaCartaoUsuario(nome, telefone);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.cadastrarBluraySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada,
				mapaItensDono);
		cUsuario.atualizaCartaoUsuario(nome, telefone);
		cUsuario.addReputacaoItemAdicionado(nome, telefone, preco);
	}

	public void adicionarBluRay(String nome, String telefone, String serie, int duracao) {

		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);
		cItem.adicionarBluray(serie, duracao, mapaItensDono);
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.cadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento, mapaItensDono);
		cUsuario.addReputacaoItemAdicionado(nome, telefone, preco);
		cUsuario.atualizaCartaoUsuario(nome, telefone);
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numFaixas, String nomeArtista, String classificacao) {
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.cadastrarBlurayShow(nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao, mapaItensDono);
		cUsuario.addReputacaoItemAdicionado(nome, telefone, preco);
		cUsuario.atualizaCartaoUsuario(nome, telefone);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.adicionarPecaPerdida(nomeItem, nomePeca, mapaItensDono);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.removerItem(nomeItem, mapaItensDono);
		cUsuario.atualizaCartaoUsuario(nome, telefone);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.atualizarItem(nomeItem, atributo, valor, mapaItensDono);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		return cItem.getInfoItem(nomeItem, atributo, mapaItensDono);
	}

	public String listarItensOrdenadosPorNome() {
		List<Item> listItens = cUsuario.getItensUsuarios();

		return cItem.listarItensOrdenadosPorNome(listItens);
	}

	public String listarItensOrdenadosPorValor() {
		List<Item> listItens = cUsuario.getItensUsuarios();
		return cItem.listarItensOrdenadosPorValor(listItens);
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		Map<String, Item> mapaItensUsuario = cUsuario.getItensUsuario(nome, telefone);
		return cItem.pesquisarDetalhesItem(nomeItem, mapaItensUsuario);
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ParseException {
		checaSeUsuarioJaExiste(nomeDono, telefoneDono);
		checaSeUsuarioJaExiste(nomeRequerente, telefoneRequerente);

		if (!cUsuario.podePegarItemEmprestado(nomeRequerente, telefoneRequerente)) {
			throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
		} else if (!cUsuario.validaPeriodoEmprestimo(nomeRequerente, telefoneRequerente, periodo)) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}

		ChaveUsuario dono = new ChaveUsuario(nomeDono, telefoneDono);
		ChaveUsuario requerente = new ChaveUsuario(nomeRequerente, telefoneRequerente);
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nomeDono, telefoneDono);

		cItem.emprestarItem(nomeItem, mapaItensDono);
		double valorItem = mapaItensDono.get(nomeItem).getValor();

		cEmprestimo.registrarEmprestimo(dono, requerente, nomeItem, dataEmprestimo, periodo);
		cUsuario.addReputacaoItemEmprestado(nomeDono, telefoneDono, valorItem);

	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws ParseException {

		checaSeUsuarioJaExiste(nomeDono, telefoneDono);

		ChaveUsuario dono = new ChaveUsuario(nomeDono, telefoneDono);
		ChaveUsuario requerente = new ChaveUsuario(nomeRequerente, telefoneRequerente);
		int diasAtraso = cEmprestimo.devolverItem(dono, requerente, nomeItem, dataEmprestimo, dataDevolucao);

		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nomeDono, telefoneDono);

		double valorItem = mapaItensDono.get(nomeItem).getValor();

		if (diasAtraso <= 0) {
			cUsuario.addReputacaoItemDevolvidoNoPrazo(nomeRequerente, telefoneRequerente, valorItem);
		} else {
			cUsuario.addReputacaoItemDevolvidoAtrasado(nomeRequerente, telefoneRequerente, valorItem, diasAtraso);
		}

		cEmprestimo.devolverItem(dono, requerente, nomeItem, dataEmprestimo, dataDevolucao);
		cItem.devolverItem(nomeItem, mapaItensDono);

	}

	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		cUsuario.checaSeUsuarioJaExiste(nome, telefone);
		return cEmprestimo.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		cUsuario.checaSeUsuarioJaExiste(nome, telefone);

		return cEmprestimo.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}

	public String listarEmprestimosItem(String nomeItem) {
		return cEmprestimo.listarEmprestimosItem(nomeItem);
	}

	public String listarItensEmprestados() {

		return cEmprestimo.listarItensEmprestados();
	}

	public String listarTop10Itens() {

		List<Item> listItens = cUsuario.getItensUsuarios();

		return cItem.listarTop10Itens(listItens);
	}

	public String listarItensNaoEmprestados() {

		List<Item> listItens = cUsuario.getItensUsuarios();

		return cItem.listarItensNaoEmprestados(listItens);

	}

	public String listarCaloteiros() {
		return cUsuario.listarCaloteiros();
	}

	public String listarTop10MelhoresUsuarios() {
		return cUsuario.listarTop10MelhoresUsuarios();
	}

	public String listarTop10PioresUsuarios() {
		return cUsuario.listarTop10PioresUsuarios();
	}

	public void fecharSistema() {

	}

}
