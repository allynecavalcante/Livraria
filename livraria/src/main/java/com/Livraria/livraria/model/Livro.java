package com.Livraria.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Livro {
	
	@Id
	@GeneratedValue
	private long id;
	
	
	@Column ()
	private String NomedoLivro;
	
	@Column ()
	private Double Qnt;
	
	@Column ()
	private String CodigoLivro;
	
	@Column ()
	private String Tipo;
	
	@Column ()
	private String Autor;
	
	@Column ()
	private String Descrição;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomedoLivro() {
		return NomedoLivro;
	}

	public void setNomedoLivro(String nomedoLivro) {
		NomedoLivro = nomedoLivro;
	}

	public Double getQnt() {
		return Qnt;
	}

	public void setQnt(Double qnt) {
		this.Qnt = qnt;
	}

	public String getCodigoLivro() {
		return CodigoLivro;
	}

	public void setCodigoLivro(String codigoLivro) {
		CodigoLivro = codigoLivro;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public String getDescrição() {
		return Descrição;
	}

	public void setDescrição(String descrição) {
		Descrição = descrição;
	}
	
	

}
