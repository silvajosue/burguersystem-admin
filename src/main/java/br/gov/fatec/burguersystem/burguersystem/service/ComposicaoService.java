package br.gov.fatec.burguersystem.burguersystem.service;

import br.gov.fatec.burguersystem.burguersystem.converter.ComposicaoConverter;
import br.gov.fatec.burguersystem.burguersystem.exceptions.NegocioException;
import br.gov.fatec.burguersystem.burguersystem.model.Composicao;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ComposicaoDTO;
import br.gov.fatec.burguersystem.burguersystem.repository.ComposicaoRepository;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.IComposicaoService;
import br.gov.fatec.burguersystem.burguersystem.utils.MensagensUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComposicaoService implements IComposicaoService {

    @Autowired
    ComposicaoRepository repository;

    @Autowired
    ComposicaoConverter converter;

    // TODO Implementar metodo com as regras de negocio presentes nessa classe, a classe service encapsula todas as regras negociais.

    // Metodo responsavel por listar todos os materiais diponiveis na base
    @Override
    @Transactional
    public List<ComposicaoDTO> listarTodos() {

        List<Composicao> lista = repository.findAll();
        if(lista.isEmpty()){
            throw new NegocioException("Nenhum dado encontrado");
        }
        return converter.toListEntityToDto(lista);
    }

    // Metodo responsavel por cadastrar uma nova composicao na base de dados
    @Override
    @Transactional
    public void cadastrar(ComposicaoDTO dto) {

        validarDadosObrigatorios(dto);

        Composicao composicao = converter.toDtoToEntity(dto);

        repository.save(composicao);

    }

    // Metodo responsavel por validar os dados e realizar a atualização dos dados na base
    @Override
    @Transactional
    public void atualizar(ComposicaoDTO dto) {

        Composicao composicao = converter.toDtoToEntity(dto);

        repository.save(composicao);
    }

    // Metodo responsavel por validar os dados de entrada dos materiais.
    private void validarDadosObrigatorios(ComposicaoDTO dto) {
        if(dto.getQuantidade() < 0.0){
            throw new NegocioException(MensagensUtils.QTD_MENOR_ZERO);
        }
    } 
}
