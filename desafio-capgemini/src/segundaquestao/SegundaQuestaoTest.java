package segundaquestao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SegundaQuestaoTest {

	public static void main(String[] args) {

		SegundaQuestao segunda = new SegundaQuestao();
		Scanner scn = new Scanner(System.in);

		System.out.println("Insira a senha! ");

		String senha = scn.next();

		System.out.println(segunda.verificaTamanho(senha));

		scn.close();
	}

	@Test
	@DisplayName("Deve recever uma String e retornar a mensagem confirmando quantos caracteres estão faltando"
			+ " ou a mensagem de confirmação com a frase 'Senha forte!' caso não falte nada")
	void testVerificaTamanho() {
		SegundaQuestao segunda = new SegundaQuestao();
		String paramentroEntrada = "Ya3";
		String resultadoEsperado = "Faltam 3 caracteres.";
		assertEquals(resultadoEsperado, segunda.verificaTamanho(paramentroEntrada));
	}

	@Test
	@DisplayName("Deve receber uma String e retornar mensagens apontando os requisitos que faltam para tornar uma senha forte")
	void testVerificaRequisitos() {
		SegundaQuestao segunda = new SegundaQuestao();
		List<String> parametroEntrada = segunda.verificaRequisitos("Val1do");
		List<String> resultadoEsperado = new ArrayList<String>();
		resultadoEsperado.add("Pelo menos 1 destes caracteres especiais --> !@#$%^&*()-+");
		assertEquals(resultadoEsperado, parametroEntrada);
	}

}
