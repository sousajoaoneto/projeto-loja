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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id_modelo == null) ? 0 : id_modelo.hashCode());
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
		Modelo other = (Modelo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id_modelo == null) {
			if (other.id_modelo != null)
				return false;
		} else if (!id_modelo.equals(other.id_modelo))
			return false;
		return true;
	}
	
	
	
	
}
