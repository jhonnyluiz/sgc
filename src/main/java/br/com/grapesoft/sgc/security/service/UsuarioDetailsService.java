package br.com.grapesoft.sgc.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.grapesoft.sgc.security.persistence.entity.Usuario;
import br.com.grapesoft.sgc.security.persistence.entity.UsuarioDetails;
import br.com.grapesoft.sgc.security.persistence.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UsuarioDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> optUsuario = usuarioRepository.findByUsername(username);
		if (optUsuario.isPresent()) {
			return new UsuarioDetails(optUsuario.get());
		}
		throw new UsernameNotFoundException("Usuário ou senha incorretos.");
	}
}
