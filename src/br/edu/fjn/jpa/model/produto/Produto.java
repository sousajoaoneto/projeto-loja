package br.edu.fjn.jpa.model.produto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity(name = "tb_produto")
public class Produto {
	@Id
	@Column(nullable= false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="genPro")
	@SequenceGenerator(name = "genPro", sequenceName="seqPro", initialValue= 1,
	allocationSize=1)
	private Integer id_produto;
	@Column(nullable= false)
	private Integer estoque;
	@Column(nullable= false)
	private String descricao;
	@Column(nullable= false)
	private Double preco;
	@Column(nullable= false)
	private Tecnologia tecnologia;
	@Column(nullable= false)
	private Genero genero;
	@JoinColumn(nullable=false, name="modelo_fk")
	@OneToOne(cascade = CascadeType.ALL) //verificar o cascade
	private Modelo modelo;
	@OneToMany
	private List<Cor> cor;
	public Produto() {
	
	}
	
	public Integer getId_produto() {
		return id_produto;
	}

	public List<Cor> getCor() {
		return cor;
	}

	public void setCor(List<Cor> cor) {
		this.cor = cor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Tecnologia getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
}
