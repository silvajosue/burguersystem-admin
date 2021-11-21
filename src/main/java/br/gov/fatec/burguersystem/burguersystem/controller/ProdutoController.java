package br.gov.fatec.burguersystem.burguersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.fatec.burguersystem.burguersystem.model.dto.ProdutoDTO;
import br.gov.fatec.burguersystem.burguersystem.service.ProdutoService;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller utilizado para o contexto negocial da Marca")
@RestController
@RequestMapping(value = "/api/produto")
public class ProdutoController {

	@Autowired
	ProdutoService service;

	@ApiOperation(value = "Metodo responsável por requisitar todos os produtos presentes na base de dados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProdutoDTO>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@ApiOperation(value = "Metodo responsável por cadastrar novos produtos na base de dados")
	@PostMapping(path = "cadastrarProduto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> cadastrarProduto(@RequestBody ProdutoDTO dto) {
		service.cadastrar(dto);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@ApiOperation(value = "Metodo responsável por remover produtos da base de dados")
	@PostMapping(path = "remover", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> remover(@RequestBody ProdutoDTO dto) {
		service.remover(dto);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@ApiOperation(value = "Metodo responsável por atualizar produtos da base de dados")
	@PutMapping(path = "remover", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> atualizar(@RequestBody ProdutoDTO dto) {
		service.atualizar(dto);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}