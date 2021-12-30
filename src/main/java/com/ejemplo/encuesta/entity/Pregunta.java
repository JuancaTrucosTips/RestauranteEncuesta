package com.ejemplo.encuesta.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "Pregunta")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pregunta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String enunciado;
	
	@OneToOne
	@JoinColumn(name="idTipo")
	private TipoPregunta tipoPregunta;

	@OneToMany(mappedBy="pregunta", cascade={CascadeType.ALL})
	private List<OpcionRespuesta> opcionRespuestas;
	
	@JsonBackReference(value = "idEncuesta")
	@ManyToOne
	@JoinColumn(name="idEncuesta")
	private Encuesta encuesta;
	
	@OneToMany(mappedBy="pregunta", cascade={CascadeType.ALL})
	private List<Respuesta> respuestas;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnunciado() {
		return this.enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<OpcionRespuesta> getOpcionRespuestas() {
		return this.opcionRespuestas;
	}

	public void setOpcionRespuestas(List<OpcionRespuesta> opcionRespuestas) {
		this.opcionRespuestas = opcionRespuestas;
	}

	public Encuesta getEncuesta() {
		return this.encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public TipoPregunta getTipoPregunta() {
		return this.tipoPregunta;
	}

	public void setTipoPregunta(TipoPregunta tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}
	
}