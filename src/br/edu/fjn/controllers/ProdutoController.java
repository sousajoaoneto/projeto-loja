package br.edu.fjn.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.annotations.Public;
import br.edu.fjn.jpa.dao.impl.DaoProduto;
import br.edu.fjn.jpa.model.produto.Cor;
import br.edu.fjn.jpa.model.produto.Genero;
import br.edu.fjn.jpa.model.produto.Modelo;
import br.edu.fjn.jpa.model.produto.Produto;

@Controller
@Path("produto")
public class ProdutoController {
	@Inject
	private Result result;
	
	@Get("novo")
	public void form(){
		
	}
	
	@Get("salvar")
	public void save(){	
		result.redirectTo(this).list();		
	}
	
	@Post("salvar")
	public void save(Produto produto, Modelo modelo, Cor cor){
		List<Cor> cores = new ArrayList<>();
		cores.add(cor);
		produto.setCor(cores);
		produto.setModelo(modelo);
		
		if(new DaoProduto().salvar(produto)){
			System.out.println("Ya Bro");
		}else{
			System.out.println("No Nigga");
		}
		
		result.redirectTo(this).list();		
	}	
	
	@Public
	@Get("catalogo")
	public void list(){
		List<Produto> produtos = new DaoProduto().listar();		
		result.include("produtos", produtos);
	}

	@Public
	@Get("pesquisar")
	public void list(List<Produto> produtos){	
		result.include("produtos", produtos);
	}
	
	@Get("editar/{codigo}")
	public void edit(int codigo){
		System.out.println("Chegou" + 1);
	}
	
	@Public
	@Post("pesquisar")
	public void localizar(String descricao, String genero){
		List<Produto> produtos = new DaoProduto().localizar(null, descricao, genero);		
		System.out.println(produtos.toString());
		result.include("produtos", produtos);
		result.redirectTo(this).list(produtos);
	}
}
