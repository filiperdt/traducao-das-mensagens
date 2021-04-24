package br.com.traducaodasmensagens.spring.traducaoDasMensagens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "/home";
	}
}
