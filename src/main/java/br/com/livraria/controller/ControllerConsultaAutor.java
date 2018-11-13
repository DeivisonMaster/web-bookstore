package br.com.livraria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.com.livraria.model.Autor;
import br.com.livraria.service.ServiceConsultaAutor;
import br.com.livraria.service.impl.ServiceConsultaAutorImpl;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;

@ManagedBean
@ViewScoped
public class ControllerConsultaAutor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Autor> listaAutores;
	private ServiceConsultaAutor serviceConsultaAutor;
	
	public ControllerConsultaAutor() {
		this.listaAutores = new ArrayList<>();
		this.serviceConsultaAutor = new ServiceConsultaAutorImpl();
	}
	
	/* by viewAction */
	public void buscaPorTodosOsAutores(){
		
	}
	
	public List<Autor> getAutores() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.listaAutores = this.serviceConsultaAutor.buscaPorTodosOsAutores();
			
		} catch (ManipulationException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		} catch (NegocioException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		} 
		return this.listaAutores;
	}
	
	public boolean renderizaListaAutores() {
		if(this.getAutores() == null || this.getAutores().isEmpty()) {
			return false;
		}
		return true;
	}
	
	
}
