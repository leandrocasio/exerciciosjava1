package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //porta random para teste
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //ciclo de vida de classe por teste
public class UsuarioRepositoryTests {
		
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
	usuarioRepository.save(new Usuario(0L, "Ramon Daniel Santos", "ramonzito@clovis.com","123456789","https://i.imgur.com/FETvs2O.jpg"));
	
	usuarioRepository.save(new Usuario(0L, "Robson Carmo", "robson@carmo.com","123456780","https://i.imgur.com/FETvs2O.jpg"));
	
	usuarioRepository.save(new Usuario(0L, "Joao da Silva", "joaozinho@silva.com","987654321","https://i.imgur.com/FETvs2O.jpg"));
	
	}
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		/**
		 *  Executa o método findByUsuario para buscar um usuario pelo nome (joao@email.com.br)
		 */
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joaozinho@silva.com");

		/**
		 *  Verifica se a afirmação: "É verdade que a busca retornou o usuario joao@email.com.br" é verdadeira
		 *  Se for verdaeira, o teste passa, senão o teste falha. 
		 */
		assertTrue(usuario.get().getUsuario().equals("joaozinho@silva.com"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		/**
		 *  Executa o método findAllByNomeContainingIgnoreCase para buscar todos os usuarios cujo nome contenha
		 *  a palavra "Silva"
		 */
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");

		/**
		 * Verifica se a afirmação: "É verdade que a busca retornou 3 usuarios, cujo nome possua a palavra Silva" 
		 * é verdadeira
		 * Se for verdadeira, o teste passa, senão o teste falha.
		 */
		assertEquals(3, listaDeUsuarios.size());

		/**
		 *  Verifica se a afirmação: "É verdade que a busca retornou na primeira posição da Lista o usuario 
		 * João da Silva" é verdadeira
		 * Se for verdadeira, o teste passa, senão o teste falha.
		 */
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Ramon Daniel Santos"));

		/**
		 *  Verifica se a afirmação: "É verdade que a busca retornou na segunda posição da Lista a usuaria 
		 * Manuela da Silva" é verdadeira
		 * Se for verdadeira, o teste passa, senão o teste falha.
		 */
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Robson Carmo"));

		/**
		 *  Verifica se a afirmação: "É verdade que a busca retornou na primeira posição da Lista a usuaria 
		 * Adriana da Silva" é verdadeira
		 * Se for verdadeira, o teste passa, senão o teste falha.
		 */
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Joao da Silva"));
		
	}

	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
	
}
