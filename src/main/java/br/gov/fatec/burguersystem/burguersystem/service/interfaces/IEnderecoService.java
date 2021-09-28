package br.gov.fatec.burguersystem.burguersystem.service.interfaces;

import br.gov.fatec.burguersystem.burguersystem.model.dto.EnderecoDTO;

import java.util.List;

public interface IEnderecoService {

    List<EnderecoDTO> listarTodos();

    void cadastrar(EnderecoDTO dto);

}
