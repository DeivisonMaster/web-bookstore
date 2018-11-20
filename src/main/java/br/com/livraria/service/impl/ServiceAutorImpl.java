package br.com.livraria.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import br.com.livraria.model.Autor;
import br.com.livraria.repository.RepositoryAutor;
import br.com.livraria.repository.impl.RepositoryAutorImpl;
import br.com.livraria.service.ServiceAutor;
import br.com.livraria.util.ManipulationException;

@Dependent
public class ServiceAutorImpl implements ServiceAutor {
	private static final long serialVersionUID = 1L;
	
	private RepositoryAutor repositoryAutor;
	
	public ServiceAutorImpl() {
		this.repositoryAutor = new RepositoryAutorImpl();
	}
	
	
	@Override
	public List<Autor> buscaPorTodosOsAutores() throws ManipulationException{
		List<Autor> autores = new ArrayList<>();
		try {
			autores = this.repositoryAutor.buscaPorTodosOsAutores();
		} catch (Exception e) {
			throw new ManipulationException("Erro ao lista autores", e);
		}
		return autores;
	}

	@Override
	public Autor buscaPorId(Long id) {
		return this.repositoryAutor.buscaPorId(id);
	}

	@Override
	public void salvar(Autor autor) throws ManipulationException {
		try {
			this.repositoryAutor.salvar(autor);
		} catch (Exception e) {
			throw new ManipulationException("Erro ao cadastrar novo Autor", e);
		}
	}

	@Override
	public void editar(Autor autor) {
		try {
			this.repositoryAutor.editar(autor);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void excluir(Autor autor) throws ManipulationException {
		try {
			this.repositoryAutor.excluir(autor);
		} catch (Exception e) {
			throw new ManipulationException("Erro ao excluir o Autor", e);
		}
	}

}
