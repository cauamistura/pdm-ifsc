package Vision;

import java.util.Scanner;

import Control.DAOPessoa;
import Model.MPessoa;

public class VPessoa {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		DAOPessoa FDAOPessoa = new DAOPessoa();
		FDAOPessoa = DAOPessoa.getFDAOPessoa();

		MPessoa FMPessoa = new MPessoa();

		Integer wAction = 0;

		while (wAction != 5) {

			System.out.println("Digite seu Nome: ");
			String wNome = s.nextLine();

			System.out.println("Digite seu Gmail: ");
			String wEmail = s.nextLine();

			FMPessoa.setFNOME(wNome);
			FMPessoa.setFEMAIL(wEmail);

			FDAOPessoa.insert(FMPessoa);
			System.out.println("Salvo com sucesso");

			while (wAction != 4) {

				System.out.println("Você deseja: \n" + " 1 - Alterar daodos de " + wNome + "\n"
						+ " 2 - Deletar daodos de " + wNome + "\n" + " 3 - Listar todos os nomes cadastrados \n"
						+ " 4 - Add outra pessoa \n " + "5 - Sair");

				wAction = s.nextInt();

				if (wAction == 1) {
					FDAOPessoa.update(FMPessoa, wNome);
					System.out.println("Dados de " + wNome + " foram alterados");
				} else if (wAction == 2) {
					FDAOPessoa.delete(FMPessoa, wNome);
					System.out.println("Dados de " + wNome + " foram excluidos");
				} else if (wAction == 3) {

				} else {
					System.out.println("Até mais \n -------------- \n");
				}

				wEmail = "";
				wNome = "";
			}
		}
	}
}
