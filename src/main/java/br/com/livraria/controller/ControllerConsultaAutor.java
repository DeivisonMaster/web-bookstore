package br.com.livraria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.livraria.model.Autor;
import br.com.livraria.service.ServiceConsultaAutor;
import br.com.livraria.service.impl.ServiceConsultaAutorImpl;

@Named
@ViewScoped
public class ControllerConsultaAutor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Autor> listaAutores;
	
	@Inject
	private ServiceConsultaAutor serviceConsultaAutor;
	
	public ControllerConsultaAutor() {
		this.listaAutores = new ArrayList<>();
	}
	
	/* by viewAction */
	public void buscaPorTodosOsAutores(){
		
	}
	
	public List<Autor> getAutores() {
		return this.serviceConsultaAutor.buscaPorTodosOsAutores();
	}
	
	public boolean renderizaListaAutores() {
		if(this.getAutores() == null || this.getAutores().isEmpty()) {
			return false;
		}
		return true;
	}
	
	
}
