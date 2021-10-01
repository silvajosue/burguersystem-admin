package br.gov.fatec.burguersystem.burguersystem.controller;

import br.gov.fatec.burguersystem.burguersystem.config.security.TokenService;
import br.gov.fatec.burguersystem.burguersystem.model.dto.LoginDTO;
import br.gov.fatec.burguersystem.burguersystem.model.dto.TokenDTO;
import br.gov.fatec.burguersystem.burguersystem.model.dto.UsuarioDTO;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.IUsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@PostMapping(path = "cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Endpoint utilizado para cadastrar novos funcionarios na base de dados")
	public ResponseEntity<HttpStatus> cadastrar(@RequestBody UsuarioDTO dto) {

		try {
			usuarioService.cadastrar(dto);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
