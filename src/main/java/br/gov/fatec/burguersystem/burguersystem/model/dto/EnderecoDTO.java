package br.gov.fatec.burguersystem.burguersystem.model.dto;

import lombok.Data;

@Data
public class EnderecoDTO {

    // TODO Copia exata da classe Endereco

    private Long id;
    private ClienteDTO cliente;
    private String logradouro;
    private Long numero;
    private String bairro;
    private String cidade;
    private String complemento;

}
