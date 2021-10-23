package br.gov.fatec.burguersystem.burguersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.fatec.burguersystem.burguersystem.model.dto.CategoriaDTO;
import br.gov.fatec.burguersystem.burguersystem.service.CategoriaService;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller utilizado para o contexto negocial da Marca")
@RestController
@RequestMapping(value = "api/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService service;

	@ApiOperation(value = "Metodo responsável por requisitar todas as categorias presentes na base de dados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriaDTO>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@ApiOperation(value = "Metodo responsável por cadastrar novas categorias na base de dados")
	@PostMapping(path = "/cadastrarCategoria", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaDTO> cadastraCategoria(@RequestBody CategoriaDTO dto) {
		CategoriaDTO categoriaDTO = service.cadastrar(dto);
		return ResponseEntity.ok(categoriaDTO);
	}

}