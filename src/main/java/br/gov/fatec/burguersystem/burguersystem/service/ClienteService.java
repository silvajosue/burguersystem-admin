package br.gov.fatec.burguersystem.burguersystem.service;


import br.gov.fatec.burguersystem.burguersystem.converter.ClienteConverter;
import br.gov.fatec.burguersystem.burguersystem.exceptions.NegocioException;
import br.gov.fatec.burguersystem.burguersystem.model.Cliente;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ClienteDTO;
import br.gov.fatec.burguersystem.burguersystem.repository.ClienteRepository;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.IClienteService;
import br.gov.fatec.burguersystem.burguersystem.utils.MensagensUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    public
    ClienteRepository repository;

    @Autowired
    public
    ClienteConverter converter;

    // TODO Implementar metodo com as regras de negocio presentes nessa classe, a classe service encapsula todas as regras negociais.

    // Metodo responsavel por listar todas os clientes diponiveis na base
    @Override
    @Transactional
    public List<ClienteDTO> listarTodos() {

        List<Cliente> lista = repository.findAll();
        if(lista.isEmpty()){
            throw new NegocioException("Nenhum dado encontrado");
        }
        return converter.toListEntityToDto(lista);
    }

    // Metodo responsavel por cadastrar um novo cliente na base de dados
    @Override
    @Transactional
    public void cadastrar(ClienteDTO dto) {

        validarDadosObrigatorios(dto);

        Cliente cliente = converter.toDtoToEntity(dto);

        repository.save(cliente);

    }

    // Metodo responsavel por validar os dados e realizar a atualização dos dados na base
    @Override
    @Transactional
    public void atualizar(ClienteDTO dto) {
        Cliente cliente = converter.toDtoToEntity(dto);
        repository.save(cliente);
    }

    // Metodo responsavel por validar os dados de entrada de cliente.
    private void validarDadosObrigatorios(ClienteDTO dto) {
        if(StringUtils.isBlank(dto.getCpf())){
            List<Cliente> lista = repository.findAll();
            for(Cliente cliente : lista ) {
                if(cliente.getCpf().equals(dto.getCpf()))
                    throw new NegocioException("Cliente ja existente na base de dados");
            }
        }
    } 
}
