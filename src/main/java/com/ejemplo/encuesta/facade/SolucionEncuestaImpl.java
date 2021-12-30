package com.ejemplo.encuesta.facade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.encuesta.dao.IRespuestaRepository;
import com.ejemplo.encuesta.dto.OpcionRespuestaDto;
import com.ejemplo.encuesta.dto.PreguntaDto;
import com.ejemplo.encuesta.dto.SolucionEncuestaDto;
import com.ejemplo.encuesta.entity.Cliente;
import com.ejemplo.encuesta.entity.Encuesta;
import com.ejemplo.encuesta.entity.OpcionRespuesta;
import com.ejemplo.encuesta.entity.Pregunta;
import com.ejemplo.encuesta.entity.Respuesta;

@Service
public class SolucionEncuestaImpl implements ISolucionEncuesta {

	private IRespuestaRepository respuestaDao;

	public SolucionEncuestaImpl(IRespuestaRepository respuestaDao) {
		this.respuestaDao = respuestaDao;
	}

	@Override
	@Transactional
	public SolucionEncuestaDto guardarSolucion(SolucionEncuestaDto solucionEncuesta) {

		Respuesta respuestaEncuesta = new Respuesta();

		Cliente cliente = new Cliente();
		cliente.setId(solucionEncuesta.getIdCliente());
		respuestaEncuesta.setCliente(cliente);

		Encuesta encuesta = new Encuesta();
		encuesta.setId(solucionEncuesta.getIdEncuesta());
		respuestaEncuesta.setEncuesta(encuesta);

		for (PreguntaDto preguntaDto : solucionEncuesta.getPreguntas()) {

			Pregunta pregunta = new Pregunta();
			pregunta.setId(preguntaDto.getIdPregunta());
			respuestaEncuesta.setPregunta(pregunta);

			if (!preguntaDto.getRespuestas().getOpcionRespuestas().isEmpty()) {
				for (OpcionRespuestaDto opcionRespuestaDto : preguntaDto.getRespuestas().getOpcionRespuestas()) {

					OpcionRespuesta opcionRespuesta = new OpcionRespuesta();
					opcionRespuesta.setId(opcionRespuestaDto.getIdOpcionRespuesta());
					respuestaEncuesta.setOpcionRespuesta(opcionRespuesta);

					almacenarSolucionEncuesta(respuestaEncuesta);
				}
			} else {
				respuestaEncuesta.setRespuestaAbierta(preguntaDto.getRespuestas().getRespuestaAbierta());
				almacenarSolucionEncuesta(respuestaEncuesta);
			}

		}

		return solucionEncuesta;
	}

	private void almacenarSolucionEncuesta(Respuesta respuestaEncuesta) {
		Respuesta respuestaEncuestaAlmacenar = new Respuesta();
		respuestaEncuestaAlmacenar.setCliente(respuestaEncuesta.getCliente());
		respuestaEncuestaAlmacenar.setEncuesta(respuestaEncuesta.getEncuesta());
		respuestaEncuestaAlmacenar.setOpcionRespuesta(respuestaEncuesta.getOpcionRespuesta());
		respuestaEncuestaAlmacenar.setPregunta(respuestaEncuesta.getPregunta());
		respuestaEncuestaAlmacenar.setRespuestaAbierta(respuestaEncuesta.getRespuestaAbierta());
		respuestaDao.save(respuestaEncuestaAlmacenar);
	}

}
