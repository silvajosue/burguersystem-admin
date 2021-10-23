package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.Composicao;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ComposicaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComposicaoConverter {

    @Autowired
    public ProdutoConverter produtoConverter;

    @Autowired
    public MaterialConverter materialConverter;

    public List<ComposicaoDTO> toListEntityToDto(List<Composicao> lista) {
        List<ComposicaoDTO> listDto = new ArrayList<>();
        for (Composicao composicao : lista) {
            ComposicaoDTO dto = toEntityToDto(composicao);
            listDto.add(dto);
        }

        return listDto;
    }

    private ComposicaoDTO toEntityToDto(Composicao composicao) {
        ComposicaoDTO dto = new ComposicaoDTO();
        dto.setId(composicao.getId());
        dto.setProduto(produtoConverter.toEntityToDto(composicao.getProduto()));
        dto.setMaterial(materialConverter.toEntityToDto(composicao.getMaterial()));
        dto.setQuantidade(composicao.getQuantidade());
        dto.setUnidadeMedida(composicao.getUnidadeMedida());
        return dto;
    }

    public Composicao toDtoToEntity(ComposicaoDTO dto) {

        Composicao composicao = new Composicao();

        composicao.setProduto(produtoConverter.toDtoToEntity(dto.getProduto()));
        composicao.setMaterial(materialConverter.toDtoToEntity(dto.getMaterial()));
        composicao.setQuantidade(dto.getQuantidade());
        composicao.setUnidadeMedida(dto.getUnidadeMedida());

        return composicao;
    }
}
