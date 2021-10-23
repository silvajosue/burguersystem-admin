package br.gov.fatec.burguersystem.burguersystem.service.interfaces;

import br.gov.fatec.burguersystem.burguersystem.model.dto.CategoriaDTO;

import java.util.List;

public interface ICategoriaService {

    List<CategoriaDTO> listarTodos();

    CategoriaDTO cadastrar(CategoriaDTO dto);
}
