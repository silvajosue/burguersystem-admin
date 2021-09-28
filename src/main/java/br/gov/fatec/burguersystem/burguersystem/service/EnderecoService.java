package br.gov.fatec.burguersystem.burguersystem.service;


import br.gov.fatec.burguersystem.burguersystem.converter.EnderecoConverter;
import br.gov.fatec.burguersystem.burguersystem.exceptions.NegocioException;
import br.gov.fatec.burguersystem.burguersystem.model.Endereco;
import br.gov.fatec.burguersystem.burguersystem.model.dto.EnderecoDTO;
import br.gov.fatec.burguersystem.burguersystem.repository.EnderecoRepository;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.IEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnderecoService implements IEnderecoService {

    @Autowired
    public
    EnderecoRepository repository;

    @Autowired
    public
    EnderecoConverter converter;

    // TODO Implementar metodo com as regras de negocio presentes nessa classe, a classe service encapsula todas as regras negociais.

    // Metodo responsavel por listar todas os endereços de clientes diponiveis na base
    @Override
    @Transactional
    public List<EnderecoDTO> listarTodos() {

        List<Endereco> lista = repository.findAll();
        if(lista.isEmpty()){
            throw new NegocioException("Nenhum dado encontrado");
        }
        return converter.toListEntityToDto(lista);
    }

    // Metodo responsavel por cadastrar um novo endereço na base de dados
    @Override
    @Transactional
    public void cadastrar(EnderecoDTO dto) {

        validarDadosObrigatorios(dto);

        Endereco endereco = converter.toDtoToEntity(dto);

        repository.save(endereco);

    }

    // Metodo responsavel por validar os dados de entrada de endereço.
    private void validarDadosObrigatorios(EnderecoDTO dto) {
        //
    } 
}
