package br.com.livraria.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.livraria.model.Autor;
import br.com.livraria.repository.RepositoryAutor;
import br.com.livraria.util.JPAUtil;

public class RepositoryAutorImpl implements RepositoryAutor{
	
	private EntityManager entityManager;
	
	public RepositoryAutorImpl() {
		this.entityManager = JPAUtil.getEntityManager();
	}
	
	@Override
	public void salvar(Autor autor) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(autor);
		this.entityManager.getTransaction().commit();
	}

	@Override
	public List<Autor> buscaPorTodosOsAutores() {
		Query consulta = entityManager.createQuery("from Autor");
		List<Autor> autores = consulta.getResultList();
		
		return autores;
	}

	@Override
	public Autor buscaPorId(Long id) {
		return this.entityManager.find(Autor.class, id);
	}

}
