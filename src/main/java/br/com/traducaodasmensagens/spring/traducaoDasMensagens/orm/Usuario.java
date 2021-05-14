package br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nomeUsuario;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String senha;
	@Column(nullable = false, columnDefinition = "boolean default false")
	private Boolean confirmado;
	@Column(nullable = false, columnDefinition = "boolean default false")
	private Boolean ativo;
	private String ultima_mensagem;
	private String ultimo_paragrafo;
	
	@ManyToMany
	@JoinTable(name = "usuarios_mensagens",
				joinColumns = @JoinColumn(name = "usuario_fk"),
				inverseJoinColumns = @JoinColumn(name = "mensagem_fk"))
	private Set<Mensagem> mensagens;
	
	@Deprecated
	public Usuario() {}

	public Usuario(String nomeUsuario, String email, String senha, Boolean confirmado, Boolean ativo, String ultima_mensagem,
			String ultimo_paragrafo) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
		this.confirmado = confirmado;
		this.ativo = ativo;
		this.ultima_mensagem = ultima_mensagem;
		this.ultimo_paragrafo = ultimo_paragrafo;
	}

	public Integer getId() {
		return id;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getConfirmado() {
		return confirmado;
	}

	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getUltima_mensagem() {
		return ultima_mensagem;
	}

	public void setUltima_mensagem(String ultima_mensagem) {
		this.ultima_mensagem = ultima_mensagem;
	}

	public String getUltimo_paragrafo() {
		return ultimo_paragrafo;
	}

	public void setUltimo_paragrafo(String ultimo_paragrafo) {
		this.ultimo_paragrafo = ultimo_paragrafo;
	}

	public Set<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(Set<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nomeUsuario=" + nomeUsuario + ", email=" + email + ", senha=" + senha + ", confirmado="
				+ confirmado + ", ativo=" + ativo + ", ultima_mensagem=" + ultima_mensagem + ", ultimo_paragrafo="
				+ ultimo_paragrafo + "]";
	}
}
