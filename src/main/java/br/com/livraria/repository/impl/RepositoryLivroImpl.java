package br.com.livraria.repository.impl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.livraria.model.Livro;
import br.com.livraria.repository.RepositoryLivro;
import br.com.livraria.util.JPAUtil;

@Dependent
public class RepositoryLivroImpl implements RepositoryLivro {
	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;

	public RepositoryLivroImpl() {
		this.entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public void salvar(Livro livro) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(livro);
		this.entityManager.getTransaction().commit();
	}

	@Override
	public void atualizar(Livro livro) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(livro);
		this.entityManager.getTransaction().commit();
	}

	@Override
	public Livro buscarPorId(Long id) {
		return this.entityManager.find(Livro.class, id);
	}

	@Override
	public List<Livro> buscarPorTodosOsLivros() {
		return entityManager.createQuery("from Livro").getResultList();
	}

	@Override
	public void remover(Livro livro) {
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(livro);
		this.entityManager.getTransaction().commit();
	}

}
