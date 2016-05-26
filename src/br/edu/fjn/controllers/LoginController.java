package br.edu.fjn.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.annotations.Public;
import br.edu.fjn.components.UserSession;
import br.edu.fjn.model.Usuario;

@Controller
public class LoginController {
	
	@Inject
	private Result result;
	
	@Inject
	private UserSession userSession;
	
	@Public
	@Get("entrar")
	public void form(){
		// chama login/form.jsp
	}
	
	@Public
	@Post("autenticar")
	public void auth(Usuario usuario){
		System.out.println("chegou");
		//fa autencicação
		if(usuario.getEmail().equalsIgnoreCase("mail@mail.com")){
			usuario.setNome("Tester");
			userSession.setUsuario(usuario);
			result.redirectTo(IndexController.class).index();			
		}else{
			result.include("msg", "Usuário ou Senha errados");
			result.redirectTo(this).form();		
		}
	}
	
	@Public
	@Get("sair")
	public void loggout(){
		userSession.loggout();
		result.redirectTo(this).form();
	}

}
