package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.gov.fatec.burguersystem.burguersystem.model.Usuario;
import br.gov.fatec.burguersystem.burguersystem.model.dto.UsuarioDTO;

import java.util.*;

@Component
public class UsuarioConverter {

	public UsuarioDTO toEntityToDto(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usuario.getCodigoUsuario());
		dto.setCpf(usuario.getCpf());
		dto.setEmail(usuario.getEmail());
		dto.setFoto(usuario.getFoto());
		dto.setNome(usuario.getNome());
		dto.setTelefone(usuario.getTelefone());
		dto.setRole(usuario.getRole());
		dto.setAtivo(usuario.getAtivo());
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		data.add(Calendar.MINUTE, 15);
		dto.setTempoSessao(data.getTimeInMillis());
		return dto;
	}

    public Usuario  toDtoToEntity(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setCpf(dto.getCpf());
		usuario.setEmail(dto.getEmail());
		usuario.setFoto(dto.getFoto());
		usuario.setNome(dto.getNome());
		usuario.setRole(dto.getRole());
		usuario.setAtivo(dto.getAtivo());
		usuario.setTelefone(dto.getTelefone());
		usuario.setSenha(new BCryptPasswordEncoder().encode(dto.getSenha()));

		Set<Role> roles = new HashSet<>();
		Role r = new Role();
		r.setNome(dto.getRole());
		r.setId(dto.getRoles().getId());
		roles.add(r);
		usuario.setRoles(roles);
		return usuario;
    }

    public List<UsuarioDTO> toListEntityToDto(List<Usuario> lista) {
		List<UsuarioDTO> list = new ArrayList<>();
		for (Usuario user : lista) {
			UsuarioDTO dto = toEntityToDto(user);
			list.add(dto);
		}
		return list;
    }
}
