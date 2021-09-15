package br.gov.fatec.burguersystem.burguersystem.service.interfaces;

import br.gov.fatec.burguersystem.burguersystem.model.dto.UsuarioDTO;

public interface IUsuarioService {

	UsuarioDTO findByEmail(String email);

}
