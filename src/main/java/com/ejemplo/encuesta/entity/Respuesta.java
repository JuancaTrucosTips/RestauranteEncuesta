package com.ejemplo.encuesta.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Respuesta")
public class Respuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String respuestaAbierta;
	
	@JsonBackReference(value = "repuesta-idencuesta")
	@ManyToOne
	@JoinColumn(name="idEncuesta")
	private Encuesta encuesta;

	@JsonBackReference(value = "repuesta-opcion-respuesta")
	@ManyToOne
	@JoinColumn(name="idOpcionRespuesta")
	private OpcionRespuesta opcionRespuesta;

	@JsonBackReference(value = "repuesta-pregunta")
	@ManyToOne
	@JoinColumn(name="idPregunta")
	private Pregunta pregunta;

	@JsonBackReference(value = "repuesta-cliente")
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRespuestaAbierta() {
		return this.respuestaAbierta;
	}

	public void setRespuestaAbierta(String respuestaAbierta) {
		this.respuestaAbierta = respuestaAbierta;
	}

	public Encuesta getEncuesta() {
		return this.encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public OpcionRespuesta getOpcionRespuesta() {
		return this.opcionRespuesta;
	}

	public void setOpcionRespuesta(OpcionRespuesta opcionRespuesta) {
		this.opcionRespuesta = opcionRespuesta;
	}

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
