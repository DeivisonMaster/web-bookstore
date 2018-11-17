package br.com.livraria.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import br.com.livraria.model.Autor;
import br.com.livraria.service.ServiceCadastroAutor;
import br.com.livraria.service.impl.ServiceCadastroAutorImpl;

@Named
@ViewScoped
@URLMappings(mappings = {
		@URLMapping(id = "editarAutor", pattern = "/cadastro/edicao", viewId = "/cadastro/editaAutor.xhtml") })
public class ControllerCadastroAutor implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String EDITAR = "pretty:editarAutor";

	private Autor autor;
	private ServiceCadastroAutor serviceCadastroAutor;

	public ControllerCadastroAutor() {
		this.autor = new Autor();
		this.serviceCadastroAutor = new ServiceCadastroAutorImpl();
	}

	public void salvar() {
		this.serviceCadastroAutor.salvar(this.autor);
		this.autor = new Autor();
	}
	
	public void carregar(Autor autor) {
		this.autor = autor;
	}

	public String editar() {
		this.serviceCadastroAutor.editar(this.autor);
		return "cadastroAutor";
	}

	public void excluir(Autor autor) {
		this.serviceCadastroAutor.excluir(autor);
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
