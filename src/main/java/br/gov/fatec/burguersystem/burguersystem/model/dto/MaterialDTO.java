package br.gov.fatec.burguersystem.burguersystem.model.dto;

import lombok.Data;

@Data // Anotação do lombok para criação de getters and setters
public class MaterialDTO {

    // TODO Copia exata da classe Material

    private Long id;
    private String nome;
    private Double quantidade;
    private String unidadeMedida;
    private Double preco;
}
