package br.com.livraria.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.livraria.model.Autor;
import br.com.livraria.model.Livro;
import br.com.livraria.service.ServiceCadastroLivro;
import br.com.livraria.service.impl.ServiceCadastroLivroImpl;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;
import br.com.livraria.validadores.Validador;

@Named
@ViewScoped
public class ControllerCadastroLivro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Livro livro;
	private Livro livroEdicao;
	private Autor autor;
	private ServiceCadastroLivro serviceCadastroLivro;

	public ControllerCadastroLivro() {
		this.livro = new Livro();
		this.serviceCadastroLivro = new ServiceCadastroLivroImpl();
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.serviceCadastroLivro.salvar(this.livro);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Livro cadastrado com sucesso!", ""));
			this.livro = new Livro();
		} catch(NegocioException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		} catch (ManipulationException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public String cadastrarAutor() {
		return "cadastroAutor?faces-redirect=true";
	}
	
	public String carregaDadosLivro(Livro livro) {
		this.livroEdicao = livro;
		return "editarLivro";
	}
	
	public void editar(Livro livro) {
		
	}
	
	public void remover(Livro livro) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.serviceCadastroLivro.remover(livro);
			context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_WARN, "Livro removido com sucesso!", ""));
		} catch (ManipulationException e) {
			context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public void deveriaComecarComDigitoUm(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		Validador.comecaComDigitoUm(context, component, value);
	}
	
	public Livro getLivroEdicao() {
		return livroEdicao;
	}
	
	public void setLivroEdicao(Livro livroEdicao) {
		this.livroEdicao = livroEdicao;
	}
	
	
}
