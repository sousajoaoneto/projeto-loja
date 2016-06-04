package br.edu.fjn.jpa.model.pedido;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import br.edu.fjn.jpa.model.produto.Produto;

@Entity(name = "tb_item_pedido")
public class ItemPedido {
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genItemP")
	@SequenceGenerator(name = "genItemP", sequenceName="seqItemP", initialValue= 1,
	allocationSize=1)
	private Integer id_item_pedido;
	@Column(nullable = false)
	private Integer quantidade;
	@JoinColumn(nullable=false, name="produto_fk")
	@OneToOne
	private Produto produto;
	
	public ItemPedido(){
		
	}

	public ItemPedido(Integer quantidade, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.produto = produto;
	}



	public Integer getId_item_pedido() {
		return id_item_pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ItemPedido [id_item_pedido=" + id_item_pedido + ", quantidade=" + quantidade + ", produto=" + produto.toString()
				+ "]";
	}
	
	
	
}
