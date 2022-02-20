package segundaquestao;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta Classe contém o algoritimo que valida os requisitos que tornam uma senha
 * forte
 * 
 * @author Alessandro Oliveira
 *
 */
public class SegundaQuestao {

	public static final int QTD_MINIMA_CARACTERE = 6;
	public static final char[] CARACTERE_ESPECIAL = { '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+' };

	/**
	 * Este método recebe a String e primeiro verifica o tamanho mínimo, caso não
	 * tenha, vai retornar a quantidade que falta. Se tiver os 6 caracteres vai
	 * verificar se cumpre os demais requisitos, Caso cumpra retorna a mensagem
	 * "Senha forte!", caso não cumpra todos os requisitos vai apontar os condições
	 * que faltam ser cumpridas.
	 * 
	 * @param senha
	 * @return
	 */
	public String verificaTamanho(String senha) {
		String mensagem = "";
		if (senha.length() == QTD_MINIMA_CARACTERE) {
			if (verificaRequisitos(senha).isEmpty()) {
				mensagem = "Senha forte!";
			} else {
				mensagem = String.format("Faltam os seguintes requisitos: %s", verificaRequisitos(senha));
			}
		} else {
			int faltaCaractere = QTD_MINIMA_CARACTERE - senha.length();
			mensagem = String.format("Faltam %d caracteres.", faltaCaractere);
		}
		return mensagem;
	}

	/**
	 * Este método vai receber uma String, verificar se cumpre todos os requisitos
	 * propostos e retornar uma lista de mensagem caso não cumpra apontando qual
	 * condição está faltando.
	 * 
	 * @param senha
	 * @return
	 */
	public List<String> verificaRequisitos(String senha) {

		List<String> mensagemFaltaRequisitos = new ArrayList<String>();
		boolean temMinuscula = false;
		boolean temMaiuscula = false;
		boolean temNumero = false;
		boolean temEspecial = false;

		for (int i = 0; i < senha.length(); i++) {

			char chr = senha.charAt(i);

			if (Character.isLowerCase(chr)) {
				temMinuscula = true;
			}

			if (Character.isUpperCase(chr)) {
				temMaiuscula = true;
			}

			if (Character.isDigit(chr)) {
				temNumero = true;
			}

			for (int j = 0; j < CARACTERE_ESPECIAL.length; j++) {
				if (CARACTERE_ESPECIAL[j] == chr) {
					temEspecial = true;
				}
			}
		}

		if (!temMinuscula && !mensagemFaltaRequisitos.contains("Pelo menos 1 letra minúscula.")) {
			mensagemFaltaRequisitos.add("Pelo menos 1 letra minúscula.");
		}

		if (!temMaiuscula && !mensagemFaltaRequisitos.contains("Pelo menos 1 letra maiúscula.")) {
			mensagemFaltaRequisitos.add("Pelo menos 1 letra maiúscula.");
		}

		if (!temNumero && !mensagemFaltaRequisitos.contains("Pelo menos 1 número.")) {
			mensagemFaltaRequisitos.add("Pelo menos 1 número.");
		}

		if (!temEspecial
				&& !mensagemFaltaRequisitos.contains("Pelo menos 1 destes caracteres especiais --> !@#$%^&*()-+.")) {
			mensagemFaltaRequisitos.add("Pelo menos 1 destes caracteres especiais --> !@#$%^&*()-+");
		}

		return mensagemFaltaRequisitos;

	}

}
