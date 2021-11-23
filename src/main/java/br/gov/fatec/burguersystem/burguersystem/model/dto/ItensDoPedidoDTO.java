package br.gov.fatec.burguersystem.burguersystem.model.dto;

import lombok.Data;

@Data
public class ItensDoPedidoDTO {

    // TODO Copia exata da classe ItensDoPedido
    
    private Long id;
    private PedidoDTO codPedido;
    private Long quantidade;
    private String observacao;

}
