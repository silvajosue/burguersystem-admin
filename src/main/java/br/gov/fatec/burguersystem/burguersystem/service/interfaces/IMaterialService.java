package br.gov.fatec.burguersystem.burguersystem.service.interfaces;

import br.gov.fatec.burguersystem.burguersystem.model.dto.MaterialDTO;

import java.util.List;

public interface IMaterialService {

    List<MaterialDTO> listarTodos();

    void cadastrar(MaterialDTO dto);
}
