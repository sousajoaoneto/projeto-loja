package br.edu.fjn.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.annotations.Public;
import br.edu.fjn.components.UserSession;
import br.edu.fjn.jpa.dao.impl.DaoUsuario;
import br.edu.fjn.jpa.model.usuario.Usuario;

@Controller
public class LoginController {
	
	@Inject
	private Result result;
	
	@Inject
	private UserSession userSession;
	
	@Inject
	private DaoUsuario daoUsuario;
	
	@Public
	@Get("entrar")
	public void form(){
		result.include("pageTitle", "Entrar");
		// chama login/form.jsp
	}
	
	@Public
	@Post("autenticar")
	public void auth(Usuario usuario){
		Usuario achado = daoUsuario.findToAuth(usuario.getEmail(),usuario.getSenha());
		
		//fa autencica��o
		if( achado!=null ){
			userSession.setUsuario(achado);
			result.redirectTo(IndexController.class).index();			
		}else{
			result.include("msg", "Usu�rio ou Senha errados");
			result.redirectTo(this).form();		
		}
	}
	
	
	@Get("sair")
	public void loggout(){
		userSession.loggout();
		result.redirectTo(this).form();
	}

}
