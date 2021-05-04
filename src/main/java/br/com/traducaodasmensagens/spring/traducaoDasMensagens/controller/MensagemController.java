package br.com.traducaodasmensagens.spring.traducaoDasMensagens.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.dto.RequisicaoFormMensagem;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.DiaDaSemana;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Mensagem;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.PeriodoDoDia;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository.MensagemRepository;

@Controller
@RequestMapping(value="/mensagens")
public class MensagemController {
	@Autowired
	public MensagemRepository mensagemRepository;
	
	@GetMapping("")
	public ModelAndView index() {
		List<Mensagem> mensagens = this.mensagemRepository.findAll();
		ModelAndView mv = new ModelAndView("mensagens/mensagens");
		mv.addObject("mensagens", mensagens);
		return mv;
	}
	
	@PostMapping("")
	public ModelAndView create(@Valid RequisicaoFormMensagem requisicao, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("mensagens/novo");
			mv.addObject("diasDaSemana", DiaDaSemana.values());
			mv.addObject("periodosDoDia", PeriodoDoDia.values());
			return mv;
		} else {
			Mensagem mensagem = requisicao.toMensagem();
			mensagemRepository.save(mensagem);
			
			ModelAndView mv = new ModelAndView("redirect:/mensagens/" + mensagem.getId());
			mv.addObject("novo", true);
			
			return mv;
		}
	}
	
	@GetMapping("/new")
	public ModelAndView nnew(RequisicaoFormMensagem requisicao) {
		ModelAndView mv = new ModelAndView("mensagens/novo");
		mv.addObject("diasDaSemana", DiaDaSemana.values());
		mv.addObject("periodosDoDia", PeriodoDoDia.values());
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable Integer id) {
		Optional<Mensagem> optional = mensagemRepository.findById(id);
		
		if(optional.isPresent()) {
			Mensagem mensagem = optional.get();
			
			ModelAndView mv = new ModelAndView("mensagens/show");
			mv.addObject("mensagem", mensagem);
			
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("redirect:/mensagens");
			return this.retornaErroMensagem(mv, "Erro na exibição de detalhes. Mensagem #" + id + " não encontrada no banco!", true);
		}
	}
	
	@GetMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Integer id, RequisicaoFormMensagem requisicao) {
		Optional<Mensagem> optional = mensagemRepository.findById(id);
		
		if(optional.isPresent()) {
			Mensagem mensagem = optional.get();
			requisicao.fromMensagem(mensagem);
			
			ModelAndView mv = new ModelAndView("mensagens/edit");
			mv.addObject("diasDaSemana", DiaDaSemana.values());
			mv.addObject("periodosDoDia", PeriodoDoDia.values());
			mv.addObject("mensagemId", mensagem.getId());
			
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("redirect:/mensagens");
			return this.retornaErroMensagem(mv, "Erro na atualização. Mensagem #" + id + " não encontrada no banco!", true);
		}
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable Integer id, @Valid RequisicaoFormMensagem requisicao, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("mensagens/edit");
			mv.addObject("diasDaSemana", DiaDaSemana.values());
			mv.addObject("periodosDoDia", PeriodoDoDia.values());
			mv.addObject("mensagemId", id);
			return mv;
		} else {
			Optional<Mensagem> optional = mensagemRepository.findById(id);
			
			if(optional.isPresent()) {
				Mensagem mensagem = requisicao.toMensagem(optional.get());
				mensagemRepository.save(mensagem);
				
				return new ModelAndView("redirect:/mensagens/" + mensagem.getId());
			} else {
				ModelAndView mv = new ModelAndView("redirect:/mensagens");
				return this.retornaErroMensagem(mv, "Erro na atualização. Mensagem #" + id + " não encontrada no banco!", true);
			}
		}
	}
	
	@GetMapping("/{id}/delete")
	public ModelAndView delete(@PathVariable Integer id) {
		Optional<Mensagem> optional = mensagemRepository.findById(id);
		
		ModelAndView mv = new ModelAndView("redirect:/mensagens");
		
		if(optional.isPresent()) {
			mensagemRepository.deleteById(id);
			return this.retornaErroMensagem(mv, "Mensagem #" + id + " deletada com sucesso!", false);
		} else {
			return this.retornaErroMensagem(mv, "Erro na exclusão. Mensagem #" + id + " não encontrada no banco!", true);
		}
	}
	
	private ModelAndView retornaErroMensagem(ModelAndView mv, String msg, boolean result) {
		mv.addObject("mensagem", msg);
		mv.addObject("error", result);
		
		return mv;
	}
}
