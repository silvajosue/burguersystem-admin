package br.gov.fatec.burguersystem.burguersystem.service.interfaces;

import br.gov.fatec.burguersystem.burguersystem.model.dto.ItensDoPedidoDTO;

import java.util.List;

public interface IItensDoPedidoService {

    List<ItensDoPedidoDTO> listarTodos();

    void cadastrar(ItensDoPedidoDTO dto);

    void atualizar(ItensDoPedidoDTO dto);
}
