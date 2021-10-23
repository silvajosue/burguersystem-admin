package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.Categoria;
import br.gov.fatec.burguersystem.burguersystem.model.dto.CategoriaDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaConverter {

    public List<CategoriaDTO> toListEntityToDto(List<Categoria> lista) {
        List<CategoriaDTO> listDto = new ArrayList<>();
        for (Categoria categoria : lista) {
            CategoriaDTO dto = toEntityToDto(categoria);
            listDto.add(dto);
        }

        return listDto;
    }

    public CategoriaDTO toEntityToDto(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        return dto;
    }

    public Categoria toDtoToEntity(CategoriaDTO dto) {

        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNome(dto.getNome());
        return categoria;
    }
}
