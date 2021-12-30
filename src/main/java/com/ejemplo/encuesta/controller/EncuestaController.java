package com.ejemplo.encuesta.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.encuesta.dto.EncuestaDto;
import com.ejemplo.encuesta.facade.IEncuestaService;

@RestController
@RequestMapping("/api/encuestas")
public class EncuestaController {

	private final IEncuestaService encuestaService;

	public EncuestaController(IEncuestaService encuestaService) {
		this.encuestaService = encuestaService;
	}

	@PostMapping
	public ResponseEntity<EncuestaDto> crear(@RequestBody EncuestaDto encuestaDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(encuestaService.almacenar(encuestaDto));
	}

	@GetMapping
	public ResponseEntity<List<EncuestaDto>> listarTodas() {
		List<EncuestaDto> encuestas = encuestaService.listarTodas();
		return ResponseEntity.ok(encuestas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EncuestaDto> buscar(@PathVariable int id) {
		var encuesta = encuestaService.buscarPorIdentificador(id);

		if (null == encuesta)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return ResponseEntity.ok(encuesta);

	}
}
