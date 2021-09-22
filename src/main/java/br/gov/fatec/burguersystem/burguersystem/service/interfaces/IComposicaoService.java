package br.gov.fatec.burguersystem.burguersystem.service.interfaces;

import br.gov.fatec.burguersystem.burguersystem.model.dto.ComposicaoDTO;

import java.util.List;

public interface IComposicaoService {

    List<ComposicaoDTO> listarTodos();

    void cadastrar(ComposicaoDTO dto);

    void atualizar(ComposicaoDTO dto);
}
