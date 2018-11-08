package br.com.livraria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;

import br.com.livraria.model.Autor;
import br.com.livraria.service.ServiceConsultaAutor;
import br.com.livraria.service.impl.ServiceConsultaAutorImpl;

@ManagedBean
@ViewScoped
public class ControllerConsultaAutor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Autor> autores;
	private ServiceConsultaAutor serviceConsultaAutor;
	
	public ControllerConsultaAutor() {
		this.autores = new ArrayList<>();
		this.serviceConsultaAutor = new ServiceConsultaAutorImpl();
	}
	
	public void buscaPorTodosOsAutores(){
		this.autores = this.serviceConsultaAutor.buscaPorTodosOsAutores();
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
