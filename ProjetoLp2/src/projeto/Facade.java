package projeto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;

public class Facade {
	private Sistema sistema;

	public Facade() {
		this.sistema = new Sistema();
	}

	public void iniciarSistema() throws ClassNotFoundException {
		String nomeArquivo = "sistema.dat";
		ObjectInputStream obj = null;
		try {
			FileInputStream f = new FileInputStream(nomeArquivo);
			obj = new ObjectInputStream(f);
			Sistema sistemaLido = (Sistema) obj.readObject();
			this.sistema = sistemaLido;

		} catch (ClassNotFoundException | IOException e) {
			throw new ClassNotFoundException("Falha na leitura");
		} finally {
			try {
				if (obj != null)
					obj.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	

	public void cadastrarUsuario(String nome, String telefone, String email) {
		sistema.cadastrarUsuario(nome, telefone, email);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return sistema.getInfoUsuario(nome, telefone, atributo);
	}

	public void removerUsuario(String nome, String telefone) {
		sistema.removerUsuario(nome, telefone);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		sistema.atualizarUsuario(nome, telefone, atributo, valor);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		sistema.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		sistema.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		sistema.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero,
				temporada);
	}

	// L
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		sistema.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}

	// L
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		sistema.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numFaixas, String nomeArtista, String classificacao) {
		sistema.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		sistema.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		sistema.removerItem(nome, telefone, nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		sistema.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return sistema.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	public String listarItensOrdenadosPorNome() {
		return sistema.listarItensOrdenadosPorNome();
	}

	public String listarItensOrdenadosPorValor() {
		return sistema.listarItensOrdenadosPorValor();
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return sistema.pesquisarDetalhesItem(nome, telefone, nomeItem);
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ParseException {
		sistema.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
				dataEmprestimo, periodo);

	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws ParseException {
		sistema.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo,
				dataDevolucao);
	}

	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		return sistema.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		return sistema.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}

	public String listarEmprestimosItem(String nomeItem) {
		return sistema.listarEmprestimosItem(nomeItem);
	}

	public String listarItensEmprestados() {
		return sistema.listarItensEmprestados();
	}

	public String listarItensNaoEmprestados() {
		return sistema.listarItensNaoEmprestados();
	}

	public String listarTop10Itens() {
		return sistema.listarTop10Itens();
	}

	public String listarCaloteiros() {
		return sistema.listarCaloteiros();
	}

	public String listarTop10MelhoresUsuarios() {
		return sistema.listarTop10MelhoresUsuarios();
	}

	public String listarTop10PioresUsuarios() {
		return sistema.listarTop10PioresUsuarios();
	}

	public void fecharSistema() throws IOException {
		String nomeArquivo = "sistema.dat";
		ObjectOutputStream obj = null;
		try {
			FileOutputStream f = new FileOutputStream(nomeArquivo);
			obj = new ObjectOutputStream(f);
			obj.writeObject(sistema);

		} catch (IOException e) {
			throw new IOException("Falha ao Salvar Sistema");
		} finally {
			try {
				if (obj != null)
					obj.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
