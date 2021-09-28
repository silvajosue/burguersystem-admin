package br.gov.fatec.burguersystem.burguersystem.model.dto;

import org.springframework.transaction.annotation.Transactional;

import br.gov.fatec.burguersystem.burguersystem.model.Cliente;
import br.gov.fatec.burguersystem.burguersystem.service.ClienteService;
import lombok.Data;

@Data
public class ClienteDTO {

    // TODO Copia exata da classe Cliente

    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    @Transactional
    public void atualizar(ClienteService clienteService) {
    
        Cliente cliente = clienteService.converter.toDtoToEntity(this);
    
        clienteService.repository.save(cliente);
    }
	
}
