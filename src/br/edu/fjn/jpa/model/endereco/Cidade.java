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

	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
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
		return "Cidade [id_cidade=" + id_cidade + ", nome=" + nome + ", cep=" + cep + ", estado=" + estado.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id_cidade == null) ? 0 : id_cidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id_cidade == null) {
			if (other.id_cidade != null)
				return false;
		} else if (!id_cidade.equals(other.id_cidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	
	
	
}
