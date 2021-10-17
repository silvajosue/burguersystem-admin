package br.gov.fatec.burguersystem.burguersystem.converter;

import br.gov.fatec.burguersystem.burguersystem.model.Endereco;
import br.gov.fatec.burguersystem.burguersystem.model.dto.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnderecoConverter {

    @Autowired
    public ClienteConverter clienteConverter;

    public List<EnderecoDTO> toListEntityToDto(List<Endereco> lista) {
        List<EnderecoDTO> listDto = new ArrayList<>();
        for (Endereco endereco : lista) {
            EnderecoDTO dto = toEntityToDto(endereco);
            listDto.add(dto);
        }

        return listDto;
    }

    private EnderecoDTO toEntityToDto(Endereco endereco) {
        EnderecoDTO dto = new EnderecoDTO();
        dto.setId(endereco.getId());
        dto.setCliente(clienteConverter.toEntityToDto(endereco.getCliente()));
        dto.setLogradouro(endereco.getLogradouro());
        dto.setNumero(endereco.getNumero());
        dto.setBairro(endereco.getBairro());
        dto.setCidade(endereco.getCidade());
        dto.setComplemento(endereco.getComplemento());
        return dto;
    }

    public Endereco toDtoToEntity(EnderecoDTO dto) {

        Endereco endereco = new Endereco();
//        endereco.setCodCliente(dto.getCodCliente());
        endereco.setCliente(clienteConverter.toDtoToEntity(dto.getCliente()));
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setNumero(dto.getNumero());
        endereco.setBairro(dto.getBairro());
        endereco.setCidade(dto.getCidade());
        endereco.setComplemento(dto.getComplemento());

        return endereco;
    }
}
