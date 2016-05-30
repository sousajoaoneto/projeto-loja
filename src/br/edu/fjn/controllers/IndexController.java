package br.edu.fjn.controllers;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.annotations.Public;
import br.edu.fjn.components.UserSession;
import br.edu.fjn.jpa.dao.impl.DaoUsuario;
import br.edu.fjn.jpa.model.usuario.Tipo;
import br.edu.fjn.jpa.model.usuario.Usuario;

@Controller
public class IndexController {

	@Inject
	private Result result;
	
	@Inject
	private UserSession userSession;
	
	@Public
	@Get("/")
	public void index(){
		
	}
	
	@Public
	@Get("cadastrar")
	public void form(){
		result.forwardTo(UsuarioController.class).form();
	}
	
	@Public
	@Get("catalogo")
	public void list(){
		result.forwardTo(ProdutoController.class).list();
	}
	
}
