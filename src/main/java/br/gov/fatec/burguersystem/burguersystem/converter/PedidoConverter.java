package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.Pedido;
import br.gov.fatec.burguersystem.burguersystem.model.dto.PedidoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoConverter {


    public List<PedidoDTO> toListEntityToDto(List<Pedido> lista) {
        List<PedidoDTO> listDto = new ArrayList<>();
        for (Pedido pedido : lista) {
            PedidoDTO dto = toEntityToDto(pedido);
            listDto.add(dto);
        }

        return listDto;
    }

    private PedidoDTO toEntityToDto(Pedido pedido) {
        
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setCodCliente(pedido.getCodCliente());
        dto.setCodEndereco(pedido.getCodEndereco());
        dto.setMesa(pedido.getMesa());
        dto.setPrecoTotal(pedido.getPrecoTotal());

        return dto;
    }

    public Pedido toDtoToEntity(PedidoDTO dto) {

        Pedido pedido = new Pedido();
        pedido.setCodCliente(dto.getCodCliente());
        pedido.setCodEndereco(dto.getCodEndereco());
        pedido.setMesa(dto.getMesa());
        pedido.setPrecoTotal(dto.getPrecoTotal());

        return pedido;
    }
}
