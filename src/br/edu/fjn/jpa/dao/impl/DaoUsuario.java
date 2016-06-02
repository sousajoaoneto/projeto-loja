package br.edu.fjn.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
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
		List<Usuario> usuarios = null;
		try {
			Query query = em.createQuery("SELECT p FROM tb_usuario p");
			usuarios = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
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
	
	
	public boolean alreadyExists(String target, String value){
        EntityManager em = FabricaDeConexao.getManager();
		
		Session session = (Session)em.getDelegate();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Usuario.class);
		
		return !criteria.add(Restrictions.eq(target, value)).list().isEmpty();
	}
	
	public int count(){
       EntityManager em = FabricaDeConexao.getManager();
       Session session = (Session)em.getDelegate();
       Criteria crit = session.createCriteria(Usuario.class).setProjection(Projections.rowCount());
  
	   return (int)Integer.parseInt(""+crit.uniqueResult());
	}
	
}