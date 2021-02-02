package br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
}
