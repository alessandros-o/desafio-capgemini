package terceiraquestao;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe contém o algoritmo que encontra, dentro de uma String, pares de
 * substrings que são anagramas
 * 
 * @author Alessandro Oliveira
 *
 */

public class TerceiraQuestao {

	/**
	 * Este método recebe duas Strings comparando para achar os anagramas e retorna
	 * uma lista com os indices iniciais de cada ocorrência
	 * 
	 * @param stringPrincipal
	 * @param stringSecundaria
	 * @return
	 */
	public List<Integer> procurarAnagrama(String stringPrincipal, String stringSecundaria) {

		List<Integer> resultado = new ArrayList<Integer>();

		if (stringPrincipal.length() == 0 || stringPrincipal == null)
			return resultado;

		/**
		 * Esse vetor vai armazenar nos índices a frequência com que um certo caractere
		 * ocorre na String analisando o valor ASCII do caractere.
		 */
		int[] contadorChar = new int[26];
		for (char c : stringSecundaria.toCharArray()) {
			contadorChar[c - 'a']++;
		}

		int esquerda = 0;
		int direita = 0;
		int contador = stringSecundaria.length();

		/**
		 * Esse laço cria uma janela com limites na esquerda e direita que recebe como
		 * tamanho o tamanho da String. Vai usar o vetor de frequência de caracteres
		 * para encontrar o anagrama.
		 */
		while (direita < stringPrincipal.length()) {
			if (contadorChar[stringPrincipal.charAt(direita++) - 'a']-- >= 1)
				contador--;

			if (contador == 0)
				resultado.add(esquerda);

			if (direita - esquerda == stringSecundaria.length()
					&& contadorChar[stringPrincipal.charAt(esquerda++) - 'a']++ >= 0)
				contador++;

		}
		return resultado;

	}

	/**
	 * Este método recebe uma String e retira os espaços no início, meio e fim, caso
	 * exista, retornando a palavra sem espaços
	 * 
	 * @param palavra
	 * @return
	 */
	public String retiraEspaco(String palavra) {
		String alterada = "";
		String interna = (palavra).trim();
		char c;

		for (int i = 0; i < interna.length(); i++) {
			c = interna.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				alterada += c;
			}
		}

		return alterada;
	}

	/**
	 * Este método recebe uma String e compara com ela própria retornando a
	 * quantidade de pares de substrings que são anagramas encontrados e os indices
	 * iniciais onde ocorre.
	 * 
	 * @param stringEntrada
	 * @return
	 */
	public int contaAnagramas(String stringEntrada) {
		int quantidadeAnagrama = 0;
		int contador1 = 0;
		int contador2 = 0;

		stringEntrada = stringEntrada.toLowerCase();

		char[] substringVetor1 = stringEntrada.toCharArray();

		/**
		 * Copia os caracteres da String recebida dentro do vetor fornecido como
		 * referência;
		 */
		List<List<Integer>> listaIndices = new ArrayList<List<Integer>>(); // vai receber a lista de indices de
																			// anagramas do 1º laço

		List<List<Integer>> listaIndicesConcat = new ArrayList<List<Integer>>(); // vai receber a lista de indices de
																					// anagramas do 2º laço

		List<String> listaPalavras = new ArrayList<String>(); // vai receber a lista de Strings formadas pela
																// concatenação de substrings

		/**
		 * 1º laço - vai comparar letra por letra individualmente e acumular os índices
		 * dos pares de substrings na lista indicada.
		 */

		for (int i = 0; i < substringVetor1.length; i++) {
			StringBuilder buffer1 = new StringBuilder();
			buffer1.append(substringVetor1[i]);

			String substring1 = buffer1.toString();

			if (!listaIndices.contains(procurarAnagrama(stringEntrada, substring1))
					&& procurarAnagrama(stringEntrada, substring1).size() >= 2) {
				listaIndices.add(procurarAnagrama(stringEntrada, substring1));
				contador1 = contador1 + 1;
			}

		}

		char[] substringVetor2 = new char[stringEntrada.length()];
		int k = 0;
		String substring2 = null;

		/**
		 * 2º laço - vai concatenar as substrings, adicionar a String formada por essa
		 * concatenação em uma lista de palavras, comparar com a palavra principal e
		 * depois acumular os índices dos pares de substrings na lista indicada.
		 */
		for (int j = 0; j < substringVetor2.length; j++) {

			substringVetor2[k++] = substringVetor1[j];

			StringBuilder buffer2 = new StringBuilder();
			StringBuilder buffer3 = new StringBuilder();
			buffer2.append(substringVetor2);
			String p = buffer2.toString();
			listaPalavras.add(p);
			buffer3.append(listaPalavras.get(j));

			substring2 = buffer3.toString();

			substring2 = retiraEspaco(substring2);

			if (!listaIndicesConcat.contains(procurarAnagrama(stringEntrada, substring2))
					&& !listaIndices.contains(procurarAnagrama(stringEntrada, substring2))
					&& procurarAnagrama(stringEntrada, substring2).size() >= 2) {
				listaIndicesConcat.add(procurarAnagrama(stringEntrada, substring2));
				contador2 = contador2 + 1;
			}

		}

		quantidadeAnagrama = contador1 + contador2;

		return quantidadeAnagrama;
	}

}