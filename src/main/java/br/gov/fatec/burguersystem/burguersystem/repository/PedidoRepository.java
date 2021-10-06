package br.gov.fatec.burguersystem.burguersystem.repository;

import br.gov.fatec.burguersystem.burguersystem.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {

}
