package com.Livraria.livraria.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioValidacao {

	private static int LIMITE_CARACTERES_NOME = 8;
	private static int LIMITE_MINIMO_IDADE = 18;

	/**
	 * https://pt.stackoverflow.com/questions/68209/verificacao-de-email-em-java
	 */

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

	private static Matcher matcher;

	public boolean validarUsuario(String nome, String email) {

		if (validarNome(nome) && validarEmail(email)) {

			return true;
		}

		else
			return false;
	}

	public boolean validarNome(String nome) {

		if (nome.length() >= LIMITE_CARACTERES_NOME) {

			return true;
		}

		return false;
	}

	public boolean validarEmail(String email) {

		if (email.contains("@")) {

			matcher = pattern.matcher(email);

			return matcher.matches();
		} else
			return false;

	}

	public boolean validarSenhal() {
		return true;
	}

	public boolean validarIdade(int idade) {

		if (idade >= LIMITE_MINIMO_IDADE) {

			return true;
		}

		return false;
	}

}
