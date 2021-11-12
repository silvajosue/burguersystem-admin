package br.gov.fatec.burguersystem.burguersystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * <Author> Émerson Junior</Author>
 * Definição dos atributos referentes as composições
 *
 */
@Data // Anotação do lombok para criação de getters and setters
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "COMPOSICAO") // TODO Colocar o nome da entidade do banco
public class Composicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_COMPOSICAO")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "FOTO")
    private String foto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_COMPOSICAO_PRODUTO", joinColumns = @JoinColumn(name = "COD_COMPOSICAO"), inverseJoinColumns = @JoinColumn(name = "COD_PRODUTO"))
    private List<Produto> produto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_COMPOSICAO_MATERIAL", joinColumns = @JoinColumn(name = "COD_COMPOSICAO"), inverseJoinColumns = @JoinColumn(name = "COD_MATERIAL"))
    private List<Material> material;

    @Column(name = "QUANTIDADE")
    private Double quantidade;

    @Column(name = "UNIDADE_MEDIDA")
    private String unidadeMedida;

}
