package br.gov.fatec.burguersystem.burguersystem.model;

import lombok.Data;

import javax.persistence.*;

/**
 * <Author> Josué Silva</Author>
 * Definição dos atributos referentes aos materiais
 *
 */
@Data // Anotação do lombok para criação de getters and setters
@Entity(name = "MATERIAL") // TODO Colocar o nome da entidade do banco
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_MATERIAL")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "QUANTIDADE_EST")
    private Double quantidade;

    @Column(name = "UNIDADE_MEDIDA")
    private String unidadeMedida;

    @Column(name = "PRECO")
    private Double preco;
}
