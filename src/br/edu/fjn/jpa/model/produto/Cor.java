package br.edu.fjn.jpa.model.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "tb_cor")
public class Cor {
	@Id
	@Column(nullable= false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "genCor")
	@SequenceGenerator(name = "genCor", sequenceName="seqCor", initialValue= 1,
	allocationSize=1)
	private Integer id_cor;
	@Column(nullable= false)
	private String descricao;
	
	public Cor(){
		
	}
		
	public Cor(String descricao) {
		super();
		this.descricao = descricao;
	}

	public void setId_cor(Integer id_cor) {
		this.id_cor = id_cor;
	}

	public Integer getId_cor() {
		return id_cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Cor [getId_cor()=" + getId_cor() + ", getDescricao()=" + getDescricao() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id_cor == null) ? 0 : id_cor.hashCode());
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
		Cor other = (Cor) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id_cor == null) {
			if (other.id_cor != null)
				return false;
		} else if (!id_cor.equals(other.id_cor))
			return false;
		return true;
	}
	 
}
