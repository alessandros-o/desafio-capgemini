package terceiraquestao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TerceiraQuestaoTest {

	public static void main(String[] args) {

		TerceiraQuestao terceira = new TerceiraQuestao();

		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite uma palavra e descubra a quantidade de anagramas: ");

		/**
		 * Recebe a palavra digitada pelo usuário
		 */
		String s = entrada.next();

		System.out.printf("Quantidade de anagramas encontrados: %d", terceira.contaAnagramas(s));

		entrada.close();

	}

	@Test
	@DisplayName("Deve receber duas Strings e retornar a lista indicies iniciais onde se encontram os anagramas")
	void testProcurarAnagrama() {
		TerceiraQuestao terceira = new TerceiraQuestao();
		List<Integer> anagramaEncontrado = terceira.procurarAnagrama("ovo", "o");
		List<Integer> resultadoEsperado = new ArrayList<Integer>();
		resultadoEsperado.add(0);
		resultadoEsperado.add(2);
		assertEquals(resultadoEsperado, anagramaEncontrado);
	}

	@Test
	@DisplayName("Deve receber uma String e retorna-la sem espaços, no início, meio ou fim")
	void testRetiraEspaco() {
		TerceiraQuestao terceira = new TerceiraQuestao();
		String parametroEntrada = "o vo";
		String resultadoEsperado = "ovo";
		assertEquals(resultadoEsperado, terceira.retiraEspaco(parametroEntrada));
	}

	@Test
	@DisplayName("Recebe uma String, compara com ela própria, e retorna a quantidade de pares de substrings encontradas")
	void testContaAnagramas() {
		TerceiraQuestao terceira = new TerceiraQuestao();
		String parametroEntrada = "ifailuhkqq";
		int resultadoEsperado = 3;
		assertEquals(resultadoEsperado, terceira.contaAnagramas(parametroEntrada));
	}

}
