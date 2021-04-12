package br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
}
