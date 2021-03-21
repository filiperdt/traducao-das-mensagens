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
	private String tituloBr;
	@Column(nullable = false)
	private String tituloEn;
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
	private String horaDoDia;
	
	@OneToMany(mappedBy = "mensagem", cascade = CascadeType.ALL)
	private List<Paragrafo> paragrafos;
	
	@ManyToMany(mappedBy = "mensagens")
	private Set<Usuario> usuarios;
	
	@Deprecated
	public Mensagem() {}

	public Mensagem(String tituloBr, String tituloEn, String cidade, String estado, String pais, String grafica,
			String identificacao,  String horaDoDia, List<Paragrafo> paragrafos) {
		super();
		this.tituloBr = tituloBr;
		this.tituloEn = tituloEn;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.grafica = grafica;
		this.identificacao = identificacao;
		this.horaDoDia = horaDoDia;
		this.paragrafos = paragrafos;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getTituloBr() {
		return tituloBr;
	}

	public void setTituloBr(String tituloBr) {
		this.tituloBr = tituloBr;
	}

	public String getTituloEn() {
		return tituloEn;
	}

	public void setTituloEn(String tituloEn) {
		this.tituloEn = tituloEn;
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

	public String getHoraDoDia() {
		return horaDoDia;
	}
	
	public void setHoraDoDia(String horaDoDia) {
		this.horaDoDia = horaDoDia;
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
		return "Mensagem [id=" + id + ", tituloBr=" + tituloBr + ", tituloEn=" + tituloEn + ", cidade=" + cidade
				+ ", estado=" + estado + ", pais=" + pais + ", grafica=" + grafica + ", identificacao=" + identificacao
				+ ", horaDoDia=" + horaDoDia + "]";
	}
}
