package com.Livraria.livraria.repository;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Livraria.livraria.model.Administrador;


@Repository
public interface AdmRepository extends JpaRepository <Admin,Long>{

	Administrador save(@Valid Administrador administrador);



}
