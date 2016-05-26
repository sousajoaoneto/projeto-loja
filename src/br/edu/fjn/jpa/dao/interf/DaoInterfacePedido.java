package br.edu.fjn.jpa.dao.interf;

import java.util.List;

import br.edu.fjn.jpa.model.pedido.Pedido;

public interface DaoInterfacePedido {
	void salvar(Pedido pedido) ;
	void atualizar(Pedido pedido);
	void deletar(Pedido pedido);
	List<Pedido> listar();
	
}
