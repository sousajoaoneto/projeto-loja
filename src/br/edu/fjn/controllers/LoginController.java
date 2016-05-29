package br.edu.fjn.controllers;

import java.util.List;

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
	
	@Public
	@Get("entrar")
	public void form(){
		// chama login/form.jsp
	}
	
	@Public
	@Post("autenticar")
	public void auth(Usuario usuario){
		List<Usuario> usuarios = new DaoUsuario().listar();
		
		for(int i=0;i<usuarios.size();i++){
			System.out.println(usuarios.get(i).getNome());
		}
		
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
