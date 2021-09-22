package br.gov.fatec.burguersystem.burguersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.fatec.burguersystem.burguersystem.model.dto.ComposicaoDTO;
import br.gov.fatec.burguersystem.burguersystem.service.ComposicaoService;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller utilizado para o contexto negocial da Marca")
@RestController
@RequestMapping(value = "api/composicao")
public class ComposicaoController {

	@Autowired
	ComposicaoService service;

	@ApiOperation(value = "Metodo responsável por requisitar todas as composições presentes na base de dados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ComposicaoDTO>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@ApiOperation(value = "Metodo responsável por cadastrar novas composições na base de dados")
	@PostMapping(path = "/cadastrarComposicao", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> cadastraComposicao(@RequestBody ComposicaoDTO dto) {
		service.cadastrar(dto);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@ApiOperation(value = "Metodo responsável por atualizar composições na base de dados")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> atualizarComposicao(@RequestBody ComposicaoDTO dto) {
		service.atualizar(dto);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}