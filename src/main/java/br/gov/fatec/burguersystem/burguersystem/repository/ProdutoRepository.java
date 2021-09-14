package br.gov.fatec.burguersystem.burguersystem.repository;

import br.gov.fatec.burguersystem.burguersystem.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
