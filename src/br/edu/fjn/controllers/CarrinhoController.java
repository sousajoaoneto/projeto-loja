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
	@Inject
	private DaoProduto daoProduto;
	
	@Public
	@Post("adicionar")
	public void adiciona(int quantidade, int codigo) {
		String msg;
		CarrinhoItem item = new CarrinhoItem();
		
		Produto produto = daoProduto.findById(codigo);
		if(produto!=null){
			item.setProduto(produto);
			item.setQuantidade(quantidade);
			carrinho.adiciona(item);
			msg = produto.getDescricao()+" adicionado ao carrinho";
		}else{
			msg = "Produto n�o existe";
		}
		result.include("msg",msg);
		result.redirectTo(IndexController.class).list();
		
	}
		
	@Public
	@Get("adicionar")
	public void adiciona(int codigo) {		
		result.redirectTo(ProdutoController.class).list();		
	}
	
	@Public
	@Get("remover/{indiceItem}")
	public void remove(int indiceItem) {
		carrinho.remove(indiceItem);
		result.redirectTo(IndexController.class).list();
	}
	
}