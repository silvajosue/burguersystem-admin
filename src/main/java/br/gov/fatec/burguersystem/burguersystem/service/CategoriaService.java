package br.gov.fatec.burguersystem.burguersystem.service;

import br.gov.fatec.burguersystem.burguersystem.converter.CategoriaConverter;
import br.gov.fatec.burguersystem.burguersystem.exceptions.NegocioException;
import br.gov.fatec.burguersystem.burguersystem.model.Categoria;
import br.gov.fatec.burguersystem.burguersystem.model.dto.CategoriaDTO;
import br.gov.fatec.burguersystem.burguersystem.repository.CategoriaRepository;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.ICategoriaService;
import br.gov.fatec.burguersystem.burguersystem.utils.MensagensUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    CategoriaRepository repository;

    @Autowired
    CategoriaConverter converter;

    // TODO Implementar metodo com as regras de negocio presentes nessa classe, a classe service encapsula todas as regras negociais.

    // Metodo responsavel por listar todas as categorias diponiveis na base
    @Override
    @Transactional
    public List<CategoriaDTO> listarTodos() {

        List<Categoria> lista = repository.findAll();
        if(lista.isEmpty()){
            throw new NegocioException("Nenhum dado encontrado");
        }
        return converter.toListEntityToDto(lista);
    }

    // Metodo responsavel por cadastrar uma nova categoria na base de dados
    @Override
    @Transactional
    public void cadastrar(CategoriaDTO dto) {

        validarDadosObrigatorios(dto);

        Categoria categoria = converter.toDtoToEntity(dto);

        repository.save(categoria);

    }

    // Metodo responsavel por validar os dados de entrada das categorias.
    private void validarDadosObrigatorios(CategoriaDTO dto) {
        if(!StringUtils.isBlank(dto.getNome())){
            List<Categoria> lista = repository.findAll();
            for (Categoria categoria : lista ) {
                if(categoria.getNome().toUpperCase().equals(dto.getNome().toUpperCase()))
                    throw new NegocioException("Categoria ja existente na base de dados");
            }
        }
    } 
}
