package com.ejemplo.encuesta.dto;

import java.util.List;

public class RespuestaDto {
	
	private List<OpcionRespuestaDto> opcionRespuestas;
	private String respuestaAbierta;
	
	public List<OpcionRespuestaDto> getOpcionRespuestas() {
		return opcionRespuestas;
	}
	public void setOpcionRespuestas(List<OpcionRespuestaDto> opcionRespuestas) {
		this.opcionRespuestas = opcionRespuestas;
	}
	public String getRespuestaAbierta() {
		return respuestaAbierta;
	}
	public void setRespuestaAbierta(String respuestaAbierta) {
		this.respuestaAbierta = respuestaAbierta;
	}

}
