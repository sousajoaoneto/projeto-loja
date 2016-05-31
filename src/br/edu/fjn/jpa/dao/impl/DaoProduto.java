package br.edu.fjn.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.transaction.Transactional;
import javax.transaction.TransactionalException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.dao.util.FabricaDeConexao;
import br.edu.fjn.jpa.dao.interf.DaoInterfaceProduto;
import br.edu.fjn.jpa.model.produto.Produto;

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
	public void atualizar(Produto produto) {
		EntityManager em = FabricaDeConexao.getManager();
		em.getTransaction().begin();
		try {
			em.merge(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();			
		}finally {
			em.close();
		}
	}

	@Override
	public void deletar(Produto produto) {
		EntityManager em = FabricaDeConexao.getManager();
		em.getTransaction().begin();
		try {
			em.remove(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Produto> listar() {
		EntityManager em = FabricaDeConexao.getManager();
		List<Produto> produtos = null;
		try {
			Query query = em.createQuery("SELECT p FROM tb_produto p");
			produtos = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}

	@Override
	public List<Produto> localizar (Integer id, String descricaoPro) {
		EntityManager em = FabricaDeConexao.getManager();
		Session session = (Session) em.getDelegate();
		Criteria criteria = session.createCriteria(Produto.class);
		criteria.createAlias("produto", "pro");
		
		criteria.add(Restrictions.or(Restrictions.eq("pro.id", id),
				Restrictions.ilike("pro.descricao", descricaoPro, MatchMode.START)));
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
