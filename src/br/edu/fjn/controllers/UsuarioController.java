package br.edu.fjn.controllers;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.annotations.Public;
import br.edu.fjn.components.UserSession;
import br.edu.fjn.jpa.dao.impl.DaoUsuario;
import br.edu.fjn.jpa.model.endereco.Cidade;
import br.edu.fjn.jpa.model.endereco.Endereco;
import br.edu.fjn.jpa.model.endereco.Estado;
import br.edu.fjn.jpa.model.usuario.Tipo;
import br.edu.fjn.jpa.model.usuario.Usuario;

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
	@Post("salvar")
	public void save(Usuario usuario, Endereco endereco, Cidade cidade, Estado estado){
		
		List<Usuario> usuarios = new DaoUsuario().listar();
		
		if(usuarios.size() > 0){			
			usuario.setTipo(Tipo.CLIENTE);
		}else{
			usuario.setTipo(Tipo.GERENTE);
		}
		cidade.setEstado(estado);
		endereco.setCidade(cidade);
		
		usuario.setData_nasc(new Date(12,12,12));
		usuario.setEndereco(endereco);
		
		new DaoUsuario().salvar(usuario);
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
