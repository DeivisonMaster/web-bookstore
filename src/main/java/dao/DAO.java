package dao;

import javax.persistence.EntityManager;

import br.com.livraria.util.JPAUtil;

public class DAO<T> {
	private EntityManager entityManager;
	private final Class<T> classe;
	
	public DAO(Class<T> classe) {
		this.classe = classe;
		this.entityManager = JPAUtil.getEntityManager();
	}
	
	public void persiste(T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}

























