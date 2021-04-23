package br.com.traducaodasmensagens.spring.traducaoDasMensagens.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.dto.RequisicaoNovaMensagem;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.DiaDaSemana;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Mensagem;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.PeriodoDoDia;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository.MensagemRepository;

@Controller
public class MensagemController {
	@Autowired
	public MensagemRepository mensagemRepository;
	
	@GetMapping("/mensagens")
	public ModelAndView index() {
		List<Mensagem> mensagens = this.mensagemRepository.findAll();
		ModelAndView mv = new ModelAndView("mensagens/mensagens");
		mv.addObject("mensagens", mensagens);
		return mv;
	}
	
	@PostMapping("/mensagens")
	public ModelAndView create(@Valid RequisicaoNovaMensagem requisicao, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("mensagens/novo");
			mv.addObject("diasDaSemana", DiaDaSemana.values());
			mv.addObject("periodosDoDia", PeriodoDoDia.values());
			return mv;
		} else {
			mensagemRepository.save(requisicao.toMensagem());
			
			return new ModelAndView("redirect:/mensagens");
		}
	}
	
	@ModelAttribute(value = "requisicaoNovaMensagem")
	public RequisicaoNovaMensagem getRequisicaoNovaMensagem()
	{
		return new RequisicaoNovaMensagem();
	}
	
	@GetMapping("/mensagens/new")
	public ModelAndView nnew() {
		ModelAndView mv = new ModelAndView("mensagens/novo");
		mv.addObject("diasDaSemana", DiaDaSemana.values());
		mv.addObject("periodosDoDia", PeriodoDoDia.values());
		return mv;
	}
}
