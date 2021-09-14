package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.Produto;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ProdutoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoConverter {


    public List<ProdutoDTO> toListEntityToDto(List<Produto> lista) {
        List<ProdutoDTO> listDto = new ArrayList<>();
        for (Produto produto : lista) {
            ProdutoDTO dto = toEntityToDto(produto);
            listDto.add(dto);
        }

        return listDto;
    }

    private ProdutoDTO toEntityToDto(Produto produto) {
        
        ProdutoDTO dto = new Produto();
        dto.setId(produto.getId());
        dto.setCategoria(produto.getCodCategoria());
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        dto.setFoto(produto.getFoto());
        dto.setQuantidade(produto.getQuantidade());

        return dto;
    }

    public Produto toDtoToEntity(ProdutoDTO dto) {

        Produto produto = new Produto();
        produto.setCategoria(dto.getCodCategoria());
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setFoto(dto.getFoto());
        produto.setQuantidade(dto.getQuantidade());

        return produto;
    }
}
