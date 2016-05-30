package br.edu.fjn.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.dao.util.FabricaDeConexao;
import br.edu.fjn.jpa.dao.interf.DaoInterfaceUsuario;
import br.edu.fjn.jpa.model.usuario.Usuario;


public class DaoUsuario implements DaoInterfaceUsuario {

	public DaoUsuario(){
		super();
	}

	@Override
	public void salvar(Usuario usuario) {
		EntityManager em = FabricaDeConexao.getManager();
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}	

	}

	@Override
	public void atualizar(Usuario usuario) {
		EntityManager em = FabricaDeConexao.getManager();
		try {
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}

	}

	@Override
	public void deletar(Usuario usuario) {
		EntityManager em = FabricaDeConexao.getManager();
		try {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public List<Usuario> listar() {
		EntityManager em = FabricaDeConexao.getManager();
		try {
			Session session = (Session) em.getDelegate();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Usuario.class);
			em.close();
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}	
	
	public boolean findById(Integer id, String email) {
		EntityManager em = FabricaDeConexao.getManager();

		Session session = (Session)em.getDelegate();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Usuario.class);


		criteria.add(Restrictions.or(Restrictions.eq("id_usuario", id),
		Restrictions.eq("email", email)));
		em.close();

		if (criteria.list() == null) {
			return false;
		}else {
			return true;
		}
	}
	
	
	public Usuario findToAuth(String email,String senha) {
		EntityManager em = FabricaDeConexao.getManager();
		
		Session session = (Session)em.getDelegate();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Usuario.class);
	
	
		criteria.add(Restrictions.and(Restrictions.eq("senha", senha),
		Restrictions.eq("email", email)));
		em.close();
	
		return (Usuario) criteria.uniqueResult();
	}

}