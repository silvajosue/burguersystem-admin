package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.Cliente;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ClienteDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteConverter {

    public List<ClienteDTO> toListEntityToDto(List<Cliente> lista) {
        List<ClienteDTO> listDto = new ArrayList<>();
        for (Cliente cliente : lista) {
            ClienteDTO dto = toEntityToDto(cliente);
            listDto.add(dto);
        }

        return listDto;
    }

    private ClienteDTO toEntityToDto(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setTelefone(cliente.getTelefone());
        dto.setCpf(cliente.getCpf());
        return dto;
    }

    public Cliente toDtoToEntity(ClienteDTO dto) {

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());
        cliente.setCpf(dto.getCpf());

        return cliente;
    }
}
