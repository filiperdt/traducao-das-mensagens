package br.com.traducaodasmensagens.spring.traducaoDasMensagens.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Usuario;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository.UsuarioRepository;

@Service
public class CrudUsuarioService {
	private UsuarioRepository usuarioRepository;

	public CrudUsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public void menu(Scanner scanner) {
		Boolean isTrue = true;
		
		while(isTrue) {
			System.out.println("\nQual ação quer executar?");
			System.out.println("0 - Voltar ao menu anterior");
			System.out.println("1 - Cadastrar Usuario");
			System.out.println("2 - Atualizar Usuario");
			System.out.println("3 - Visualizar todos os Usuarios");
			System.out.println("4 - Deletar Usuario");
			
			int opcao = scanner.nextInt();
			
			switch(opcao) {
				case 1:
					this.cadastrar(scanner);
					break;
				case 2:
					this.atualizar(scanner);
					break;
				case 3:
					this.visualizarTodos();
					break;
				case 4:
					this.deletar(scanner);
					break;
				default:
					isTrue = false;
					break;
			}
		}
		
		System.out.println();
	}
	
	private void cadastrar(Scanner scanner) {
		System.out.print("Insira o nome do usuário: ");
		String nome = scanner.next(); // le a próxima string até achar um enter ou um espaco
		
		System.out.print("Insira o login: ");
		String login = scanner.next();
		
		System.out.print("Insira a senha: ");
		String senha = scanner.next();
		
		Usuario usuario = new Usuario(nome, login, senha, true, true, null, null);
		
		this.usuarioRepository.save(usuario);
		
		System.out.println("Usuário salvo no banco!\n");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.print("Insira o id do Usuário a ser atualizado: ");
		Integer id = scanner.nextInt();
		
		Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(id);
		
		// se o hibernate conseguiu achar uma tupla/registro na tabela de mensagens com id igual ao passado pelo usuario
		if(usuarioOptional.isPresent()) {
			Usuario usuario= usuarioOptional.get();
			
			System.out.print("Insira o novo nome do usuário: ");
			String nome = scanner.next(); // le a próxima string até achar um enter ou um espaco
			
			usuario.setNome(nome);
			
			this.usuarioRepository.save(usuario); // atualiza (persiste) o objeto/registro/tupla no BD
			
			System.out.println("Usuário atualizado no banco!\n");
		} else{
			System.out.println("O id '" + id + "' é inválido.");
		}
	}
	
	private void visualizarTodos() {
		Iterable<Usuario> usuarios = this.usuarioRepository.findAll();
		
//		for(Usuario usuario : usuarios) {
//			System.out.println(usuario);
//		}
		
		usuarios.forEach(System.out::println);
		
		System.out.println();
	}
	
	private void deletar(Scanner scanner) {
		System.out.print("Insira o id do usuário a ser deletado: ");
		Integer id = scanner.nextInt();
		
		Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(id);
		
		if(usuarioOptional.isPresent()) {
			this.usuarioRepository.deleteById(id);
			
			System.out.println("Usuário deletado do banco!\n");
		} else {
			System.out.println("O id " + id + " não existe no banco!\n");
		}
	}
}