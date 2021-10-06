package br.gov.fatec.burguersystem.burguersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.fatec.burguersystem.burguersystem.model.dto.PedidoComStatusDTO;
import br.gov.fatec.burguersystem.burguersystem.service.PedidoComStatusService;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller utilizado para o contexto negocial da Marca")
@RestController
@RequestMapping(value = "/api/pedidoComStatus")
public class PedidoComStatusController {

	@Autowired
	PedidoComStatusService service;

	@ApiOperation(value = "Metodo responsável por requisitar todos os status dos pedidos presentes na base de dados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PedidoComStatusDTO>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@ApiOperation(value = "Metodo responsável por cadastrar novos status de pedidos na base de dados")
	@PostMapping(path = "cadastrarPedidoComStatus", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> cadastrarPedidoComStatus(@RequestBody PedidoComStatusDTO dto) {
		service.cadastrar(dto);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}