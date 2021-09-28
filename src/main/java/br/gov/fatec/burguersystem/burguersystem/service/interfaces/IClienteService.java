package br.gov.fatec.burguersystem.burguersystem.service.interfaces;

import br.gov.fatec.burguersystem.burguersystem.model.dto.ClienteDTO;

import java.util.List;

public interface IClienteService {

    List<ClienteDTO> listarTodos();

    void cadastrar(ClienteDTO dto);

    void atualizar(ClienteDTO dto);
}
