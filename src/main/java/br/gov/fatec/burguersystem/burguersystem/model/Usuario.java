package br.gov.fatec.burguersystem.burguersystem.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "USUARIO")
public class Usuario  implements UserDetails {
	
	private static final long serialVersionUID = 4929406702442903318L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_USUARIO")
	private Long codigoUsuario;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "FOTO")
	private String foto;
	
	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SENHA")
	private String senha;
	
	@Column(name = "ROLE")
	private String role;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TB_USUARIO_AUTORIZACAO", joinColumns = @JoinColumn(name = "CO_USUARIO"), inverseJoinColumns = @JoinColumn(name = "CO_AUTORIZACAO"))
	private Set<Role> roles = new HashSet<>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


}

