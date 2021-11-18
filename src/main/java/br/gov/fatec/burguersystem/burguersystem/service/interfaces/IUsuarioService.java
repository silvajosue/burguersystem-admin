package br.gov.fatec.burguersystem.burguersystem.service.interfaces;

import br.gov.fatec.burguersystem.burguersystem.model.dto.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {

	UsuarioDTO findByEmail(String email);

    void cadastrar(UsuarioDTO dto);

    List<UsuarioDTO> buscarTodos();
}
