package br.edu.fjn.components;

import br.edu.fjn.jpa.model.produto.Produto;

public class CarrinhoItem {
	
	private Produto produto;
	private Integer quantidade;
	
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
		return "CarrinhoItem [produto=" + produto.toString() + ",\n quantidade=" + quantidade + "]";
	}	
	
	
}
