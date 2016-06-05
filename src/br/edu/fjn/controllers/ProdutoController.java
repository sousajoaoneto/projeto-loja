package br.edu.fjn.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.fjn.annotations.Public;
import br.edu.fjn.jpa.dao.impl.DaoProduto;
import br.edu.fjn.jpa.model.produto.Cor;
import br.edu.fjn.jpa.model.produto.Modelo;
import br.edu.fjn.jpa.model.produto.Produto;

@Controller
@Path("produto")
public class ProdutoController {
	
	@Inject
	private Result result;
	
	@Inject
	private DaoProduto dao;
	
	@Get("novo")
	public void form(){
		result.include("pageTitle", "Cadastrar Produto");
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
		
		if( dao.salvar(produto)){
			result.include("msg", produto.getDescricao()+" cadastrado!");
		}else{
			result.include("msg", "Falha ao cadastrar produto!");
		}
		
		result.redirectTo(this).list();		
	}	
	
	@Public
	@Get("catalogo")
	public void list(){
		result.include("pageTitle", "Catálogo");
		result.include("produtos", dao.listar());
	}

	@Public
	@Get("pesquisar")
	public void list(List<Produto> produtos){	
		result.include("pageTitle", "Pesquisa");
		result.include("produtos", produtos);
	}
	
	@Post("editar")
	public void edit(Produto produto, Modelo modelo, Cor cor){
		List<Cor> cores = new ArrayList<>();
		cores.add(cor);
		produto.setCor(cores);
		produto.setModelo(modelo);
		
		if( dao.atualizar(produto) ){
			result.include("msg", "Produto editado com sucesso");			
		}else{
			result.include("msg", "Falha ao alterar produto");
		}
		result.redirectTo(IndexController.class).list();
	}
	
	@Get("busca.json")
	public void buscaJson(int codigo) {
		result.use(Results.json()).from(dao.findById(codigo)).include("modelo").include("cor").serialize();
	}
	
	@Public
	@Post("pesquisar")
	public void localizar(String descricao, String genero){

		List<Produto> produtos = dao.localizar(descricao, genero);		

		System.out.println(produtos.toString());
		result.include("produtos", produtos);
		result.redirectTo(this).list(produtos);
	}
}
