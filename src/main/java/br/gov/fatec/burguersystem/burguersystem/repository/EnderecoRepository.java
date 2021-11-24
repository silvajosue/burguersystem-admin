package br.gov.fatec.burguersystem.burguersystem.repository;

import br.gov.fatec.burguersystem.burguersystem.model.Cliente;
import br.gov.fatec.burguersystem.burguersystem.model.Endereco;

import com.google.common.base.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
    
	Endereco[] findByCliente(Cliente cliente);
}
