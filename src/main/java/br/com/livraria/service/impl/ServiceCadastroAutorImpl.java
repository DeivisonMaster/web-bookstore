package br.com.livraria.service.impl;

import br.com.livraria.model.Autor;
import br.com.livraria.service.ServiceAutor;
import br.com.livraria.service.ServiceCadastroAutor;
import br.com.livraria.util.ManipulationException;

public class ServiceCadastroAutorImpl implements ServiceCadastroAutor{
	
	private ServiceAutor serviceAutor;
	
	public ServiceCadastroAutorImpl() {
		this.serviceAutor = new ServiceAutorImpl();
	}

	@Override
	public void salvar(Autor autor) throws ManipulationException{
		this.serviceAutor.salvar(autor);
	}

}
