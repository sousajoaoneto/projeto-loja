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
import javax.persistence.Transient;

@Entity(name = "tb_endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="genEnd")
	@SequenceGenerator(name = "genEnd", sequenceName="seqEnd", initialValue= 1,
	allocationSize=1)
	private Integer id_end;
	
	@Column(nullable= false)
	private String rua;
	
	@Column(nullable= false)
	private Integer numero;
	
	 
	@JoinColumn(nullable = false, name ="cidade_fk")
	@OneToOne(cascade=CascadeType.ALL)
	private Cidade cidade;
	
	public Endereco(){
		
	}
	
	public Endereco(String rua, Integer numero, Cidade cidade) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
	}
	
	public void setId_end(Integer id_end) {
		this.id_end = id_end;
	}


	public Integer getId_end() {
		return id_end;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Endereco [id_end=" + id_end + ", rua=" + rua + ", numero=" + numero + ", cidade=" + cidade.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((id_end == null) ? 0 : id_end.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
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
		Endereco other = (Endereco) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (id_end == null) {
			if (other.id_end != null)
				return false;
		} else if (!id_end.equals(other.id_end))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}
	
	
}
