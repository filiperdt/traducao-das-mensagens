package br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Mensagem;

@Repository
public interface MensagemRepository extends CrudRepository<Mensagem, Integer> {
	
}