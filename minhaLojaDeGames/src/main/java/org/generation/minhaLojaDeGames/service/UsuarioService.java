package org.generation.minhaLojaDeGames.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.minhaLojaDeGames.model.UsuarioLogin;
import org.generation.minhaLojaDeGames.model.UsuarioModel;
import org.generation.minhaLojaDeGames.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	//Cadastro do usuario
	public Optional<UsuarioModel> registerUsario(UsuarioModel usuario){

		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			return Optional.empty(); // --> Verifica se no repositorio contém o email digitado, caso existe
		 // ele retorna vazio.
		

		usuario.setSenha(encryptSenha(usuario.getSenha())); // Se não existe ele faz a encriptografia da senha

		return Optional.of(usuarioRepository.save(usuario)); // e por fim salva no repositorio de usuario.

	}

	//Atualização do usuario
	public Optional<UsuarioModel> updateUsuario(UsuarioModel usuario) {


		if(usuarioRepository.findById(usuario.getId()).isPresent()) { // --> Se o usuario existe no banco de dados, ele entra no if.

			Optional<UsuarioModel> buscaUsuario = usuarioRepository.findByEmail(usuario.getEmail()); // --> Busca o usuario pelo email.

			if ( (buscaUsuario.isPresent()) && ( buscaUsuario.get().getId() != usuario.getId())) // --> Se o email existir e o Id existir, ele entra no if.
				throw new ResponseStatusException(
						HttpStatus.BAD_REQUEST, "Usuário já existe!", null); // --> Diz que o usuario existe.

			usuario.setSenha(encryptSenha(usuario.getSenha())); // --> Pega a senha

			return Optional.ofNullable(usuarioRepository.save(usuario)); // Atualiza a senha do usuario pela nova digitada.

		}

			return Optional.empty(); // --> Caso algum dos ifs seja falso, ele retorna vazio.

	}

	//Função que faz a autentificação do usuario.
	public Optional<UsuarioLogin> authenticateUsuario(Optional<UsuarioLogin> usuarioLogin){

		Optional<UsuarioModel> usuario = usuarioRepository.findByEmail(usuarioLogin.get().getEmail()); // --> Ele pega o usuario do banco de dados

		if(usuario.isPresent()) { // --> Se o usuario estiver presente (no caso, existir), ele entra no if, caso contrario, retorna vazio.

			if(compareSenha(usuarioLogin.get().getSenha(), usuario.get().getSenha())) { // --> Aqui ele compara a senha digitada com a senha no banco de dados
																						   // --> Se forem iguais, ele permite o acesso, caso contrario, retorna vazio.
				usuarioLogin.get().setId(usuario.get().getId()); // Pega o Id do usuario
				usuarioLogin.get().setNome(usuario.get().getNome()); // Pega o nome do usuario
				usuarioLogin.get().setFoto(usuario.get().getFoto()); // Pega a foto do usuario
				usuarioLogin.get().setToken(generateBasicToken(usuario.get().getEmail(),usuarioLogin.get().getSenha())); // Gera o token de acesso do usuario.
				usuarioLogin.get().setSenha(usuario.get().getSenha()); //Pega a senha do usuario (Criptografada)

				return usuarioLogin;
			}
		}

		return Optional.empty(); //Caso seja falso em algum dos ifs, ele retorna vazio.
	}

	//Função em que está criptografando a senha do usuario.
	private String encryptSenha(String senha) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // cria uma criptografia de senha.

		return encoder.encode(senha); // --> Criptografa a senha.
	}

	//Função responsável por comparar a senha digitada pelo usuario e a senha que contém no banco de dados.
	private boolean compareSenha(String typedSenha, String dbSenha) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder.matches(typedSenha, dbSenha); // --> Faz a comparação das senhas.

	}

	//Função responsável por gerar o token para o usuario ter acesso a aplicação.
	private String generateBasicToken(String usuario, String senha) {

		String token = usuario + ":" + senha;
		byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII"))); // --> Um array de byte que pega nosso email + senha e faz um token com base no 
																							   //"Código Padrão Americano para o Intercâmbio de Informação"
		
		return "Basic " + new String(tokenBase64); // retorna nosso token, transformando nosso array de byte em uma nova String.

	}
}
