package org.generation.minhaLojaDeGames.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.minhaLojaDeGames.model.UsuarioLogin;
import org.generation.minhaLojaDeGames.model.UsuarioModel;
import org.generation.minhaLojaDeGames.repository.UsuarioRepository;
import org.generation.minhaLojaDeGames.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService; // --> Pegando UserService.

	@Autowired
	private UsuarioRepository usuarioRepository; // --> Pegando o repositorio do usuario

		//Buscar todos usuarios.
	@GetMapping("/all")
	public ResponseEntity <List<UsuarioModel>> getAll(){
			
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

		//Busca usuario por ID.
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> getById(@PathVariable Long id){
			
		return usuarioRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
			
	}
		
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<UsuarioModel>> getByName(@PathVariable String nome){
			
		return ResponseEntity.ok(usuarioRepository.findByNomeContainingIgnoreCase(nome));
			
	}

		//Função de login.
	@PostMapping("/login")
	public ResponseEntity<UsuarioLogin> login(@RequestBody Optional<UsuarioLogin> usuarioLogin){

		return usuarioService.authenticateUsuario(usuarioLogin) // --> chama afunção de autentificação, para verificar se o usuario é valido.
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp)) // --> se for valido, ele da um status 200
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()); // --> se nao for valido, ele da um 401(sem autorização)
			
	}

		//Função para cadastrar um novo usuario.
	@PostMapping("/registro")
	public ResponseEntity<UsuarioModel> postUsuario(@Valid @RequestBody UsuarioModel usuario){

		return usuarioService.registerUsario(usuario) //Chama a função de cadastrar usuario.
			.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp)) // --> Se tudo ocorrer certo com todos os campos obrigatorios digitados, ele da um CREATED.
			.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build()); // --> Se algo estiver errado, ele da um Bad Request (400)
			
	}

		//Função de atualização do usuario
	@PutMapping("/atualizar")
    public ResponseEntity<UsuarioModel> putUsuario(@Valid @RequestBody UsuarioModel usuario){

		return usuarioService.updateUsuario(usuario) // --> Chamando a função de atualização do usuario
			.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta)) // --> Caso o usuario esteja no banco, e a alteração seja aceita, ele da um status 200.
			.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // --> Caso o usuario não esteja no banco de dados, ele da um Not Found (404)
			
		}
}