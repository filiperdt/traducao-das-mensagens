package br.com.traducaodasmensagens.spring.traducaoDasMensagens.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.dto.RequisicaoFormUsuario;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Usuario;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository.UsuarioRepository;

@Controller
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
	public ModelAndView create(RequisicaoFormUsuario requisicao) {
		Usuario usuario = requisicao.toUsuario();
		usuario.setConfirmado(true);
		usuario.setAtivo(true);
		usuarioRepository.save(usuario);
		
		ModelAndView mv = new ModelAndView("redirect:/usuarios/" + usuario.getId());
		mv.addObject("novo", true);
		
		return mv;
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
			
		}
		
		return null;
	}
	
	@GetMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Integer id) {
		return null;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable Integer id) {
		return null;
	}
	
	@GetMapping("/{id}/delete")
	public ModelAndView delete(@PathVariable Integer id) {
		return null;
	}
}