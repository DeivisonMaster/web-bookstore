package br.com.livraria.service.impl;

import java.util.List;

import br.com.livraria.model.Livro;
import br.com.livraria.repository.RepositoryLivro;
import br.com.livraria.repository.impl.RepositoryLivroImpl;
import br.com.livraria.service.ServiceLivro;
import br.com.livraria.util.ManipulationException;

public class ServiceLivroImpl implements ServiceLivro {
	
	private RepositoryLivro repositoryLivro;
	
	public ServiceLivroImpl() {
		this.repositoryLivro = new RepositoryLivroImpl();
	}

	@Override
	public void salvar(Livro livro) throws ManipulationException {
		try {
			this.repositoryLivro.salvar(livro);
		} catch (Exception e) {
			throw new ManipulationException("Erro ao salvar o Livro", e);
		}
		
	}

	@Override
	public void atualizar(Long id) {
		try {
			
		} catch (Exception e) {
			// EXCEÇÕES DE PERSISTENCIA
		}
		
	}

	@Override
	public List<Livro> buscaPorTodosOsLivros() {
		try {
			return this.repositoryLivro.buscarPorTodosOsLivros();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
