package br.gov.fatec.burguersystem.burguersystem.service.interfaces;

import br.gov.fatec.burguersystem.burguersystem.model.dto.PedidoComStatusDTO;

import java.util.List;

public interface IPedidoComStatusService {

    List<PedidoComStatusDTO> listarTodos();

    void cadastrar(PedidoComStatusDTO dto);
    
    void atualizar(PedidoComStatusDTO dto);
}
