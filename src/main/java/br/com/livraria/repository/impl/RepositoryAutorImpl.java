package br.com.livraria.repository.impl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.livraria.model.Autor;
import br.com.livraria.repository.RepositoryAutor;
import br.com.livraria.util.JPAUtil;

@Dependent
public class RepositoryAutorImpl implements RepositoryAutor{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	
	@Override
	public void salvar(Autor autor) {
		this.entityManager.persist(autor);
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
		this.entityManager.merge(autor);
	}

	@Override
	public void excluir(Autor autor) {
		this.entityManager.remove(autor);
	}

}
