package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.Composicao;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ComposicaoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComposicaoConverter {

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
        dto.setCodProduto(composicao.getCodProduto());
        dto.setCodMaterial(composicao.getCodMaterial());
        dto.setQuantidade(composicao.getQuantidade());
        dto.setUnidadeMedida(composicao.getUnidadeMedida());
        return dto;
    }

    public Composicao toDtoToEntity(ComposicaoDTO dto) {

        Composicao composicao = new Composicao();
        composicao.setCodProduto(dto.getCodProduto());
        composicao.setCodMaterial(dto.getCodMaterial());
        composicao.setQuantidade(dto.getQuantidade());
        composicao.setUnidadeMedida(dto.getUnidadeMedida());

        return composicao;
    }
}
