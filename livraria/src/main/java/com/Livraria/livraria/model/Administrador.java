package com.Livraria.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Administrador {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column ()
	private String CadastroLivro;
	
	@Column ()
	private String RemoverLivro;
	
	@Column ()
	private String AdiconarComentarios;
	
	
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCadastroLivro() {
		return CadastroLivro;
	}

	public void setCadastroLivro(String cadastroLivro) {
		CadastroLivro = cadastroLivro;
	}

	public String getRemoverLivro() {
		return RemoverLivro;
	}

	public void setRemoverLivro(String removerLivro) {
		RemoverLivro = removerLivro;
	}

	public String getAdiconarComentarios() {
		return AdiconarComentarios;
	}

	public void setAdiconarComentarios(String adiconarComentarios) {
		AdiconarComentarios = adiconarComentarios;
	}

	


}
