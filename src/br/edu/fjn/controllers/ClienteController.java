package br.edu.fjn.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.dao.ClienteDAO;
import br.edu.fjn.model.Cliente;

@Controller
@Path("cliente")
public class ClienteController {
	
	@Inject
	private Result result;
	@Inject
	private ClienteDAO clienteDAO;
	
	@Get("novo")
	public void form(){
		
	}
	
	@Get("editar/{codigo}")
	public void edit(int codigo){
		Cliente clienteEdicao = clienteDAO.buscar(codigo);
		result.include("cliente",clienteEdicao);
	}
	@Post("atualizar")
	public void update(Cliente cliente){
		clienteDAO.atualizar(cliente);
		result.redirectTo(this).list();
	}
	
	@Post("salvar")
	public void salvar(Cliente cliente){		
		clienteDAO.salvar(cliente);
		result.redirectTo(this).list();
		
	}
	
	@Get("listar")
	public void list(){
		List<Cliente> clientes = clienteDAO.listarTodos();
		result.include("clientesList",clientes);
	}
	
	@Get("deletar/{codigo}")
	public void erase(int codigo){
		Cliente defunto = clienteDAO.buscar(codigo);
		clienteDAO.deletar(defunto);
		result.redirectTo(this).list();
	}
}
