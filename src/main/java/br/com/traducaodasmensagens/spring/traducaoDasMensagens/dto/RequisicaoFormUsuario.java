package br.com.traducaodasmensagens.spring.traducaoDasMensagens.dto;

import br.com.traducaodasmensagens.spring.traducaoDasMensagens.orm.Usuario;

public class RequisicaoFormUsuario {
	private String nomeUsuario;
	private String email;
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
	
	public Usuario toUsuario(Usuario usuario) {
		usuario.setNomeUsuario(this.nomeUsuario);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		
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
