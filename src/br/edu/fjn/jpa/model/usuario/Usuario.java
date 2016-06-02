package br.edu.fjn.jpa.model.usuario;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.fjn.dao.util.Util;
import br.edu.fjn.jpa.model.endereco.Endereco;

@Entity(name = "tb_usuario")
public class Usuario {
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genUsu")
	@SequenceGenerator(name = "genUsu", sequenceName = "seqUsu", initialValue = 1, allocationSize = 1)
	private Integer id_usuario;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String senha;
	@Column(unique = true)
	private String cpf;
	@Column(nullable = false)
	private Tipo tipo;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data_nasc;
	@Column(nullable = false)
	private String email;
	
	@JoinColumn(nullable = false, name = "endereco_fk")
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	public Usuario() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.senha = Util.criotograph(senha);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nome=" + nome + ", username=" + username + ", senha=" + senha
				+ ", cpf=" + cpf + ", tipo=" + tipo + ", data_nasc=" + data_nasc + ", email=" + email + ", endereco="
				+ endereco + "]";
	}
	

}
