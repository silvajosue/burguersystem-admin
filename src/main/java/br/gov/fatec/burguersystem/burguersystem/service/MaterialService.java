package br.gov.fatec.burguersystem.burguersystem.service;

import br.gov.fatec.burguersystem.burguersystem.converter.MaterialConverter;
import br.gov.fatec.burguersystem.burguersystem.exceptions.NegocioException;
import br.gov.fatec.burguersystem.burguersystem.model.Material;
import br.gov.fatec.burguersystem.burguersystem.model.dto.MaterialDTO;
import br.gov.fatec.burguersystem.burguersystem.repository.MaterialRepository;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.IMaterialService;
import br.gov.fatec.burguersystem.burguersystem.utils.MensagensUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialService implements IMaterialService {

    @Autowired
    MaterialRepository repository;

    @Autowired
    MaterialConverter converter;

    // TODO Implementar metodo com as regras de negocio presentes nessa classe, a classe service encapsula todas as regras negociais.

    // Metodo responsavel por listar todos os materiais diponiveis na base
    @Override
    @Transactional
    public List<MaterialDTO> listarTodos() {

        List<Material> lista = repository.findAll();
        if(lista.isEmpty()){
            throw new NegocioException("Nenhum dado encontrado");
        }
        return converter.toListEntityToDto(lista);
    }

    // Metodo responsavel por cadastrar um novo material na base de dados
    @Override
    @Transactional
    public void cadastrar(MaterialDTO dto) {

        validarDadosObrigatorios(dto);

        Material material = converter.toDtoToEntity(dto);

        repository.save(material);

    }

    // Metodo responsavel por validar os dados e realizar a atualização dos dados na base
    @Override
    @Transactional
    public void atualizar(MaterialDTO dto) {

        Material material = converter.toDtoToEntity(dto);

        repository.save(material);
    }

    // Metodo responsavel por validar os dados de entrada dos materiais.
    private void validarDadosObrigatorios(MaterialDTO dto) {
        if(!StringUtils.isBlank(dto.getNome())){
            List<Material> lista = repository.findAll();
            for (Material material : lista ) {
                if(material.getNome().toUpperCase().equals(dto.getNome().toUpperCase()))
                    throw new NegocioException(MensagensUtils.DADO_EXISTENTE);
            }
        }

        if (dto.getPreco() < 0.0){
            throw new NegocioException(MensagensUtils.VALOR_MENOR_ZERO);
        }

        if(dto.getQuantidade() < 0.0){
            throw new NegocioException(MensagensUtils.QTD_MENOR_ZERO);
        }
    }
}
