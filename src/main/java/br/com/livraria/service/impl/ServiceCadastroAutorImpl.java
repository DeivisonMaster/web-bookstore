package br.com.livraria.service.impl;

import br.com.livraria.model.Autor;
import br.com.livraria.service.ServiceAutor;
import br.com.livraria.service.ServiceCadastroAutor;
import br.com.livraria.util.ManipulationException;

public class ServiceCadastroAutorImpl implements ServiceCadastroAutor {

	private ServiceAutor serviceAutor;

	public ServiceCadastroAutorImpl() {
		this.serviceAutor = new ServiceAutorImpl();
	}

	@Override
	public void salvar(Autor autor) throws ManipulationException {
		this.serviceAutor.salvar(autor);
	}

	@Override
	public Autor edita(Long id) {
		return this.serviceAutor.buscaPorId(id);
	}

	@Override
	public void editar(Autor autor) {
		this.serviceAutor.editar(autor);
	}

	@Override
	public Autor buscaPorId(Long id) {
		return this.serviceAutor.buscaPorId(id);
	}

	@Override
	public void excluir(Autor autor) {
		Autor buscaAutor = this.buscaPorId(autor.getId());
		
		this.serviceAutor.excluir(buscaAutor);
	}

}
