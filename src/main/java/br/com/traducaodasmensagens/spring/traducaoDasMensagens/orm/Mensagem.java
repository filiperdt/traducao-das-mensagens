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
	
	@Deprecated
	public Mensagem() {}
	
	public Mensagem(String titulo, String texto, String local, String cidade, String estado, String pais, Date data,
			String periodoDia, String grafica, String identificacao) {
		super();
		this.titulo = titulo;
		this.texto = texto;
		this.local = local;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.data = data;
		this.periodoDia = periodoDia;
		this.grafica = grafica;
		this.identificacao = identificacao;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getPeriodoDia() {
		return periodoDia;
	}

	public void setPeriodoDia(String periodoDia) {
		this.periodoDia = periodoDia;
	}

	public String getGrafica() {
		return grafica;
	}

	public void setGrafica(String grafica) {
		this.grafica = grafica;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
}
