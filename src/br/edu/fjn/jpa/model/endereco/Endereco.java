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
		return "Endereco [getId_end()=" + getId_end() + ", getCidade()=" + getCidade() + ", getRua()=" + getRua()
				+ ", getNumero()=" + getNumero() + "]";
	}
	
	
}
