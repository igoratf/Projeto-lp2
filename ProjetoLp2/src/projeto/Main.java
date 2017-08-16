package projeto;

import java.io.File;
import java.util.ArrayList;

import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayList<String> testes = new ArrayList<>();
		testes.add("diretorio_testes" + File.separator + "us1_test.txt");
		testes.add("diretorio_testes" + File.separator + "us2_test.txt");
		testes.add("diretorio_testes" + File.separator + "us3_test.txt");
		testes.add("diretorio_testes" + File.separator + "us4_test.txt");
		testes.add("diretorio_testes" + File.separator + "us5_test.txt");
		testes.add("diretorio_testes" + File.separator + "us6_test.txt");
		testes.add("diretorio_testes" + File.separator + "us7_test.txt");
		testes.add("diretorio_testes" + File.separator + "us8_test.txt");

		EasyAccept.executeEasyAcceptTests("projeto.Facade", testes);
	}

}
