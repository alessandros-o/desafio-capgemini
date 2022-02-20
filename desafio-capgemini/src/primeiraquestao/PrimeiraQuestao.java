package primeiraquestao;

/**
 * Esta Classe cont�m um algoritmo que mostra na tela uma escada utilizando o
 * caractere * de tamanho fornecido pelo usu�rio.
 * 
 * @author Alessandro Oliveira
 *
 */

public class PrimeiraQuestao {

	/**
	 * Esse m�todo recebe o tamanho fornecido pelo usu�rio e usa o valor para fazer
	 * o alinhamento � direita enquanto imprime o resultado.
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
