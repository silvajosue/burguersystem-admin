package br.gov.fatec.burguersystem.burguersystem.service;

import br.gov.fatec.burguersystem.burguersystem.converter.ItensDoPedidoConverter;
import br.gov.fatec.burguersystem.burguersystem.exceptions.NegocioException;
import br.gov.fatec.burguersystem.burguersystem.model.ItensDoPedido;
import br.gov.fatec.burguersystem.burguersystem.model.dto.ItensDoPedidoDTO;
import br.gov.fatec.burguersystem.burguersystem.repository.ItensDoPedidoRepository;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.IItensDoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ItensDoPedidoService implements IItensDoPedidoService {

    @Autowired
    ItensDoPedidoRepository repository;

    @Autowired
    ItensDoPedidoConverter converter;

    // TODO Implementar metodo com as regras de negocio presentes nessa classe, a classe service encapsula todas as regras negociais.

    // Metodo responsavel por listar todos os itens de pedidos diponiveis na base
    @Override
    @Transactional
    public List<ItensDoPedidoDTO> listarTodos() {

        List<ItensDoPedido> lista = repository.findAll();
        if(lista.isEmpty()){
            throw new NegocioException("Nenhum dado encontrado");
        }
        return converter.toListEntityToDto(lista);
    }

    // Metodo responsavel por cadastrar um novo item de pedido na base de dados
    @Override
    @Transactional
    public void cadastrar(ItensDoPedidoDTO dto) {

        validarDadosObrigatorios(dto);

        ItensDoPedido itensDoPedido = converter.toDtoToEntity(dto);

        repository.save(itensDoPedido);

    }  
      // Metodo responsavel por validar os dados e realizar a atualização dos dados na base
    @Override
    @Transactional
    public void atualizar(ItensDoPedidoDTO dto) {

        ItensDoPedido itensDoPedido = converter.toDtoToEntity(dto);

        repository.save(itensDoPedido);
    }

    private void validarDadosObrigatorios(ItensDoPedidoDTO dto) {
        //TODO validar ItensDoPedido
    }

}
