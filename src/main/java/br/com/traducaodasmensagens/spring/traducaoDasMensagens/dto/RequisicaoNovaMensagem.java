package br.com.traducaodasmensagens.spring.traducaoDasMensagens.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.DiaDaSemana;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Mensagem;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.PeriodoDoDia;

// Classe DTO (Data Transfer Object)
public class RequisicaoNovaMensagem {
	@NotBlank
	@NotNull
	private String tituloBr; // Em caso de erro, NotBlank.requisicaoNovaMensagem.tituloBr   > Utiliza-lo em resources/messages.properties
	@NotBlank
	@NotNull
	private String tituloEn;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPregacao;
	@NotBlank
	@NotNull
	private String cidade;
	@NotBlank
	@NotNull
	private String estado;
	@NotBlank
	@NotNull
	private String siglaEstado;
	@NotBlank
	@NotNull
	private String pais;
	private String grafica;
	private PeriodoDoDia periodoDoDia;
	private DiaDaSemana diaDaSemana;
	
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
	
	public PeriodoDoDia getPeriodoDoDia() {
		return periodoDoDia;
	}
	public void setPeriodoDoDia(PeriodoDoDia periodoDoDia) {
		this.periodoDoDia = periodoDoDia;
	}
	
	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	
	public Mensagem toMensagem() {
		Mensagem mensagem = new Mensagem();
		mensagem.setTituloBr(this.tituloBr);
		mensagem.setTituloEn(this.tituloEn);
		mensagem.setDataPregacao(this.dataPregacao);
		mensagem.setCidade(this.cidade);
		mensagem.setEstado(this.estado);
		mensagem.setSiglaEstado(this.siglaEstado);
		mensagem.setPais(this.pais);
		mensagem.setGrafica(this.grafica);
		mensagem.setPeriodoDoDia(this.periodoDoDia);
		mensagem.setDiaDaSemana(this.diaDaSemana);
		
		return mensagem;
	}
	
	@Override
	public String toString() {
		return "RequisicaoNovaMensagem [tituloBr=" + tituloBr + ", tituloEn=" + tituloEn + ", dataPregacao="
				+ dataPregacao + ", cidade=" + cidade + ", estado=" + estado + ", siglaEstado=" + siglaEstado
				+ ", pais=" + pais + ", grafica=" + grafica + ", periodoDoDia=" + periodoDoDia + ", diaDaSemana="
				+ diaDaSemana + "]";
	}
}