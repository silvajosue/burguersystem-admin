package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.ItensDoPedido;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ItensDoPedidoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItensDoPedidoConverter {


    public List<ItensDoPedidoDTO> toListEntityToDto(List<ItensDoPedido> lista) {
        List<ItensDoPedidoDTO> listDto = new ArrayList<>();
        for (ItensDoPedido itensDoPedido : lista) {
            ItensDoPedidoDTO dto = toEntityToDto(itensDoPedido);
            listDto.add(dto);
        }

        return listDto;
    }

    private ItensDoPedidoDTO toEntityToDto(ItensDoPedido itensDoPedido) {
        
        ItensDoPedidoDTO dto = new ItensDoPedidoDTO();
        dto.setId(itensDoPedido.getId());
        dto.setCodPedido(itensDoPedido.getCodPedido());
        dto.setCodProduto(itensDoPedido.getCodProduto());
        dto.setQuantidade(itensDoPedido.getQuantidade());
        dto.setObservacao(itensDoPedido.getObservacao());

        return dto;
    }

    public ItensDoPedido toDtoToEntity(ItensDoPedidoDTO dto) {

        ItensDoPedido itensDoPedido = new ItensDoPedido();
        itensDoPedido.setCodPedido(dto.getCodPedido());
        itensDoPedido.setCodProduto(dto.getCodProduto());
        itensDoPedido.setQuantidade(dto.getQuantidade());
        itensDoPedido.setObservacao(dto.getObservacao());

        return itensDoPedido;
    }
}
