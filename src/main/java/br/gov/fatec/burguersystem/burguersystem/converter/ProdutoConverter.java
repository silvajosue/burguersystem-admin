package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.Produto;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoConverter {

    @Autowired
    public CategoriaConverter categoriaConverter;

    public List<ProdutoDTO> toListEntityToDto(List<Produto> lista) {
        List<ProdutoDTO> listDto = new ArrayList<>();
        for (Produto produto : lista) {
            ProdutoDTO dto = toEntityToDto(produto);
            listDto.add(dto);
        }

        return listDto;
    }

    public ProdutoDTO toEntityToDto(Produto produto) {

        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setCategoria(categoriaConverter.toEntityToDto(produto.getCategoria()));
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        dto.setQuantidadeEst(produto.getQuantidadeEst());
        dto.setFoto(produto.getFoto());

        return dto;
    }

    public Produto toDtoToEntity(ProdutoDTO dto) {

        Produto produto = new Produto();
        produto.setCategoria(categoriaConverter.toDtoToEntity(dto.getCategoria()));
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setQuantidadeEst(dto.getQuantidadeEst());
        produto.setFoto(dto.getFoto());

        return produto;
    }
}
