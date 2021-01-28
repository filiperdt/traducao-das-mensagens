package br.com.traducaodasmensagens.spring.traducaoDasMensagens.service;

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
	
	public void menu(Scanner scanner) {
		Boolean isTrue = true;
		
		while(isTrue) {
			System.out.println("\nQual ação quer executar?");
			System.out.println("0 - Voltar ao menu anterior");
			System.out.println("1 - Cadastrar nova Mensagem");
			
			int opcao = scanner.nextInt();
			
			switch(opcao) {
				case 1:
					this.cadastrar(scanner);
					break;
				default:
					isTrue = false;
					break;
			}
		}
		
		System.out.println();
	}
	
	private void cadastrar(Scanner scanner) {
		System.out.print("Insira o nome da Mensagem em português BR: ");
		String titulo_br = scanner.next();
		
		System.out.print("Insira o nome da Mensagem em inglês: ");
		String titulo_en = scanner.next();
		
		System.out.print("Insira a cidade: ");
		String cidade = scanner.next();
		
		System.out.print("Insira o estado: ");
		String estado = scanner.next();
		
		System.out.print("Insira o país: ");
		String pais = scanner.next();
		
		System.out.print("Insira a gráfica: ");
		String grafica = scanner.next();
		
		System.out.print("Insira a identificação: ");
		String identificacao = scanner.next();
		
		Mensagem mensagem = new Mensagem(titulo_br, titulo_en, cidade, estado, pais, grafica, identificacao);
		
		this.mensagemRepository.save(mensagem);
		
		System.out.println("Mensagem salva no banco!\n");
	}
}
