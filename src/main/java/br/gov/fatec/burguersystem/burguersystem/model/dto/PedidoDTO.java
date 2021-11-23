package br.gov.fatec.burguersystem.burguersystem.model.dto;

import lombok.Data;

@Data
public class PedidoDTO {

    // TODO Copia exata da classe Pedido
    
    private Long id;
    private ClienteDTO codCliente;
    private EnderecoDTO codEndereco;
    private Long mesa;
    private Double precoTotal;

}
