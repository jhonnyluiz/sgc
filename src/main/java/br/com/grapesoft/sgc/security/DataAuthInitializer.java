package br.com.grapesoft.sgc.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.grapesoft.sgc.core.constant.RoleConstant;
import br.com.grapesoft.sgc.security.persistence.entity.Usuario;
import br.com.grapesoft.sgc.security.service.RoleService;
import br.com.grapesoft.sgc.security.service.UsuarioService;

@Component
public class DataAuthInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RoleService roleService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initRoles();
		initUserAdmin();
	}

	private void initRoles() {
		roleService.saveAll(RoleConstant.getRoles());
	}

	private void initUserAdmin() {
		List<Usuario> usuarios = usuarioService.findAll();
		if (usuarios.isEmpty()) {
			usuarioService.create(UsuarioDefaultFactory.getAdmin());
		}
	}

}
