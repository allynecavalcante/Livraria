package com.Livraria.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Livraria.livraria.model.Cadastro;




@Repository
public interface CadastroRepository extends JpaRepository <Cadastro,Long> {

}
