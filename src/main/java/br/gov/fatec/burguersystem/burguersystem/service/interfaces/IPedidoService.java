package br.gov.fatec.burguersystem.burguersystem.service.interfaces;

import br.gov.fatec.burguersystem.burguersystem.model.dto.PedidoDTO;

import java.util.List;

public interface IPedidoService {

    List<PedidoDTO> listarTodos();

    void cadastrar(PedidoDTO dto);
}
