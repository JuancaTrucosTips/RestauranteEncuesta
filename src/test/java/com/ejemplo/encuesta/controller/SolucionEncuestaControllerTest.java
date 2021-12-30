package com.ejemplo.encuesta.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ejemplo.encuesta.dto.SolucionEncuestaDto;
import com.ejemplo.encuesta.facade.ISolucionEncuesta;

@ExtendWith(MockitoExtension.class)
class SolucionEncuestaControllerTest {

	@Mock
	ISolucionEncuesta solucionEncuestaService;

	@InjectMocks
	private SolucionEncuestaController solucionEncuestaController;
	
	@Test
	void crear() {
		var solucionEncuestaResponse = new SolucionEncuestaDto(); 
		solucionEncuestaResponse.setIdCliente(1);
		solucionEncuestaResponse.setIdEncuesta(1);

		Mockito.when(solucionEncuestaService.guardarSolucion(any(SolucionEncuestaDto.class))).thenReturn(solucionEncuestaResponse);

		var solucionEncuesta = new SolucionEncuestaDto();
		solucionEncuesta.setIdCliente(1);
		solucionEncuesta.setIdEncuesta(1);
		
		var response = solucionEncuestaController.crear(solucionEncuesta);
		
		assertEquals(201, response.getStatusCode().value());

	}

}
