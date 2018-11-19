package br.com.livraria.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.livraria.model.Livro;
import br.com.livraria.service.ServiceConsultaLivro;
import br.com.livraria.service.impl.ServiceConsultaLivroImpl;

@Named
@ViewScoped
public class ControllerConsultaLivro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ServiceConsultaLivro serviceConsultaLivro;
	
	public ControllerConsultaLivro() {
		this.serviceConsultaLivro = new ServiceConsultaLivroImpl();
	}
	
	public List<Livro> getListaLivros(){
		return this.serviceConsultaLivro.buscaPorTodosOsLivros();
	}
}
