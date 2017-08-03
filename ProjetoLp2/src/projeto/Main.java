package projeto;

import easyaccept.EasyAccept;

public class Main {
	
	public static void main(String[] args) {
		args = new String[] { "projeto.Facade",
				"diretorio_testes/us1_test.txt",
				"diretorio_testes/us2_test.txt",
				"diretorio_testes/us3_test.txt", 
				"diretorio_testes/us4_test.txt" }; 
		
		EasyAccept.main(args);
	}

}
