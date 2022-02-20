package primeiraquestao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrimeiraQuestaoTest {

	public static void main(String[] args) {

		PrimeiraQuestao primeira = new PrimeiraQuestao();
		Scanner scn = new Scanner(System.in);

		System.out.println("Digite um número: ");
		int tamanho = scn.nextInt();

		System.out.print(primeira.imprimeEscada(tamanho));

		scn.close();
	}

	@Test
	@DisplayName("Deve receber um número indicando a quantidade de 'degraus' e imprimir a escada com o tamanho indicado")
	void testImprimeEscada() {
		PrimeiraQuestao primeira = new PrimeiraQuestao();
		int paramentroEntrada = 6;
		String resultadoEsperado = "     *\n" + "    **\n" + "   ***\n" + "  ****\n" + " *****\n" + "******";
		assertEquals(resultadoEsperado, primeira.imprimeEscada(paramentroEntrada));
	}

}
