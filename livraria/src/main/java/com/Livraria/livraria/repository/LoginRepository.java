package com.Livraria.livraria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Livraria.livraria.model.Login;



@Repository
public interface LoginRepository extends JpaRepository <Login,Long>{

	
	public Login findByEmailAndSenha(String email, String senha);
	public Optional<Login> findByEmail(String email);
	
}

	


