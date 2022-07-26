package br.com.grapesoft.sgc.security.persistence.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.grapesoft.sgc.core.base.AppEntity;
import br.com.grapesoft.sgc.core.type.SimNaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios", schema = "security")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Usuario extends AppEntity<Long> {
	private static final long serialVersionUID = 2660342569725144897L;

	@Id
	@Column(name = "cod_usuario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(unique = true)
	private String username;

	@Column(name = "cod_pessoa")
	private Long pessoaId;

	@JsonIgnore
	private String password;

	private LocalDate dataExpiracaoConta;
	private LocalDate dataExpiracaoCredencial;

	private SimNaoEnum contaAtiva;
	private SimNaoEnum contaBloqueada;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roles_usuarios", schema = "security", joinColumns = @JoinColumn(name = "cod_usuario"), inverseJoinColumns = @JoinColumn(name = "cod_role"))
	private List<Role> roles;

	public Usuario(Usuario u) {
		this.id = u.getId();
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.dataExpiracaoConta = u.getDataExpiracaoConta();
		this.dataExpiracaoCredencial = u.getDataExpiracaoCredencial();
		this.contaAtiva = u.getContaAtiva();
		this.contaBloqueada = u.getContaBloqueada();
		this.roles = u.getRoles();
	}
}
