package br.gov.fatec.burguersystem.burguersystem.model;

import lombok.Data;

import javax.persistence.*;

/**
 * <Author> Émerson Junior</Author>
 * Definição dos atributos referentes aos itens do pedidos
 *
 */
@Data // Anotação do lombok para criação de getters and setters
@Entity(name = "ITENS_DO_PEDIDO")
public class ItensDoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "COD_ITENS_DO_PEDIDO")
    private Long id;

    @Column(name = "COD_PEDIDO")
    private Long codPedido;

    //A quantidade não é double pois, como o produto, é sempre medida com unidades.
    @Column(name = "QUANTIDADE") 
    private Long quantidade;

    @Column(name = "OBSERVACAO")
    private String observacao;

}
