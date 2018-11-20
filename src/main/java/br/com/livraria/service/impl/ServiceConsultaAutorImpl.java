package br.com.livraria.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.livraria.model.Autor;
import br.com.livraria.service.ServiceAutor;
import br.com.livraria.service.ServiceConsultaAutor;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;

public class ServiceConsultaAutorImpl implements ServiceConsultaAutor {
	private static final long serialVersionUID = 1L;

	@Inject
	private ServiceAutor serviceAutor;
	
	@Inject
	private FacesContext context;

	@Override
	public List<Autor> buscaPorTodosOsAutores() {
		List<Autor> lista = new ArrayList<>();
		try {
			lista = this.serviceAutor.buscaPorTodosOsAutores();
			if(lista.isEmpty()) {
				this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não há autores cadastrados", ""));
			}
		} catch (Exception e) {
			this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return lista;
	}

}
