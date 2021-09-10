package br.gov.fatec.burguersystem.burguersystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller utilizado para o contexto negocial da Marca")
@RestController
@RequestMapping(value = "/material")
public class MaterialController {

	@ApiOperation(value = "Metodo responsável por requisitar todos os materiais presentes na base de dados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> listarTodos() {
		List<String> lista = new ArrayList<>();
		lista.add("Funciona");
		lista.add("Olha olha");
		return ResponseEntity.ok(lista);
	}
}