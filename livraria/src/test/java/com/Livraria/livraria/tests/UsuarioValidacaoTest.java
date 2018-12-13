package com.Livraria.livraria.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Livraria.livraria.services.UsuarioValidacao;

public class UsuarioValidacaoTest {

	public UsuarioValidacao usuario = new UsuarioValidacao();

	@Test
	public void deveVlidarNomeMaiorOuIgual8Caracteres() {

		String nome = "shelton ";
		String email = "shelton@gmail.com";
//		int idade = 18;

		boolean retornaNomeDoUsuarioValido = usuario.validarUsuario(nome, email);

		assertEquals(true, retornaNomeDoUsuarioValido);
	}

	@Test
	public void naoDeveValidarEmailSemArroba() {

		String nome = "shelton ";
		String email = "sheltongmail.com";
//		int idade = 18;

		boolean retornaEmailDoUsuarioInValido = usuario.validarUsuario(nome, email);

		assertEquals(false, retornaEmailDoUsuarioInValido);
	}

	// @Test
	// public void deveValidarMaiorOuIgual18() {
	//
	// String nome = "shelton ";
	// String email = "shelton@gmailcom";
	// int idade = 18;
	//
	// boolean retornaNomeDoUsuarioValido = usuario.validarUsuario(nome, email,
	// idade);
	//
	// assertEquals(true, retornaNomeDoUsuarioValido);
	// }

}
