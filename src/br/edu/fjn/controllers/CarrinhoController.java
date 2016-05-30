package br.edu.fjn.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.annotations.Public;
import br.edu.fjn.components.CarrinhoItem;
import br.edu.fjn.components.CarrinhoSession;
import br.edu.fjn.jpa.dao.impl.DaoProduto;

@Controller
@Public
@Path("carrinho")
public class CarrinhoController {

	@Inject
	private Result result;
	
	private final CarrinhoSession carrinho;
	private final DaoProduto dao;
	
	public CarrinhoController(CarrinhoSession carrinho, DaoProduto dao) {
		this.carrinho = carrinho;
		this.dao = dao;
	}
	
	@Post("/adicionar")
	public void adiciona(CarrinhoItem item) {
		dao.recarrega(item.getProduto());
		carrinho.adiciona(item);
		System.out.println("cheguei no carrinho");
		result.redirectTo(ProdutoController.class).list();
		
	}
}
