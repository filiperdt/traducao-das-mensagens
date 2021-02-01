package br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Paragrafo;

@Repository
public interface ParagrafoRepository extends CrudRepository<Paragrafo, Integer> {
	
}
