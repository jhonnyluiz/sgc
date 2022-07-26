package br.com.grapesoft.sgc.security;

import br.com.grapesoft.sgc.core.constant.RoleConstant;
import br.com.grapesoft.sgc.core.type.SimNaoEnum;
import br.com.grapesoft.sgc.security.persistence.entity.Usuario;

public class UsuarioDefaultFactory {

	private UsuarioDefaultFactory() {
	}

	public static Usuario getAdmin() {
		return Usuario.builder().username("admin").password("123456").pessoaId(1L).contaAtiva(SimNaoEnum.SIM)
				.contaBloqueada(SimNaoEnum.NAO).roles(RoleConstant.getRoles()).build();
	}
}
