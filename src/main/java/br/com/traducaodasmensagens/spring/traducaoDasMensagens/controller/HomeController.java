package br.com.traducaodasmensagens.spring.traducaoDasMensagens.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<String> home() {
		return new ResponseEntity<String>("Olá Spring Boot", HttpStatus.OK);
	}
}
