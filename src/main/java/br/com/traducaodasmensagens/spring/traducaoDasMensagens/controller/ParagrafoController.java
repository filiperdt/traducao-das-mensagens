package br.com.traducaodasmensagens.spring.traducaoDasMensagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Paragrafo;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository.ParagrafoRepository;

@Controller
@RequestMapping("/paragrafos")
public class ParagrafoController {
	@Autowired
	private ParagrafoRepository paragrafoRepository;
	
	@GetMapping("")
	public ModelAndView index() {
		List<Paragrafo> paragrafos = paragrafoRepository.findAll();
		
		ModelAndView mv = new ModelAndView("paragrafos/paragrafos");
		mv.addObject("paragrafos", paragrafos);
		
		return mv;
	}
}
