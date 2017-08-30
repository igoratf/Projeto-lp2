package projeto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;

/**
 * Classe de Fachada
 * 
 * @author caiosbl
 *
 */

public class Facade {
	private Sistema sistema;

	public Facade() {
		this.sistema = new Sistema();
	}

	/**
	 * Carrega a versão salva do Sistema.
	 * 
	 * @throws ClassNotFoundException
	 *             Se o arquivo não for encontrado.
	 */
	public void iniciarSistema() throws ClassNotFoundException {
		try {
			String nomeArquivo = "storage/sistema.dat";
			File arquivo = new File(nomeArquivo);
			if (arquivo.exists()) {
				FileInputStream f = new FileInputStream(nomeArquivo);
				ObjectInputStream obj = new ObjectInputStream(f);
				Sistema sistemaLido = (Sistema) obj.readObject();
				this.sistema = sistemaLido;
				obj.close();
			} else {
				this.sistema = new Sistema();
			}
		} catch (IOException e) {
			throw new ClassNotFoundException("Falha na leitura");
		}
	}

	/**
	 * Cadastra um usuário no sistema
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param email
	 *            email do usuario
	 */
	public void cadastrarUsuario(String nome, String telefone, String email) {
		sistema.cadastrarUsuario(nome, telefone, email);
	}

	/**
	 * Busca as informacões de um usuario
	 * 
	 * @param nome
	 *            nome do usuario a ser consultado
	 * @param telefone[
	 *            telefone do usuario a ser consultado
	 * @param atributo
	 *            atributo do usuario a ser consultado
	 * @return Retorna a string que representa o atributo consultado
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return sistema.getInfoUsuario(nome, telefone, atributo);
	}

	/**
	 * Remove um usuario do sistema
	 * 
	 * @param nome
	 *            nome do usuario a ser removido
	 * @param telefone
	 *            telefone do usuario a ser removido
	 */
	public void removerUsuario(String nome, String telefone) {
		sistema.removerUsuario(nome, telefone);
	}

