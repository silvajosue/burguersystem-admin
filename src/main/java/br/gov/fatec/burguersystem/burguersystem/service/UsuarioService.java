package br.gov.fatec.burguersystem.burguersystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.fatec.burguersystem.burguersystem.converter.UsuarioConverter;
import br.gov.fatec.burguersystem.burguersystem.model.Usuario;
import br.gov.fatec.burguersystem.burguersystem.model.dto.UsuarioDTO;
import br.gov.fatec.burguersystem.burguersystem.repository.UsuarioRepository;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioConverter converter;

	@Override
	public UsuarioDTO findByEmail(String email) {
		Optional<Usuario> op = repository.findByEmail(email);
		
		return converter.toEntityToDto(op.get());
	}

}
