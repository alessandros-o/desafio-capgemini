package questoes;

import java.util.Scanner;

/**
 * Esta Classe contem o algoritimo que valida os requisitos que torna uma senha forte
 * @author Alessandro Oliveira
 *
 */

public class SegundaQuestao {
	
	
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		char[] especial = { '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+' };
		boolean temQtd = false;
		boolean temMaiusc = false;
		boolean temMinusc = false;
		boolean temNum = false;
		boolean temEspecial = false;
		int qtdMinimaCaractere = 6;
		
		
		/**
		 * Este laço será executado enquanto todos os requisitos não forem atendidos
		 */
		while (!temQtd || !temMaiusc || !temMinusc || !temNum || !temEspecial) {

			System.out.println("-----------------");
			System.out.println("Insira sua senha!");
			System.out.println("-----------------");
			System.out.println("Ela precisa conter pelo no mínimo 6 caracteres, 1 letra maiúscula, "
					+ "1 letra minúscula, 1 número e 1 caracter especial");
			System.out.println("-----------------");
			System.out.println("Senha: ");

			String senha = scn.next();
			
			
			/**
			 * Vai conferir primeiramente se a quantidade mínima da senha foi atendida.
			 * Caso sim, mas os outros requisitos não tenham sido atendidos vai mostrar
			 * qual requisito ainda está faltando.
			 */
			if (senha.length() == qtdMinimaCaractere) {

				for (int i = 0; i < senha.length(); i++) {

					char chr = senha.charAt(i);

					if (Character.isLowerCase(chr)) {
						temMinusc = true;
					}

					if (Character.isUpperCase(chr)) {
						temMaiusc = true;
					}

					if (Character.isDigit(chr)) {
						temNum = true;
					}

					for (int j = 0; j < especial.length; j++) {
						if (especial[j] == chr) {
							temEspecial = true;
						}
					}
				}

				if (!temMinusc) {
					System.out.println("Você precisa inserir pelo menos 1 letra minúscula.");
				}
				if (!temMaiusc) {
					System.out.println("Você precisa inserir pelo menos 1 letra maiúscula.");
				}
				if (!temNum) {
					System.out.println("Você precisa inserir pelo menos 1 número.");
				}
				if (!temEspecial) {
					System.out.println("Você precisa inserir pelo menos 1 destes caracteres especiais --> !@#$%^&*()-+");
				}

				temQtd = true;
			} else {
				int falta = qtdMinimaCaractere - senha.length();
				System.out.printf("Faltam %d caracteres\n", falta);
			}
			
		}

		scn.close();
	}

}
