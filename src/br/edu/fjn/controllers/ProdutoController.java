package br.edu.fjn.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.annotations.Public;

@Controller
@Path("produto")
public class ProdutoController {
	@Inject
	private Result result;
	
	@Get("novo")
	public void form(){
		
	}
	
	@Public
	@Get("catalogo")
	public void list(){
		
	}
}
