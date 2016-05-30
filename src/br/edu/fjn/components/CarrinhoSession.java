package br.edu.fjn.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("carrinho")
public class CarrinhoSession implements Serializable {
	
	private List<CarrinhoItem> itens = new ArrayList<CarrinhoItem>();
	private Double total = 0.0;
	
	public void adiciona(CarrinhoItem item) {
		itens.add(item);
		total += item.getProduto().getPreco() * item.getQuantidade();
	}
	
	public Integer getTotalDeItens() {
		return itens.size();
	}

	public List<CarrinhoItem> getItens() {
		return itens;
	}

	public void setItens(List<CarrinhoItem> itens) {
		this.itens = itens;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}

