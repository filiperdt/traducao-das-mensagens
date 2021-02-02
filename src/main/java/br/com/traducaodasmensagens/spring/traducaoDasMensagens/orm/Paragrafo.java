package br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Paragrafo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private Integer numero;
	@Column(nullable = false)
	private String texto;
//	@Column(nullable = false)
//	private Time tempo_inicio;
//	@Column(nullable = false)
//	private Time tempo_fim;
	@ManyToOne
	@JoinColumn(name = "mensagem_id", nullable = false)
	private Mensagem mensagem;
	
	@Deprecated
	public Paragrafo() {}

	public Paragrafo(Integer numero, String texto, Mensagem mensagem) {
		super();
		this.numero = numero;
		this.texto = texto;
		this.mensagem = mensagem;
	}

	public Integer getId() {
		return id;
	}
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "Paragrafo [id=" + id + ", numero=" + numero + ", texto=" + texto + ", mensagem=" + mensagem + "]";
	}
}
