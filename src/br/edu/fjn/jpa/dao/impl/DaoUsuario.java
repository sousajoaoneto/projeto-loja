package br.edu.fjn.jpa.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;

import br.edu.fjn.dao.util.FabricaDeConexao;
import br.edu.fjn.jpa.dao.interf.DaoInterfaceUsuario;
import br.edu.fjn.jpa.model.usuario.Usuario;

public class DaoUsuario implements DaoInterfaceUsuario {

	EntityManager entityManager = FabricaDeConexao.getManager();
	
	public DaoUsuario(){
		super();
	}
	
	@Override
	public void salvar(Usuario usuario) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
			entityManager.close();
		
	}

	@Override
	public void atualizar(Usuario usuario) {
		entityManager.getTransaction().begin();
		try {
			entityManager.merge(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		
	}

	@Override
	public void deletar(Usuario usuario) {
		entityManager.getTransaction().begin();
		try {
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = null;
		try {
			usuarios = entityManager.createNamedQuery("from Usuario", Usuario.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

}
