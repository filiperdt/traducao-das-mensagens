package br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Mensagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String titulo_br;
	@Column(nullable = false)
	private String titulo_en;
//	@Column(nullable = false)
//	private Date data;
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false)
	private String estado;
	@Column(nullable = false)
	private String pais;
	private String grafica;
	@Column(nullable = false, unique = true)
	private String identificacao;
	
	@OneToMany(mappedBy = "mensagem", cascade = CascadeType.ALL)
	private List<Paragrafo> paragrafos;
	
	@ManyToMany(mappedBy = "mensagens")
	private Set<Usuario> usuarios;
	
	@Deprecated
	public Mensagem() {}

	public Mensagem(String titulo_br, String titulo_en, String cidade, String estado, String pais, String grafica,
			String identificacao, List<Paragrafo> paragrafos) {
		super();
		this.titulo_br = titulo_br;
		this.titulo_en = titulo_en;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.grafica = grafica;
		this.identificacao = identificacao;
		this.paragrafos = paragrafos;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getTitulo_br() {
		return titulo_br;
	}

	public void setTitulo_br(String titulo_br) {
		this.titulo_br = titulo_br;
	}

	public String getTitulo_en() {
		return titulo_en;
	}

	public void setTitulo_en(String titulo_en) {
		this.titulo_en = titulo_en;
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

	public List<Paragrafo> getParagrafos() {
		return paragrafos;
	}

	public void setParagrafos(List<Paragrafo> paragrafos) {
		this.paragrafos = paragrafos;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Mensagem [id=" + id + ", titulo_br=" + titulo_br + ", titulo_en=" + titulo_en + ", cidade=" + cidade
				+ ", estado=" + estado + ", pais=" + pais + ", grafica=" + grafica + ", identificacao=" + identificacao
				+ "]";
	}
}
