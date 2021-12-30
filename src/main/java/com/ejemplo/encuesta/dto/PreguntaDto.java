package com.ejemplo.encuesta.dto;

public class PreguntaDto {
	
	private int idPregunta;
	private RespuestaDto respuestas;
	
	public int getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	public RespuestaDto getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(RespuestaDto respuestas) {
		this.respuestas = respuestas;
	}
}
