package com.ejemplo.encuesta.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.encuesta.dto.SolucionEncuestaDto;
import com.ejemplo.encuesta.facade.ISolucionEncuesta;

@RestController
@RequestMapping("/api/solucionEncuestas")
public class SolucionEncuestaController {
	
	private final ISolucionEncuesta solucionEncuestaService;

	public SolucionEncuestaController(ISolucionEncuesta solucionEncuestaService) {
		this.solucionEncuestaService = solucionEncuestaService;
	}
	
	@PostMapping()
	public ResponseEntity<SolucionEncuestaDto> crear(@RequestBody SolucionEncuestaDto solucionEncuestaDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(solucionEncuestaService.guardarSolucion(solucionEncuestaDto));
	}
}
