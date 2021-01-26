package br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mensagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String texto;
	@Column(nullable = false)
	private String local;
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false)
	private String estado;
	@Column(nullable = false)
	private String pais;
	@Column(nullable = false)
	private Date data;
	@Column(nullable = false)
	private String periodoDia;
	@Column(nullable = false)
	private String grafica;
	@Column(nullable = false, unique = true)
	private String identificacao;
}
