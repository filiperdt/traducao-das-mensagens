package br.com.traducaodasmensagens.spring.traducaoDasMensagens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MensagemController {
	
	@GetMapping("/mensagens")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("mensagens/mensagens");
		mv.addObject("nome", "Filipe");
		return mv;
	}
}