	/**
	 * Atualiza um atributo de um usuario
	 * 
	 * @param nome
	 *            nome do usuario a ter o atributo atualizado
	 * @param telefone
	 *            telefone do usuario a ter o atributo atualizado
	 * @param atributo
	 *            atributo do usuario a ser atualizado
	 * @param valor
	 *            novo valor para o atributo a ser atualziado
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		sistema.atualizarUsuario(nome, telefone, atributo, valor);
	}

	/**
	 * Cadastra um novo eletronico no sistema
	 * 
	 * @param nome
	 *            nome do dono do eletronico a ser cadastrado
	 * @param telefone
	 *            telefone do dono do eletronico a ser cadastrado
	 * @param nomeItem
	 *            nome do eletronico a ser cadastrado
	 * @param preco
	 *            preço do eletronico a ser cadastrado
	 * @param plataforma
	 *            plataforma do eletronico a ser cadastrado
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		sistema.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	/**
	 * Cadastra um novo jogo de tabuleiro no sistema.
	 * 
	 * @param nome
	 *            nome do dono do jogo de tabuleiro a ser cadstrado
	 * @param telefone
	 *            telefone do dono do jogo de tabuleiro a ser castrado
	 * @param nomeItem
	 *            nome do jogo de tabuleiro a ser cadastrado
	 * @param preco
	 *            preço do jogo de tabuleiro a ser cadastrado
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		sistema.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	/**
	 * Cadastra um bluray serie
	 * 
	 * @param nome
	 *            nome do dono do bluray serie a ser cadastrado
	 * @param telefone
	 *            telefone do dono do bluray serie a ser cadastrado
	 * @param nomeItem
	 *            nome da serie gravada do bluray
	 * @param preco
	 *            preço do blyray serie a ser cadastrado
	 * @param descricao
	 *            descrição do bluray
	 * @param duracao
	 *            duração do bluray
	 * @param classificacao
	 *            classificação do bluray
	 * @param genero
	 *            genero do bluray
	 * @param temporada
	 *            temporada do bluray
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		sistema.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero,
				temporada);
	}

	/**
	 * Adiciona um bluray com um episódio a um bluray serie
	 * 
	 * @param nome
	 *            nome do dono do bluray a ser adicionado
	 * @param telefone
	 *            telefone do dono do bluray a ser adicionado
	 * @param nomeBlurayTemporada
	 *            serie a qual o episodio será adicionado
	 * @param duracao
	 *            duracao do episodio a ser adicionado
	 * 
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		sistema.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}

	/**
	 * Cadastra um BlurayFilme no Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do filme
	 * @param preco
	 *            é o valor do bluray
	 * @param duracao
	 *            é a duração do filme
	 * @param genero
	 *            é o gênero do filme
	 * @param classificacao
	 *            é a classificação indicativa do filme
	 * @param anoLancamento
	 *            é o ano de lançamento do filme
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		sistema.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	/**
	 * Cadastra um BlurayShow no Usuario setando sua reputação e seu cartão
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do show
	 * @param preco
	 *            é o valor do bluray
	 * @param duracao
	 *            é a duração do bluray
	 * @param numFaixas
	 *            é o número de faixas do bluray
	 * @param nomeArtista
	 *            é o nome do artista
	 * @param classificacao
	 *            é a classificação indicativa do show
	 */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numFaixas, String nomeArtista, String classificacao) {
		sistema.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao);
	}

	/**
	 * Adiciona uma peça perdida a um JogoTabuleiro
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do jogo
	 * @param nomePeca
	 *            é o nome da peça perdida
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		sistema.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	/**
	 * Remove um item dos itens de um usuario
	 * 
	 * @param nome
	 *            nome do usuario que terá o item removido
	 * @param telefone
	 *            telefone do usuario que tera o item removido
	 * @param nomeItem
	 *            nome do item a ser removido
	 */
	public void removerItem(String nome, String telefone, String nomeItem) {
		sistema.removerItem(nome, telefone, nomeItem);
	}

	/**
	 * Atualiza informações de um item de um Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do item
	 * @param atributo
	 *            é o atributo que será atualizado
	 * @param valor
	 *            é o novo atributo atualizado após a modificação
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		sistema.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}

	/**
	 * Retorna informações de um item de um Usuario
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do item
	 * @param atributo
	 *            é o atributo cuja informação será exibida
	 * @return informação correspondente a um atributo do item
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return sistema.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	/**
	 * Lista os itens dos usuários ordenados por nome
	 * 
	 * @return informações dos itens ordenados por nome
	 */
	public String listarItensOrdenadosPorNome() {
		return sistema.listarItensOrdenadosPorNome();
	}

	/**
	 * Lista os itens dos usuários ordenados por valor
	 * 
	 * @return informações dos itens ordenados por valor
	 */
	public String listarItensOrdenadosPorValor() {
		return sistema.listarItensOrdenadosPorValor();
	}

	/**
	 * Retorna uma informações detalhadas de um item
	 * 
	 * @param nome
	 *            é o nome do usuário
	 * @param telefone
	 *            é o telefone do usuário
	 * @param nomeItem
	 *            é o nome do itme
	 * @return representação textual do item
	 */
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return sistema.pesquisarDetalhesItem(nome, telefone, nomeItem);
	}

	/**
	 * Cria um registro de um emprestimo, e salva no sistema.
	 * 
	 * @param nomeDono
	 *            nome do dono do item a ser emprestado
	 * @param telefoneDono
	 *            telefone do dono do item a ser emprestado
	 * @param nomeRequerente
	 *            nome do requerente do item a ser emprestado
	 * @param telefoneRequerente
	 *            telefone do requerente do item a ser emprestado
	 * @param nomeItem
	 *            nome do item a ser emprestado
	 * @param dataEmprestimo
	 *            data em que ocorreu o emprestimo
	 * @param periodo
	 *            periodo de emprestimo
	 * @throws ParseException
	 *             lança uma exceção caso a data seja inválida
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ParseException {
		sistema.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
				dataEmprestimo, periodo);

	}

	/**
	 * Devolve um item a um usuario, setando a reputação do requerente
	 * 
	 * @param nomeDono
	 *            nome do dono do item
	 * @param telefoneDono
	 *            telefone do dono do item
	 * @param nomeRequerente
	 *            nome do requerente do item
	 * @param telefoneRequerente
	 *            telefone do requerente do item
	 * @param nomeItem
	 *            nome do item a ser devolvido
	 * @param dataEmprestimo
	 *            data do emprestimo do item
	 * @param dataDevolucao
	 *            data da devolucao do item
	 * @throws ParseException
	 *             lança uma exceção caso a data seja inválida
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws ParseException {
		sistema.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo,
				dataDevolucao);
	}

	/**
	 * Listagem dos emprestimo em que o Usuario era o dono do item.
	 * 
	 * @param nome,
	 *            String passado por parametro.
	 * @param telefone,
	 *            String passado por parametro. @return, retorna a lista de
	 *            emprestimos realizados em ordem lexicografica.
	 * @return listagem
	 */
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		return sistema.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}

	/**
	 * * Listagem dos emprestimo em que o Usuario pegou um item emprestado.
	 * 
	 * @param nome,
	 *            String passado por parametro.
	 * @param telefone,
	 *            String passado por parametro. @return, retorna a lista de
	 *            emprestimos realizados em ordem lexicografica.
	 * @return listagem
	 */
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		return sistema.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}

	/**
	 * Metodo para listar os emprestimos associados ao item de acordo com o nome
	 * do mesmo.
	 * 
	 * @param nomeItem
	 *            Nome do Item
	 * @return retorna a lista de emprestimos encontrados naquele item.
	 */
	public String listarEmprestimosItem(String nomeItem) {
		return sistema.listarEmprestimosItem(nomeItem);
	}

	/**
	 * Metodo para listar todos os itens emprestados nesse momento.
	 * 
	 * @return retorna a lista de itens emprestados junto com o nome do dono.
	 */
	public String listarItensEmprestados() {
		return sistema.listarItensEmprestados();
	}

	/**
	 * Lista os itens não emprestados ordenados por nome
	 * 
	 * @return informações dos itens não emprestados ordenados por nome
	 */
	public String listarItensNaoEmprestados() {
		return sistema.listarItensNaoEmprestados();
	}

	/**
	 * Lista os 10 itens com maior quantidade de empréstimos em ordem
	 * decrescente
	 * 
	 * @return retorna top 10 itens
	 */
	public String listarTop10Itens() {
		return sistema.listarTop10Itens();
	}

	/**
	 * Lista os usuários com reputação negativa.
	 * 
	 * @return lista de caloteiros
	 */
	public String listarCaloteiros() {
		return sistema.listarCaloteiros();
	}

	/**
	 * Lista os usuários com melhores reputações.
	 * 
	 * @return top 10 com melhores usuarios
	 */
	public String listarTop10MelhoresUsuarios() {
		return sistema.listarTop10MelhoresUsuarios();
	}

	/**
	 * Lista os 10 piores Usuários.
	 * 
	 * @return listagem
	 */
	public String listarTop10PioresUsuarios() {
		return sistema.listarTop10PioresUsuarios();
	}

	/**
	 * Salva o sistema em um arquivo.
	 * 
	 * @throws IOException
	 *             Lança uma exceção caso não seja possível salvar.
	 */
	public void fecharSistema() throws IOException {
		try {
			String nomeArquivo = "storage/sistema.dat";
			FileOutputStream f = new FileOutputStream(nomeArquivo);
			ObjectOutputStream obj = new ObjectOutputStream(f);
			obj.writeObject(sistema);
			obj.close();
		} catch (IOException e) {
			throw new IOException("Falha ao Salvar Sistema");
		}
	}

}
