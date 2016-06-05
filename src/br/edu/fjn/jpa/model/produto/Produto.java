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
	@OneToMany(cascade = CascadeType.ALL) //verificar o cascade
	private List<Cor> cor;
	@Column (nullable = false)
	private String imagem;
	
	public Produto() {
	
	}
	
	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	
	@Override
	public String toString() {
		return "Produto [id_produto=" + id_produto + ", estoque=" + estoque + ", descricao=" + descricao + ", preco="
				+ preco + ", tecnologia=" + tecnologia + ", genero=" + genero + ", modelo=" + modelo.toString() + ", cor=" + cor
				+ ", imagem=" + imagem + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id_produto == null) ? 0 : id_produto.hashCode());
		result = prime * result + ((imagem == null) ? 0 : imagem.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((tecnologia == null) ? 0 : tecnologia.hashCode());
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
		Produto other = (Produto) obj;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estoque == null) {
			if (other.estoque != null)
				return false;
		} else if (!estoque.equals(other.estoque))
			return false;
		if (genero != other.genero)
			return false;
		if (id_produto == null) {
			if (other.id_produto != null)
				return false;
		} else if (!id_produto.equals(other.id_produto))
			return false;
		if (imagem == null) {
			if (other.imagem != null)
				return false;
		} else if (!imagem.equals(other.imagem))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (tecnologia != other.tecnologia)
			return false;
		return true;
	}	
	
	
	
	
}
