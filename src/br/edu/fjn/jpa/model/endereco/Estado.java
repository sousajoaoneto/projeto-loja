package br.edu.fjn.jpa.model.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "tb_estado")
public class Estado {
	@Id
	@Column(nullable = false,name="pedido_fk")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genEst")
	@SequenceGenerator(name = "genEst", sequenceName="seqEst", initialValue= 1,
	allocationSize=1)
	private Integer id_estado;
	@Column(nullable = false)
	
	private String nome;
	
	public Estado(){
		
	}

	public Estado(String nome) {
		super();
		this.nome = nome;
	}

	public Integer getId_estado() {
		return id_estado;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Estado [getId_estado()=" + getId_estado() + ", getNome()=" + getNome() + "]";
	}
	
	
}
