package br.gov.fatec.burguersystem.burguersystem.model;

import lombok.Data;

import javax.persistence.*;

/**
 * <Author> Émerson Junior</Author>
 * Definição dos atributos referentes aos pedidos
 *
 */
@Data // Anotação do lombok para criação de getters and setters
@Entity(name = "PEDIDOS")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_PEDIDO")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_CLIENTE")
    private Cliente codCliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_ENDERECO")
    private Endereco codEndereco;

    @Column(name = "MESA")
    private Long mesa;

    @Column(name = "PRECO_TOTAL")
    private Double precoTotal;

}
//TODO retirar o campo status do pedido no BD por conta da tabela pedido_com_status
