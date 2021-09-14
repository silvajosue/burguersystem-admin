package br.gov.fatec.burguersystem.burguersystem.model.dto;

import lombok.Data;

@Data // Anotação do lombok para criação de getters and setters
public class ProdutoDTO {

    // TODO Copia exata da classe Produto

    private Long id;
    private Long codCategoria;
    private String nome;
    private Double preco;
    private String foto;
    private Double quantidade;
}