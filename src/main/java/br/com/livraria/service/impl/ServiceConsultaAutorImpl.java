package br.com.livraria.service.impl;

import java.util.List;

import br.com.livraria.model.Autor;
import br.com.livraria.service.ServiceAutor;
import br.com.livraria.service.ServiceConsultaAutor;

public class ServiceConsultaAutorImpl implements ServiceConsultaAutor {
	
	private ServiceAutor serviceAutor;
	
	public ServiceConsultaAutorImpl() {
		this.serviceAutor = new ServiceAutorImpl();
	}

	@Override
	public List<Autor> buscaPorTodosOsAutores() {
		return this.serviceAutor.buscaPorTodosOsAutores();
	}
	
}
