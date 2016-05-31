package br.edu.fjn.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.annotations.Public;
import br.edu.fjn.components.CarrinhoItem;
import br.edu.fjn.components.CarrinhoSession;
import br.edu.fjn.jpa.dao.impl.DaoProduto;
import br.edu.fjn.jpa.model.produto.Produto;

@Controller
@Path("carrinho")
public class CarrinhoController {

	@Inject
	private Result result;	
	@Inject
	private CarrinhoSession carrinho;
	
	
	@Public
	@Post("adicionar")
	public void adiciona(int quantidade, int codigo) {
		String msg;
		CarrinhoItem item = new CarrinhoItem();
		
		Produto produto = new DaoProduto().findById(codigo);
		if(produto!=null){
			System.out.println(produto.toString());
			item.setProduto(produto);
			item.setQuantidade(quantidade);
			carrinho.adiciona(item);
			msg = "Produto adicionado ao carrinho";
		}else{
			msg = "Produto não existe";
		}
		result.include("msg",msg);
		result.redirectTo(IndexController.class).list();		
		
	}
	
	@Public
	@Get("adicionar")
	public void adiciona(int codigo) {		
		result.redirectTo(ProdutoController.class).list();		
	}
}