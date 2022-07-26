package br.com.grapesoft.sgc.security.service;

import org.springframework.stereotype.Service;

import br.com.grapesoft.sgc.core.base.AppCrudService;
import br.com.grapesoft.sgc.security.persistence.entity.Role;
import br.com.grapesoft.sgc.security.persistence.repository.RoleRepository;

@Service
public class RoleService extends AppCrudService<RoleRepository, Role, String> {

	@Override
	protected Role toUpdateValue(Role entity, Role entityDB) {
		return entityDB;
	}

}
