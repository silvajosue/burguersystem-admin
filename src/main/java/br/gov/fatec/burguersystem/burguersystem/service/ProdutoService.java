package br.gov.fatec.burguersystem.burguersystem.service;

import br.gov.fatec.burguersystem.burguersystem.converter.ProdutoConverter;
import br.gov.fatec.burguersystem.burguersystem.exceptions.NegocioException;
import br.gov.fatec.burguersystem.burguersystem.model.Produto;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ProdutoDTO;
import br.gov.fatec.burguersystem.burguersystem.repository.ProdutoRepository;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    ProdutoRepository repository;

    @Autowired
    ProdutoConverter converter;

    // TODO Implementar metodo com as regras de negocio presentes nessa classe, a classe service encapsula todas as regras negociais.

    // Metodo responsavel por listar todos os produtos diponiveis na base
    @Override
    @Transactional
    public List<ProdutoDTO> listarTodos() {

        List<Produto> lista = repository.findAll();
        if(lista.isEmpty()){
            throw new NegocioException("Nenhum dado encontrado");
        }
        return converter.toListEntityToDto(lista);
    }

    // Metodo responsavel por cadastrar um novo produto na base de dados
    @Override
    @Transactional
    public void cadastrar(ProdutoDTO dto) {

        validarDadosObrigatorios(dto);

        Produto produto = converter.toDtoToEntity(dto);

        repository.save(produto);

    }
    
    // Metodo responsavel por validar os dados e realizar a atualização dos dados na base
    @Override
    @Transactional
    public void atualizar(ProdutoDTO dto) {
        Produto produto = converter.toDtoToEntity(dto);
        repository.save(produto);
    }

    // Metodo responsavel por validar os dados de entrada de produtos.
    private void validarDadosObrigatorios(ProdutoDTO dto) {
        if(!StringUtils.isBlank(dto.getNome())){
            List<Produto> lista = repository.findAll();
            for (Produto produto : lista ) {
                if(produto.getNome().toUpperCase().equals(dto.getNome().toUpperCase()))
                    throw new NegocioException("Produto ja existente na base de dados");
            }
        }
    }
}
