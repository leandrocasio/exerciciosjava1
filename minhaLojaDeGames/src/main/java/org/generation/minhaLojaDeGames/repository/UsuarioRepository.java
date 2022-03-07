package org.generation.minhaLojaDeGames.repository;

import java.util.List;
import java.util.Optional;

import org.generation.minhaLojaDeGames.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	
	public Optional<UsuarioModel> findByEmail(String email);
	
	public List<UsuarioModel> findByNomeContainingIgnoreCase(String nome);
}
