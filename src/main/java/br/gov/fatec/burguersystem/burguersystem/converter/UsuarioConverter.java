package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.gov.fatec.burguersystem.burguersystem.model.Usuario;
import br.gov.fatec.burguersystem.burguersystem.model.dto.UsuarioDTO;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		data.add(Calendar.MINUTE, 15);
		dto.setTempoSessao(data.getTimeInMillis());
		return dto;
	}

    public Usuario toDtoToEntity(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setCpf(dto.getCpf());
		usuario.setEmail(dto.getEmail());
		usuario.setFoto(dto.getFoto());
		usuario.setNome(dto.getNome());
		usuario.setRole(dto.getRole());
		usuario.setTelefone(dto.getTelefone());
		usuario.setSenha(new BCryptPasswordEncoder().encode(dto.getSenha()));

		Set<Role> roles = new HashSet<>();
		Role r = new Role();
		r.setNome(dto.getRole());
		r.setId(dto.getCodigoUsuario());
		roles.add(r);
		usuario.setRoles(roles);
		return usuario;
    }
}
