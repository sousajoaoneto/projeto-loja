package br.edu.fjn.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.dao.util.FabricaDeConexao;
import br.edu.fjn.jpa.dao.interf.DaoInterfaceProduto;
import br.edu.fjn.jpa.model.produto.Produto;

@Transactional
public class DaoProduto implements DaoInterfaceProduto{
	
	private EntityManager entityManager = FabricaDeConexao.getManager();
	
	public DaoProduto() {
		super();
	}

	@Override
	public void salvar(Produto produto) {
		entityManager = FabricaDeConexao.getManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(produto);
			entityManager.getTransaction().commit();
			entityManager.flush();
		}catch (Exception e) {
			System.out.println("Error: Niga");
			e.printStackTrace();			
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
		List<Produto> produtos = null;
		try {
			Query query = entityManager.createQuery("SELECT p FROM tb_produto p");
			produtos = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}

	@Override
	public List<Produto> localizar (Integer id, String descricaoPro) {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Produto.class);
		criteria.createAlias("produto", "pro");
		
		criteria.add(Restrictions.or(Restrictions.eq("pro.id", id),
				Restrictions.ilike("pro.descricao", descricaoPro, MatchMode.START)));
		entityManager.close();
		return criteria.list();
	}
	
	
	public void recarrega(Produto produto) {
		entityManager.getTransaction().begin();
		try {
			entityManager.refresh(produto);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
}
