package com.ejemplo.encuesta.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ejemplo.encuesta.dto.EncuestaDto;
import com.ejemplo.encuesta.facade.IEncuestaService;

@ExtendWith(MockitoExtension.class)
class EncuestaControllerTest {

	@Mock
	IEncuestaService encuestaService;

	@InjectMocks
	private EncuestaController encuestaController;

	@Test
	void crear() {
		var encuestaDtoReponse = new EncuestaDto();
		encuestaDtoReponse.setId(1);
		encuestaDtoReponse.setDescripcion("Encuesta Dominos Pizza");

		Mockito.when(encuestaService.almacenar(any(EncuestaDto.class))).thenReturn(encuestaDtoReponse);

		var encuestaDtoCrear = new EncuestaDto();
		encuestaDtoCrear.setDescripcion("Encuesta Dominos Pizza"); 
		
		var response = encuestaController.crear(encuestaDtoCrear);
		
		assertEquals(201, response.getStatusCode().value());

	}
	
	@Test
	void listarTodas() {
		var encuestasDtoReponse = new ArrayList<EncuestaDto>();
		
		var encuestaDtoReponse = new EncuestaDto();
		encuestaDtoReponse.setId(1);
		encuestaDtoReponse.setDescripcion("Encuesta Dominos Pizza"); 
		
		var encuestaDtoReponse2 = new EncuestaDto();
		encuestaDtoReponse2.setId(2);
		encuestaDtoReponse2.setDescripcion("Encuesta Haburguesas El Oeste");
		
		encuestasDtoReponse.add(encuestaDtoReponse);
		encuestasDtoReponse.add(encuestaDtoReponse2);

		Mockito.when(encuestaService.listarTodas()).thenReturn(encuestasDtoReponse);
		
		var response = encuestaController.listarTodas();
		
		assertEquals(200, response.getStatusCode().value());

	}
	
	@Test
	void buscar() {		
		var encuestaDtoReponse = new EncuestaDto();
		encuestaDtoReponse.setId(1);
		encuestaDtoReponse.setDescripcion("Encuesta Dominos Pizza");
		
		Mockito.when(encuestaService.buscarPorIdentificador(encuestaDtoReponse.getId())).thenReturn(encuestaDtoReponse);
		
		var response = encuestaController.buscar(1);
		
		assertEquals(200, response.getStatusCode().value());

	}
	
	@Test
	void buscarNoEncontrado() {
		Mockito.when(encuestaService.buscarPorIdentificador(anyInt())).thenReturn(null);
		
		var response = encuestaController.buscar(1);
		
		assertEquals(404, response.getStatusCode().value());

	}

}
