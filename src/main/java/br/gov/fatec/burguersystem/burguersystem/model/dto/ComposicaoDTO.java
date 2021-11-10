package br.gov.fatec.burguersystem.burguersystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ComposicaoDTO {

    // TODO Copia exata da classe Composicao

    private Long id;
    private String foto;
    private String nome;
    private List<ProdutoDTO> produto;
    private List<MaterialDTO> material;
    private Double quantidade;
    private String unidadeMedida;
	
}
