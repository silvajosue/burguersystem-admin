package br.gov.fatec.burguersystem.burguersystem.model;

import lombok.Data;

import javax.persistence.*;

/**
 * <Author> Émerson Junior</Author>
 * Definição dos atributos referentes aos clientes
 *
 */

@Data
@Entity
@Table(name = "CLIENTE")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cliente")
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "CPF")
	private String cpf;

}

