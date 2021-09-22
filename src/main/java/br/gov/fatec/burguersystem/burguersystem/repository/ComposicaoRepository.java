package br.gov.fatec.burguersystem.burguersystem.repository;

import br.gov.fatec.burguersystem.burguersystem.model.Composicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposicaoRepository extends JpaRepository<Composicao,Long> {

}
