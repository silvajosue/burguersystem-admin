package br.gov.fatec.burguersystem.burguersystem.model;

import lombok.Data;

import javax.persistence.*;

import org.springframework.format.datetime.standard.DateTimeContext;

/**
 * <Author> Émerson Junior</Author>
 * Definição dos atributos referentes aos status dos pedidos
 *
 */
@Data // Anotação do lombok para criação de getters and setters
@Entity(name = "PEDIDO_COM_STATUS")
public class PedidoComStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_PEDIDO_COM_STATUS")
    private Long id;

    @Column(name = "COD_PEDIDO")
    private Long codPedido;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DHPEDIDO")
    private DateTimeContext dhpedido;

}
//TODO dhpedido deve ter o tipo DATETIME do banco
