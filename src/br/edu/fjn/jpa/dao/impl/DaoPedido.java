package br.edu.fjn.jpa.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.components.UserSession;
import br.edu.fjn.dao.util.FabricaDeConexao;
import br.edu.fjn.jpa.dao.interf.DaoInterfacePedido;
import br.edu.fjn.jpa.model.pedido.Pedido;
import br.edu.fjn.jpa.model.usuario.Usuario;

public class DaoPedido implements DaoInterfacePedido {

	@Inject
	private UserSession userSession;
	
	private EntityManager entityManager = FabricaDeConexao.getManager();
	
	public DaoPedido(){
		super();
	}
	
	@Override
	public boolean salvar(Pedido pedido) {
		
		EntityManager em = FabricaDeConexao.getManager();
		try {
			em.getTransaction().begin();
			em.persist(pedido);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			em.close();			
		}
	}

	@Override
	public void atualizar(Pedido pedido) {
		EntityManager em = FabricaDeConexao.getManager();
		em.getTransaction().begin();
		try {
			em.merge(pedido);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}

	@Override
	public void deletar(Pedido pedido) {
		EntityManager em = FabricaDeConexao.getManager();
		em.getTransaction().begin();
		try {
			em.remove(pedido);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Pedido> listar() {
		EntityManager em = FabricaDeConexao.getManager();
		System.out.println(userSession.getUsuario().getId_usuario());
		Session session = (Session)em.getDelegate();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Pedido.class);
		criteria.add(Restrictions.eq("usuario.id_usuario", userSession.getUsuario().getId_usuario())).addOrder(Order.desc("id_pedido"));
		
		//criteria.addOrder(Order.desc("id_pedido"));
		em.close();
	
		return criteria.list();
	}

}
