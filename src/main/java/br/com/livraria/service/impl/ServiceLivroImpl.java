package br.com.livraria.service.impl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import br.com.livraria.model.Livro;
import br.com.livraria.repository.RepositoryLivro;
import br.com.livraria.repository.impl.RepositoryLivroImpl;
import br.com.livraria.service.ServiceLivro;
import br.com.livraria.util.ManipulationException;

@Dependent
public class ServiceLivroImpl implements ServiceLivro {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RepositoryLivro repositoryLivro;
	

	
	@Override
	public void salvar(Livro livro) throws ManipulationException {
		try {
			this.repositoryLivro.salvar(livro);
		} catch (Exception e) {
			throw new ManipulationException("Erro ao salvar o Livro", e);
		}
		
	}

	@Override
	public void atualizar(Livro livro) throws ManipulationException {
		try {
			this.repositoryLivro.atualizar(livro);
		} catch (Exception e) {
			throw new ManipulationException("Erro ao atualizar o livro", e);
		}
		
	}

	@Override
	public List<Livro> buscaPorTodosOsLivros() throws ManipulationException {
		try {
			return this.repositoryLivro.buscarPorTodosOsLivros();
		} catch (Exception e) {
			throw new ManipulationException("Erro ao listar todos os livros", e);
		}
	}

	@Override
	public void remover(Livro livro) throws ManipulationException {
		try {
			this.repositoryLivro.remover(livro);
		} catch (Exception e) {
			throw new ManipulationException("Erro ao remover o Livro", e);
		}
	}

	@Override
	public Livro buscarPorId(Long id) {
		return this.repositoryLivro.buscarPorId(id);
	}
	
}
