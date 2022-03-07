package org.generation.minhaLojaDeGames.security;

import java.util.Collection;
import java.util.List;

import org.generation.minhaLojaDeGames.model.UsuarioModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {
		
		private static final long serialVersionUID = 1L; // --> Identificador de versão.
		
		private String usuarioNome;
		private String senha;
		private List<GrantedAuthority> authorities; // --> Instanciamento da lista que vai ler as autorizações
		
		//Construtor do UserDetailsImpl
		public UserDetailsImpl(UsuarioModel usuario) {
			
			this.usuarioNome = usuario.getNome();
			this.senha = usuario.getSenha();
			
		}
		
		//Contrutor vazio do UserDetailsImpl
		public UserDetailsImpl() {
			
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return false;
		}
	
	}	
