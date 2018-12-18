package com.Livraria.livraria.Security;

import javax.security.sasl.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {

	public InvalidJwtAuthenticationException(String string) {
		super (string);
	}

}
