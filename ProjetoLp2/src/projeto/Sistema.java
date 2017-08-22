package projeto;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import projeto.controllers.ControllerEmprestimo;
import projeto.controllers.ControllerItem;
import projeto.controllers.ControllerUsuario;
import projeto.utilitarios.ChaveUsuario;

/**
 * Sistema responsável por delegar os metodos, trabalhando em cima dos
 * controllers.
 * 
 * @author javanktl
 *
 */
public class Sistema {

	private ControllerUsuario cUsuario;
	private ControllerItem cItem;
	private ControllerEmprestimo cEmprestimo;

	/**
	 * Construtor do sistema
	 */
	public Sistema() {

		this.cUsuario = new ControllerUsuario();
		this.cItem = new ControllerItem();
		this.cEmprestimo = new ControllerEmprestimo();

	}

	/**
	 * Inicia o sistema
	 */
	public void iniciarSistema() {
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
		cUsuario.cadastrarUsuario(nome, telefone, email);
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
		return cUsuario.getInfoUsuario(nome, telefone, atributo);
	}

	/**
	 * Busca os itens de um usuario
	 * 
	 * @param nome
	 *            nome do usuario a ser consultado
	 * @param telefone
	 *            telefone do usuario a ser consultado
	 * @return retorna Map de itens do usuario consultado
	 */
	public Map<String, Item> getItensUsuario(String nome, String telefone) {
		return cUsuario.getItensUsuario(nome, telefone);
	}

	/**
	 * Busca lista com itens te todos usuarios
	 * 
	 * @return retorna a lista com os itens de todos usuarios
	 */
	public List<Item> getItensUsuarios() {
		return cUsuario.getItensUsuarios();
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
		cUsuario.removerUsuario(nome, telefone);
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
		cUsuario.atualizarUsuario(nome, telefone, atributo, valor);
	}

