package br.gov.fatec.burguersystem.burguersystem.service.interfaces;

import br.gov.fatec.burguersystem.burguersystem.model.dto.ProdutoDTO;

import java.util.List;

public interface IProdutoService {

    List<ProdutoDTO> listarTodos();

    void cadastrar(ProdutoDTO dto);

    void atualizar(ProdutoDTO dto);

    void deletar(Long id);
}
