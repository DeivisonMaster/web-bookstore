package br.com.livraria.util;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory entityManagerFactory;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("livraria_web");
	}

	@Produces 
	@RequestScoped
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public void close(@Disposes EntityManager manager) {
		manager.close();
	}
}
