package br.gov.fatec.burguersystem.burguersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.fatec.burguersystem.burguersystem.model.dto.ClienteDTO;
import br.gov.fatec.burguersystem.burguersystem.service.ClienteService;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller utilizado para o contexto negocial da Marca")
@RestController
@RequestMapping(value = "api/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;

	@ApiOperation(value = "Metodo responsável por requisitar todos os clientes presentes na base de dados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClienteDTO>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@ApiOperation(value = "Metodo responsável por cadastrar novos clientes na base de dados")
	@PostMapping(path = "/cadastrarCliente", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> cadastraCliente(@RequestBody ClienteDTO dto) {
		ClienteDTO cliente = service.cadastrar(dto);
		return ResponseEntity.ok(cliente);
	}

	@ApiOperation(value = "Metodo responsável por atualizar os clientes na base de dados")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> atualizarCliente(@RequestBody ClienteDTO dto) {
		service.atualizar(dto);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}