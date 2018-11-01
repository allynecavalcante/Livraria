package com.Livraria.livraria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Livraria.livraria.model.Administrador;


@Repository
public interface AdmRepository extends JpaRepository <Administrador,Long>{




}
