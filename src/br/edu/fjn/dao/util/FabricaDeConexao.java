package br.edu.fjn.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaDeConexao {
	
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("fjn");
	
	private FabricaDeConexao(){
		
	}
			
	public static EntityManager getManager() {
		return factory.createEntityManager();
	}
}
