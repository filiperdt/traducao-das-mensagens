package br.com.traducaodasmensagens.spring.traducaoDasMensagens;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Mensagem;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository.MensagemRepository;

@SpringBootApplication
public class TraducaoDasMensagensApplication implements CommandLineRunner {

	private MensagemRepository repository;
	
	public TraducaoDasMensagensApplication(MensagemRepository repository) {
		this.repository = repository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TraducaoDasMensagensApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Mensagem mensagem = new Mensagem("Quando Seus Olhos Foram Abertos, Eles O Reconheceram", "When Their Eyes Were Opened, They Knew Him", "Beaumont", "Texas", "EUA", "Crentes da Bíblia do Brasil", "64-0312");
		System.out.println(mensagem);
		this.repository.save(mensagem);
		System.out.println(mensagem);
	}
	
}
