package br.gov.fatec.burguersystem.burguersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.fatec.burguersystem.burguersystem.model.dto.PedidoDTO;
import br.gov.fatec.burguersystem.burguersystem.service.PedidoService;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller utilizado para o contexto negocial da Marca")
@RestController
@RequestMapping(value = "/api/pedido")
public class PedidoController {

	@Autowired
	PedidoService service;

	@ApiOperation(value = "Metodo responsável por requisitar todos os pedidos presentes na base de dados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PedidoDTO>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@ApiOperation(value = "Metodo responsável por cadastrar novos pedidos na base de dados")
	@PostMapping(path = "cadastrarPedido", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> cadastrarPedido(@RequestBody PedidoDTO dto) {
		service.cadastrar(dto);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}