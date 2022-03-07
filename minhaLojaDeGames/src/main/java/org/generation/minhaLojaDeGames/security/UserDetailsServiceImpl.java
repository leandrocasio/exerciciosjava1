package org.generation.minhaLojaDeGames.security;

import java.util.Optional;

import org.generation.minhaLojaDeGames.model.UsuarioModel;
import org.generation.minhaLojaDeGames.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;
	
	
	//Função que busca o usuario no banco e retorna se ele existe ou não.
	@Override
	public UserDetails loadUserByUsername(String usuarionome) throws UsernameNotFoundException {
		
		Optional<UsuarioModel> usuario = repository.findByEmail(usuarionome);
			usuario.orElseThrow(() -> new UsernameNotFoundException(usuarionome + " not found."));
	
		return usuario.map(UserDetailsImpl::new).get();
	}
}
