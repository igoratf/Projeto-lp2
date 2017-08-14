package projeto;

public class Facade {
	private ControllerUsuario controller;
	public Facade(){
		this.controller = new ControllerUsuario();
	}

	public void iniciarSistema() {
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		controller.cadastrarUsuario(nome, telefone, email);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return controller.getInfoUsuario(nome, telefone, atributo);
	}

	public void removerUsuario(String nome, String telefone) {
		controller.removerUsuario(nome, telefone);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		controller.atualizarUsuario(nome, telefone, atributo, valor);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco,
			String plataforma) {
		controller.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		controller.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}
	
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		controller.cadastrarBluraySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}
	//L
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao){
		controller.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}
	
	//L
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		controller.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}
	public void cadastrarBluRayShow(String nome, String telefone,String nomeItem, double preco, int duracao, int numFaixas,String nomeArtista,String classificacao) {
		controller.cadastrarBlurayShow(nome, telefone, nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		controller.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		controller.removerItem(nome, telefone, nomeItem);
	}


	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		controller.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}
	public String getInfoItem(String nome, String telefone,String nomeItem,String atributo){
		return controller.getInfoItem(nome, telefone, nomeItem, atributo);
	}
	public String listarItensOrdenadosPorNome(){
		return controller.listarItensOrdenadosPorNome();
	}
	public String listarItensOrdenadosPorValor() {
		return controller.listarItensOrdenadosPorValor();
	}
	
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return controller.pesquisarDetalhesItem(nome, telefone, nomeItem);
	}
	
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo){
		controller.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
		
	}
	
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, String dataDevolucao){
		controller.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
	}
	
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		controller.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}
	
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		controller.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}
	
	public String listarEmprestimosItem(String nomeItem) {
		controller.listarEmprestimosItem(nomeItem);
	}
	
	public String listarItensEmprestados() {
		controller.listarItensEmprestados();
	}
	
	public String listarItensNaoEmprestados() {
		controller.listarItensNaoEmprestados();
	}
	
	public String listarTop10Itens() {
		controller.listarTop10itens();
	}

	public void fecharSistema() {

	}

}
