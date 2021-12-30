package com.ejemplo.encuesta.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.encuesta.entity.Respuesta;

@Repository
public interface IRespuestaRepository extends JpaRepository<Respuesta, Integer>{

}
