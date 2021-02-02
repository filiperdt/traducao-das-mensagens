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
	private String nome;
	@Column(nullable = false, unique = true)
	private String login;
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

	public Usuario(String nome, String login, String senha, Boolean confirmado, Boolean ativo, String ultima_mensagem,
			String ultimo_paragrafo) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.confirmado = confirmado;
		this.ativo = ativo;
		this.ultima_mensagem = ultima_mensagem;
		this.ultimo_paragrafo = ultimo_paragrafo;
	}

	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", confirmado="
				+ confirmado + ", ativo=" + ativo + ", ultima_mensagem=" + ultima_mensagem + ", ultimo_paragrafo="
				+ ultimo_paragrafo + "]";
	}
}
