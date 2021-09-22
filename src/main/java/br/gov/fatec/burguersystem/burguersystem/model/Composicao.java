package br.gov.fatec.burguersystem.burguersystem.model;

import lombok.Data;

import javax.persistence.*;

/**
 * <Author> Émerson Junior</Author>
 * Definição dos atributos referentes as composições
 *
 */
@Data // Anotação do lombok para criação de getters and setters
@Entity(name = "COMPOSICAO") // TODO Colocar o nome da entidade do banco
public class Composicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_COMPOSICAO")
    private Long id;

    @Column(name = "COD_PRODUTO")
    private Long codProduto;

    @Column(name = "COD_MATERIAL")
    private Long codMaterial;

    @Column(name = "QUANTIDADE")
    private Double quantidade;

    @Column(name = "UNIDADE_MEDIDA")
    private String unidadeMedida;

}
