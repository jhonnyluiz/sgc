package br.com.grapesoft.sgc.security.persistence.entity;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.grapesoft.sgc.core.type.SimNaoEnum;

public final class UsuarioDetails extends Usuario implements UserDetails {
	private static final long serialVersionUID = -7917475335769203063L;

	public UsuarioDetails(Usuario usuario) {
		super(usuario);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles();
	}

	@Override
	public boolean isAccountNonExpired() {
		if (getDataExpiracaoConta() != null) {
			return LocalDate.now().isBefore(getDataExpiracaoConta());
		}
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return getContaBloqueada().equals(SimNaoEnum.NAO);
	}

	@Override
	public boolean isCredentialsNonExpired() {
		if (getDataExpiracaoCredencial() != null) {
			return LocalDate.now().isBefore(getDataExpiracaoCredencial());
		}
		return true;
	}

	@Override
	public boolean isEnabled() {
		return getContaAtiva().equals(SimNaoEnum.SIM);
	}

}
