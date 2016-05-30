package br.edu.fjn.model;

import java.util.Date;

public class UsuarioWeb {
	private String nome;
	private String senha;
	private String email;
	private String username;
	private String cpf;
	private int tipo;
	private String data_nasc;
	private String endereco;

	public UsuarioWeb() {

	}

	public UsuarioWeb(String nome, String senha, String email) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Usuario [getNome()=" + getNome() + ", getSenha()=" + getSenha() + ", getEmail()=" + getEmail()
				+ ", getUsername()=" + getUsername() + ", getCpf()=" + getCpf() + ", getTipo()=" + getTipo()
				+ ", getData_nasc()=" + getData_nasc() + ", getEndereco()=" + getEndereco() + "]";
	}

	

}
