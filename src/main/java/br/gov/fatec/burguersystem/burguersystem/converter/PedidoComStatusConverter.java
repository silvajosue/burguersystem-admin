package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.PedidoComStatus;
import br.gov.fatec.burguersystem.burguersystem.model.dto.PedidoComStatusDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoComStatusConverter {


    public List<PedidoComStatusDTO> toListEntityToDto(List<PedidoComStatus> lista) {
        List<PedidoComStatusDTO> listDto = new ArrayList<>();
        for (PedidoComStatus pedidoComStatus : lista) {
            PedidoComStatusDTO dto = toEntityToDto(pedidoComStatus);
            listDto.add(dto);
        }

        return listDto;
    }

    private PedidoComStatusDTO toEntityToDto(PedidoComStatus pedidoComStatus) {
        
        PedidoComStatusDTO dto = new PedidoComStatusDTO();
        dto.setId(pedidoComStatus.getId());
        dto.setCodPedido(pedidoComStatus.getCodPedido());
        dto.setStatus(pedidoComStatus.getStatus());
        dto.setDhpedido(pedidoComStatus.getDhpedido());

        return dto;
    }

    public PedidoComStatus toDtoToEntity(PedidoComStatusDTO dto) {

        PedidoComStatus pedidoComStatus = new PedidoComStatus();
        pedidoComStatus.setCodPedido(dto.getCodPedido());
        pedidoComStatus.setStatus(dto.getStatus());
        pedidoComStatus.setDhpedido(dto.getDhpedido());

        return pedidoComStatus;
    }
}
