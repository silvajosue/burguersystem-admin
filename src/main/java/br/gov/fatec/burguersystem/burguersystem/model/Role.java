package br.gov.fatec.burguersystem.burguersystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_AUTORIZACAO")
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = 1971031224571454884L;

	@Id
	@Column(name = "CO_AUTORIZACAO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NO_AUTORIZACAO")
	private String nome;

	@Override
	public String getAuthority() {
		return this.nome;
	}
}
