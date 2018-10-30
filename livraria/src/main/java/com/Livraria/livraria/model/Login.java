package com.Livraria.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Login {
 @Id
 @GeneratedValue
 private long id;
 
    @Column(nullable=false)	
	private String Email;
 
    @Column(nullable=false)	
	private String Senha;
 
	public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public String getSenha() {
	return Senha;
}

public void setSenha(String senha) {
	Senha = senha;
}

	
	
	
	
}
