package com.ejemplo.encuesta.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.encuesta.entity.Encuesta;

@Repository
public interface IEncuestaRepository extends JpaRepository<Encuesta, Integer>{

}
