package br.gov.fatec.burguersystem.burguersystem.controller;

import java.util.ArrayList;
import java.util.List;

import br.gov.fatec.burguersystem.burguersystem.model.dto.MaterialDTO;
import br.gov.fatec.burguersystem.burguersystem.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	MaterialService service;
	@ApiOperation(value = "Metodo responsável por requisitar todos os materiais presentes na base de dados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialDTO>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}
}