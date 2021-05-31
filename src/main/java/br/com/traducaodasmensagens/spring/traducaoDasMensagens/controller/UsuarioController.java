package br.com.traducaodasmensagens.spring.traducaoDasMensagens.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.dto.RequisicaoFormUsuario;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.interfaces.VerificacaoEditarUsuario;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.interfaces.VerificacaoNovoUsuario;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Usuario;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("")
	public ModelAndView index() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		ModelAndView mv = new ModelAndView("usuarios/usuarios");
		mv.addObject("usuarios", usuarios);
		
		return mv;
	}
	
	@GetMapping("/new")
	public ModelAndView nnew(RequisicaoFormUsuario requisicao) {
		ModelAndView mv = new ModelAndView("usuarios/novo");
		
		return mv;
	}
	
	@PostMapping("")
	public ModelAndView create(@Validated(VerificacaoNovoUsuario.class) RequisicaoFormUsuario requisicao, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("usuarios/novo");
			
			return mv;
		}else {
			Usuario usuario = requisicao.toUsuario();
			usuario.setConfirmado(true);
			usuario.setAtivo(true);
			usuario.setUltima_mensagem("Última Mensagem");
			usuario.setUltimo_paragrafo("Último parágrafo");
			usuarioRepository.save(usuario);
			
			ModelAndView mv = new ModelAndView("redirect:/usuarios/" + usuario.getId());
			mv.addObject("novo", true);
			
			return mv;
		}
	}
	
	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable Integer id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		
		if(optional.isPresent()) {
			Usuario usuario = optional.get();
			
			ModelAndView mv = new ModelAndView("usuarios/show");
			mv.addObject("usuario", usuario);
			
			return mv;
		}else {
			ModelAndView mv = new ModelAndView("redirect:/usuarios");
			return this.retornaErroMensagem(mv, "Erro na exibição de detalhes. Usuário #" + id + " não encontrado no banco!", true);
		}
	}
	
	@GetMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Integer id, RequisicaoFormUsuario requisicao) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		
		if(optional.isPresent()) {
			Usuario usuario = optional.get();
			requisicao.fromUsuario(usuario);
			
			ModelAndView mv = new ModelAndView("usuarios/edit");
			mv.addObject("usuarioId", usuario.getId());
			
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("redirect:/usuarios");
			return this.retornaErroMensagem(mv, "Erro na atualização. Usuário #" + id + " não encontrado no banco!", true);
		}
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable Integer id, @Validated(VerificacaoEditarUsuario.class) RequisicaoFormUsuario requisicao, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("usuarios/edit");
			mv.addObject("usuarioId", id);
			
			return mv;
		}else {
			Optional<Usuario> optional = usuarioRepository.findById(id);
			
			if(optional.isPresent()) {
				Usuario usuarioRequisicao = requisicao.toUsuario(optional.get(), optional.get().getSenha());
				usuarioRequisicao.setConfirmado(true);
				usuarioRequisicao.setAtivo(true);
				usuarioRequisicao.setUltima_mensagem("Última Mensagem");
				usuarioRequisicao.setUltimo_paragrafo("Último parágrafo");
				usuarioRepository.save(usuarioRequisicao);
				
				return new ModelAndView("redirect:/usuarios/" + usuarioRequisicao.getId());
			} else {
				ModelAndView mv = new ModelAndView("redirect:/usuarios");
				return this.retornaErroMensagem(mv, "Erro na atualização. Usuário #" + id + " não encontrado no banco!", true);
			}
		}
	}
	
	@GetMapping("/{id}/delete")
	public ModelAndView delete(@PathVariable Integer id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		
		ModelAndView mv = new ModelAndView("redirect:/usuarios");
		
		if(optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return this.retornaErroMensagem(mv, "Usuário #" + id + " deletado com sucesso!", false);
		} else {
			return this.retornaErroMensagem(mv, "Erro na exclusão. Usuário #" + id + " não encontrado no banco!", true);
		}
	}
	
	private ModelAndView retornaErroMensagem(ModelAndView mv, String msg, boolean result) {
		mv.addObject("mensagem", msg);
		mv.addObject("error", result);
		
		return mv;
	}
}