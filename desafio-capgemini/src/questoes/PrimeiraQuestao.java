package questoes;

import java.util.Scanner;

/**
 * Esta Classe cont�m um algoritmo que mostra na tela uma escada utilizando o caractere *
 * de tamanho fornecido pelo usu�rio.
 * 
 * @author Alessandro Oliveira
 *
 */

public class PrimeiraQuestao {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int tamanho = scn.nextInt();
		
		String valor = "*";
		
		/**
		 * Esse la�o recebe o tamanho fornecido pelo usu�rio
		 * e usa o valor para fazer o alinhamento � direita enquanto imprime o resultado.
		 */
		for(int i = 1; i <= tamanho; i++ ) {
			System.out.printf("%" + tamanho + "s\n", valor);
			valor += "*";
		}
		
		scn.close();
	}

}
