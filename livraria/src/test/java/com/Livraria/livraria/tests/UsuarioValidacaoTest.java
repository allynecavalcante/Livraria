package com.Livraria.livraria.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Livraria.livraria.services.UsuarioValidacao;

public class UsuarioValidacaoTest {

	public UsuarioValidacao usuario = new UsuarioValidacao();

	@Test
	public void deveValidarNomeMaiorOuIgual8Caracteres() {

		String nome = "Allyne Cavalcante";
		String email = "example@gmail.com";
		int idade = 18;
		int senha=123456;

	
		boolean retornaNomeDoUsuarioValido = usuario.validarUsuario(nome, email, idade, senha);

		assertEquals(true, retornaNomeDoUsuarioValido);
	}

	@Test
	public void naoDeveValidarEmailSemArroba() {

		String nome = "Allyne Cavalcante";
		String email = "examplegmail.com";
		int idade = 18;
		int senha=123456;

		boolean retornaEmailDoUsuarioInValido = usuario.validarUsuario(nome, email, idade, senha);

		assertEquals(false, retornaEmailDoUsuarioInValido);
	}

	 @Test
	 public void deveValidarMaiorOuIgual18() {
	
	 String nome = "Allyne Cavalcante ";
	 String email = "example@gmailcom";
	 int idade = 15;
	 int senha=123456;
	
    boolean retornaIdadeDoUsuarioInvalido = usuario.validarUsuario(nome, email, idade, senha);
	
     assertEquals(false, retornaIdadeDoUsuarioInvalido);
	 }
	 
	 @Test
	 public void deveValidarMaiorOuigual6() {
	
	 String nome = "Allyne Cavalcante";
	 String email = "example@gmailcom";
	 int idade = 18;
	 int senha=123;
	
    boolean retornaSenhaDoUsuarioInvalido = usuario.validarUsuario(nome, email, idade, senha);
	
	assertEquals(false, retornaSenhaDoUsuarioInvalido);
	 }

}
