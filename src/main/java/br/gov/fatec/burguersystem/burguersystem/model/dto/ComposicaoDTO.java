package br.gov.fatec.burguersystem.burguersystem.model.dto;

import lombok.Data;

@Data
public class ComposicaoDTO {

    // TODO Copia exata da classe Composicao

    private Long id;
    private Long codProduto;
    private Long codMaterial;
    private Double quantidade;
    private String unidadeMedida;
	
}
