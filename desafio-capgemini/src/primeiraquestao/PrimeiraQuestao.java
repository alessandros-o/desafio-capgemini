package primeiraquestao;

/**
 * Esta Classe contém um algoritmo que mostra na tela uma escada utilizando o
 * caractere * de tamanho fornecido pelo usuário.
 * 
 * @author Alessandro Oliveira
 *
 */

public class PrimeiraQuestao {

	/**
	 * Esse método recebe o tamanho fornecido pelo usuário e usa o valor para fazer
	 * o alinhamento à direita enquanto imprime o resultado.
	 * 
	 * @param tamanho
	 * @return
	 */
	public String imprimeEscada(int tamanho) {
		String valor = "*";
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= tamanho; i++) {
			if (i == tamanho) {
				sb.append(String.format("%" + tamanho + "s", valor));

			} else {
				sb.append(String.format("%" + tamanho + "s\n", valor));
				valor += "*";
			}
		}

		return sb.toString();
	}

}
