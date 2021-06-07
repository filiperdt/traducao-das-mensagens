package br.com.traducaodasmensagens.spring.traducaoDasMensagens.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.dto.RequisicaoFormMensagem;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Mensagem;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository.MensagemRepository;

@RestController /*Arquitetura REST*/
@RequestMapping(value="/mensagens")
public class MensagemController {
	@Autowired
	public MensagemRepository mensagemRepository;
	
	/*Serviço RESTful*/
	@GetMapping("")
	@ResponseBody
	public ResponseEntity<List<Mensagem>> index() {
		List<Mensagem> mensagens = this.mensagemRepository.findAll();
		
		return new ResponseEntity<List<Mensagem>>(mensagens, HttpStatus.OK);
	}
	
	@PostMapping("")
	@ResponseBody
	public ResponseEntity<?> create(@Valid @RequestBody RequisicaoFormMensagem requisicao, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Object>("Tudo errado", HttpStatus.BAD_REQUEST);
		} else {
			Mensagem mensagemSalva = mensagemRepository.save(requisicao.toMensagem()); /*O 'save' salva no BD e já faz o get do objeto criado*/
			
			return new ResponseEntity<Mensagem>(mensagemSalva, HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> show(@PathVariable(name = "id") Integer id) {
		Optional<Mensagem> optional = mensagemRepository.findById(id);
		
		if(optional.isPresent()) {
			Mensagem mensagem = optional.get();
			
			return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Mensagem #" + id + " não encontrada no banco!", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}", produces="application/json")
	public ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @Valid @RequestBody RequisicaoFormMensagem requisicao, BindingResult bindingResult) {
		Optional<Mensagem> optional = mensagemRepository.findById(id);
		
		if(optional.isPresent()) {
			if(bindingResult.hasErrors()) {
				return new ResponseEntity<String>("Tudo errado", HttpStatus.BAD_REQUEST);
			} else {
				Mensagem mensagemSalva = mensagemRepository.save(requisicao.toMensagem(optional.get()));
				
				return new ResponseEntity<Mensagem>(mensagemSalva, HttpStatus.OK);
			}
		}else {
			return new ResponseEntity<String>("Mensagem #" + id + " não encontrada no banco!", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value="/{id}", produces="application/text")
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
		Optional<Mensagem> optional = mensagemRepository.findById(id);
		
		if(optional.isPresent()) {
			mensagemRepository.deleteById(id);
			return new ResponseEntity<String> ("Mensagem #" + id + " deletada com sucesso!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String> ("Erro na exclusão. Mensagem #" + id + " não encontrada no banco!", HttpStatus.NOT_FOUND);
		}
	}
}