	/**
	 * Checa se usuario ja existe
	 * 
	 * @param nome
	 *            nome do usario a ser checado
	 * @param telefone
	 *            telefone do usuario a ser checado
	 * @return retorna booleano confirmando se usuario existe ou não
	 */
	public boolean checaSeUsuarioJaExiste(String nome, String telefone) {
		return cUsuario.checaSeUsuarioJaExiste(nome, telefone);
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
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.cadastrarEletronico(nomeItem, preco, plataforma, mapaItensDono);
		cUsuario.addReputacaoItemAdicionado(nome, telefone, preco);
		cUsuario.atualizaCartaoUsuario(nome, telefone);
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
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.cadastrarJogoTabuleiro(nomeItem, preco, mapaItensDono);
		cUsuario.addReputacaoItemAdicionado(nome, telefone, preco);
		cUsuario.atualizaCartaoUsuario(nome, telefone);
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
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.cadastrarBluraySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada,
				mapaItensDono);
		cUsuario.atualizaCartaoUsuario(nome, telefone);
		cUsuario.addReputacaoItemAdicionado(nome, telefone, preco);
	}

	/**
	 * Adiciona um bluray com um episódio a um bluray serie
	 * 
	 * @param nome
	 *            nome do dono do bluray a ser adicionado
	 * @param telefone
	 *            telefone do dono do bluray a ser adicionado
	 * @param serie
	 *            serie a qual o episodio será adicionado
	 * @param duracao
	 *            duracao do episodio a ser adicionado
	 */
	public void adicionarBluRay(String nome, String telefone, String serie, int duracao) {

		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);
		cItem.adicionarBluray(serie, duracao, mapaItensDono);
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
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.cadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento, mapaItensDono);
		cUsuario.addReputacaoItemAdicionado(nome, telefone, preco);
		cUsuario.atualizaCartaoUsuario(nome, telefone);
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
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.cadastrarBlurayShow(nomeItem, preco, duracao, numFaixas, nomeArtista, classificacao, mapaItensDono);
		cUsuario.addReputacaoItemAdicionado(nome, telefone, preco);
		cUsuario.atualizaCartaoUsuario(nome, telefone);
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
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.adicionarPecaPerdida(nomeItem, nomePeca, mapaItensDono);
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
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.removerItem(nomeItem, mapaItensDono);
		cUsuario.atualizaCartaoUsuario(nome, telefone);
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
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		cItem.atualizarItem(nomeItem, atributo, valor, mapaItensDono);
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
		Map<String, Item> mapaItensDono = cUsuario.getItensUsuario(nome, telefone);

		return cItem.getInfoItem(nomeItem, atributo, mapaItensDono);
	}

	/**
	 * Lista os itens dos usuários ordenados por nome
	 * 
	 * @return informações dos itens ordenados por nome
	 */
	public String listarItensOrdenadosPorNome() {
		List<Item> listItens = cUsuario.getItensUsuarios();

		return cItem.listarItensOrdenadosPorNome(listItens);
	}

	/**
	 * Lista os itens dos usuários ordenados por valor
	 * 
	 * @return informações dos itens ordenados por valor
	 */
	public String listarItensOrdenadosPorValor() {
		List<Item> listItens = cUsuario.getItensUsuarios();
		return cItem.listarItensOrdenadosPorValor(listItens);
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
		Map<String, Item> mapaItensUsuario = cUsuario.getItensUsuario(nome, telefone);
		return cItem.pesquisarDetalhesItem(nomeItem, mapaItensUsuario);
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

		this.cItem.emprestarItem(nomeItem, mapaItensDono);
		double valorItem = mapaItensDono.get(nomeItem).getValor();

		try {
			cEmprestimo.registrarEmprestimo(dono, requerente, nomeItem, dataEmprestimo, periodo);

		} catch (ParseException e) {

			throw new ParseException(e.getMessage(), 43);
		}
		cUsuario.addReputacaoItemEmprestado(nomeDono, telefoneDono, valorItem);

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

		try {
			cEmprestimo.devolverItem(dono, requerente, nomeItem, dataEmprestimo, dataDevolucao);
		} catch (ParseException e) {

			throw new ParseException(e.getMessage(), 43);
		}
		cItem.devolverItem(nomeItem, mapaItensDono);

	}

	/**
	 * Listagem dos emprestimo em que o Usuario era o dono do item.
	 * 
	 * @param nome,
	 *            String passado por parametro.
	 * @param telefone,
	 *            String passado por parametro. @return, retorna a lista de
	 *            emprestimos realizados em ordem lexicografica.
	 */
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		cUsuario.checaSeUsuarioJaExiste(nome, telefone);
		return cEmprestimo.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}

	/**
	 * * Listagem dos emprestimo em que o Usuario pegou um item emprestado.
	 * 
	 * @param nome,
	 *            String passado por parametro.
	 * @param telefone,
	 *            String passado por parametro. @return, retorna a lista de
	 *            emprestimos realizados em ordem lexicografica.
	 * 
	 */

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		cUsuario.checaSeUsuarioJaExiste(nome, telefone);

		return cEmprestimo.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}

	/**
	 * Metodo para listar os emprestimos associados ao item de acordo com o nome do mesmo.
	 * @return, retorna a lista de emprestimos encontrados naquele item.
	 */
	public String listarEmprestimosItem(String nomeItem) {
		return cEmprestimo.listarEmprestimosItem(nomeItem);
	}

	
	/**
	 * Metodo para listar todos os itens emprestados nesse momento.
	 * @return, retorna a lista de itens emprestados junto com o nome do dono.
	 */
	public String listarItensEmprestados() {

		return cEmprestimo.listarItensEmprestados();
	}

	
	/**
	 * Lista os 10 itens com maior quantidade de empréstimos em ordem decrescente
	 * 
	 * @param itensUsuarios
	 *            lista de itens do usuario
	 * @return retorna top 10 itens
	 */
	public String listarTop10Itens() {

		List<Item> listItens = cUsuario.getItensUsuarios();

		return cItem.listarTop10Itens(listItens);
	}

	/**
	 * Lista os itens não emprestados ordenados por nome
	 * 
	 * @param itensUsuarios
	 *            é a lista de itens de todos os usuários
	 * @return informações dos itens não emprestados ordenados por nome
	 */
	public String listarItensNaoEmprestados() {

		List<Item> listItens = cUsuario.getItensUsuarios();

		return cItem.listarItensNaoEmprestados(listItens);

	}

	/**
	 * Lista os usuários com reputação negativa.
	 * 
	 * @return lista de caloteiros
	 */
	public String listarCaloteiros() {
		return cUsuario.listarCaloteiros();
	}

	/**
	 * Lista os usuários com melhores reputações.
	 * 
	 * @return top 10 com melhores usuarios
	 */
	public String listarTop10MelhoresUsuarios() {
		return cUsuario.listarTop10MelhoresUsuarios();
	}

	/**
	 * Lista os 10 piores Usuários.
	 * 
	 * @return listagem
	 */
	public String listarTop10PioresUsuarios() {
		return cUsuario.listarTop10PioresUsuarios();
	}
	/**
	 * fecha o sistema
	 */
	public void fecharSistema() {

	}

}
