package br.com.traducaodasmensagens.spring.traducaoDasMensagens.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.interfaces.VerificacaoNovoUsuario;
import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Usuario;

public class RequisicaoFormUsuario {
	@NotBlank
	@NotNull
	private String nomeUsuario; // Em caso de erro, NotBlank.requisicaoFormUsuario.nomeUsuario   > Utiliza-lo em resources/messages.properties
	@NotBlank
	@NotNull
	@Email
	private String email;
	@NotBlank(groups= {VerificacaoNovoUsuario.class})
	@NotNull(groups= {VerificacaoNovoUsuario.class})
	private String senha;
	
	@Deprecated
	public RequisicaoFormUsuario() {}

	public RequisicaoFormUsuario(String nomeUsuario, String email, String senha) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
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
	
	public Usuario toUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario(this.nomeUsuario);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		
		return usuario;
	}
	
	public Usuario toUsuario(Usuario usuario, String senha) {
		usuario.setNomeUsuario(this.nomeUsuario);
		usuario.setEmail(this.email);
		if(this.senha != "") {
			usuario.setSenha(this.senha);
		}
		
		return usuario;
	}
	
	public void fromUsuario(Usuario usuario) {
		this.nomeUsuario = usuario.getNomeUsuario();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

	@Override
	public String toString() {
		return "RequisicaoFormUsuario [nomeUsuario=" + nomeUsuario + ", email=" + email + ", senha=" + senha + "]";
	}
}
