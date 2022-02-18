package questoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta classe contém o algoritmo que encontra, dentro de uma String, pares de substrings que são anagramas
 * @author Alessandro Oliveira
 *
 */

public class TerceiraQuestao {
	
	
	/**
	 * Este método recebe duas Strings comparando para achar os anagramas
	 * e retorna uma lista com os indices iniciais de cada ocorrência
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static List<Integer> procurarAnagrama(String s, String p) {

		List<Integer> resultado = new ArrayList<Integer>();

		if (s.length() == 0 || s == null)
			return resultado;

		/**
		 * Esse vetor vai armazenar nos índices a frequência com que um certo caractere ocorre na String
		 * analisando o valor ASCII do caractere.
		 */
		int[] contadorChar = new int[26];
		for (char c : p.toCharArray()) {
			contadorChar[c - 'a']++;
		}

		int left = 0;
		int right = 0;
		int contador = p.length();

		/**
		 * Esse laço cria uma janela com limites na esquerda e direita que recebe como tamanho o tamanho da String.
		 * Vai usar o vetor de frequência de caracteres para encontrar o anagrama.
		 */
		while (right < s.length()) {
			if (contadorChar[s.charAt(right++) - 'a']-- >= 1)
				contador--;

			if (contador == 0)
				resultado.add(left);

			if (right - left == p.length() && contadorChar[s.charAt(left++) - 'a']++ >= 0)
				contador++;

		}
		return resultado;

	}
	
	
	/**
	 * Este método recebe uma String e retira os espaços no início, meio e fim, caso exista, retornando a palavra sem espaços
	 * @param palavra
	 * @return
	 */
	public static String retiraEspaco(String palavra) {
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
	 * Este método recebe uma String e compara com ela própria retornando 
	 * a quantidade de pares de substrings que são anagramas encontrados e os indices iniciais onde ocorre.
	 * 
	 * @param s
	 * @return
	 */
	public static int contaAnagramas(String s) {
		int quantidadeAnagrama = 0;
		int contador1 = 0;
		int contador2 = 0;

		s = s.toLowerCase();
		StringBuilder buffer = new StringBuilder(s);

		char[] vetor = new char[s.length()];

		/**
		 * Copia os caracteres da String recebida dentro do vetor fornecido como referência;
		 */
		buffer.getChars(0, buffer.length(), vetor, 0);
		
		List<List<Integer>> listaIndices = new ArrayList<List<Integer>>(); // vai receber a lista de indices de anagramas do 1º laço
		
		List<List<Integer>> listaIndicesConcat = new ArrayList<List<Integer>>(); // vai receber a lista de indices de anagramas do 2º laço
		
		List<String> palavras = new ArrayList<String>(); //vai receber a lista de Strings formadas pela concatenação de substrings

		
		/**
		 * 1º laço - vai comparar letra por letra individualmente e acumular os índices dos pares de substrings na lista indicada.
		 */
		for (int i = 0; i < vetor.length; i++) {
			StringBuilder buffer2 = new StringBuilder();
			buffer2.append(vetor[i]);

			String p = buffer2.toString();

			if (!listaIndices.contains(procurarAnagrama(s, p)) && procurarAnagrama(s, p).size() >= 2) {
				listaIndices.add(procurarAnagrama(s, p));
				contador1 = contador1 + 1;
			}

		}

		char[] nome = new char[s.length()];
		int k = 0;
		String p3 = null;

		/**
		 * 2º laço - vai concatenar as substrings, adicionar a String formada por essa concatenação em uma lista de palavras,
		 * comparar com a palavra principal e depois acumular os índices dos pares de substrings na lista indicada.
		 */
		for (int j = 0; j < nome.length; j++) {

			nome[k++] = vetor[j];

			StringBuilder buffer3 = new StringBuilder();
			StringBuilder buffer4 = new StringBuilder();
			buffer3.append(nome);
			String p2 = buffer3.toString();
			palavras.add(p2);
			buffer4.append(palavras.get(j));

			p3 = buffer4.toString();

			p3 = retiraEspaco(p3);

			if (!listaIndicesConcat.contains(procurarAnagrama(s, p3)) && !listaIndices.contains(procurarAnagrama(s, p3))
					&& procurarAnagrama(s, p3).size() >= 2) {
				listaIndicesConcat.add(procurarAnagrama(s, p3));
				contador2 = contador2 + 1;
			}

		}

//		System.out.println("Índice substrings individuais --> " + listaIndices);
//		System.out.println("Índice de substrings contatenadas --> " + listaIndicesConcat);

		quantidadeAnagrama = contador1 + contador2;

		return quantidadeAnagrama;
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		/**
		 * Recebe a palavra digitada pelo usuário
		 */
		String s = entrada.next();
		
		
		/**
		 * Recebe a palavra, passa como parâmetro para o método e imprime a quantidade de anagramas encontrados.
		 */
		System.out.println(contaAnagramas(s));

		entrada.close();

	}

}