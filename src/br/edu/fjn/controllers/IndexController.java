package br.edu.fjn.controllers;

import java.util.Date;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
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
		Estado estado = new Estado();
		estado.setNome("Ceara");
		
		Cidade cidade = new Cidade();
		cidade.setNome("Juazeiro");
		cidade.setEstado(estado);
		cidade.setCep("565235");		
		
		Endereco endereco = new Endereco();
		endereco.setCidade(cidade);
		endereco.setNumero(10);
		endereco.setRua("Ramiro");
		
	
		Usuario usuario = new Usuario();
		usuario.setCpf("985632");
		usuario.setNome("Josineide");
		usuario.setEndereco(endereco);
		usuario.setTipo(Tipo.GERENTE);
		usuario.setUsername("josi");
		usuario.setData_nasc(new Date(10,05,90));
		usuario.setSenha("123");
		usuario.setEmail("josi@gmail.com");
		
		
		new DaoUsuario().atualizar(usuario);
		result.forwardTo(ProdutoController.class).list();
	}
	
}
