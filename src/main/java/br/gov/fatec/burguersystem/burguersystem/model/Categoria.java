package br.gov.fatec.burguersystem.burguersystem.model;

import lombok.Data;

import javax.persistence.*;

/**
 * <Author> Émerson Junior</Author>
 * Definição dos atributos referentes as categorias
 *
 */
@Data // Anotação do lombok para criação de getters and setters
@Entity(name = "CATEGORIA") // TODO Colocar o nome da entidade do banco
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CATEGORIA")
    private Long id;

    @Column(name = "NOME")
    private String nome;

}
