package br.edu.fjn.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.annotations.Public;
import br.edu.fjn.components.UserSession;
import br.edu.fjn.model.Usuario;

@Controller
@Path("usuario")
public class UsuarioController {

	@Inject
	private Result result;
	
	@Inject
	private UserSession userSession;
	
	@Public
	@Get("cadastrar")//maybe this line can be removed
	public void form(){
		//chama usuario/form.jsp
	}
	
	@Public
	@Post("salvar")//maybe this line can be removed
	public void save(Usuario usuario){
		
		//colocaria o dao
		result.redirectTo(IndexController.class).index();
		System.out.println(usuario.toString());
	}
	
	@Get("editar/{codigo}")
	public void edit(int codigo){
		
	}
	
	@Post("atualizar")
	public void update(Usuario usuario){
		
	}
	
	@Get("listar")
	public void list(){
		
	}
	
	@Get("deletar/{codigo}")
	public void delete(int codigo){
		
	}
}
