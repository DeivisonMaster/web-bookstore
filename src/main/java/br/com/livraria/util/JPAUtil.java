package br.com.livraria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("livraria_web");
	}
	
	public static EntityManager getEntityManager() {
		if(entityManagerFactory != null) {
			return entityManagerFactory.createEntityManager();
		}else {
			throw new RuntimeException("Unidade de persistência não iniciada");
		}
	}
}
