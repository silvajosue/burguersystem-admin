package br.gov.fatec.burguersystem.burguersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.fatec.burguersystem.burguersystem.model.dto.ItensDoPedidoDTO;
import br.gov.fatec.burguersystem.burguersystem.service.ItensDoPedidoService;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller utilizado para o contexto negocial da Marca")
@RestController
@RequestMapping(value = "/api/itensDoPedido")
public class ItensDoPedidoController {

	@Autowired
	ItensDoPedidoService service;

	@ApiOperation(value = "Metodo responsável por requisitar todos os itens dos pedidos presentes na base de dados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItensDoPedidoDTO>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@ApiOperation(value = "Metodo responsável por cadastrar um novo item do pedido na base de dados")
	@PostMapping(path = "cadastrarItensDoPedido", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> cadastrarItensDoPedido(@RequestBody ItensDoPedidoDTO dto) {
		service.cadastrar(dto);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}