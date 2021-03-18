package br.com.traducaodasmensagens.spring.traducaoDasMensagens.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Mensagem;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Paragrafo;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository.MensagemRepository;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository.ParagrafoRepository;

@Service
public class CrudParagrafoService {
//	private ParagrafoRepository paragrafoRepository;
//	private MensagemRepository mensagemRepository;
//	
//	public CrudParagrafoService(ParagrafoRepository paragrafoRepository, MensagemRepository mensagemRepository) {
//		this.paragrafoRepository = paragrafoRepository;
//		this.mensagemRepository = mensagemRepository;
//	}
//	
//	public void menu(Scanner scanner) {
//		Boolean isTrue = true;
//		
//		while(isTrue) {
//			System.out.println("\nQual ação quer executar?");
//			System.out.println("0 - Voltar ao menu anterior");
//			System.out.println("1 - Cadastrar Parágrafo");
//			System.out.println("2 - Atualizar Parágrafo");
//			System.out.println("3 - Visualizar todos os Parágrafos");
//			System.out.println("4 - Deletar Parágrafo");
//			
//			int opcao = scanner.nextInt();
//			
//			switch(opcao) {
//				case 1:
//					this.cadastrar(scanner);
//					break;
//				case 2:
//					this.atualizar(scanner);
//					break;
//				case 3:
//					this.visualizarTodos();
//					break;
//				case 4:
//					this.deletar(scanner);
//					break;
//				default:
//					isTrue = false;
//					break;
//			}
//		}
//	}
//	
//	private void cadastrar(Scanner scanner) {
//		System.out.print("Número do parágrafo: ");
//		Integer numero = scanner.nextInt();
//		
//		System.out.print("Texto do parágrafo: ");
//		String texto = scanner.next();
//		
//		System.out.print("Id da Mensagem: ");
//		Integer mensagemId = scanner.nextInt();
//		
//		Optional<Mensagem> mensagemOptional = this.mensagemRepository.findById(mensagemId);
//		
//		if(mensagemOptional.isPresent()) {
//			Mensagem mensagem = mensagemOptional.get();
//			Paragrafo paragrafo = new Paragrafo(numero, texto, mensagem);
//			this.paragrafoRepository.save(paragrafo);
//			System.out.println("Parágrafo salvo!\n");
//		} else {
//			System.out.println("Não há Mensagem com o id " + mensagemId);
//		}	
//	}
//	
//	private void atualizar(Scanner scanner) {
//		System.out.print("Insira o id do Parágrafo a ser atualizado: ");
//		Integer id = scanner.nextInt();
//		
//		Optional<Paragrafo> paragrafoOptional = this.paragrafoRepository.findById(id);
//		
//		if(paragrafoOptional.isPresent()) {
//			Paragrafo paragrafo = paragrafoOptional.get();
//			
//			System.out.print("Texto do paragrafo em português BR: ");
//			String texto = scanner.next(); // le a próxima string até achar um enter ou um espaco
//			
//			System.out.print("Id da Mensagem: ");
//			Integer mensagemId = scanner.nextInt();
//			
//			Optional<Mensagem> mensagemOptional = this.mensagemRepository.findById(mensagemId);
//				
//			if(mensagemOptional.isPresent()) {
//				Mensagem mensagem = mensagemOptional.get();
//								
//				paragrafo.setTexto(texto);
//				paragrafo.setMensagem(mensagem);
//
//				this.paragrafoRepository.save(paragrafo); // atualiza (persiste) o objeto/registro/tupla no BD
//				
//				System.out.println("Parágrafo atualizado!\n");
//			} else{
//				System.out.println("O id '" + id + "' da Mensagem é inválido.");
//			}
//			
//		} else{
//			System.out.println("O id '" + id + "' é inválido.");
//		}
//	}
//	
//	private void visualizarTodos() {
//		Iterable<Paragrafo> paragrafos = this.paragrafoRepository.findAll();
//		
////		for(Paragrafo paragrafo : paragrafos) {
////			System.out.println(paragrafo);
////		}
//		
//		paragrafos.forEach(System.out::println);
//		
//		System.out.println();
//	}
//	
//	private void deletar(Scanner scanner) {
//		System.out.print("Insira o id do parágrafo a ser deletado: ");
//		Integer id = scanner.nextInt();
//		
//		Optional<Paragrafo> paragrafoOptional = this.paragrafoRepository.findById(id);
//		
//		if(paragrafoOptional.isPresent()) {
//			this.paragrafoRepository.deleteById(id);
//			
//			System.out.println("Parágrafo deletado do banco!\n");
//		} else {
//			System.out.println("O id " + id + " não existe no banco!\n");
//		}
//	}	
}
