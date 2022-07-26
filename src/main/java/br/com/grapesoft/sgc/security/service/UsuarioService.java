package br.com.grapesoft.sgc.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.grapesoft.sgc.core.base.AppCrudService;
import br.com.grapesoft.sgc.core.type.SimNaoEnum;
import br.com.grapesoft.sgc.security.persistence.entity.Usuario;
import br.com.grapesoft.sgc.security.persistence.repository.UsuarioRepository;
import br.com.grapesoft.sgc.util.ObjUtil;

@Service
public class UsuarioService extends AppCrudService<UsuarioRepository, Usuario, Long> {

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	protected Usuario toCreateValue(Usuario usuario) {
		usuario.setContaAtiva(SimNaoEnum.SIM);
		usuario.setContaBloqueada(SimNaoEnum.NAO);
		String defaultPassword =  ObjUtil.isEmpty(usuario.getPassword()) ? "123456": usuario.getPassword();
		usuario.setPassword(bcryptEncoder.encode(defaultPassword));
		return usuario;
	}

	@Override
	protected Usuario toUpdateValue(Usuario entity, Usuario entityDB) {
		entityDB.setContaBloqueada(entity.getContaBloqueada());
		entityDB.setContaAtiva(entity.getContaAtiva());
		entityDB.setDataExpiracaoCredencial(entity.getDataExpiracaoCredencial());
		entityDB.setDataExpiracaoConta(entity.getDataExpiracaoConta());
		entityDB.setPessoaId(entity.getPessoaId());
		entityDB.setRoles(entity.getRoles());
		return entityDB;
	}

}
