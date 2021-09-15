package br.gov.fatec.burguersystem.burguersystem.converter;

import org.springframework.stereotype.Component;

import br.gov.fatec.burguersystem.burguersystem.model.Usuario;
import br.gov.fatec.burguersystem.burguersystem.model.dto.UsuarioDTO;

@Component
public class UsuarioConverter {

	public UsuarioDTO toEntityToDto(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setCodigoUsuario(usuario.getCodigoUsuario());
		dto.setCpf(usuario.getCpf());
		dto.setEmail(usuario.getEmail());
		dto.setFoto(usuario.getFoto());
		dto.setNome(usuario.getNome());
		dto.setTelefone(usuario.getTelefone());
		dto.setRole(usuario.getRole());
		return dto;
	}

}
