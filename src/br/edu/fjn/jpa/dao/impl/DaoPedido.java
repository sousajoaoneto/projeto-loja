package br.edu.fjn.jpa.dao.impl;

import java.util.List;

import br.edu.fjn.dao.util.FabricaDeConexao;

import br.edu.fjn.jpa.dao.interf.DaoInterfacePedido;
import br.edu.fjn.jpa.model.pedido.Pedido;

public class DaoPedido implements DaoInterfacePedido {

	private EntityManager entityManager = FabricaDeConexao.getManager();
	
	public DaoPedido(){
		super();
	}
	
	@Override
	public void salvar(Pedido pedido) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(pedido);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}

	@Override
	public void atualizar(Pedido pedido) {
		entityManager.getTransaction().begin();
		try {
			entityManager.merge(pedido);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		
	}

	@Override
	public void deletar(Pedido pedido) {
		entityManager.getTransaction().begin();
		try {
			entityManager.remove(pedido);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		
	}

	@Override
	public List<Pedido> listar() {
		List<Pedido> pedidos = null;
		try {
			pedidos = entityManager.createNamedQuery("from Pedido", Pedido.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}

}
