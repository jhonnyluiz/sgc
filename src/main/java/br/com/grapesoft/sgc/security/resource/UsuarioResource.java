package br.com.grapesoft.sgc.security.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grapesoft.sgc.core.base.AppCrudResource;
import br.com.grapesoft.sgc.core.constant.PathResource;
import br.com.grapesoft.sgc.security.persistence.entity.Usuario;
import br.com.grapesoft.sgc.security.persistence.repository.UsuarioRepository;
import br.com.grapesoft.sgc.security.resource.dto.UsuarioDTO;
import br.com.grapesoft.sgc.security.service.UsuarioService;

@RestController
@RequestMapping(PathResource.USUARIOS)
public class UsuarioResource extends AppCrudResource<UsuarioService, UsuarioRepository, UsuarioDTO, Usuario, Long> {

}
