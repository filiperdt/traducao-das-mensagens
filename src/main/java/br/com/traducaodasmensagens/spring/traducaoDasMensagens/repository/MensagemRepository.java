package br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository;

import org.springframework.data.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends CrudRepository<Mensagem, int> {
	
}
