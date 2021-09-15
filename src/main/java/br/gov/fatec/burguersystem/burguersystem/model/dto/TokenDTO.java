package br.gov.fatec.burguersystem.burguersystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {

	private String token;
	private String tipo;
	
}
