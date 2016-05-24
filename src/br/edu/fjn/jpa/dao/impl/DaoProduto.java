package br.edu.fjn.jpa.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.dao.util.FabricaDeConexao;
import br.edu.fjn.jpa.dao.interf.DaoInterfaceProduto;
import br.edu.fjn.jpa.model.produto.Produto;

public class DaoProduto implements DaoInterfaceProduto{
	
	private EntityManager entityManager = FabricaDeConexao.getManager();
	
	public DaoProduto() {
		super();
	}

	@Override
	public void salvar(Produto produto) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(produto);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}

	@Override
	public void atualizar(Produto produto) {
		entityManager.getTransaction().begin();
		try {
			entityManager.merge(produto);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}

	@Override
	public void deletar(Produto produto) {
		entityManager.getTransaction().begin();
		try {
			entityManager.remove(produto);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		
	}

	@Override
	public List<Produto> listar() {
		List<Produto> produto = null;
		try {
			produto = entityManager.createNamedQuery("from Produto", Produto.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produto;
	}

	@Override
	public List<Produto> localizar (Integer id, String descricaoPro) {
		EntityManager em = FabricaDeConexao.getManager();
		Session session = (Session)em.getDelegate();
		Criteria criteria = session.createCriteria(Produto.class);
		criteria.createAlias("produto", "pro");
		
		criteria.add(Restrictions.or(Restrictions.eq("pro.id", id),
				Restrictions.ilike("pro.descricao", descricaoPro, MatchMode.START)));
		em.close();
		return criteria.list();
	}

}
