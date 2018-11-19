package br.com.livraria.repository.impl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.livraria.model.Autor;
import br.com.livraria.repository.RepositoryAutor;
import br.com.livraria.util.JPAUtil;

@Dependent
public class RepositoryAutorImpl implements RepositoryAutor{
	private static final long serialVersionUID = 1L;
	
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
	
	@Override
	public void editar(Autor autor) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(autor);
		this.entityManager.getTransaction().commit();
	}

	@Override
	public void excluir(Autor autor) {
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(autor);
		this.entityManager.getTransaction().commit();
	}

}
