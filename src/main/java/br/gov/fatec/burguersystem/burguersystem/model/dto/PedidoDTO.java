package br.gov.fatec.burguersystem.burguersystem.model.dto;

import lombok.Data;

@Data
public class PedidoDTO {

    // TODO Copia exata da classe Pedido
    
    private Long id;
    private Long codCliente;
    private Long codEndereco;
    private Long mesa;
    private Double precoTotal;

}
