package br.com.grapesoft.sgc.security.persistence.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.grapesoft.sgc.core.base.AppEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles", schema = "security")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Role extends AppEntity<String> implements GrantedAuthority {
	private static final long serialVersionUID = 1079060002102212412L;

	@Id
	@Column(name = "cod_role")
	@EqualsAndHashCode.Include
	private String id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "roles_operacoes", schema = "security", joinColumns = @JoinColumn(name = "cod_role"), inverseJoinColumns = @JoinColumn(name = "cod_operacao"))
	private List<OperacaoSistema> allowedOperations;

	@JsonIgnore
	@Override
	public String getAuthority() {
		return this.id;
	}
}
