package br.com.livraria.service.impl;

import java.util.List;

import javax.enterprise.context.Dependent;

import br.com.livraria.model.Livro;
import br.com.livraria.service.ServiceConsultaLivro;
import br.com.livraria.service.ServiceLivro;

@Dependent
public class ServiceConsultaLivroImpl implements ServiceConsultaLivro {
	
	private static final long serialVersionUID = 1L;
	
	private ServiceLivro serviceLivro;
	
	public ServiceConsultaLivroImpl() {
		this.serviceLivro = new ServiceLivroImpl();
	}

	@Override
	public List<Livro> buscaPorTodosOsLivros() {
		return this.serviceLivro.buscaPorTodosOsLivros();
	}

}
