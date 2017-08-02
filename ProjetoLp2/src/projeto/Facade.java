package projeto;

public class Facade {
	private ControllerUsuario controller;
	public Facade(){
		this.controller = new ControllerUsuario();
		
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
	public String atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		return controller.atualizarUsuario(nome, telefone, atributo, valor);
	}

}
