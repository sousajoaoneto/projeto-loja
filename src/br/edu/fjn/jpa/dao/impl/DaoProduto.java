package br.edu.fjn.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.dao.util.FabricaDeConexao;
import br.edu.fjn.jpa.dao.interf.DaoInterfaceProduto;
import br.edu.fjn.jpa.model.produto.Genero;
import br.edu.fjn.jpa.model.produto.Produto;
import br.edu.fjn.jpa.model.usuario.Usuario;

@Transactional
public class DaoProduto implements DaoInterfaceProduto{
		
	public DaoProduto() {
		super();
	}

	@Override
	public boolean salvar(Produto produto) {
		EntityManager em = FabricaDeConexao.getManager();
		try {
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return false;
		}finally {
			em.close();			
		}
		
	}

	@Override
	public boolean atualizar(Produto produto) {
		EntityManager em = FabricaDeConexao.getManager();
		try {
			em.getTransaction().begin();
			em.refresh(produto);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return false;
		}finally {
			em.close();
		}
	}

	@Override
	public List<Produto> listar() {
		EntityManager em = FabricaDeConexao.getManager();
		
		Session session = (Session)em.getDelegate();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Produto.class);
		criteria.addOrder(Order.desc("id_produto"));
		em.close();
	
		return criteria.list();
	}

	@Override
	public List<Produto> localizar (String descricao, String genero) {

		EntityManager em = FabricaDeConexao.getManager();		
		Session session = (Session)em.getDelegate();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Produto.class);
		if(descricao!=null){
			criteria.add(
				Restrictions.and(
					Restrictions.eq("genero", Genero.valueOf(genero)),
					Restrictions.ilike("descricao", descricao, MatchMode.ANYWHERE)
				)
			);
		}else{
			criteria.add(Restrictions.eq("genero", Genero.valueOf(genero)));
		}
		em.close();
		return criteria.list();
	}
	
	
	public Produto findById(int codigo){
		EntityManager em = FabricaDeConexao.getManager();
		em.getTransaction().begin();
		try {			
			return em.find(Produto.class, codigo);
		} catch (Exception e) {
			return null;
		}finally {
			em.close();			
		}
	}	
}
