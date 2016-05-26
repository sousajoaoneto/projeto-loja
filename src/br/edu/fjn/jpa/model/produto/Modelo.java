package br.edu.fjn.jpa.model.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "tb_modelo")
public class Modelo {
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genMod")
	@SequenceGenerator(name = "genMod", sequenceName="seqMod", initialValue= 1,
	allocationSize=1)
	private Integer id_modelo;
	@Column(nullable = false)
	private String descricao;
	
	public Modelo(){
		
	}
	
	public Integer getId_modelo() {
		return id_modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
