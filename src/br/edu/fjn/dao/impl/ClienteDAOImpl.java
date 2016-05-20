package br.edu.fjn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.edu.fjn.dao.ClienteDAO;
import br.edu.fjn.model.Cliente;

@ApplicationScoped
public class ClienteDAOImpl implements ClienteDAO {

	private List<Cliente> clientes = new ArrayList<>();
	
	public ClienteDAOImpl() {
		super();
	}

	@Override
	public void salvar(Cliente cliente){
		clientes.add(cliente);
	}

	@Override
	public Cliente buscar(int codigo) {
		Cliente clienteLocalizado = null;
		for(Cliente cliente:clientes){
			if(cliente.getCodigo() == codigo){
				clienteLocalizado = cliente;
				break;
			}
		}
		return clienteLocalizado;
	}

	@Override
	public void deletar(Cliente cliente) {
		clientes.remove(cliente);
	}

	@Override
	public void atualizar(Cliente cliente) {
		for(int i=0;i<clientes.size();i++){
			if(clientes.get(i).getCodigo() == cliente.getCodigo()){
				clientes.set(i, cliente);
				break;
			}
		}
	}

	@Override
	public List<Cliente> listarTodos() {
		return clientes;
	}

}
