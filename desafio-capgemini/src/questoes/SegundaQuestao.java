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
		 * Este la�o ser� executado enquanto todos os requisitos n�o forem atendidos
		 */
		while (!temQtd || !temMaiusc || !temMinusc || !temNum || !temEspecial) {

			System.out.println("-----------------");
			System.out.println("Insira sua senha!");
			System.out.println("-----------------");
			System.out.println("Ela precisa conter pelo no m�nimo 6 caracteres, 1 letra mai�scula, "
					+ "1 letra min�scula, 1 n�mero e 1 caracter especial");
			System.out.println("-----------------");
			System.out.println("Senha: ");

			String senha = scn.next();
			
			
			/**
			 * Vai conferir primeiramente se a quantidade m�nima da senha foi atendida.
			 * Caso sim, mas os outros requisitos n�o tenham sido atendidos vai mostrar
			 * qual requisito ainda est� faltando.
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
					System.out.println("Voc� precisa inserir pelo menos 1 letra min�scula.");
				}
				if (!temMaiusc) {
					System.out.println("Voc� precisa inserir pelo menos 1 letra mai�scula.");
				}
				if (!temNum) {
					System.out.println("Voc� precisa inserir pelo menos 1 n�mero.");
				}
				if (!temEspecial) {
					System.out.println("Voc� precisa inserir pelo menos 1 destes caracteres especiais --> !@#$%^&*()-+");
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
