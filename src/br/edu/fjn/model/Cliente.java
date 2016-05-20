package br.edu.fjn.model;

public class Cliente {
	private String nome; 
	private String rg; 
	private String cpf;
	private int codigo;
	
	public Cliente(){};
	
	public Cliente(int codigo, String nome, String rg, String cpf) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
}
