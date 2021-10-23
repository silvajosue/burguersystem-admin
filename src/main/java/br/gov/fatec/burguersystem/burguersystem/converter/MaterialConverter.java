package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.Material;
import br.gov.fatec.burguersystem.burguersystem.model.dto.MaterialDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MaterialConverter {


    public List<MaterialDTO> toListEntityToDto(List<Material> lista) {
        List<MaterialDTO> listDto = new ArrayList<>();
        for (Material material : lista) {
            MaterialDTO dto = toEntityToDto(material);
            listDto.add(dto);
        }

        return listDto;
    }

    public MaterialDTO toEntityToDto(Material material) {
        MaterialDTO dto = new MaterialDTO();
        dto.setId(material.getId());
        dto.setNome(material.getNome());
        dto.setPreco(material.getPreco());
        dto.setQuantidade(material.getQuantidade());
        dto.setUnidadeMedida(material.getUnidadeMedida());
        return dto;
    }

    public Material toDtoToEntity(MaterialDTO dto) {

        Material material = new Material();
        material.setNome(dto.getNome());
        material.setPreco(dto.getPreco());
        material.setQuantidade(dto.getQuantidade());
        material.setUnidadeMedida(dto.getUnidadeMedida());

        return material;
    }
}
