package br.com.traducaodasmensagens.spring.traducaoDasMensagens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {
	
	@Query("select m from Mensagem m where upper(trim(m.tituloBr)) like %?1%")
	List<Mensagem> buscarPorTitulo(String titulo);
}