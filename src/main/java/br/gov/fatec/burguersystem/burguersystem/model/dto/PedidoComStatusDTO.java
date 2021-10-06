package br.gov.fatec.burguersystem.burguersystem.model.dto;

import org.springframework.format.datetime.standard.DateTimeContext;

import lombok.Data;

@Data
public class PedidoComStatusDTO {

    // TODO Copia exata da classe Pedido
    
    private Long id;
    private Long codPedido;
    private String status;
    private DateTimeContext dhpedido;

}
//TODO dhpedido deve ter o tipo DATETIME do banco