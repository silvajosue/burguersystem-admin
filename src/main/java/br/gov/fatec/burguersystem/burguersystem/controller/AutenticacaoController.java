package br.gov.fatec.burguersystem.burguersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import br.gov.fatec.burguersystem.burguersystem.config.security.TokenService;
import br.gov.fatec.burguersystem.burguersystem.model.dto.LoginDTO;
import br.gov.fatec.burguersystem.burguersystem.model.dto.TokenDTO;
import br.gov.fatec.burguersystem.burguersystem.model.dto.UsuarioDTO;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.IUsuarioService;



@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private IUsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<UsuarioDTO> autenticar(@RequestBody LoginDTO login) {
		UsernamePasswordAuthenticationToken dadosLogin = login.converter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			UsuarioDTO dto = recuperaUsuario(login);
			dto.setTokenDTO(new TokenDTO(token, "Bearer "));
			return ResponseEntity.ok(dto);
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	private UsuarioDTO recuperaUsuario(LoginDTO login) {
		UsuarioDTO dto = usuarioService.findByEmail(login.getEmail());
		dto.setEmail(login.getEmail());
		return dto;
	}
	
}
