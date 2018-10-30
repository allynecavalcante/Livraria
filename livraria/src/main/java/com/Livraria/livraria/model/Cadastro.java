package com.Livraria.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.Livraria.livraria.repository.CadastroRepository;

@Entity
@Table
public class Cadastro  {
	
	@Id
	@GeneratedValue
	private long id;
	
	
	@Column (length = 60, nullable = false)
	private String NomeCompleto;
	
	@Column (length = 60, nullable = false)
	private Double idade;
	
	@Column (length = 60, nullable = false)
	private String email;
	
	@Column (length = 60, nullable = false)
	private String senha;


	private boolean pagamento;
	

	public boolean isPagamento() {
		return pagamento;
	}

	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return NomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		NomeCompleto = nomeCompleto;
	}

	public Double getIdade() {
		return idade;
	}

	public void setIdade(Double idade) {
		this.idade = idade;
	}

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
