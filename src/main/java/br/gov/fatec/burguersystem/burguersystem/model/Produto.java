package br.gov.fatec.burguersystem.burguersystem.model;

import lombok.Data;

import javax.persistence.*;

/**
 * <Author> Émerson Junior</Author>
 * Definição dos atributos referentes aos produtos
 *
 */
@Data // Anotação do lombok para criação de getters and setters
@Entity(name = "PRODUTO") // TODO Colocar o nome da entidade do banco
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_PRODUTO")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_CATEGORIA")
    private Categoria categoria;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PRECO")
    private Double preco;

    @Column(name = "QUANTIDADE_EST")
    private Long quantidadeEst;

    @Column(name = "FOTO")
    private String foto;

}
