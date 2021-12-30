package com.ejemplo.encuesta.facade;

import java.util.List;

import com.ejemplo.encuesta.dto.EncuestaDto;

public interface IEncuestaService {

	public List<EncuestaDto> listarTodas();
	
	public EncuestaDto buscarPorIdentificador(int id);
	
	public EncuestaDto almacenar(EncuestaDto encuestaDto);
	
}
