package com.Livraria.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Livraria.livraria.model.Livro;


@Repository
public interface LivroRepository extends JpaRepository <Livro,Long>{

}
