package br.com.grapesoft.sgc.security.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "operacoes", schema = "security")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class OperacaoSistema extends AppEntity<String> implements GrantedAuthority {
	private static final long serialVersionUID = 2376242472099504627L;

	
	@Id
	@Column(name = "cod_operacao")
	@EqualsAndHashCode.Include
	private String id;
	
	@JsonIgnore
	@Override
	public String getAuthority() {
		return id;
	}
}
