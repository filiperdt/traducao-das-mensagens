package br.com.traducaodasmensagens.spring.traducaoDasMensagens.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Mensagem;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository.MensagemRepository;

@Service
public class CrudMensagemService {
	private MensagemRepository mensagemRepository;  // dependência da classe CrudProfessorService
	
	// o Spring automaticamente cria um objeto com a interface `ProfessorRepository`,
    // e o injeta para nós no construtor da classe atual ==> Injeção de Depenência
	public CrudMensagemService(MensagemRepository mensagemRepository) {
		this.mensagemRepository = mensagemRepository;
	}
	
	private void cadastrar(Mensagem mensagem) {
//		System.out.print("Insira o nome da Mensagem em português BR: ");
//		String titulo_br = scanner.next(); // le a próxima string até achar um enter ou um espaco
//		
//		System.out.print("Insira o nome da Mensagem em inglês: ");
//		String titulo_en = scanner.next();
//		
//		System.out.print("Insira a cidade: ");
//		String cidade = scanner.next();
//		
//		System.out.print("Insira o estado: ");
//		String estado = scanner.next();
//		
//		System.out.print("Insira o país: ");
//		String pais = scanner.next();
//		
//		System.out.print("Insira a gráfica: ");
//		String grafica = scanner.next();
//		
//		System.out.print("Insira a identificação: ");
//		String identificacao = scanner.next();
//		
//		Mensagem mensagem = new Mensagem(titulo_br, titulo_en, cidade, estado, pais, grafica, identificacao, null);
//		
//		Mensagem mensagem = new Mensagem("q", "q", "q", "q", "q", "q", "q", null);
//		
		this.mensagemRepository.save(mensagem);
//		
//		System.out.println("Mensagem salva no banco!\n");
	}
//	
	private void atualizar(Integer id) {
//		System.out.print("Insira o id da Mensagem a ser atualizada: ");
//		Integer id = scanner.nextInt();
//		
		Optional<Mensagem> mensagemOptional = this.mensagemRepository.findById(id);
//		
//		// se o hibernate conseguiu achar uma tupla/registro na tabela de mensagens com id igual ao passado pelo usuario
		if(mensagemOptional.isPresent()) {
			Mensagem mensagem = mensagemOptional.get();
//			
//			System.out.print("Você só pode alterar o nome da Mensagem em português BR. Insira o novo nome: ");
//			String titulo_br = scanner.next(); // le a próxima string até achar um enter ou um espaco
//			
//			mensagem.setTitulo_br(titulo_br);
//			
			this.mensagemRepository.save(mensagem); // atualiza (persiste) o objeto/registro/tupla no BD
//			
//			System.out.println("Mensagem atualizada no banco!\n");
		} else{
			System.out.println("O id '" + id + "' é inválido.");
		}
	}
//	
	private void visualizarTodas() {
		Iterable<Mensagem> mensagens = this.mensagemRepository.findAll();
//		
//		// ALTERNATIVA 1
////		for(Mensagem mensagem : mensagens) {
////			System.out.println(mensagem);
////		}
//		
//		// ALTERNATIVA 2
////		mensagens.forEach(mensagem -> {System.out.println(mensagem);});
//		
//		// ALTERNATIVA 3
//		mensagens.forEach(System.out::println);
//		
//		System.out.println();
	}
//	
	private void deletar(Integer id) {
//		System.out.print("Insira o id da Mensagem a ser deletada: ");
//		Integer id = scanner.nextInt();
//		
		Optional<Mensagem> mensagemOptional = this.mensagemRepository.findById(id);
//		
		if(mensagemOptional.isPresent()) {
			this.mensagemRepository.deleteById(id);
//			
//			System.out.println("Mensagem deletada do banco!\n");
		} else {
			System.out.println("O id " + id + " não existe no banco!\n");
		}
	}
}
