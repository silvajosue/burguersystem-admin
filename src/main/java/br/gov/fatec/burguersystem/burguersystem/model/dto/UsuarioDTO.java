package br.gov.fatec.burguersystem.burguersystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	
	private Long codigoUsuario;
	private String nome;
	private String foto;
	private String cpf;
	private String telefone;
	private String email;
	private String senha;
	private String role;
	private TokenDTO tokenDTO;
	private Long tempoSessao;

}
