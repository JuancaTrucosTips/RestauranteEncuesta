package com.ejemplo.encuesta.dto;

import java.util.List;

public class SolucionEncuestaDto {
	private int idEncuesta;
	private int idCliente;
	private List<PreguntaDto> preguntas;
	
	public int getIdEncuesta() {
		return idEncuesta;
	}
	public void setIdEncuesta(int idEncuesta) {
		this.idEncuesta = idEncuesta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public List<PreguntaDto> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<PreguntaDto> preguntas) {
		this.preguntas = preguntas;
	}	
}
