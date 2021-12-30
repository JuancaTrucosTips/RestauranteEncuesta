package com.ejemplo.encuesta.facade;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.encuesta.dao.IEncuestaRepository;
import com.ejemplo.encuesta.dto.EncuestaDto;
import com.ejemplo.encuesta.entity.Encuesta;
import com.ejemplo.encuesta.entity.OpcionRespuesta;
import com.ejemplo.encuesta.entity.Pregunta;

@Service
public class EncuestaServicesImpl implements IEncuestaService {

	private final IEncuestaRepository encuestaDao;
	private ModelMapper mapper;

	public EncuestaServicesImpl(IEncuestaRepository encuestaDao, ModelMapper mapper) {
		this.encuestaDao = encuestaDao;
		this.mapper = mapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EncuestaDto> listarTodas() {
		return encuestaDao.findAll().stream().map(encuesta -> mapper.map(encuesta, EncuestaDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public EncuestaDto buscarPorIdentificador(int id) {
		var encuesta = encuestaDao.findById(id);
		if (encuesta.isPresent()) {
			return mapper.map(encuesta.get(), EncuestaDto.class);
		}
		
		return null;
	}

	@Override
	@Transactional
	public EncuestaDto almacenar(EncuestaDto encuestaDto) {
		Encuesta encuesta = mapper.map(encuestaDto, Encuesta.class);

		encuesta.getPreguntas().forEach(pregunta -> pregunta.setEncuesta(encuesta));

		for (Pregunta pregunta : encuesta.getPreguntas()) {
			for (OpcionRespuesta opcionRepuesta : pregunta.getOpcionRespuestas()) {
				opcionRepuesta.setPregunta(pregunta);
			}
		}

		return mapper.map(encuestaDao.save(encuesta), EncuestaDto.class);
	}

}
