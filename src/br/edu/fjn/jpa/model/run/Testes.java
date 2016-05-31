package br.edu.fjn.jpa.model.run;


import br.edu.fjn.jpa.dao.impl.DaoProduto;
import br.edu.fjn.jpa.model.produto.Produto;

public class Testes {
	public static void main(String[] args) {
		
		Produto produto = new DaoProduto().findById(2);
		if(produto!=null){
			System.out.println(produto.toString());
		}else{
			System.out.println("Sem produto");
		}
		
	}

}
