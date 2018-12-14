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
	private String email;
 
    @Column(nullable=false)	
	private String senha;
 
	public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}


	
	
	
	
}
