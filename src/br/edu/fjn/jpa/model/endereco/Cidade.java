package br.edu.fjn.jpa.model.endereco;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "tb_cidade")
public class Cidade {
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genCid")
	@SequenceGenerator(name = "genCid", sequenceName="seqCid", initialValue= 1,
	allocationSize=1)
	private Integer id_cidade;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cep;
	@JoinColumn(nullable = false, name = "estado_fk")
	@OneToOne(cascade = CascadeType.ALL)
	private Estado estado;
	
	public Cidade(){
		
	}
	
	public Cidade(String nome, String cep, Estado estado) {
		super();
		this.nome = nome;
		this.cep = cep;
		this.estado = estado;
	}

	public Integer getId_cidade() {
		return id_cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Cidade [getId_cidade()=" + getId_cidade() + ", getEstado()=" + getEstado() + ", getNome()=" + getNome()
				+ ", getCep()=" + getCep() + "]";
	}
	
	
}
