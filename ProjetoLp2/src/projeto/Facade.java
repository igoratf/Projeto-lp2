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

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		controller.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		controller.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		controller.removerItem(nome, telefone, nomeItem);
	}

	public Item getItem(String nome, String telefone, String nomeItem) {
		return controller.getItem(nome, telefone, nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		controller.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}
	public String getInfoItem(String nome, String telefone,String nomeItem,String atributo){
		return controller.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	public void fecharSistema() {

	}

}
