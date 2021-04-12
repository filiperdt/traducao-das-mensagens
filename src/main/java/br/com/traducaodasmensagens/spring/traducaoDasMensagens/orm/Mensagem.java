package br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm;

import java.time.LocalDate;
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
	@Column(nullable = false)
	private LocalDate dataPregacao;
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false)
	private String estado;
	@Column(nullable = false)
	private String siglaEstado;
	@Column(nullable = false)
	private String pais;
	private String grafica;
	private String periodoDoDia;
	private String diaDaSemana;
	
	@OneToMany(mappedBy = "mensagem", cascade = CascadeType.ALL)
	private List<Paragrafo> paragrafos;
	
	@ManyToMany(mappedBy = "mensagens")
	private Set<Usuario> usuarios;
	
	@Deprecated
	public Mensagem() {}
	
	public Mensagem(String tituloBr, String tituloEn, LocalDate dataPregacao, String cidade, String estado,
			String siglaEstado, String pais, String grafica, String periodoDoDia, String diaDaSemana,
			List<Paragrafo> paragrafos, Set<Usuario> usuarios) {
		super();
		this.tituloBr = tituloBr;
		this.tituloEn = tituloEn;
		this.dataPregacao = dataPregacao;
		this.cidade = cidade;
		this.estado = estado;
		this.siglaEstado = siglaEstado;
		this.pais = pais;
		this.grafica = grafica;
		this.periodoDoDia = periodoDoDia;
		this.diaDaSemana = diaDaSemana;
		this.paragrafos = paragrafos;
		this.usuarios = usuarios;
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
	
	public LocalDate getDataPregacao() {
		return dataPregacao;
	}
	
	public void setDataPregacao(LocalDate dataPregacao) {
		this.dataPregacao = dataPregacao;
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
	public String getSiglaEstado() {
		return siglaEstado;
	}
	
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
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

	public String getPeriodoDoDia() {
		return periodoDoDia;
	}
	public void setPeriodoDoDia(String periodoDoDia) {
		this.periodoDoDia = periodoDoDia;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
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
		return "Mensagem [id=" + id + ", tituloBr=" + tituloBr + ", tituloEn=" + tituloEn 
				+ ", dataPregacao=" + dataPregacao + ", cidade=" + cidade + ", estado=" + estado + ", pais=" 
				+ pais + ", grafica=" + grafica + ", periodoDoDia=" + periodoDoDia 
				+ ", diaDaSemana=" + diaDaSemana + "]";
	}
}
