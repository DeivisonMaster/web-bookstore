package br.com.livraria.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.livraria.model.Livro;
import br.com.livraria.service.ServiceConsultaLivro;
import br.com.livraria.service.ServiceLivro;

@Dependent
public class ServiceConsultaLivroImpl implements ServiceConsultaLivro {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServiceLivro serviceLivro;
	
	@Inject
	private FacesContext context;
	
	@Override
	public List<Livro> buscaPorTodosOsLivros() {
		List<Livro> lista = new ArrayList<>();
		
		try {
			lista = this.serviceLivro.buscaPorTodosOsLivros();
			if(lista.isEmpty()) {
				this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não há livros cadastrados", ""));
			}
		} catch (Exception e) {
			this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return lista;
	}

}
