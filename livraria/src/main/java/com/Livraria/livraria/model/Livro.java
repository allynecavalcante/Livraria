package com.Livraria.livraria.model;

import java.util.List;

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

	
	
	public Livro(String string, double d) {
		// TODO Auto-generated constructor stub
	}

	public Livro() {
		// TODO Auto-generated constructor stub
	}

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

	public Double getValor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getMaiorPreco() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getMenorPreco() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getLivroPrecos(Livro livro) {
		// TODO Auto-generated method stub
		
	}

	public List<Livro> getLivrosMaisCaros() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void add(Livro romance) {
		// TODO Auto-generated method stub
		
	}
	
	

}
