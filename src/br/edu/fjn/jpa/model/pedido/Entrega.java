package br.edu.fjn.jpa.model.pedido;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity(name = "tb_entrega")
public class Entrega {
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genEntrega")
	@SequenceGenerator(name = "genEntrega", sequenceName="seqEntrega", initialValue= 1,
	allocationSize=1)
	private Integer id_entrega;
	@Column(nullable = false)
	private String status_entrega;
	
	public Entrega(){
		
	}	

	public Entrega(String status_entrega) {
		super();
		this.status_entrega = status_entrega;
	}
	
	public String getStatus_entrega() {
		return status_entrega;
	}

	public void setStatus_entrega(String status_entrega) {
		this.status_entrega = status_entrega;
	}
	
	public void setId_entrega(Integer id_entrega) {
		this.id_entrega = id_entrega;
	}

	public Integer getId_entrega() {
		return id_entrega;
	}

	@Override
	public String toString() {
		return "Entrega [id_entrega=" + id_entrega + ", status_entrega=" + status_entrega + "]";
	}

	//hash and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_entrega == null) ? 0 : id_entrega.hashCode());
		result = prime * result + ((status_entrega == null) ? 0 : status_entrega.hashCode());
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
		Entrega other = (Entrega) obj;
		if (id_entrega == null) {
			if (other.id_entrega != null)
				return false;
		} else if (!id_entrega.equals(other.id_entrega))
			return false;
		if (status_entrega == null) {
			if (other.status_entrega != null)
				return false;
		} else if (!status_entrega.equals(other.status_entrega))
			return false;
		return true;
	}
	
}
