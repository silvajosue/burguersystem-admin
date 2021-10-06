package br.gov.fatec.burguersystem.burguersystem.service;

import br.gov.fatec.burguersystem.burguersystem.converter.PedidoComStatusConverter;
import br.gov.fatec.burguersystem.burguersystem.exceptions.NegocioException;
import br.gov.fatec.burguersystem.burguersystem.model.PedidoComStatus;
import br.gov.fatec.burguersystem.burguersystem.model.dto.PedidoComStatusDTO;
import br.gov.fatec.burguersystem.burguersystem.repository.PedidoComStatusRepository;
import br.gov.fatec.burguersystem.burguersystem.service.interfaces.IPedidoComStatusService;
import br.gov.fatec.burguersystem.burguersystem.utils.MensagensUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import antlr.StringUtils;

import java.util.List;

@Service
public class PedidoComStatusService implements IPedidoComStatusService {

    @Autowired
    PedidoComStatusRepository repository;

    @Autowired
    PedidoComStatusConverter converter;

    // TODO Implementar metodo com as regras de negocio presentes nessa classe, a classe service encapsula todas as regras negociais.

    // Metodo responsavel por listar todos os status de pedidos diponiveis na base
    @Override
    @Transactional
    public List<PedidoComStatusDTO> listarTodos() {

        List<PedidoComStatus> lista = repository.findAll();
        if(lista.isEmpty()){
            throw new NegocioException("Nenhum dado encontrado");
        }
        return converter.toListEntityToDto(lista);
    }

    // Metodo responsavel por cadastrar um novo status de pedido na base de dados
    @Override
    @Transactional
    public void cadastrar(PedidoComStatusDTO dto) {

        validarDadosObrigatorios(dto);

        PedidoComStatus pedidoComStatus = converter.toDtoToEntity(dto);

        repository.save(pedidoComStatus);

    }  
      // Metodo responsavel por validar os dados e realizar a atualização dos dados na base
    @Override
    @Transactional
    public void atualizar(PedidoComStatusDTO dto) {

        PedidoComStatus pedidoComStatus = converter.toDtoToEntity(dto);

        repository.save(pedidoComStatus);
    }

    private void validarDadosObrigatorios(PedidoComStatusDTO dto) {
        //Verifica se o status está sendo criado em um pedido que ja tenha um status
        if(!StringUtils.isBlank(dto.getCodPedido())){
            List<PedidoComStatus> lista = repository.findAll();
            for (PedidoComStatus pedidoComStatus : lista ) {
                if(pedidoComStatus.getCodPedido.equals(dto.getCodPedido()))
                    throw new NegocioException(MensagensUtils.DADO_EXISTENTE);
            }
        }
    }

}
