package com.ejemplo.encuesta.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.ejemplo.encuesta.dao.IEncuestaRepository;
import com.ejemplo.encuesta.dto.EncuestaDto;
import com.ejemplo.encuesta.entity.Encuesta;
import com.ejemplo.encuesta.entity.OpcionRespuesta;
import com.ejemplo.encuesta.entity.Pregunta;
import com.ejemplo.encuesta.entity.TipoPregunta;

@ExtendWith(MockitoExtension.class)
class EncuestaServicesImplTest {

	@Mock
	private IEncuestaRepository encuestaDao;

	private IEncuestaService encuestaService;

	@BeforeEach
	void setUp() {

		encuestaService = new EncuestaServicesImpl(encuestaDao, new ModelMapper());
	}

	@Test
	void listarTodas() {
		var listadoEncuestasResponse = new ArrayList<Encuesta>();
		var encuesta1 = new Encuesta();
		encuesta1.setDescripcion("Encuesta para Clientes VIP");
		var encuesta2 = new Encuesta();
		encuesta2.setDescripcion("Encuesta para Clientes Nuevos");
		listadoEncuestasResponse.add(encuesta1);
		listadoEncuestasResponse.add(encuesta2);

		Mockito.lenient().when(encuestaDao.findAll()).thenReturn(listadoEncuestasResponse);

		var listadoEncuestas = encuestaService.listarTodas();

		var encuesta1Salida = new EncuestaDto();
		var encuesta2Salida = new EncuestaDto();

		encuesta1Salida = listadoEncuestas.get(0);
		encuesta2Salida = listadoEncuestas.get(1);

		assertEquals(2, listadoEncuestas.size());
		assertEquals(encuesta1.getDescripcion(), encuesta1Salida.getDescripcion());
		assertEquals(encuesta2.getDescripcion(), encuesta2Salida.getDescripcion());
		Mockito.verify(encuestaDao).findAll();

	}

	@Test
	void listarPorIdentificador() {
		var encuestaDb = new Encuesta();
		encuestaDb.setId(1);

		Mockito.lenient().when(encuestaDao.findById(anyInt())).thenReturn(Optional.of(encuestaDb));

		var encuesta = encuestaService.buscarPorIdentificador(1);

		assertNotNull(encuesta);
		Mockito.verify(encuestaDao).findById(anyInt());

	}

	@Test
	void listarPorIdentificadorNoEncontradp() {
		Mockito.lenient().when(encuestaDao.findById(anyInt())).thenReturn(Optional.empty());

		var encuesta = encuestaService.buscarPorIdentificador(1);

		assertNull(encuesta);
		Mockito.verify(encuestaDao).findById(anyInt());

	}

	@Test
	void almacenar() {
		var encuestaBd = new Encuesta();
		encuestaBd.setId(2);

		Mockito.lenient().when(encuestaDao.save(any(Encuesta.class))).thenReturn(encuestaBd);

		var encuestaDto = new EncuestaDto();
		encuestaDto.setDescripcion("Encuesta para clientes recurrentes");

		var tipoPregunta = new TipoPregunta();
		tipoPregunta.setId(1);
		
		var pregunta1 = new Pregunta();
		pregunta1.setTipoPregunta(tipoPregunta);
		pregunta1.setEnunciado("¿enunciado1?");
		
		var opcionRespuesta1 = new OpcionRespuesta();
		opcionRespuesta1.setTexto("A");
		
		pregunta1.setOpcionRespuestas(Collections.singletonList(opcionRespuesta1));
		encuestaDto.setPreguntas(Collections.singletonList(pregunta1));

		var encuesta = encuestaService.almacenar(encuestaDto);

		assertNotNull(encuesta);
		Mockito.verify(encuestaDao).save(any(Encuesta.class));

	}

}
