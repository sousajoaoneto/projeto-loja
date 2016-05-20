package br.edu.fjn.dao;

import java.util.List;

import br.edu.fjn.model.Cliente;

public interface ClienteDAO {
	void salvar(Cliente cliente);
	Cliente buscar(int codigo);
	void deletar(Cliente cliente);
	void atualizar(Cliente cliente);
	List<Cliente> listarTodos();
}
