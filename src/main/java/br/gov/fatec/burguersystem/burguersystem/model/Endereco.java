package br.gov.fatec.burguersystem.burguersystem.model;

import lombok.Data;

import javax.persistence.*;

/**
 * <Author> Émerson Junior</Author>
 * Definição dos atributos referentes aos endereços dos clientes
 *
 */

@Data
@Entity(name = "ENDERECO")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_ENDERECO")
	private Long id;

	@Column(name = "COD_CLIENTE")
	private Long codCliente;
	
	@Column(name = "LOGRADOURO")
	private String logradouro;
	
	@Column(name = "NUMERO")
	private Long numero;

	@Column(name = "BAIRRO")
	private String bairro;
	
	@Column(name = "CIDADE")
	private String cidade;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;

}

