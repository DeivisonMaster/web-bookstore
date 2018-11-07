package br.com.livraria.service.impl;

import java.util.List;

import br.com.livraria.model.Livro;
import br.com.livraria.service.ServiceConsultaLivro;
import br.com.livraria.service.ServiceLivro;

public class ServiceConsultaLivroImpl implements ServiceConsultaLivro {
	
	private ServiceLivro serviceLivro;
	
	public ServiceConsultaLivroImpl() {
		this.serviceLivro = new ServiceLivroImpl();
	}

	@Override
	public List<Livro> buscaPorTodosOsLivros() {
		return this.serviceLivro.buscaPorTodosOsLivros();
	}

}
