package br.gov.fatec.burguersystem.burguersystem.service;

import br.gov.fatec.burguersystem.burguersystem.converter.PedidoConverter;
import br.gov.fatec.burguersystem.burguersystem.exceptions.NegocioException;
import br.gov.fatec.burguersystem.burguersystem.model.Pedido;
import br.gov.fatec.burguersystem.burguersystem.model.dto.PedidoDTO;
import br.gov.fatec.burguersystem.burguersystem.repository.PedidoRepository;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    PedidoRepository repository;

    @Autowired
    PedidoConverter converter;

    // TODO Implementar metodo com as regras de negocio presentes nessa classe, a classe service encapsula todas as regras negociais.

    // Metodo responsavel por listar todos os pedidos diponiveis na base
    @Override
    @Transactional
    public List<PedidoDTO> listarTodos() {

        List<Pedido> lista = repository.findAll();
        if(lista.isEmpty()){
            throw new NegocioException("Nenhum dado encontrado");
        }
        return converter.toListEntityToDto(lista);
    }

    // Metodo responsavel por cadastrar um novo pedido na base de dados
    @Override
    @Transactional
    public void cadastrar(PedidoDTO dto) {

        validarDadosObrigatorios(dto);

        Pedido pedido = converter.toDtoToEntity(dto);

        repository.save(pedido);

    }

    private void validarDadosObrigatorios(PedidoDTO dto) {
        //TODO validação para não cadastrar o mesmo pedido 2 vezes
    }
}
