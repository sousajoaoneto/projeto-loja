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

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
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
		return "Estado [id_estado=" + id_estado + ", nome=" + nome + "]";
	}

	//hash and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_estado == null) ? 0 : id_estado.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (id_estado == null) {
			if (other.id_estado != null)
				return false;
		} else if (!id_estado.equals(other.id_estado))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
