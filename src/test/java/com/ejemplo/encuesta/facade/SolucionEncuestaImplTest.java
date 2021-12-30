package com.ejemplo.encuesta.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ejemplo.encuesta.dao.IRespuestaRepository;
import com.ejemplo.encuesta.dto.OpcionRespuestaDto;
import com.ejemplo.encuesta.dto.PreguntaDto;
import com.ejemplo.encuesta.dto.RespuestaDto;
import com.ejemplo.encuesta.dto.SolucionEncuestaDto;
import com.ejemplo.encuesta.entity.Respuesta;

@ExtendWith(MockitoExtension.class)
class SolucionEncuestaImplTest {
	
	@Mock
	private IRespuestaRepository respuestaDao;
	
	private ISolucionEncuesta solucionEncuestaService;
	
	@BeforeEach
	void setUp() {
		solucionEncuestaService = new SolucionEncuestaImpl(respuestaDao);
	}
		
		
	@Test
	void guardarSolucionConRespuestaAbierta () {				
		var respuestaEncuestaBd = new Respuesta();
		respuestaEncuestaBd.setId(1);
		
		Mockito.lenient().when(respuestaDao.save(any(Respuesta.class))).thenReturn(respuestaEncuestaBd);
		
		var solucionEncuesta = new SolucionEncuestaDto();
		solucionEncuesta.setIdCliente(1);
		solucionEncuesta.setIdEncuesta(1);
		
		var preguntas = new ArrayList<PreguntaDto>();
		
		var pregunta1 = new PreguntaDto();
		pregunta1.setIdPregunta(1);
		
		var opcionesRespuesta = new ArrayList<OpcionRespuestaDto>();
		var respuesta = new RespuestaDto();
		respuesta.setRespuestaAbierta("Muy bien atendido");
		respuesta.setOpcionRespuestas(opcionesRespuesta);
		
		pregunta1.setRespuestas(respuesta);
		
		preguntas.add(pregunta1);
		
		solucionEncuesta.setPreguntas(preguntas);
		
		solucionEncuestaService.guardarSolucion(solucionEncuesta);
		
		SolucionEncuestaDto respuestaGuardado = solucionEncuestaService.guardarSolucion(solucionEncuesta);
		
		assertEquals(1, respuestaGuardado.getIdEncuesta());
		Mockito.verify(respuestaDao, Mockito.times(2)).save(any(Respuesta.class));
		
	}
	
	@Test
	void guardarSolucionConOpcionesRespuesta () {				
		var respuestaEncuestaBd = new Respuesta();
		respuestaEncuestaBd.setId(1);
		
		Mockito.lenient().when(respuestaDao.save(any(Respuesta.class))).thenReturn(respuestaEncuestaBd);
		
		var solucionEncuesta = new SolucionEncuestaDto();
		solucionEncuesta.setIdCliente(1);
		solucionEncuesta.setIdEncuesta(1);
		
		var preguntas = new ArrayList<PreguntaDto>();
		
		var pregunta1 = new PreguntaDto();
		pregunta1.setIdPregunta(1);
		
		var opcionesRespuesta = new ArrayList<OpcionRespuestaDto>();
		var opcionRespuesta = new OpcionRespuestaDto();
		opcionRespuesta.setIdOpcionRespuesta(1);
		
		opcionesRespuesta.add(opcionRespuesta);
		
		var respuesta = new RespuestaDto();
		respuesta.setRespuestaAbierta(null);
		respuesta.setOpcionRespuestas(opcionesRespuesta);
		
		pregunta1.setRespuestas(respuesta);
			
		preguntas.add(pregunta1);
		
		solucionEncuesta.setPreguntas(preguntas);
		
		SolucionEncuestaDto respuestaGuardado = solucionEncuestaService.guardarSolucion(solucionEncuesta);
		
		assertEquals(1, respuestaGuardado.getIdEncuesta());
		Mockito.verify(respuestaDao, Mockito.times(1)).save(any(Respuesta.class));
		
	}

}
