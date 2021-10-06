package br.gov.fatec.burguersystem.burguersystem.repository;

import br.gov.fatec.burguersystem.burguersystem.model.PedidoComStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoComStatusRepository extends JpaRepository<PedidoComStatus,Long> {

}
