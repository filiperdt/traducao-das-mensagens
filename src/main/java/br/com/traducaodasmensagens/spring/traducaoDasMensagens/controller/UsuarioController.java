package br.com.traducaodasmensagens.spring.traducaoDasMensagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView nnew() {
		ModelAndView mv = new ModelAndView("usuarios/novo");
		
		return mv;
	}
	
	@PostMapping("")
	public ModelAndView create() {
		return null;
	}
	
	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable Integer id) {
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