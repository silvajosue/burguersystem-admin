package br.gov.fatec.burguersystem.burguersystem.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PedidoComStatusDTO {

    // TODO Copia exata da classe Pedido
    
    private Long id;
    private Long codPedido;
    private String status;
    private Date dhpedido;

}
//TODO dhpedido deve ter o tipo DATETIME do banco