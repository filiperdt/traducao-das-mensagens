package br.com.traducaodasmensagens.spring.traducaoDasMensagens;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.service.CrudMensagemService;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.service.CrudParagrafoService;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.service.CrudUsuarioService;

@SpringBootApplication
public class TraducaoDasMensagensApplication implements CommandLineRunner {
	
	private CrudMensagemService mensagemService;
	private CrudParagrafoService paragrafoService;
	private CrudUsuarioService usuarioService;
	
	// Os objetos passados por parâmetro são injetados automaticamente pelo Spring
	// Porque suas classes possuem a anotação @Service
	public TraducaoDasMensagensApplication(CrudMensagemService mensagemService, CrudParagrafoService paragrafoService, 
			CrudUsuarioService usuarioService) {
		this.mensagemService = mensagemService;
		this.paragrafoService = paragrafoService;
		this.usuarioService = usuarioService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TraducaoDasMensagensApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Boolean isTrue = true;
		Scanner scanner = new Scanner(System.in);
		
		while(isTrue) {
			System.out.println("Com qual entidade deseja interagir?");
			System.out.println("0 - Sair");
			System.out.println("1 - Mensagem");
			System.out.println("2 - Paragrafo");
			System.out.println("3 - Usuario");
			
			int opcao = scanner.nextInt();
			
			switch(opcao) {
				case 1:
					this.mensagemService.menu(scanner);
					break;
				case 2:
					this.paragrafoService.menu(scanner);
					break;
				case 3:
					this.usuarioService.menu(scanner);
					break;
				default:
					isTrue = false;
					break;
			}
		}
	}	
}
